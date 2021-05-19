package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import com.vaadin.tutorial.crm.backend.library.Utilities;
import lombok.AllArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
public class PredicateParam {

    public SearchOperation operation;
    public CriteriaBuilder builder;
    public Root<?> root;
    public Class<?> modelClass;
    public String modelFieldName;
    public String filterValueString;

    public Path<LocalDateTime> getActualObjectPathWithLocalDateTime() {
        return root.get(modelFieldName);
    }

    public LocalDateTime getActualFilterValueAsLocalDateTime() {
        return Utilities.convertStringToLocalDateTime(filterValueString, true);
    }

    public Path<LocalDate> getActualObjectPathWithLocalDate() {
        return root.get(modelFieldName);
    }

    public LocalDate getActualFilterValueAsLocalDate() {
        return Utilities.convertStringToLocalDate(filterValueString);
    }

    public Path<LocalTime> getActualObjectPathWithLocalTime() {
        return root.get(modelFieldName);
    }

    public LocalTime getActualFilterValueAsLocalTime() {
        return Utilities.convertStringToLocalTime(filterValueString);
    }

}
