package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source;


import java.time.LocalDate;

/**
 * Result of a {@link DateRange} calculation
 */
public interface DateRangeResult {

    LocalDate getStart();

    LocalDate getEnd();

}
