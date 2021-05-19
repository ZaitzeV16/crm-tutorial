package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.repetitionConfig.model;//package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.repetitionConfig.model;
//
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.repetitionConfig.type.RepetitionStepType;
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
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class RepetitionConfig extends BaseEntity {
//
//    @Enumerated(EnumType.STRING)
//    private RepetitionStepType type;
//
//    @NotNull
//    @ManyToOne
//    private MainCalendarEntry mainCalendarEntry;
//
//    @ElementCollection
//    private List<LocalDateTime> exceptions = new ArrayList<>();
//}
