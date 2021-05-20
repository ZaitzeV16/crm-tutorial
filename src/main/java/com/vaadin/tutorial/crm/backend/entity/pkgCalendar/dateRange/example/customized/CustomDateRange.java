package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.example.customized;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.AbstractDateRange;

public class CustomDateRange extends AbstractDateRange<CustomDateRange> {

    private String tag;

    public CustomDateRange withTag(final String tag) {
        this.tag = (tag != null) ? tag : "";
        return this;
    }

    public String getTag() {
        return this.tag;
    }

}
