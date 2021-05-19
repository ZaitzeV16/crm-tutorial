package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.CalendarService;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SeedService
public class CalendarSeedService extends BaseSeedService<Calendar, CalendarService> {

    @Autowired
    public CalendarSeedService(CalendarService CalendarService) {
        super(CalendarService);
    }

    @Override
    public List<Calendar> generateSeedData() {
        return List.of(new Calendar());
    }

}
