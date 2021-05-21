package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Result of a {@link DateTimeRange} calculation
 */
public interface DateTimeRangeResult {

    LocalDateTime getStart();

    LocalDate getStartDate();

    LocalTime getStartTime();


    LocalDateTime getEnd();

    LocalDate getEndDate();

    LocalTime getEndTime();

}
