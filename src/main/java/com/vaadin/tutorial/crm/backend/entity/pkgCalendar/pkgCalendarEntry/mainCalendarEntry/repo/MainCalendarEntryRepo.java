package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.repo;


import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCalendarEntryRepo extends BaseEntityJpaRepo<MainCalendarEntry, Long> {

}
