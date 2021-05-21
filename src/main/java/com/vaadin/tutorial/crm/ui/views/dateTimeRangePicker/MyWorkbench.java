package com.vaadin.tutorial.crm.ui.views.dateTimeRangePicker;

import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.DateRangeMaterial;
import com.vaadin.tutorial.crm.ui.MainLayout;
import com.vaadin.tutorial.crm.ui.views.temporary.dateTimeRangePickerExample.MyDateRangePicker;

@PageTitle("DateTimeRangePicker")
@Route(value = "customDateTimeRangePicker", layout = MainLayout.class)
public class MyWorkbench extends VerticalLayout {

    DateRangeMaterial dateRangeMaterial = new DateRangeMaterial();

    MyDateRangePicker myDateRangePicker = new MyDateRangePicker();

    public MyWorkbench() {
        this.addClassName("custom-date-time-range-picker");

        VerticalLayout materials = this.createMaterials();
        VerticalLayout merged = this.createMerged();

        this.add(materials, new Hr(), merged);
    }

    private VerticalLayout createMerged() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(this.dateRangeMaterial);
        return verticalLayout;
    }

    private VerticalLayout createMaterials() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(this.myDateRangePicker);
        return verticalLayout;
    }

}
