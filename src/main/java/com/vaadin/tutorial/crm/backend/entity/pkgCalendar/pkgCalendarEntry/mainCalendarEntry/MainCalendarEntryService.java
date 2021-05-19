package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.repo.MainCalendarEntryRepo;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainCalendarEntryService extends BaseEntityService<MainCalendarEntry, Long, MainCalendarEntryRepo> {

    @Autowired
    protected MainCalendarEntryService(MainCalendarEntryRepo repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

}
