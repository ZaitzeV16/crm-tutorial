package com.vaadin.tutorial.crm.ui.views.temporary.dateRangePickerExample;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.DateRangePickerStyledDemo;
import com.vaadin.tutorial.crm.ui.MainLayout;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@PageTitle("DateRangePicker Example")
@Route(value = "dateRangePickerExample", layout = MainLayout.class)
public class DateRangePickerExampleView extends Composite<VerticalLayout> {
    private final Grid<Example> grExamples = new Grid<>();

    public DateRangePickerExampleView() {
        this.grExamples
                .addColumn(new ComponentRenderer<>(example -> {
                    final Anchor anchor = new Anchor(example.getRoute(), example.getName());

                    final Span spDesc = new Span(example.getDesc());
                    spDesc.getStyle().set("font-size", "90%");

                    final VerticalLayout vl = new VerticalLayout(anchor, spDesc);
                    vl.setSpacing(false);
                    return vl;
                }))
                .setHeader("Available demos");

        this.grExamples.setSizeFull();
        this.grExamples.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER);

        this.getContent().add(this.grExamples);
        this.getContent().setHeightFull();
    }

    @Override
    protected void onAttach(final AttachEvent attachEvent) {
        this.grExamples.setItems(Arrays.asList(
                new Example(DateRangePickerStyledDemo.NAV, "Styled-Demo", "dark mode 🌑  and more")
        ));
    }


    @Getter
    @AllArgsConstructor
    static class Example {
        private final String route;
        private final String name;
        private final String desc;
    }

}
