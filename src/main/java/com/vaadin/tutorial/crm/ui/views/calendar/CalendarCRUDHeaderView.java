//package com.vaadin.tutorial.crm.ui.views.calendar.events;
//
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
//import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.pkgCalendarEntry.mainCalendarEntry.model.MainCalendarEntry;
//import com.vaadin.tutorial.crm.backend.entity.user.UserService;
//import com.vaadin.tutorial.crm.backend.entity.user.model.User;
//import com.vaadin.tutorial.crm.ui.MainLayout;
//import com.vaadin.tutorial.crm.ui.views.calendar.FullCalendarView;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//@Component
//@Scope("prototype")
//@Route(value = "calendar", layout = MainLayout.class)
//@PageTitle("Calendar | Vaadin CRM")
//public class CalendarCRUDHeaderView extends HorizontalLayout {
//
//    private final UserService userService;
//
//    Calendar calendar;
//    Button save = new Button("Save");
//    Binder<MainCalendarEntry> binder = new BeanValidationBinder<>(MainCalendarEntry.class);
//
//
//    public CalendarCRUDHeaderView(UserService userService) {
//        this.userService = userService;
//
//        this.setup();
//
////        this.setSizeFull();
////        this.configureGrid();
//
////        form = new ContactForm(companyService.findAll());
////        form.addListener(ContactForm.SaveEvent.class, this::saveContact);
////        form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
////        form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());
//
////        Div content = new Div(grid, form);
////        content.addClassName("content");
////        content.setSizeFull();
//
////        this.add(this.getToolBar(), content);
////        this.updateList();
////        this.closeEditor();
//    }
//
//    private void setup() {
//        User loggedInUser = this.userService.findLoggedInUser();
//
//        assert loggedInUser != null;
//        this.calendar = loggedInUser.getCalendar();
//
//        this.addClassName("calendar-view");
//    }
//
//    private com.vaadin.flow.component.Component createButtonsLayout() {
//        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
////        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
////        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//        save.addClickShortcut(Key.ENTER);
////        close.addClickShortcut(Key.ESCAPE);
//
//        save.addClickListener(click -> validateAndSave());
////        delete.addClickListener(click -> fireEvent(new ContactForm.DeleteEvent(this, contact)));
////        close.addClickListener(click -> fireEvent(new CloseEvent(this)));
//
//        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
//
//        return new HorizontalLayout(save, delete, close);
//    }
//
////    private void deleteContact(ContactForm.DeleteEvent evt) {
////        contactService.delete(evt.getContact());
////        updateList();
////        closeEditor();
////    }
////
////    private void saveContact(ContactForm.SaveEvent evt) {
////        contactService.save(evt.getContact());
////        updateList();
////        closeEditor();
////    }
//
////    private HorizontalLayout getToolBar() {
////        filterText.setPlaceholder("Filter by name...");
////        filterText.setClearButtonVisible(true);
////        filterText.setValueChangeMode(ValueChangeMode.LAZY);
////        filterText.addValueChangeListener(e -> updateList());
////
////        Button addContactButton = new Button("Add contact", click -> addContact());
////
////        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
////        toolbar.addClassName("toolbar");
////        return toolbar;
////    }
//
////    private void addContact() {
////        grid.asSingleSelect().clear();
////        editContact(new Contact());
////    }
//
////    private void configureGrid() {
////        grid.addClassName("contact-grid");
////        grid.setSizeFull();
////        grid.removeColumnByKey("company");
////        grid.setColumns("firstName", "lastName", "email", "status");
////        grid.addColumn(contact -> {
////            Company company = contact.getCompany();
////            return company == null ? "-" : company.getName();
////        }).setHeader("Company");
////
////        grid.getColumns().forEach(col -> col.setAutoWidth(true));
////
////        grid.asSingleSelect().addValueChangeListener(evt -> editContact(evt.getValue()));
////    }
//
////    private void editContact(Contact contact) {
////        if (contact == null) {
////            closeEditor();
////        } else {
////            form.setContact(contact);
////            form.setVisible(true);
////            addClassName("editing");
////        }
////    }
////
////    private void closeEditor() {
////        form.setContact(null);
////        form.setVisible(false);
////        removeClassName("editing");
////    }
//
////    private void updateList() {
////        grid.setItems(contactService.findAll(filterText.getValue()));
////    }
//
//}
