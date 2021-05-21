package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.IsoChronology;
import java.time.temporal.*;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.*;

@Getter
public final class DateTimeStep implements TemporalAmount, Serializable {

    public static final DateTimeStep ZERO = new DateTimeStep(Period.ZERO, Duration.ZERO);

    private static final List<TemporalUnit> SUPPORTED_UNITS = List.of(YEARS, MONTHS, DAYS, SECONDS, NANOS);
    private static final long SECONDS_PER_DAY = 86400;

    private final Period period;
    private final Duration duration;


    // region Static "constructors"
    public static DateTimeStep ofDays(int days) {
        return DateTimeStep.of(Period.ofDays(days));
    }

    public static DateTimeStep ofWeeks(int weeks) {
        return DateTimeStep.of(Period.ofWeeks(weeks));
    }

    public static DateTimeStep ofMonths(int months) {
        return DateTimeStep.of(Period.ofMonths(months));
    }

    public static DateTimeStep ofYears(int years) {
        return DateTimeStep.of(Period.ofYears(years));
    }

    public static DateTimeStep between(@NotNull LocalDate startDateInclusive, @NotNull LocalDate endDateExclusive) {
        Period periodDifference = startDateInclusive.until(endDateExclusive);
        return DateTimeStep.of(periodDifference);
    }

    public static DateTimeStep between(@NotNull LocalTime startTimeInclusive, @NotNull LocalTime endTimeExclusive) {
        Duration durationDifference = Duration.between(startTimeInclusive, endTimeExclusive);
        return DateTimeStep.of(durationDifference);
    }

    public static DateTimeStep between(@NotNull LocalDateTime startInclusive, @NotNull LocalDateTime endExclusive) {
        Period periodDifference = Period.between(startInclusive.toLocalDate(), endExclusive.toLocalDate());
        Duration durationDifference = Duration.between(startInclusive.toLocalTime(), endExclusive.toLocalTime());
        return DateTimeStep.of(periodDifference, durationDifference);
    }

    public static DateTimeStep of(@NotNull Period period, @NotNull Duration duration) {
        return new DateTimeStep(period, duration);
    }

    public static DateTimeStep of(@NotNull Period period) {
        return new DateTimeStep(period, Duration.ZERO);
    }

    public static DateTimeStep of(@NotNull Duration duration) {
        return new DateTimeStep(Period.ZERO, duration);
    }

    /**
     * Obtains an instance from a temporal amount.
     * <p>
     * This obtains an instance based on the specified amount.
     * A {@code TemporalAmount} represents an amount of time which this factory
     * extracts to a {@code PeriodDuration}.
     * <p>
     * The result is calculated by looping around each unit in the specified amount.
     * Any amount that is zero is ignore.
     * If a unit has an exact duration, it will be totalled using {@link Duration#plus(Duration)}.
     * If the unit is days or weeks, it will be totalled into the days part of the period.
     * If the unit is months or quarters, it will be totalled into the months part of the period.
     * If the unit is years, decades, centuries or millennia, it will be totalled into the years part of the period.
     *
     * @param amount the temporal amount to convert, not null
     * @return the equivalent duration, not null
     * @throws DateTimeException   if unable to convert to a {@code Duration}
     * @throws ArithmeticException if numeric overflow occurs
     */
    public static DateTimeStep from(TemporalAmount amount) {
        if (amount instanceof DateTimeStep) {
            return (DateTimeStep) amount;
        }
        if (amount instanceof Period) {
            return DateTimeStep.of((Period) amount);
        }
        if (amount instanceof Duration) {
            return DateTimeStep.of((Duration) amount);
        }
        if (amount instanceof ChronoPeriod) {
            if (!IsoChronology.INSTANCE.equals(((ChronoPeriod) amount).getChronology())) {
                throw new DateTimeException("Period requires ISO chronology: " + amount);
            }
        }
        Objects.requireNonNull(amount, "amount");
        int years = 0;
        int months = 0;
        int days = 0;
        Duration duration = Duration.ZERO;
        for (TemporalUnit unit : amount.getUnits()) {
            long value = amount.get(unit);
            if (value != 0) {
                // ignore unless non-zero
                if (unit.isDurationEstimated()) {
                    if (unit == ChronoUnit.DAYS) {
                        days = Math.addExact(days, Math.toIntExact(value));
                    } else if (unit == ChronoUnit.WEEKS) {
                        days = Math.addExact(days, Math.toIntExact(Math.multiplyExact(value, 7)));
                    } else if (unit == ChronoUnit.MONTHS) {
                        months = Math.addExact(months, Math.toIntExact(value));
                    } else if (unit == IsoFields.QUARTER_YEARS) {
                        months = Math.addExact(months, Math.toIntExact(Math.multiplyExact(value, 3)));
                    } else if (unit == ChronoUnit.YEARS) {
                        years = Math.addExact(years, Math.toIntExact(value));
                    } else if (unit == ChronoUnit.DECADES) {
                        years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 10)));
                    } else if (unit == ChronoUnit.CENTURIES) {
                        years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 100)));
                    } else if (unit == ChronoUnit.MILLENNIA) {
                        years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 1000)));
                    } else {
                        throw new DateTimeException("Unknown unit: " + unit);
                    }
                } else {
                    // total of exact durations
                    duration = duration.plus(amount.get(unit), unit);
                }
            }
        }
        return DateTimeStep.of(Period.of(years, months, days), duration);
    }
    // region Static "constructors"


    private DateTimeStep(Period period, Duration duration) {
        this.period = period;
        this.duration = duration;
    }

    @Override
    public long get(TemporalUnit unit) {
        if (unit instanceof ChronoUnit) {
            switch ((ChronoUnit) unit) {
                case YEARS:
                    return period.getYears();
                case MONTHS:
                    return period.getMonths();
                case DAYS:
                    return period.getDays();
                case SECONDS:
                    return duration.getSeconds();
                case NANOS:
                    return duration.getNano();
                default:
                    break;
            }
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
    }

    @Override
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    public DateTimeStep withPeriod(Period period) {
        return DateTimeStep.of(period, this.duration);
    }

    public DateTimeStep withDuration(Duration duration) {
        return DateTimeStep.of(this.period, duration);
    }

    public boolean isZero() {
        return this.period.isZero() && this.duration.isZero();
    }

    public DateTimeStep plus(TemporalAmount amountToAdd) {
        DateTimeStep other = DateTimeStep.from(amountToAdd);

        Period period = this.period.plus(other.period);
        Duration duration = this.duration.plus(other.duration);

        return DateTimeStep.of(period, duration);
    }

    public DateTimeStep minus(TemporalAmount amountToAdd) {
        DateTimeStep other = DateTimeStep.from(amountToAdd);

        Period period = this.period.minus(other.period);
        Duration duration = this.duration.minus(other.duration);

        return DateTimeStep.of(period, duration);
    }

    public DateTimeStep multipliedBy(int scalar) {
        Period period = this.period.multipliedBy(scalar);
        Duration duration = this.duration.multipliedBy(scalar);

        return DateTimeStep.of(period, duration);
    }

//    public DateTimeStep negated() {
//        return multipliedBy(-1);
//    }
//
//    public DateTimeStep normalizedYears() {
//        return withPeriod(period.normalized());
//    }
//
//    public DateTimeStep normalizedStandardDays() {
//        long totalSecs = (this.period.getDays() * SECONDS_PER_DAY) + this.duration.getSeconds();
//        int splitDays = Math.toIntExact(totalSecs / SECONDS_PER_DAY);
//        long splitSecs = totalSecs % SECONDS_PER_DAY;
//        if (splitDays == period.getDays() && splitSecs == duration.getSeconds()) {
//            return this;
//        }
//        return DateTimeStep.of(period.withDays(splitDays), duration.withSeconds(splitSecs));
//    }

    @Override
    public Temporal addTo(Temporal temporal) {
        return temporal.plus(this.period).plus(this.duration);
    }

    @Override
    public Temporal subtractFrom(Temporal temporal) {
        return temporal.minus(this.period).minus(this.duration);
    }

    @Override
    public boolean equals(Object externalObj) {
        if (externalObj == null) {
            return false;
        }

        if (this == externalObj) {
            return true;
        }

        if (externalObj instanceof DateTimeStep) {
            DateTimeStep externalStep = (DateTimeStep) externalObj;
            return this.period.equals(externalStep.period)
                    && this.duration.equals(externalStep.duration);
        }

        return false;
    }

}
