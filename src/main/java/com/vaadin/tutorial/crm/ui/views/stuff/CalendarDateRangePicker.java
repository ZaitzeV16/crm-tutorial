package com.vaadin.tutorial.crm.ui.views.stuff;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.model.CalendarDateRange;
import com.vaadin.tutorial.crm.backend.temp.daterange_picker.business.DateRangeModel;
import com.vaadin.tutorial.crm.backend.temp.daterange_picker.ui.DateRangePicker;

public class CalendarDateRangePicker extends DateRangePicker<CalendarDateRange> {

    public CalendarDateRangePicker(DateRangeModel<CalendarDateRange> defaultModel) {
        super(defaultModel);
    }

}
