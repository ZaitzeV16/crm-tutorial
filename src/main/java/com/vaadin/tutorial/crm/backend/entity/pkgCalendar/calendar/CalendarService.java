package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.repo.CalendarRepo;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class CalendarService extends BaseEntityService<Calendar, Long, CalendarRepo> {

    @Autowired
    protected CalendarService(CalendarRepo repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

}
