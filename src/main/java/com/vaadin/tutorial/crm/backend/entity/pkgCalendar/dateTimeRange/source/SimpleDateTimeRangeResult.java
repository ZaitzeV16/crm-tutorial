package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Simple implementation of {@link DateTimeRangeResult}
 */
@Getter
public class SimpleDateTimeRangeResult implements DateTimeRangeResult {

    private final LocalDate startDate;
    private final LocalTime startTime;

    private final LocalDate endDate;
    private final LocalTime endTime;

    public SimpleDateTimeRangeResult(final LocalDate startDate, final LocalDate endDate) {
        this(
                startDate.atStartOfDay(),
                endDate.plusDays(1).atStartOfDay().minusSeconds(1L)
        );
    }

    public SimpleDateTimeRangeResult(final LocalDateTime start, final LocalDateTime end) {
        this.startDate = start.toLocalDate();
        this.startTime = start.toLocalTime();

        this.endDate = end.toLocalDate();
        this.endTime = end.toLocalTime();
    }


    @Override
    public LocalDateTime getStart() {
        return LocalDateTime.of(this.startDate, this.startTime);
    }

    @Override
    public LocalDateTime getEnd() {
        return LocalDateTime.of(this.endDate, this.endTime);
    }

}
