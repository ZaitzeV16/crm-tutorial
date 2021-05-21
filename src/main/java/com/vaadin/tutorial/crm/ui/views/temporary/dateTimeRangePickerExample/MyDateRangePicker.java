package com.vaadin.tutorial.crm.ui.views.temporary.dateTimeRangePickerExample;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.library.Utilities;
import com.vaadin.tutorial.crm.ui.MainLayout;
import com.vaadin.tutorial.crm.ui.components.dateTimePicker.MyDateTimePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;

@PageTitle("DateTimeRangePicker")
@Route(value = "", layout = MainLayout.class)
//public class DateTimeRangePickerExampleView extends Composite<VerticalLayout> {
public class MyDateRangePicker extends VerticalLayout {
//    private final Grid<Example> grExamples = new Grid<>();

    MyDateTimePicker startPicker;
    MyDateTimePicker endPicker;

    public MyDateRangePicker() {
        this.addClassName("date-time-range-picker");

        this.startPicker = this.initStartPicker();
        this.endPicker = this.initEndPicker();

        this.addValueChangeListenersToStartPicker();
        this.addValueChangeListenersToEndPicker();

        this.startPicker.focus();

        this.add(this.startPicker, this.endPicker);
    }

    private MyDateTimePicker initStartPicker() {
        MyDateTimePicker startPicker = new MyDateTimePicker("Select start:");
        startPicker.setDatePlaceholder("Start Date");
        startPicker.setTimePlaceholder("Start Time");

        startPicker.setRequiredIndicatorVisible(true);
//        dateTimePicker.setHelperText("Please, select the most suitable time");
//        dateTimePickerHelperComponent.setHelperComponent(new Span("Select your arrival time"));
//
//        dateTimePicker.setMin(min);
//        dateTimePicker.setMax(max);
//
//        dateTimePicker.setStep(Duration.ofMinutes(30));
        return startPicker;
    }

    private MyDateTimePicker initEndPicker() {
        MyDateTimePicker endPicker = new MyDateTimePicker("Select end:");
        endPicker.setDatePlaceholder("End Date");
        endPicker.setTimePlaceholder("End Time");

        endPicker.setRequiredIndicatorVisible(true);
//        dateTimePicker.setHelperText("Please, select the most suitable time");
//        dateTimePickerHelperComponent.setHelperComponent(new Span("Select your arrival time"));
//
//        dateTimePicker.setMin(min);
//        dateTimePicker.setMax(max);
//
//        dateTimePicker.setStep(Duration.ofMinutes(30));
        return endPicker;
    }

    private void addValueChangeListenersToStartPicker() {
        this.addLabelChangeListener(this.startPicker);
        this.addMinEndDateChangeListener();
        this.addMinEndDateTimeChangeListener();
    }

    private void addValueChangeListenersToEndPicker() {
        this.addLabelChangeListener(this.endPicker);
        this.addMaxStartDateChangeListener();
        this.addMaxStartDateTimeChangeListener();
    }


    // region GeneralListener
    private void addLabelChangeListener(DateTimePicker dateTimePicker) {
        dateTimePicker.addValueChangeListener(event -> {
            LocalDateTime value = event.getValue();
            if (value == null) {
                dateTimePicker.setLabel("No date time selected");
            } else {
                dateTimePicker.setLabel("Selected date time: " + value.format(Utilities.DATE_TIME_FORMATTER));
            }
        });
    }
    // endregion GeneralListener


    // region StartPickerListener
    private void addMinEndDateChangeListener() {
        this.startPicker.getDatePicker().addValueChangeListener(event -> {
            LocalDate value = event.getValue();
            if (value != null) {
                this.endPicker.getDatePicker().setMin(value);
            }
        });
    }

    private void addMinEndDateTimeChangeListener() {
        this.startPicker.addValueChangeListener(event -> {
            LocalDateTime value = event.getValue();
            if (value != null) {
                this.endPicker.setMin(value);
            }
        });
    }
    // endregion StartPickerListener


    // region EndPickerListener
    private void addMaxStartDateChangeListener() {
        this.endPicker.getDatePicker().addValueChangeListener(event -> {
            LocalDate value = event.getValue();
            if (value != null) {
                this.startPicker.getDatePicker().setMax(value);
            }
        });
    }

    private void addMaxStartDateTimeChangeListener() {
        this.endPicker.addValueChangeListener(event -> {
            LocalDateTime value = event.getValue();
            if (value != null) {
                this.startPicker.setMax(value);
            }
        });
    }
    // endregion EndPickerListener




    private void addValueChangeListenerPipa() {
        this.startPicker.addValueChangeListener(event -> {
            LocalDateTime value = event.getValue();
            if (value != null && !this.endPicker.isEmpty()) {
                this.startPicker.setEnabled(true);
                this.endPicker.setEnabled(true);
            }
        });
        this.endPicker.addValueChangeListener(event -> {
            LocalDateTime value = event.getValue();
            if (value != null && !this.startPicker.isEmpty()) {
                this.startPicker.setEnabled(true);
                this.endPicker.setEnabled(true);
            }
        });
    }

}
