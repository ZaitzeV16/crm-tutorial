package com.vaadin.tutorial.crm.ui.views.calendar;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.ContactService;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
import com.vaadin.tutorial.crm.backend.entity.user.UserService;
import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.ui.MainLayout;
import com.vaadin.tutorial.crm.ui.views.list.ContactForm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.FullCalendar;

@Component
@Scope("prototype")
@Route(value = "calendar", layout = MainLayout.class)
@PageTitle("Calendar | Vaadin CRM")
public class FullCalendarView extends FullCalendar {

    private final UserService userService;

    ContactForm form;
    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();

    ContactService contactService;

//    public CalendarView(ContactService contactService,
//                        CompanyService companyService) {
    public FullCalendarView(UserService userService) {
        this.userService = userService;
//        this.contactService = contactService;
        this.addClassName("calendar-view");

        User user = this.userService.findLoggedInUser();
        Calendar calendar = user.getCalendar();

        Entry entry;
        for (MainCalendarEntry mainCalendarEntry : calendar.getEntries()) {
            entry = new Entry();
            entry.setStart(mainCalendarEntry.getStart());
            entry.setEnd(mainCalendarEntry.getEnd());
            entry.setTitle(mainCalendarEntry.getTitle());
            this.addEntry(entry);
        }
//        this.setSizeFull();
//        this.configureGrid();


//        form = new ContactForm(companyService.findAll());
//        form.addListener(ContactForm.SaveEvent.class, this::saveContact);
//        form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
//        form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());

//        Div content = new Div(grid, form);
//        content.addClassName("content");
//        content.setSizeFull();

//        this.add(this.getToolBar(), content);
//        this.updateList();
//        this.closeEditor();
    }

//    private void deleteContact(ContactForm.DeleteEvent evt) {
//        contactService.delete(evt.getContact());
//        updateList();
//        closeEditor();
//    }
//
//    private void saveContact(ContactForm.SaveEvent evt) {
//        contactService.save(evt.getContact());
//        updateList();
//        closeEditor();
//    }

//    private HorizontalLayout getToolBar() {
//        filterText.setPlaceholder("Filter by name...");
//        filterText.setClearButtonVisible(true);
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.addValueChangeListener(e -> updateList());
//
//        Button addContactButton = new Button("Add contact", click -> addContact());
//
//        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
//        toolbar.addClassName("toolbar");
//        return toolbar;
//    }

//    private void addContact() {
//        grid.asSingleSelect().clear();
//        editContact(new Contact());
//    }

//    private void configureGrid() {
//        grid.addClassName("contact-grid");
//        grid.setSizeFull();
//        grid.removeColumnByKey("company");
//        grid.setColumns("firstName", "lastName", "email", "status");
//        grid.addColumn(contact -> {
//            Company company = contact.getCompany();
//            return company == null ? "-" : company.getName();
//        }).setHeader("Company");
//
//        grid.getColumns().forEach(col -> col.setAutoWidth(true));
//
//        grid.asSingleSelect().addValueChangeListener(evt -> editContact(evt.getValue()));
//    }

//    private void editContact(Contact contact) {
//        if (contact == null) {
//            closeEditor();
//        } else {
//            form.setContact(contact);
//            form.setVisible(true);
//            addClassName("editing");
//        }
//    }
//
//    private void closeEditor() {
//        form.setContact(null);
//        form.setVisible(false);
//        removeClassName("editing");
//    }

//    private void updateList() {
//        grid.setItems(contactService.findAll(filterText.getValue()));
//    }

}
