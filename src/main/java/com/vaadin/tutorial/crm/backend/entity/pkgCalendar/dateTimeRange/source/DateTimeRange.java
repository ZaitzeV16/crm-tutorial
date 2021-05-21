package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.source;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateTimeRange.DateTimeStep;

import java.time.LocalDateTime;
import java.util.Optional;

public interface DateTimeRange {
    /**
     * Returns the identification key, e.g. DAY, MONTH, etc
     *
     * @return identification key
     */
    String getKey();

    /**
     * Returns the {@link DateTimeStep} to move the date, if any
     *
     * @return {@link DateTimeStep} to move the date
     */
    Optional<DateTimeStep> getStep();

    /**
     * Retunns the default description, e.g. "Day" or "Half year"
     *
     * @return default description
     */
    String getDefaultDescription();

    /**
     * Trys to return the calculated {@link DateTimeRangeResult} for the supplied dateTime
     *
     * @param dateTime dateTime that is used for calculation
     * @return calculated {@link DateTimeRangeResult}
     */
    Optional<DateTimeRangeResult> calcFor(LocalDateTime dateTime);

    /**
     * Trys to return a moved {@link DateTimeRangeResult}
     *
     * @param baseDateTime Date that is used as a base
     * @param diff      Count of moves
     * @return moved {@link DateTimeRangeResult}
     */
    Optional<DateTimeRangeResult> moveByStep(LocalDateTime baseDateTime, int diff);

    /**
     * Returns if the {@link DateTimeRange} is movable<br>
     * Example:
     * <ul>
     * 	<li> <code>false</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>false</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateTimeRange} is movable
     */
    boolean isMovable();

    /**
     * Returns if the {@link DateTimeRange} is calcable<br>
     * Example:
     * <ul>
     * 	<li> <code>true</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>false</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateTimeRange} is calcable
     */
    boolean isCalculated();

    /**
     * Returns if the {@link DateTimeRange} is settable from a date<br>
     * Example:
     * <ul>
     * 	<li> <code>false</code> for TODAY</li>
     * 	<li> <code>true</code> for MONTH</li>
     * 	<li> <code>true</code> for FREE</li>
     * </ul>
     *
     * @return if the {@link DateTimeRange} is settable from a date
     */
    boolean isSettable();
}
