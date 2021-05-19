package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.calendarEntry.model.CalendarEntry;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class MainCalendarEntry extends CalendarEntry {
//public class CalendarEntry extends BaseEntity<Long> {

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

    public MainCalendarEntry(@NotNull LocalDateTime start, @NotNull LocalDateTime end) {
        super(start, end);
    }

//    public boolean isBase() {
//        return this.base == null;
//    }

}
