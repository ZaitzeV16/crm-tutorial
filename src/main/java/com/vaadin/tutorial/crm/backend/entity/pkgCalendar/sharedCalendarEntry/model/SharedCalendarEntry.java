package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.sharedCalendarEntry.model;//package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.sharedCalendarEntry.model;
//
//import com.vaadin.tutorial.crm.backend.entity.reminder.model.Reminder;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.repetitionConfig.model.RepetitionConfig;
//import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
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
//public class SharedCalendarEntry extends BaseEntity {
////public class CalendarEntry extends BaseEntity<Long> {
//
//    @NotNull
//    private LocalDateTime start;
//
//    @NotNull
//    private LocalDateTime end;
//
//    @ManyToOne
//    private SharedCalendarEntry base;
//
//    @OneToMany(mappedBy = "base")
//    private List<SharedCalendarEntry> repetitions = new ArrayList<>();
//
//    @OneToMany(mappedBy = "calendarEntry", cascade = ALL)
//    private List<RepetitionConfig> repetitionConfigs = new ArrayList<>();
//
//    @ManyToMany
//    private List<Reminder> reminders = new ArrayList<>();
//
//    public SharedCalendarEntry(@NotNull LocalDateTime start, @NotNull LocalDateTime end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    public boolean isBase() {
//        return this.base == null;
//    }
//
//}
