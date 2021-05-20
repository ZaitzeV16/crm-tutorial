package com.vaadin.tutorial.crm.backend.entity.user.model;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @NotNull
    @NotBlank
    private String username;

    @OneToOne(cascade = {ALL})
    private Calendar calendar;

    public User(@NotNull @NotBlank String username, Calendar calendar) {
        this.username = username;
        this.setCalendar(calendar);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        if (calendar != null) {
            calendar.setUser(this);
        }
    }
}
