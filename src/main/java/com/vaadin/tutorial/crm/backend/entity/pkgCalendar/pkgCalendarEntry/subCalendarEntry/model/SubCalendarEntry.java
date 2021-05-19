package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.subCalendarEntry.model;//package com.vaadin.tutorial.crm.backend.pkgCalendar.pkgCalendarEntry.subCalendarEntry.model;
//
//import com.vaadin.tutorial.crm.backend.pkgCalendar.calendar.model.Calendar;
//import com.vaadin.tutorial.crm.backend.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
//import com.vaadin.tutorial.crm.backend.reminder.model.Reminder;
//import com.vaadin.tutorial.crm.backend.pkgCalendar.repetitionConfig.model.RepetitionConfig;
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static javax.persistence.CascadeType.ALL;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class SubCalendarEntry extends BaseEntity {
////public class CalendarEntry extends BaseEntity<Long> {
//
//    @NotNull
//    private LocalDateTime start;
//
//    @NotNull
//    private LocalDateTime end;
//
//    @ManyToOne
//    private MainCalendarEntry base;
//
//    @ManyToMany
//    @JoinTable(
//            name = "calendar_entry_reminder",
//            joinColumns = @JoinColumn(name = "calendar_entry_id"),
//            inverseJoinColumns = @JoinColumn(name = "reminder_id"))
//    private List<Reminder> reminders = new ArrayList<>();
//
//    public SubCalendarEntry(@NotNull LocalDateTime start, @NotNull LocalDateTime end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    public boolean isBase() {
//        return this.base == null;
//    }
//
//}
