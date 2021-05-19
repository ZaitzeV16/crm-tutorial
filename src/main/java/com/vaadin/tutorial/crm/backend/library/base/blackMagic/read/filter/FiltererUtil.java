package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.OrderByFilter;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.PredicateParam;
import org.hibernate.query.criteria.internal.path.AbstractPathImpl;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.Attribute;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

abstract public class FiltererUtil {
    private static Pattern NESTED_OBJECT_FIELD_NAME_PATTERN = Pattern.compile("_");

    public static <PATH_GENERIC> Path<PATH_GENERIC> getPathByModelFieldName(PredicateParam pp) {
        return getPathByModelFieldName(pp.root, pp.modelFieldName);
    }

    public static <PATH_GENERIC> Path<PATH_GENERIC> getPathByModelFieldName(Root<?> root, String modelFieldName) {
        if (modelFieldName == null || modelFieldName.isEmpty()) {
            throw new RuntimeException("Not set modelFieldName");
        }

        String[] fieldNameElements = NESTED_OBJECT_FIELD_NAME_PATTERN.split(modelFieldName);

        if (fieldNameElements.length == 1) {
            return root.get(modelFieldName);
        }
        return getPathByFieldElements(root, fieldNameElements);
    }

    private static <PATH_GENERIC> boolean isJoinPath(Path<PATH_GENERIC> objectPath) {
        Attribute.PersistentAttributeType persistentAttributeType = ((AbstractPathImpl) objectPath).getAttribute().getPersistentAttributeType();
        return persistentAttributeType.equals(Attribute.PersistentAttributeType.ONE_TO_MANY) || persistentAttributeType.equals(Attribute.PersistentAttributeType.MANY_TO_MANY);
    }

    private static <PATH_GENERIC> Path<PATH_GENERIC> getPathByFieldElements(Root<?> root, String[] fieldNameElements) {
        Path<PATH_GENERIC> objectPath;
        objectPath = root.get(fieldNameElements[0]);
        int i = 1;
        if (isJoinPath(objectPath)) {
            i = 2;
            if (objectPath.getJavaType().isAssignableFrom(Map.class)) {
                objectPath = root.joinMap(fieldNameElements[0]).get(fieldNameElements[1]);
            } else {
                objectPath = root.joinList(fieldNameElements[0]).get(fieldNameElements[1]);
            }
        }

        while (i < fieldNameElements.length) {
            objectPath = objectPath.get(fieldNameElements[i]);
            if (isJoinPath(objectPath)) {
                throw new RuntimeException("Joinable field is not in 0 index");
            }
            i++;
        }
        return objectPath;
    }

    public static Expression[] getExpressionArrayByGroupByAttributes(Root<?> root, List<String> groupByAttributes) {
        return groupByAttributes
                .stream()
                .map(s -> NESTED_OBJECT_FIELD_NAME_PATTERN.split(s))
                .map(strings -> getPathByFieldElements(root, strings))
                .toArray(Expression[]::new);
    }

    public static List<Order> getOrderByOrderByFilters(CriteriaBuilder builder, Root<?> root, List<OrderByFilter> orderByFilters) {
        return orderByFilters
                .stream()
                .map(orderByFilter -> orderByFilter.getOrder(root, builder))
                .collect(Collectors.toList());
    }
}
