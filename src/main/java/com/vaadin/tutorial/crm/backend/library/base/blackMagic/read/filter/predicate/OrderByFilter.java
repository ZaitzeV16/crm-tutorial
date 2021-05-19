package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderByFilter {
    private OrderBySortType sortType;
    private String orderByAttribute;

    public Order getOrder(Root<?> root, CriteriaBuilder builder) {
        return sortType.build(root, builder, orderByAttribute);
    }
}
