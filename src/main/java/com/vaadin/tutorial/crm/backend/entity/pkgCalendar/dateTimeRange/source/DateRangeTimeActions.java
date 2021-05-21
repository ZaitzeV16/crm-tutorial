package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;


import java.time.LocalDateTime;

/**
 * Actions which can be done with a {@link DateTimeRangeModel}
 *
 * @param <DATE_TIME_RANGE> DateTimeRange
 * @param <SELF> Implementer; returned as "Builder"
 */
public interface DateRangeTimeActions<DATE_TIME_RANGE extends DateTimeRange, SELF> {

    LocalDateTime getStart();

    SELF setStart(final LocalDateTime start);

    LocalDateTime getEnd();

    SELF setEnd(final LocalDateTime end);

    DATE_TIME_RANGE getDateRange();

    SELF setStep(final DATE_TIME_RANGE step);

}
