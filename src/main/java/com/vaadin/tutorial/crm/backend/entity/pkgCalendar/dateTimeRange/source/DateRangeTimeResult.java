package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;


import java.time.LocalDate;

/**
 * Result of a {@link DateTimeRange} calculation
 */
public interface DateRangeTimeResult {

    LocalDate getStart();

    LocalDate getEnd();

}
