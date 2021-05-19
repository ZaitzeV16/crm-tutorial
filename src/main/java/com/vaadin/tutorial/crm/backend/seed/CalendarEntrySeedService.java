package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.MainCalendarEntryService;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import com.vaadin.tutorial.crm.backend.library.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SeedService(dependsOn = CalendarSeedService.class)
public class CalendarEntrySeedService extends BaseSeedService<MainCalendarEntry, MainCalendarEntryService> {

    private final CalendarSeedService calendarSeedService;

    @Autowired
    public CalendarEntrySeedService(MainCalendarEntryService mainCalendarEntryService, CalendarSeedService calendarSeedService) {
        super(mainCalendarEntryService);
        this.calendarSeedService = calendarSeedService;
    }

    @Override
    public List<MainCalendarEntry> generateSeedData() {
        Calendar calendar = this.calendarSeedService.findAll()
                .stream()
                .findAny()
                .orElseThrow(() -> new ConflictException("at least 1 calendar should already exist"));

        List<MainCalendarEntry> entries = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < 10; i++) {
            entries.add(new MainCalendarEntry(now.plusDays(i), now.plusDays(i + 1), calendar));
        }

        return entries;
    }

}
