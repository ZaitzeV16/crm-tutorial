package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.calendarEntry.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class CalendarEntry extends BaseEntity {
//public class CalendarEntry extends BaseEntity<Long> {

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private LocalTime endTime;

    @ManyToOne
    private Calendar calendar;

//    @ManyToOne
//    private MainCalendarEntry base;

//    @OneToMany(mappedBy = "base")
//    private List<MainCalendarEntry> repetitions = new ArrayList<>();

//    @OneToMany(mappedBy = "base")
//    private List<SubCalendarEntry> repetitions = new ArrayList<>();

//    @OneToMany(mappedBy = "calendarEntry", cascade = ALL)
//    private List<RepetitionConfig> repetitionConfigs = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(
//            name = "calendar_entry_reminder",
//            joinColumns = @JoinColumn(name = "calendar_entry_id"),
//            inverseJoinColumns = @JoinColumn(name = "reminder_id"))
//    private List<Reminder> reminders = new ArrayList<>();


    public CalendarEntry(@NotNull @NotBlank String title, @NotNull @NotBlank String description, @NotNull LocalDateTime start, @NotNull LocalDateTime end, @NotNull Calendar calendar) {
        this(start, end);
        this.title = title;
        this.description = description;
        this.calendar = calendar;
    }

    private CalendarEntry(@NotNull LocalDateTime start, @NotNull LocalDateTime end) {
        this.startDate = start.toLocalDate();
        this.startTime = start.toLocalTime();

        this.endDate = end.toLocalDate();
        this.endTime = end.toLocalTime();
    }

    public LocalDateTime getStart() {
        return LocalDateTime.of(this.startDate, this.startTime);
    }

    public LocalDateTime getEnd() {
        return LocalDateTime.of(this.endDate, this.endTime);
    }

//    public boolean isBase() {
//        return this.base == null;
//    }

}
