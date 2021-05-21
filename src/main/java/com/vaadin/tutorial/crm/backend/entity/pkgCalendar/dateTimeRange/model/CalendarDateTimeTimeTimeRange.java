package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.model;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source.AbstractDateTimeTimeRange;

public class CalendarDateTimeTimeTimeRange extends AbstractDateTimeTimeRange<CalendarDateTimeTimeTimeRange> {

    private String tag;

    public CalendarDateTimeTimeTimeRange withTag(final String tag) {
        this.tag = (tag != null) ? tag : "";
        return this;
    }

    public String getTag() {
        return this.tag;
    }

}
