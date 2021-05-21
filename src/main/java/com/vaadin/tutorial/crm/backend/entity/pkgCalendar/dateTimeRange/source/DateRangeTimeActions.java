package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;


import java.time.LocalDate;

/**
 * Actions which can be done with a {@link DateRangeTimeModel}
 *
 * @param <D> DateRange
 * @param <T> Implementer; returned as "Builder"
 */
public interface DateRangeTimeActions<D extends DateTimeRange, T> {

    LocalDate getStart();

    T setStart(final LocalDate start);

    LocalDate getEnd();

    T setEnd(final LocalDate end);

    D getDateRange();

    T setDateRange(final D dateRange);

}
