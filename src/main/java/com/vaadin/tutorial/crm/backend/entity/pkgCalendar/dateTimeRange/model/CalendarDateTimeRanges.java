package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.model;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source.SimpleDateTimeRanges;

public class CalendarDateTimeRanges {
    private CalendarDateTimeRanges() {
        // No Impls
    }

    public static final CalendarDateTimeTimeTimeRange DAY = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.DAY)
            .withTag("has 24 hours");

    public static final CalendarDateTimeTimeTimeRange WEEK = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.WEEK)
            .withTag("has 7 days");

    public static final CalendarDateTimeTimeTimeRange MONTH = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.MONTH)
            .withTag("has 28-31 days");

    public static final CalendarDateTimeTimeTimeRange QUARTER = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.QUARTER)
            .withTag("has 3 months");

    public static final CalendarDateTimeTimeTimeRange HALF_YEAR = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.HALF_YEAR)
            .withTag("has 6 months");

    public static final CalendarDateTimeTimeTimeRange YEAR = new CalendarDateTimeTimeTimeRange()
            .from(SimpleDateTimeRanges.YEAR)
            .withTag("has 12 months");

    public static CalendarDateTimeTimeTimeRange[] allValues() {
        return new CalendarDateTimeTimeTimeRange[]{DAY, WEEK, MONTH, QUARTER, HALF_YEAR, YEAR};
    }
}
