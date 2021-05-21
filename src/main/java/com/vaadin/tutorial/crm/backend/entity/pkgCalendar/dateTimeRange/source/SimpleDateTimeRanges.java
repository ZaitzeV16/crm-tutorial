package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.DateTimeStep;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Contains predefined {@link SimpleDateTimeTimeRange SimpleDateRanges}
 */
@NoArgsConstructor
public final class SimpleDateTimeRanges {

    public static final SimpleDateTimeTimeRange TODAY = new SimpleDateTimeTimeRange()
            .withKey("TODAY")
            .withDefaultDesc("Today")
            .withMovable(false)
            .withSettable(false)
            .withStepCalcFunc(dateTime -> new SimpleDateTimeRangeResult(LocalDateTime.now(), LocalDateTime.now()));

    public static final SimpleDateTimeTimeRange DAY = new SimpleDateTimeTimeRange()
            .withKey("DAY")
            .withDefaultDesc("Day")
            .withStep(DateTimeStep.ofDays(1))
            .withStepCalcFunc(dateTime -> new SimpleDateTimeRangeResult(dateTime, dateTime));

    public static final SimpleDateTimeTimeRange WEEK = new SimpleDateTimeTimeRange()
            .withKey("WEEK")
            .withDefaultDesc("Week")
            .withStep(DateTimeStep.ofWeeks(1))
            .withStepCalcFunc(dateTime -> {
                final LocalDateTime start = dateTime.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                return new SimpleDateTimeRangeResult(start, start.plusDays(6));
            });

    public static final SimpleDateTimeTimeRange MONTH = new SimpleDateTimeTimeRange()
            .withKey("MONTH")
            .withDefaultDesc("Month")
            .withStep(DateTimeStep.ofMonths(1))
            .withStepCalcFunc(dateTime ->
                    new SimpleDateTimeRangeResult(
                            dateTime.with(TemporalAdjusters.firstDayOfMonth()),
                            dateTime.with(TemporalAdjusters.lastDayOfMonth())));

    public static final SimpleDateTimeTimeRange QUARTER = new SimpleDateTimeTimeRange()
            .withKey("QUARTER")
            .withDefaultDesc("Quarter")
            .withStep(DateTimeStep.ofMonths(3))
            .withStepCalcFunc(dateTime -> {
                final int startMonth = (int) Math.floor((dateTime.getMonthValue() - 1) / 3.0) * 3 + 1;
                final int endMonth = startMonth + 2;

                return new SimpleDateTimeRangeResult(
                        LocalDate.of(dateTime.getYear(), startMonth, 1),
                        LocalDate.of(dateTime.getYear(), endMonth, 1).with(TemporalAdjusters.lastDayOfMonth()));
            });

    public static final SimpleDateTimeTimeRange HALF_YEAR = new SimpleDateTimeTimeRange()
            .withKey("HALF_YEAR")
            .withDefaultDesc("Half year")
            .withStep(DateTimeStep.ofMonths(6))
            .withStepCalcFunc(dateTime -> {
                final int startMonth = (int) Math.floor((dateTime.getMonthValue() - 1) / 6.0) * 6 + 1;
                final int endMonth = startMonth + 5;

                return new SimpleDateTimeRangeResult(
                        LocalDate.of(dateTime.getYear(), startMonth, 1),
                        LocalDate.of(dateTime.getYear(), endMonth, 1).with(TemporalAdjusters.lastDayOfMonth()));
            });

    public static final SimpleDateTimeTimeRange YEAR = new SimpleDateTimeTimeRange()
            .withKey("YEAR")
            .withDefaultDesc("Years")
            .withStep(DateTimeStep.ofYears(1))
            .withStepCalcFunc(dateTime ->
                    new SimpleDateTimeRangeResult(
                            dateTime.with(TemporalAdjusters.firstDayOfYear()),
                            dateTime.with(TemporalAdjusters.lastDayOfYear())));

    public static final SimpleDateTimeTimeRange FREE = new SimpleDateTimeTimeRange()
            .withKey("FREE")
            .withDefaultDesc("Free")
            .withMovable(false)
            .withCalculated(false);


    public static SimpleDateTimeTimeRange[] allValues() {
        return new SimpleDateTimeTimeRange[]{
                TODAY, DAY, WEEK, MONTH, QUARTER, HALF_YEAR, YEAR, FREE
        };
    }

}
