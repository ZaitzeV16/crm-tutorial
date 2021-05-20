//package com.vaadin.tutorial.crm.ui.views.calendar.entry;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.ComponentEvent;
//import com.vaadin.flow.component.ComponentEventListener;
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.data.binder.ValidationException;
//import com.vaadin.flow.shared.Registration;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
//import com.vaadin.tutorial.crm.ui.views.calendar.entry.events.MainCalendarEntryCloseEvent;
//import com.vaadin.tutorial.crm.ui.views.calendar.entry.events.MainCalendarEntryDeleteEvent;
//import com.vaadin.tutorial.crm.ui.views.calendar.entry.events.MainCalendarEntrySaveEvent;
//import com.vaadin.tutorial.crm.ui.views.stuff.CalendarDateRangePicker;
//
//public class MainCalendarEntryForm extends FormLayout {
//
//    TextField title = new TextField("Title");
//    TextField description = new TextField("Description");
//
//    CalendarDateRangePicker dateRangePicker = new CalendarDateRangePicker();
////    LocalDateTime start;
////    LocalDateTime end;
//
//    Calendar calendar;
//
////    EmailField email = new EmailField("Email");
////    ComboBox<ContactStatus> status = new ComboBox<>("Status");
////    ComboBox<Company> company = new ComboBox<>("Company");
//
//    Button save = new Button("Save");
//    Button delete = new Button("Delete");
//    Button close = new Button("Cancel");
//
//    Binder<MainCalendarEntry> binder = new BeanValidationBinder<>(MainCalendarEntry.class);
//    private MainCalendarEntry mainCalendarEntry;
//
//    public MainCalendarEntryForm(Calendar calendar) {
//        this.calendar = calendar;
//        this.addClassName("main-calendar-entry-form");
//
//        this.title.setPlaceholder("tájtől");
//        this.title.focus();
//        this.description.setPlaceholder("deszk rip sün");
//
//        this.binder.bindInstanceFields(this);
//
////        status.setItems(ContactStatus.values());
////        company.setItems(companies);
////        company.setItemLabelGenerator(Company::getName);
//
//        this.title.focus();
//        this.add(
//                this.title,
//                this.description,
//                this.dateRangePicker,
//                this.createButtonsLayout()
//        );
//    }
//
//    public void setMainCalendarEntry(MainCalendarEntry mainCalendarEntry) {
//        this.mainCalendarEntry = mainCalendarEntry;
//        this.binder.readBean(mainCalendarEntry);
//    }
//
//    private Component createButtonsLayout() {
//        this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        this.delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//        this.close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//        this.save.addClickShortcut(Key.ENTER);
//        this.close.addClickShortcut(Key.ESCAPE);
//
//        this.save.addClickListener(click -> this.validateAndSave());
//        this.delete.addClickListener(click -> this.fireEvent(new MainCalendarEntryDeleteEvent(this, this.mainCalendarEntry)));
//        this.close.addClickListener(click -> this.fireEvent(new MainCalendarEntryCloseEvent(this)));
//
//        this.binder.addStatusChangeListener(evt -> this.save.setEnabled(this.binder.isValid()));
//
//        return new HorizontalLayout(this.save, this.delete, this.close);
//    }
//
//    private void validateAndSave() {
//        try {
//            this.binder.writeBean(this.mainCalendarEntry);
//            this.fireEvent(new MainCalendarEntrySaveEvent(this, this.mainCalendarEntry));
//        } catch (ValidationException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public <EVENT extends ComponentEvent<?>> Registration addListener(Class<EVENT> eventType, ComponentEventListener<EVENT> listener) {
//        return this.getEventBus().addListener(eventType, listener);
//    }
//
//}
