package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import lombok.Getter;

import java.time.LocalDate;

/**
 * Simple implementation of {@link DateRangeTimeResult}
 */
@Getter
public class SimpleDateTimeRangeResult implements DateRangeTimeResult {

    private final LocalDate start;
    private final LocalDate end;

    public SimpleDateTimeRangeResult(final LocalDate start, final LocalDate end) {
        super();
        this.start = start;
        this.end = end;
    }

}
