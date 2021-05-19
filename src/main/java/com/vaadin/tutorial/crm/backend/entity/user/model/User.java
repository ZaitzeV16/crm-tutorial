package com.vaadin.tutorial.crm.backend.entity.user.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @OneToOne
    private Calendar calendar;

}
