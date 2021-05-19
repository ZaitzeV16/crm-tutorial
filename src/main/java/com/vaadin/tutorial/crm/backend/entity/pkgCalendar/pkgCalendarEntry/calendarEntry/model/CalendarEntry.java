package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.calendarEntry.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class CalendarEntry extends BaseEntity {
//public class CalendarEntry extends BaseEntity<Long> {

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

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

    public CalendarEntry(@NotNull LocalDateTime start, @NotNull LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

//    public boolean isBase() {
//        return this.base == null;
//    }

}
