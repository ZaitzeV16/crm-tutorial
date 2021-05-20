package com.vaadin.tutorial.crm.backend.temp.daterange_picker.ui;


import com.vaadin.flow.component.AbstractField;
import com.vaadin.tutorial.crm.backend.temp.daterange_picker.business.DateRange;
import com.vaadin.tutorial.crm.backend.temp.daterange_picker.business.DateRangeModel;

public class DateRangeValueChangeEvent<D extends DateRange> extends AbstractField.ComponentValueChangeEvent<DateRangePicker<D>, DateRangeModel<D>> {
    public DateRangeValueChangeEvent(
            final DateRangePicker<D> source,
            final DateRangeModel<D> oldValue,
            final boolean isFromClient) {
        super(source, source, oldValue, isFromClient);
    }
}
