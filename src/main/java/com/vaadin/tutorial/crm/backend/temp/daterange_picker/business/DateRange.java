package com.vaadin.tutorial.crm.backend.temp.daterange_picker.business;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public interface DateRange {
    /**
     * Returns the identification key, e.g. DAY, MONTH, etc
     *
     * @return identification key
     */
    String getKey();

    /**
     * Returns the {@link Period} to move the date, if any
     *
     * @return {@link Period} to move the date
     */
    Optional<Period> getOptMovePeriod();

    /**
     * Retunns the default description, e.g. "Day" or "Half year"
     *
     * @return default description
     */
    String getDefaultDescription();

    /**
     * Trys to return the calculated {@link DateRangeResult} for the supplied date
     *
     * @param date date that is used for calculation
     * @return calculated {@link DateRangeResult}
     */
    Optional<DateRangeResult> calcFor(LocalDate date);

    /**
     * Trys to return a moved {@link DateRangeResult}
     *
     * @param baseDate Date that is used as a base
     * @param dif      Count of moves
     * @return moved {@link DateRangeResult}
     */
    Optional<DateRangeResult> moveDateRange(LocalDate baseDate, int dif);

    /**
     * Returns if the {@link DateRange} is movable<br>
     * Example:
     * <ul>
     * 	<li> <code>false</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>false</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateRange} is movable
     */
    boolean isMovable();

    /**
     * Returns if the {@link DateRange} is calcable<br>
     * Example:
     * <ul>
     * 	<li> <code>true</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>false</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateRange} is calcable
     */
    boolean isCalcable();

    /**
     * Returns if the {@link DateRange} is settable from a date<br>
     * Example:
     * <ul>
     * 	<li> <code>false</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>true</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateRange} is settable from a date
     */
    boolean isSettable();
}
