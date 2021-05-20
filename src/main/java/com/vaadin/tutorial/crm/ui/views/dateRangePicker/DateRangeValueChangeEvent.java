package com.vaadin.tutorial.crm.ui.views.dateRangePicker;


import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRange;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRangeModel;

public class DateRangeValueChangeEvent<D extends DateRange> extends ComponentValueChangeEvent<DateRangePicker<D>, DateRangeModel<D>> {

    public DateRangeValueChangeEvent(
            final DateRangePicker<D> source,
            final DateRangeModel<D> oldValue,
            final boolean isFromClient) {
        super(source, source, oldValue, isFromClient);
    }

}
