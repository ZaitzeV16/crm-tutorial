package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.DateTimeStep;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @param <SELF> implementer
 */
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Getter
public abstract class AbstractDateTimeTimeRange<SELF extends AbstractDateTimeTimeRange<SELF>> implements DateTimeRange {

    private String key;
    private String defaultDescription;

    private Optional<DateTimeStep> step = Optional.empty();
    private Function<LocalDateTime, Optional<DateTimeRangeResult>> stepCalcFunc;
    private BiFunction<LocalDateTime, Integer, Optional<DateTimeRangeResult>> moveByStepFunc = (dateTime, count) ->
    {
        if (this.step.isEmpty()) {
            return Optional.empty();
        }

        LocalDateTime input = count != 0 ? dateTime.plus(this.step.get().multipliedBy(count)) : dateTime;
        return this.stepCalcFunc.apply(input);
    };

    private boolean movable = true;
    private boolean calculated = true;
    private boolean settable = true;

    @SuppressWarnings("unchecked")
    public SELF self() {
        return (SELF) this;
    }

    // -- CONFIGURE
    public SELF withKey(final String key) {
        this.key = key;
        return this.self();
    }

    public SELF withStep(final DateTimeStep Step) {
        this.step = Optional.ofNullable(Step);
        return this.self();
    }

    public SELF withDefaultDesc(final String defaultDesc) {
        this.defaultDescription = defaultDesc;
        return this.self();
    }

    public SELF withStepCalcFunc(final Function<LocalDateTime, DateTimeRangeResult> calcForFunc) {
        return this.withOptStepCalcFunc(date -> Optional.ofNullable(calcForFunc.apply(date)));
    }

    public SELF withOptStepCalcFunc(final Function<LocalDateTime, Optional<DateTimeRangeResult>> stepCalcFunc) {
        this.stepCalcFunc = stepCalcFunc;
        return this.self();
    }

    public SELF withMoveByStepFunc(final BiFunction<LocalDateTime, Integer, Optional<DateTimeRangeResult>> moveByStepFunc) {
        this.moveByStepFunc = moveByStepFunc;
        return this.self();
    }

    public SELF withMovable(final boolean movable) {
        this.movable = movable;
        return this.self();
    }

    public SELF withCalculated(final boolean calcable) {
        this.calculated = calcable;
        return this.self();
    }

    public SELF withSettable(final boolean settable) {
        this.settable = settable;
        return this.self();
    }

    public SELF from(final AbstractDateTimeTimeRange<?> dateRange) {
        this.key = dateRange.getKey();
        this.step = dateRange.getStep();
        this.defaultDescription = dateRange.getDefaultDescription();
        this.stepCalcFunc = dateRange.getStepCalcFunc();
        this.moveByStepFunc = dateRange.getMoveByStepFunc();
        this.movable = dateRange.isMovable();
        this.calculated = dateRange.isCalculated();
        this.settable = dateRange.isSettable();

        return this.self();
    }

    @Override
    public boolean isMovable() {
        return this.movable && this.calculated;
    }

    @Override
    public Optional<DateTimeRangeResult> calcFor(final LocalDateTime dateTime) {
        if (!this.isCalculated()) {
            return Optional.empty();
        }
        return this.stepCalcFunc.apply(dateTime);
    }

    @Override
    public Optional<DateTimeRangeResult> moveByStep(final LocalDateTime baseDateTime, final int diff) {
        if (!this.isMovable()) {
            return Optional.empty();
        }
        return this.moveByStepFunc.apply(baseDateTime, diff);
    }

}
