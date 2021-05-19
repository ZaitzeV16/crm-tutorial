package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.FiltererUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

public enum OrderBySortType {
    ASC {
        @Override
        public Order build(Root<?> root, CriteriaBuilder builder, String orderByAttribute) {
            return builder.asc(FiltererUtil.getPathByModelFieldName(root, orderByAttribute));
        }
    },
    DESC {
        @Override
        public Order build(Root<?> root, CriteriaBuilder builder, String orderByAttribute) {
            return builder.desc(FiltererUtil.getPathByModelFieldName(root, orderByAttribute));
        }
    };


    public abstract Order build(Root<?> root, CriteriaBuilder builder, String orderByAttribute);
}
