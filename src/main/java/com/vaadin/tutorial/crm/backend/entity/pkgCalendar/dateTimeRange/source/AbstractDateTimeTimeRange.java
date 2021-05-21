package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Basic implementation of {@link DateTimeRange}
 *
 * @param <SELF> implementer
 */
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public abstract class AbstractDateTimeTimeRange<SELF extends AbstractDateTimeTimeRange<SELF>> implements DateTimeRange {
    private String key;
    private Optional<Period> optMovePeriod = Optional.empty();
    private String defaultDesc;
    private Function<LocalDate, Optional<DateRangeTimeResult>> calcForFunc;
    private BiFunction<LocalDate, Integer, Optional<DateRangeTimeResult>> moveFunc = (date, count) ->
    {
        if (this.optMovePeriod.isEmpty()) {
            return Optional.empty();
        }

        return this.calcForFunc.apply(count != 0 ? date.plus(this.optMovePeriod.get().multipliedBy(count)) : date);
    };
    private boolean movable = true;
    private boolean calcable = true;
    private boolean setable = true;

    @SuppressWarnings("unchecked")
    public SELF self() {
        return (SELF) this;
    }

    // -- CONFIGURE
    public SELF withKey(final String key) {
        this.key = key;
        return this.self();
    }

    public SELF withMovePeriod(final Period period) {
        this.optMovePeriod = Optional.ofNullable(period);
        return this.self();
    }

    public SELF withDefaultDesc(final String defaultDesc) {
        this.defaultDesc = defaultDesc;
        return this.self();
    }

    public SELF withCalcForFunc(final Function<LocalDate, DateRangeTimeResult> calcForFunc) {
        return this.withOptCalcForFunc(date -> Optional.ofNullable(calcForFunc.apply(date)));
    }

    public SELF withOptCalcForFunc(final Function<LocalDate, Optional<DateRangeTimeResult>> calcForFunc) {
        this.calcForFunc = calcForFunc;
        return this.self();
    }

    public SELF withMoveFunc(final BiFunction<LocalDate, Integer, Optional<DateRangeTimeResult>> moveFunc) {
        this.moveFunc = moveFunc;
        return this.self();
    }

    public SELF withMovable(final boolean movable) {
        this.movable = movable;
        return this.self();
    }

    public SELF withCalcable(final boolean calcable) {
        this.calcable = calcable;
        return this.self();
    }

    public SELF withSettable(final boolean settable) {
        this.setable = settable;
        return this.self();
    }

    public SELF from(final AbstractDateTimeTimeRange<?> dateRange) {
        this.key = dateRange.getKey();
        this.optMovePeriod = dateRange.getOptMovePeriod();
        this.defaultDesc = dateRange.getDefaultDescription();
        this.calcForFunc = dateRange.getCalcForFunc();
        this.moveFunc = dateRange.getMoveFunc();
        this.movable = dateRange.isMovable();
        this.calcable = dateRange.isCalcable();
        this.setable = dateRange.isSettable();

        return this.self();
    }

    // -- GETTER

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Optional<Period> getOptMovePeriod() {
        return this.optMovePeriod;
    }

    @Override
    public String getDefaultDescription() {
        return this.defaultDesc;
    }

    @Override
    public boolean isMovable() {
        return this.movable && this.isCalcable();
    }

    @Override
    public boolean isCalcable() {
        return this.calcable;
    }

    @Override
    public boolean isSettable() {
        return this.setable;
    }

    public Function<LocalDate, Optional<DateRangeTimeResult>> getCalcForFunc() {
        return this.calcForFunc;
    }

    public BiFunction<LocalDate, Integer, Optional<DateRangeTimeResult>> getMoveFunc() {
        return this.moveFunc;
    }

    @Override
    public Optional<DateRangeTimeResult> calcFor(final LocalDate date) {
        if (!this.isCalcable()) {
            return Optional.empty();
        }
        return this.calcForFunc.apply(date);
    }

    @Override
    public Optional<DateRangeTimeResult> moveDateRange(final LocalDate date, final int dif) {
        if (!this.isMovable()) {
            return Optional.empty();
        }
        return this.moveFunc.apply(date, dif);
    }

}
