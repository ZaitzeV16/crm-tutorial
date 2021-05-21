package com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRangeModel;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.SimpleDateRange;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.SimpleDateRanges;
import com.vaadin.tutorial.crm.ui.base.dateRangePicker.DateRangePicker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Route("styled")
public class DateRangeMaterial extends Composite<VerticalLayout> {

    protected static final List<SimpleDateRange> DATE_RANGE_VALUES = Arrays.asList(SimpleDateRanges.allValues());

    private final DateRangePicker<SimpleDateRange> dateRangePicker =
            new DateRangePicker<>(
                    () -> new DateRangeModel<>(LocalDate.now(), LocalDate.now(), SimpleDateRanges.TODAY),
                    DATE_RANGE_VALUES);

    private final TextArea taResult =
            new TextArea("ValueChangeEvent", "Change something in the datepicker to see the result");

    /*
     * Fields
     */

    public DateRangeMaterial() {
        this.initUI();
    }

    protected void initUI() {
        this.taResult.setSizeFull();

        this.getContent().setPadding(false);
        this.getContent().add(new VerticalLayout(this.dateRangePicker), new VerticalLayout(this.taResult));
        this.getContent().getChildren().forEach(comp -> ((HasSize) comp).setHeight("50%"));
        this.getContent().setHeightFull();

        this.dateRangePicker.addValueChangeListener(ev ->
        {
            final DateRangeModel<SimpleDateRange> model = ev.getValue();

            this.taResult.clear();
            // @formatter:off
            this.taResult.setValue(
                    "DateRange: " + model.getDateRange().getKey() + "\r\n" +
                            "Start: " + model.getStart() + "\r\n" +
                            "End: " + model.getEnd() + "\r\n" +
                            (ev.getOldValue() != null ?
                                    "OldValue-DateRange: " + ev.getOldValue().getDateRange().getKey() + "\r\n" +
                                            "OldValue-Start: " + ev.getOldValue().getStart() + "\r\n" +
                                            "OldValue-End: " + ev.getOldValue().getEnd()
                                    : "OldValue: null")
                            + "\r\n"
                            + "IsFromClient: " + ev.isFromClient()

            );
            // @formatter:on
        });
    }

}
