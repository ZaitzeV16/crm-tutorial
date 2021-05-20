//package com.vaadin.tutorial.crm.ui.views.calendar.entry.events;
//
//import com.vaadin.flow.component.ComponentEvent;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
//import com.vaadin.tutorial.crm.ui.views.calendar.entry.MainCalendarEntryForm;
//
//public abstract class MainCalendarEntryFormEvent extends ComponentEvent<MainCalendarEntryForm> {
//
//    private MainCalendarEntry mainCalendarEntry;
//
//    protected MainCalendarEntryFormEvent(MainCalendarEntryForm source, MainCalendarEntry mainCalendarEntry) {
//        super(source, false);
//        this.mainCalendarEntry = mainCalendarEntry;
//    }
//
//    public MainCalendarEntry getMainCalendarEntry() {
//        return this.mainCalendarEntry;
//    }
//
//}