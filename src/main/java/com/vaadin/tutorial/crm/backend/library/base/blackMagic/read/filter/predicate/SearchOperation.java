package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.FiltererUtil;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum SearchOperation {

    GREATER_THAN {
        @Override
        public Predicate build(PredicateParam pp) {
            Class<?> javaType = FiltererUtil.getPathByModelFieldName(pp).getJavaType();

            // TODO: 2020. 11. 10. Zi - refactor NAAAAAAAAAAAAAAAAAAAAAA!
            if (javaType.equals(LocalDate.class)) {
                Path<LocalDate> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDate filterValueString = pp.getActualFilterValueAsLocalDate();

                return pp.builder.greaterThan(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalTime.class)) {
                Path<LocalTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalTime filterValueString = pp.getActualFilterValueAsLocalTime();

                return pp.builder.greaterThan(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalDateTime.class)) {
                Path<LocalDateTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDateTime filterValueString = pp.getActualFilterValueAsLocalDateTime();

                return pp.builder.greaterThan(
                        objectPath,
                        filterValueString);
            }

            Path<String> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            String filterValueString = pp.filterValueString;

            return pp.builder.greaterThan(
                    objectPath,
                    filterValueString);
        }
    },

    LESS_THAN {
        @Override
        public Predicate build(PredicateParam pp) {
            Class<?> javaType = FiltererUtil.getPathByModelFieldName(pp).getJavaType();

            // TODO: 2020. 11. 10. Zi - refactor NAAAAAAAAAAAAAAAAAAAAAA!
            if (javaType.equals(LocalDate.class)) {
                Path<LocalDate> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDate filterValueString = pp.getActualFilterValueAsLocalDate();

                return pp.builder.lessThan(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalTime.class)) {
                Path<LocalTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalTime filterValueString = pp.getActualFilterValueAsLocalTime();

                return pp.builder.lessThan(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalDateTime.class)) {
                Path<LocalDateTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDateTime filterValueString = pp.getActualFilterValueAsLocalDateTime();

                return pp.builder.lessThan(
                        objectPath,
                        filterValueString);
            }

            Path<String> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            String filterValueString = pp.filterValueString;

            return pp.builder.lessThan(
                    objectPath,
                    filterValueString);
        }
    },

    GREATER_THAN_EQUAL {
        @Override
        public Predicate build(PredicateParam pp) {
            Class<?> javaType = FiltererUtil.getPathByModelFieldName(pp).getJavaType();

            // TODO: 2020. 11. 10. Zi - refactor NAAAAAAAAAAAAAAAAAAAAAA!
            if (javaType.equals(LocalDate.class)) {
                Path<LocalDate> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDate filterValueString = pp.getActualFilterValueAsLocalDate();

                return pp.builder.greaterThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalTime.class)) {
                Path<LocalTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalTime filterValueString = pp.getActualFilterValueAsLocalTime();

                return pp.builder.greaterThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalDateTime.class)) {
                Path<LocalDateTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDateTime filterValueString = pp.getActualFilterValueAsLocalDateTime();

                return pp.builder.greaterThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            Path<String> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            String filterValueString = pp.filterValueString;

            return pp.builder.greaterThanOrEqualTo(
                    objectPath,
                    filterValueString);
        }
    },

    LESS_THAN_EQUAL {
        @Override
        public Predicate build(PredicateParam pp) {
            Class<?> javaType = FiltererUtil.getPathByModelFieldName(pp).getJavaType();

            // TODO: 2020. 11. 10. Zi - refactor NAAAAAAAAAAAAAAAAAAAAAA!
            if (javaType.equals(LocalDate.class)) {
                Path<LocalDate> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDate filterValueString = pp.getActualFilterValueAsLocalDate();

                return pp.builder.lessThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalTime.class)) {
                Path<LocalTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalTime filterValueString = pp.getActualFilterValueAsLocalTime();

                return pp.builder.lessThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            if (javaType.equals(LocalDateTime.class)) {
                Path<LocalDateTime> objectPath = FiltererUtil.getPathByModelFieldName(pp);
                LocalDateTime filterValueString = pp.getActualFilterValueAsLocalDateTime();

                return pp.builder.lessThanOrEqualTo(
                        objectPath,
                        filterValueString);
            }

            Path<String> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            String filterValueString = pp.filterValueString;

            return pp.builder.lessThanOrEqualTo(
                    objectPath,
                    filterValueString);
        }
    },

    NOT_EQUAL {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Object> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.notEqual(
                    objectPath,
                    PredicateFactory.valueOf(objectPath.getJavaType(), pp.filterValueString));
        }
    },

    EQUAL {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Object> objectPath = FiltererUtil.getPathByModelFieldName(pp);
            Class<?> javaType = objectPath.getJavaType();
            String filterValueString = pp.filterValueString;
            Object actualFilterValue = PredicateFactory.valueOf(javaType, filterValueString);

            return pp.builder.equal(
                    objectPath,
                    actualFilterValue);
        }
    },

    IS_NULL {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Object> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.isNull(expression);
        }
    },

    IS_NOT_NULL {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Object> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.isNotNull(expression);
        }
    },

    MATCH {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.like(
                    pp.builder.lower(expression),
                    "%" + pp.filterValueString.toLowerCase() + "%");
        }
    },
    NOT_MATCH {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.notLike(
                    pp.builder.lower(expression),
                    "%" + pp.filterValueString.toLowerCase() + "%");
        }
    },

    MATCH_START {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.like(
                    pp.builder.lower(expression),
                    pp.filterValueString.toLowerCase() + "%");
        }
    },
    MATCH_NOT_START {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.notLike(
                    pp.builder.lower(expression),
                    pp.filterValueString.toLowerCase() + "%");
        }
    },

    MATCH_END {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.like(
                    pp.builder.lower(expression),
                    "%" + pp.filterValueString.toLowerCase());
        }
    },
    MATCH_NOT_END {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<String> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.notLike(
                    pp.builder.lower(expression),
                    "%" + pp.filterValueString.toLowerCase());
        }
    },

    IN {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Object> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.in(expression)
                    .value(pp.filterValueString);
        }
    },

    NOT_IN {
        @Override
        public Predicate build(PredicateParam pp) {
            Path<Boolean> expression = FiltererUtil.getPathByModelFieldName(pp);
            return pp.builder.not(expression)
                    .in(pp.filterValueString);
        }
    };

    public abstract Predicate build(PredicateParam pp);

}
