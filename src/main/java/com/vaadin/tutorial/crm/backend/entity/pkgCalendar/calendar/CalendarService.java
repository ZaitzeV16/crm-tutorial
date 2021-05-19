package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar;

import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.repo.CalendarRepo;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService extends BaseEntityService<Calendar, Long, CalendarRepo> {

    @Autowired
    protected CalendarService(CalendarRepo repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

}
