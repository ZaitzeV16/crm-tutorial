package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source;

import lombok.Getter;

import java.time.LocalDate;

/**
 * Simple implementation of {@link DateRangeResult}
 */
@Getter
public class SimpleDateRangeResult implements DateRangeResult {

    private final LocalDate start;
    private final LocalDate end;

    public SimpleDateRangeResult(final LocalDate start, final LocalDate end) {
        super();
        this.start = start;
        this.end = end;
    }

}
