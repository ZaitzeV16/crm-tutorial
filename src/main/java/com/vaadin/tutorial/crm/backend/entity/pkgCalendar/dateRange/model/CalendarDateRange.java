package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.model;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.AbstractDateRange;

public class CalendarDateRange extends AbstractDateRange<CalendarDateRange> {

    private String tag;

    public CalendarDateRange withTag(final String tag) {
        this.tag = (tag != null) ? tag : "";
        return this;
    }

    public String getTag() {
        return this.tag;
    }

}
