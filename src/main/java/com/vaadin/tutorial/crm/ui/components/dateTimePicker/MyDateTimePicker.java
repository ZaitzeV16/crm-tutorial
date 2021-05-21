package com.vaadin.tutorial.crm.ui.components.dateTimePicker;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.timepicker.TimePicker;

import java.time.LocalDateTime;
import java.util.Locale;

public class MyDateTimePicker extends DateTimePicker {

    public MyDateTimePicker() {
        super();
    }

    public MyDateTimePicker(String label) {
        super(label);
    }

    public MyDateTimePicker(String label, LocalDateTime initialDateTime) {
        super(label, initialDateTime);
    }

    public MyDateTimePicker(LocalDateTime initialDateTime) {
        super(initialDateTime);
    }

    public MyDateTimePicker(ValueChangeListener<ComponentValueChangeEvent<DateTimePicker, LocalDateTime>> listener) {
        super(listener);
    }

    public MyDateTimePicker(String label, ValueChangeListener<ComponentValueChangeEvent<DateTimePicker, LocalDateTime>> listener) {
        super(label, listener);
    }

    public MyDateTimePicker(LocalDateTime initialDateTime, ValueChangeListener<ComponentValueChangeEvent<DateTimePicker, LocalDateTime>> listener) {
        super(initialDateTime, listener);
    }

    public MyDateTimePicker(String label, LocalDateTime initialDateTime, ValueChangeListener<ComponentValueChangeEvent<DateTimePicker, LocalDateTime>> listener) {
        super(label, initialDateTime, listener);
    }

    public MyDateTimePicker(LocalDateTime initialDateTime, Locale locale) {
        super(initialDateTime, locale);
    }

    public DatePicker getDatePicker() {
        return (DatePicker) this.getChildren()
                .filter(component -> DatePicker.class.isAssignableFrom(component.getClass()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("this should'n have happened :)"));
    }

    public TimePicker getTimePicker() {
        return (TimePicker) this.getChildren()
                .filter(component -> TimePicker.class.isAssignableFrom(component.getClass()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("this should'n have happened :)"));
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.getDatePicker().setEnabled(enabled);
        this.getTimePicker().setEnabled(enabled);
    }

}
