package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.OrderByFilter;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.PredicateFactory;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.PredicateParam;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.SearchFilter;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.iRead;
import com.vaadin.tutorial.crm.backend.library.base.dto.DtoClassContainer;
import com.vaadin.tutorial.crm.backend.library.exception.BadRequestException;
import com.vaadin.tutorial.crm.backend.library.exception.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

import static com.vaadin.tutorial.crm.backend.library.Utilities.getClassForName;
import static com.vaadin.tutorial.crm.backend.library.Utilities.getDtoTypeEnumByEntityClassCanonicalName;
import static java.util.stream.Collectors.toList;

public class Filterer<MODEL, DTO> implements Specification<MODEL>, iRead<DTO, Filterer<MODEL, DTO>> {

    private final List<List<List<SearchFilter>>> filters;
    private final String dtoTypeName;

    private final List<String> groupByAttributes;
    private final List<OrderByFilter> orderByFilters;

    private Class<DTO> dtoClass;
    private Class<MODEL> modelClass;

    private CriteriaBuilder builder;
    private Root<MODEL> root;

    public Filterer(List<List<List<SearchFilter>>> filters, String dtoTypeName, List<String> groupByAttributes, List<OrderByFilter> orderByFilters) {
        this.filters = filters;
        this.dtoTypeName = dtoTypeName;
        this.groupByAttributes = groupByAttributes;
        this.orderByFilters = orderByFilters;
    }

    @Override
    public Predicate toPredicate(Root<MODEL> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        this.builder = builder;
        this.root = root;

        setDtoClassAndModelClass(root);

        if (groupByAttributes != null && groupByAttributes.size() > 0) {
            criteriaQuery.groupBy(FiltererUtil.getExpressionArrayByGroupByAttributes(root, groupByAttributes));
        }
        if (orderByFilters != null && orderByFilters.size() > 0) {
            criteriaQuery.orderBy(FiltererUtil.getOrderByOrderByFilters(builder, root, orderByFilters));
        }

        return this.filters.size() > 0
                ? this.createPredicate()
                : null;
    }

    private Predicate createPredicate() {
        List<List<List<Predicate>>> predicates = this.getORPredicates();
        List<Predicate> collectedPredicates = predicates
                .stream()
                .map(layerOne -> {
                    List<Predicate> layerOnePredicates = layerOne
                            .stream()
                            .map(this::chainInnerORPredicates)
                            .collect(toList());
                    return this.chainAndPredicates(layerOnePredicates);
                })
                .collect(toList());


        return chainORPredicates(collectedPredicates);
    }

    private Predicate chainORPredicates(List<Predicate> predicates) {
        return builder.or(predicates.toArray(new Predicate[0]));
    }

    private Predicate chainAndPredicates(List<Predicate> predicates) {
        return this.builder.and(predicates.toArray(new Predicate[0]));
    }

    private Predicate chainInnerORPredicates(List<Predicate> predicates) {
        return this.builder.or(predicates.toArray(new Predicate[0]));
    }

    private List<List<List<Predicate>>> getORPredicates() {
        return this.filters
                .stream()
                .map(this::getANDPredicates)
                .collect(toList());
    }

    private List<List<Predicate>> getANDPredicates(List<List<SearchFilter>> filters) {
        return filters
                .stream()
                .map(this::getInnerORPredicates)
                .collect(toList());
    }

    private List<Predicate> getInnerORPredicates(List<SearchFilter> filters) {
        return filters
                .stream()
                .map(this::buildPredicate)
                .collect(toList());
    }

    @SneakyThrows
    private void setDtoClassAndModelClass(Root<MODEL> root) {
        String entityCanonicalName = root.getJavaType().getTypeName();
        this.modelClass = (Class<MODEL>) getClassForName(entityCanonicalName);
        String entitySimpleName = this.getEntitySimpleNameLowerCamelCase(entityCanonicalName);

        Class<? extends Enum<?>> enumClass = getDtoTypeEnumByEntityClassCanonicalName(entityCanonicalName);
        Enum<?> targetEnumConstant = this.getEnumConstantByName(entitySimpleName, enumClass);

        dtoClass = this.getDtoClassFromEnumConstant(entitySimpleName, targetEnumConstant);
    }

    private Class<DTO> getDtoClassFromEnumConstant(String entitySimpleName, Enum<?> targetEnumConstant) {
        if (targetEnumConstant instanceof DtoClassContainer) {
            DtoClassContainer enumConstant = (DtoClassContainer) targetEnumConstant;
            return enumConstant.getDtoClass();
        } else {
            throw new BadRequestException("error." + entitySimpleName + ".dtoTypeEnum.missing" + DtoClassContainer.class.getSimpleName());
        }
    }

    private Enum<?> getEnumConstantByName(String entitySimpleName, Class<? extends Enum<?>> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(enumConstant -> enumConstant.name().equals(dtoTypeName))
                .findAny()
                .orElseThrow(() -> new NotFoundException("error." + entitySimpleName + ".dtoType.notExist"));
    }

    private String getEntitySimpleNameLowerCamelCase(String entityCanonicalName) {
        String[] entityCanonicalNameParts = entityCanonicalName.split("\\.");
        return entityCanonicalNameParts[entityCanonicalNameParts.length - 3];
    }

    private Predicate buildPredicate(SearchFilter filter) {
        return PredicateFactory.build(createPredicateParam(filter));
    }

    private PredicateParam createPredicateParam(SearchFilter filter) {
        return new PredicateParam(
                filter.getOperation(),
                this.builder,
                this.root,
                this.modelClass,
                filter.getModelFieldName(),
                filter.getFilterValue());
    }

    public Class<DTO> getDtoClass() {
        return this.dtoClass;
    }

}
