package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calendar extends BaseEntity {

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "calendar")
    private List<MainCalendarEntry> entries = new ArrayList<>();

//    @OneToMany
//    private List<MainCalendarEntry> sharedEntries = new ArrayList<>();

}
