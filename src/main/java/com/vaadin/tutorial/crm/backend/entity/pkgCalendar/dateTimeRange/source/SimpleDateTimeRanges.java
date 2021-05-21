package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

/**
 * Contains predefined {@link SimpleDateTimeTimeRange SimpleDateRanges}
 */
public final class SimpleDateTimeRanges {
    private SimpleDateTimeRanges() {
        // No Impls
    }

    // @formatter:off
    public static final SimpleDateTimeTimeRange TODAY = new SimpleDateTimeTimeRange()
            .withKey("TODAY")
            .withDefaultDesc("Today")
            .withMovable(false)
            .withSettable(false)
            .withCalcForFunc(date -> new SimpleDateTimeRangeResult(LocalDate.now(), LocalDate.now()));

    public static final SimpleDateTimeTimeRange DAY = new SimpleDateTimeTimeRange()
            .withKey("DAY")
            .withDefaultDesc("Day")
            .withMovePeriod(Period.ofDays(1))
            .withCalcForFunc(date -> new SimpleDateTimeRangeResult(date, date));

    public static final SimpleDateTimeTimeRange WEEK = new SimpleDateTimeTimeRange()
            .withKey("WEEK")
            .withDefaultDesc("Week")
            .withMovePeriod(Period.ofWeeks(1))
            .withCalcForFunc(date -> {
                final LocalDate start = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                return new SimpleDateTimeRangeResult(start, start.plusDays(6));
            });

    public static final SimpleDateTimeTimeRange MONTH = new SimpleDateTimeTimeRange()
            .withKey("MONTH")
            .withDefaultDesc("Month")
            .withMovePeriod(Period.ofMonths(1))
            .withCalcForFunc(date ->
                    new SimpleDateTimeRangeResult(
                            date.with(TemporalAdjusters.firstDayOfMonth()),
                            date.with(TemporalAdjusters.lastDayOfMonth())));

    public static final SimpleDateTimeTimeRange QUARTER = new SimpleDateTimeTimeRange()
            .withKey("QUARTER")
            .withDefaultDesc("Quarter")
            .withMovePeriod(Period.ofMonths(3))
            .withCalcForFunc(date -> {
                final int startMonth = (int) Math.floor((date.getMonthValue() - 1) / 3.0) * 3 + 1;
                final int endMonth = startMonth + 2;

                return new SimpleDateTimeRangeResult(
                        LocalDate.of(date.getYear(), startMonth, 1),
                        LocalDate.of(date.getYear(), endMonth, 1).with(TemporalAdjusters.lastDayOfMonth()));
            });

    public static final SimpleDateTimeTimeRange HALF_YEAR = new SimpleDateTimeTimeRange()
            .withKey("HALF_YEAR")
            .withDefaultDesc("Half year")
            .withMovePeriod(Period.ofMonths(6))
            .withCalcForFunc(date -> {
                final int startMonth = (int) Math.floor((date.getMonthValue() - 1) / 6.0) * 6 + 1;
                final int endMonth = startMonth + 5;

                return new SimpleDateTimeRangeResult(
                        LocalDate.of(date.getYear(), startMonth, 1),
                        LocalDate.of(date.getYear(), endMonth, 1).with(TemporalAdjusters.lastDayOfMonth()));
            });

    public static final SimpleDateTimeTimeRange YEAR = new SimpleDateTimeTimeRange()
            .withKey("YEAR")
            .withDefaultDesc("Years")
            .withMovePeriod(Period.ofYears(1))
            .withCalcForFunc(date ->
                    new SimpleDateTimeRangeResult(
                            date.with(TemporalAdjusters.firstDayOfYear()),
                            date.with(TemporalAdjusters.lastDayOfYear())));

    public static final SimpleDateTimeTimeRange FREE = new SimpleDateTimeTimeRange()
            .withKey("FREE")
            .withDefaultDesc("Free")
            .withMovable(false)
            .withCalcable(false);


    public static SimpleDateTimeTimeRange[] allValues() {
        return new SimpleDateTimeTimeRange[]{
                TODAY, DAY, WEEK, MONTH, QUARTER, HALF_YEAR, YEAR, FREE
        };

    }
}
