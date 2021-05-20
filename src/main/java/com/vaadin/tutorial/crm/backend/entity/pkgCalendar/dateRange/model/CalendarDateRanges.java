package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.model;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.SimpleDateRanges;

public class CalendarDateRanges {
    private CalendarDateRanges() {
        // No Impls
    }

    public static final CalendarDateRange DAY = new CalendarDateRange()
            .from(SimpleDateRanges.DAY)
            .withTag("has 24 hours");

    public static final CalendarDateRange WEEK = new CalendarDateRange()
            .from(SimpleDateRanges.WEEK)
            .withTag("has 7 days");

    public static final CalendarDateRange MONTH = new CalendarDateRange()
            .from(SimpleDateRanges.MONTH)
            .withTag("has 28-31 days");

    public static final CalendarDateRange QUARTER = new CalendarDateRange()
            .from(SimpleDateRanges.QUARTER)
            .withTag("has 3 months");

    public static final CalendarDateRange HALF_YEAR = new CalendarDateRange()
            .from(SimpleDateRanges.HALF_YEAR)
            .withTag("has 6 months");

    public static final CalendarDateRange YEAR = new CalendarDateRange()
            .from(SimpleDateRanges.YEAR)
            .withTag("has 12 months");

    public static CalendarDateRange[] allValues() {
        return new CalendarDateRange[]{DAY, WEEK, MONTH, QUARTER, HALF_YEAR, YEAR};
    }
}
