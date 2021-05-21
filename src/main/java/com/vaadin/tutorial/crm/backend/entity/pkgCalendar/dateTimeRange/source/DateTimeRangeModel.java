package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;


import com.vaadin.tutorial.crm.ui.base.dateRangePicker.DateRangePicker;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Model for {@link DateRangePicker}
 */
@Getter
@AllArgsConstructor
public class DateTimeRangeModel<DATE_TIME_RANGE extends DateTimeRange> implements DateRangeTimeActions<DATE_TIME_RANGE, DateTimeRangeModel<DATE_TIME_RANGE>> {

    private LocalDateTime start;
    private LocalDateTime end;
    private DATE_TIME_RANGE dateRange;

    @Override
    public DateTimeRangeModel<DATE_TIME_RANGE> setStart(final LocalDateTime start) {
        this.start = start;
        return this;
    }

    @Override
    public DateTimeRangeModel<DATE_TIME_RANGE> setEnd(final LocalDateTime end) {
        this.end = end;
        return this;
    }

    @Override
    public DateTimeRangeModel<DATE_TIME_RANGE> setStep(final DATE_TIME_RANGE step) {
        this.dateRange = step;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.dateRange == null ? 0 : this.dateRange.hashCode());
        result = prime * result + (this.end == null ? 0 : this.end.hashCode());
        result = prime * result + (this.start == null ? 0 : this.start.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final DateTimeRangeModel<?> other = (DateTimeRangeModel<?>) obj;
        if (this.dateRange == null) {
            if (other.dateRange != null) {
                return false;
            }
        } else if (!this.dateRange.equals(other.dateRange)) {
            return false;
        }

        if (this.end == null) {
            if (other.end != null) {
                return false;
            }
        } else if (!this.end.equals(other.end)) {
            return false;
        }

        if (this.start == null) {
            return other.start == null;
        } else {
            return this.start.equals(other.start);
        }
    }

}
