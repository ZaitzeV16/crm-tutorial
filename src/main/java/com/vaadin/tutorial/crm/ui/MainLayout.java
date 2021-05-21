package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.tutorial.crm.ui.views.dateTimeRangePicker.MyWorkbench;
import com.vaadin.tutorial.crm.ui.views.temporary.MyDateTimeRangePicker;

import static com.vaadin.tutorial.crm.ui.UiUtils.createDarkModeToggleButton;

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

        Button buttonToggleDarkMode = createDarkModeToggleButton(true);
        Anchor logout = new Anchor("/logout", "Log out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, buttonToggleDarkMode, logout);
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        this.addToNavbar(header);
    }

    private void createDrawer() {
//        RouterLink listLink = new RouterLink("Contacts", ListView.class);
//        RouterLink dashboard = new RouterLink("Dashboard", DashboardView.class);
//        RouterLink calendarLink = new RouterLink("Calendar", FullCalendarView.class);
//        RouterLink dateRangePickerLink = new RouterLink("date-range picker demo", DateRangeMaterial.class);
        RouterLink dateTimeRangePickerLink = new RouterLink("date-time-range picker demo", MyDateTimeRangePicker.class);
        RouterLink customDateTimeRangePickerLink = new RouterLink("saját basz", MyWorkbench.class);

        customDateTimeRangePickerLink.setHighlightCondition(HighlightConditions.sameLocation());
//        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        VerticalLayout verticalLayout = new VerticalLayout(
//                listLink,
//                dashboard,
//                calendarLink,
//                dateRangePickerLink,
                dateTimeRangePickerLink,
                customDateTimeRangePickerLink
        );

        this.addToDrawer(verticalLayout);
    }

}
