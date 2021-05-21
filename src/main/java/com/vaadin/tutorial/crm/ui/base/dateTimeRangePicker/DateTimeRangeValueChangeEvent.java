package com.vaadin.tutorial.crm.ui.base.dateTimeRangePicker;


import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRange;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRangeModel;

public class DateTimeRangeValueChangeEvent<D extends DateRange> extends ComponentValueChangeEvent<DateTimeRangePicker<D>, DateRangeModel<D>> {

    public DateTimeRangeValueChangeEvent(
            final DateTimeRangePicker<D> source,
            final DateRangeModel<D> oldValue,
            final boolean isFromClient) {
        super(source, source, oldValue, isFromClient);
    }

}
