package com.vaadin.tutorial.crm.backend.temp.daterange_picker.business;


import java.time.LocalDate;

/**
 * Result of a {@link DateRange} calculation
 */
public interface DateRangeResult {

    LocalDate getStart();

    LocalDate getEnd();

}
