package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.repo;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepo extends BaseEntityJpaRepo<Calendar, Long> {

}
