package com.vaadin.tutorial.crm.ui.views.stuff;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.model.CalendarDateRange;
import software.xdev.vaadin.daterange_picker.business.DateRangeModel;
import software.xdev.vaadin.daterange_picker.ui.DateRangePicker;

public class CalendarDateRangePicker extends DateRangePicker<CalendarDateRange> {

    public CalendarDateRangePicker(DateRangeModel<CalendarDateRange> defaultModel) {
        super(defaultModel);
    }

}
