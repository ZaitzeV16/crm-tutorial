package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.tutorial.crm.ui.views.calendar.FullCalendarView;
import com.vaadin.tutorial.crm.ui.views.dashboard.DashboardView;
import com.vaadin.tutorial.crm.ui.views.list.ListView;
import com.vaadin.tutorial.crm.ui.views.temporary.dateRangePickerExample.DateRangePickerExampleView;

@PWA(
        name = "Vaadin CRM",
        shortName = "CRM",
        offlineResources = {
                "./styles/offline.css",
                "./images/offline.png"
        },
        enableInstallPrompt = false
)
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        this.createHeader();
        this.createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassName("logo");

        Anchor logout = new Anchor("/logout", "Log out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        this.addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", ListView.class);
        RouterLink dashboard = new RouterLink("Dashboard", DashboardView.class);
        RouterLink calendarLink = new RouterLink("Calendar", FullCalendarView.class);
        RouterLink dateRangePickerLink = new RouterLink("DateRangePickerDemo", DateRangePickerExampleView.class);

        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        VerticalLayout verticalLayout = new VerticalLayout(
                listLink,
                dashboard,
                calendarLink,
                dateRangePickerLink
        );

        this.addToDrawer(verticalLayout);
    }

}
