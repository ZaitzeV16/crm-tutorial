package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import com.vaadin.tutorial.crm.backend.library.Utilities;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

public abstract class PredicateFactory {

    public static Predicate build(PredicateParam predicateParam) {
        return predicateParam.operation.build(predicateParam);
    }

    static Object valueOf(Class<?> javaType, String value) {
        if (javaType.equals(Boolean.class) || javaType.equals(boolean.class)) {
            return Boolean.valueOf(value);
        }

        if (javaType.equals(Integer.class) || javaType.equals(int.class)) {
            return Integer.valueOf(value);
        }

        if (javaType.equals(Long.class) || javaType.equals(long.class)) {
            return Long.valueOf(value);
        }

        if (javaType.equals(Double.class) || javaType.equals(double.class)) {
            return Double.valueOf(value);
        }

        if (Enum.class.isAssignableFrom(javaType)) {
            //noinspection unchecked
            return PredicateFactory.getValueAsEnumConstant((Class<? extends Enum<?>>) javaType, value);
        }

        if (javaType.equals(LocalDate.class)) {
            return Utilities.convertStringToLocalDate(value);
        }

        if (javaType.equals(LocalTime.class)) {
            return Utilities.convertStringToLocalTime(value);
        }

        if (javaType.equals(LocalDateTime.class)) {
            return Utilities.convertStringToLocalDateTime(value, true);
        }

        return value;
    }

    private static Object getValueAsEnumConstant(Class<? extends Enum<?>> javaType, String value) {
        Class<? extends Enum<?>> modelFieldTypeAsEnum = javaType;

        Optional<? extends Enum<?>> filterObjectValue = Arrays.stream(modelFieldTypeAsEnum.getEnumConstants())
                .filter(enumConstant -> enumConstant.name().equals(value))
                .findAny();

        return (filterObjectValue.isPresent())
                ? filterObjectValue.get()
                : value;
    }

}