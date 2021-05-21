package com.vaadin.tutorial.crm.ui.base.dateTimeRangePicker;

import com.helger.commons.io.resource.ClassPathResource;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.HasItems;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.shared.Registration;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRange;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRangeActions;
import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.dateRange.source.DateRangeModel;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.Supplier;


@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@CssImport(DateTimeRangePickerStyles.LOCATION)
public class DateTimeRangePicker<D extends DateRange> extends Composite<VerticalLayout> implements
        FlexComponent<VerticalLayout>,
        HasItems<D>,
        DateRangeActions<D, DateTimeRangePicker<D>>,
        HasValue<DateTimeRangeValueChangeEvent<D>, DateRangeModel<D>> {
    public static final Locale DEFAULT_LOCALE = Locale.US;
    protected static int nextID = 0;

    protected static synchronized int getNextID() {
        return ++nextID;
    }

    ClassPathResource classPathResource = new ClassPathResource("META-INF/resources/js/outsideListenerDateRangePicker.txt");

    /*
     * Fields
     */
    protected boolean expanded = false;
    protected DateRangeModel<D> model;

    /*
     * Config
     */
    protected Optional<Locale> formatLocale = Optional.empty();
    protected ItemLabelGenerator<D> dateRangeLocalizerFunction = DateRange::getDefaultDescription;
    protected Optional<DatePickerI18n> datePickerI18n = Optional.empty();
    protected boolean closeOnOutsideClick = true;

    /*
     * UI-Components
     */
    protected final Button btnOverview = new Button();

    protected final Div overlayContainer = new Div();
    protected final DateTimeRangePickerOverlay<D> overlay = new DateTimeRangePickerOverlay<>(this);

    public DateTimeRangePicker(final DateRangeModel<D> initialModel) {
        this(initialModel, new ArrayList<>());
    }

    public DateTimeRangePicker(final DateRangeModel<D> initialModel, final D[] items) {
        this(initialModel, new ArrayList<>(Arrays.asList(items)));
    }

    public DateTimeRangePicker(final DateRangeModel<D> initialModel, final Collection<D> items) {
        this.model = Objects.requireNonNull(initialModel);
        this.overlay.setItems(items);

        this.initUI();
        this.registerListeners();
    }

    public DateTimeRangePicker(final Supplier<DateRangeModel<D>> initialModelSupplier) {
        this(initialModelSupplier.get());
    }

    public DateTimeRangePicker(final Supplier<DateRangeModel<D>> initialModelSupplier, final D[] items) {
        this(initialModelSupplier.get(), items);
    }

    public DateTimeRangePicker(final Supplier<DateRangeModel<D>> initialModelSupplier, final Collection<D> items) {
        this(initialModelSupplier.get(), items);
    }

    // -- Initializers --

    public DateTimeRangePicker<D> withCloseOnOutsideClick(final boolean closeOnOutsideClick) {
        this.closeOnOutsideClick = closeOnOutsideClick;
        return this;
    }

    public boolean isCloseOnOutsideClick() {
        return this.closeOnOutsideClick;
    }

    public DateTimeRangePicker<D> withDatePickerI18n(final DatePickerI18n datePickerI18n) {
        this.datePickerI18n = Optional.ofNullable(datePickerI18n);
        return this;
    }

    public Optional<DatePickerI18n> getDatePickerI18n() {
        return this.datePickerI18n;
    }

    public DateTimeRangePicker<D> withFormatLocale(final Locale locale) {
        this.formatLocale = Optional.ofNullable(locale);
        return this;
    }

    public Locale getFormatLocale() {
        return this.formatLocale.orElse(DEFAULT_LOCALE);
    }

    public DateTimeRangePicker<D> withDateRangeLocalizerFunction(final ItemLabelGenerator<D> dateRangeLocalizerFunction) {
        this.dateRangeLocalizerFunction = dateRangeLocalizerFunction;
        return this;
    }

    public ItemLabelGenerator<D> getDateRangeLocalizerFunction() {
        return this.dateRangeLocalizerFunction;
    }

    /**
     * Shortcut for {@link DateTimeRangePicker#setStartLabel(String)}
     *
     * @param label
     * @return
     */
    public DateTimeRangePicker<D> withStartLabel(final String label) {
        this.setStartLabel(label);
        return this;
    }

    /**
     * Shortcut for {@link DateTimeRangePicker#setEndLabel(String)}
     *
     * @param label
     * @return
     */
    public DateTimeRangePicker<D> withEndLabel(final String label) {
        this.setEndLabel(label);
        return this;
    }

    /**
     * Shortcut for {@link DateTimeRangePicker#setDateRangeOptionsLabel(String)}
     *
     * @param label
     * @return
     */
    public DateTimeRangePicker<D> withDateRangeOptionsLabel(final String label) {
        this.setDateRangeOptionsLabel(label);
        return this;
    }

    // -- END Initializers --

    protected void initUI() {
        // Set an unique ID for each element
        this.setId("DateRangePickerID" + getNextID());

        this.btnOverview.addClassNames(DateTimeRangePickerStyles.BUTTON, DateTimeRangePickerStyles.CLICKABLE);
        this.btnOverview.setMinWidth("20em");
        this.btnOverview.setWidthFull();

        this.btnOverview.setDisableOnClick(true);

        this.overlay.addClassName(DateTimeRangePickerStyles.OVERLAY_LAYOUT);

        this.overlay.setWidthFull();
        this.overlay.setHeight("auto");

        this.overlayContainer.setWidthFull();
        this.overlayContainer.addClassName(DateTimeRangePickerStyles.OVERLAY_BASE);
        this.overlayContainer.add(this.overlay);

        this.getContent().setSpacing(false);
        this.getContent().setPadding(false);
        this.setSizeUndefined();
        this.add(this.btnOverview, this.overlayContainer);

        this.setExpanded(false);
    }

    protected void registerListeners() {
        this.btnOverview.addClickListener(ev ->
        {
            this.toggle();
            ev.getSource().setEnabled(true);
        });

        this.overlay.addValueChangeListener(ev ->
        {
            this.model = ev.getSource().getModel();

            this.updateFromModel(false);
            this.fireEvent(new DateTimeRangeValueChangeEvent<>(this, ev.getOldValue(), ev.isFromClient()));
        });
    }

    @Override
    protected void onAttach(final AttachEvent attachEvent) {
        this.setLocaleFromClient();

        this.updateFromModel(true);

        this.addClickOutsideListener();
    }

    protected void setLocaleFromClient() {
        this.formatLocale = Optional.ofNullable(VaadinService.getCurrentRequest().getLocale());
    }

    @SneakyThrows
    protected void addClickOutsideListener() {
        if (!this.isCloseOnOutsideClick()) {
            return;
        }

        byte[] bytes = Files.readAllBytes(Objects.requireNonNull(this.classPathResource.getAsFile())
                .toPath());
        String jsFileRawContent = new String(bytes);
        String thisId = this.getId().get();

        String jsFileContent = jsFileRawContent.replaceAll("\\{ID}", thisId);

        this.getContent().getElement().executeJs(jsFileContent);
    }

    @ClientCallable
    protected void clickOutsideOccurred() {
        if (!this.isCloseOnOutsideClick()) {
            return;
        }

        if (this.isExpanded()) {
            this.setExpanded(false);
        }
    }

    protected void updateFromModel(final boolean updateOverlay) {
        if (updateOverlay) {
            this.tryFixInvalidModel();
        }

        final DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(this.getFormatLocale());

        // @formatter:off
        this.btnOverview.setText(
                this.model.getStart().format(formatter) +
                        (
                                (this.model.getStart().equals(this.model.getEnd())) ?
                                        "" :
                                        " - " + this.model.getEnd().format(formatter)
                        )
        );
        // @formatter:on

        if (updateOverlay) {
            this.overlay.setModel(this.model);
        }
    }

    protected void tryFixInvalidModel() {
        this.model.getDateRange()
                .calcFor(this.model.getStart())
                .ifPresent(result -> {
                    this.model.setStart(result.getStart());
                    this.model.setEnd(result.getEnd());
                });
    }

    protected void toggle() {
        this.setExpanded(!this.isExpanded());
    }

    protected synchronized void setExpanded(final boolean expanded) {
        this.expanded = expanded;
        this.btnOverview.setIcon(expanded ? VaadinIcon.CARET_DOWN.create() : VaadinIcon.CARET_UP.create());

        this.overlay.setVisible(expanded);
    }

    public synchronized boolean isExpanded() {
        return this.expanded;
    }

    // --- GET UI ELEMENTS ---

    public DateTimeRangePickerOverlay<D> getOverlay() {
        return this.overlay;
    }

    public Button getBtnOverview() {
        return this.btnOverview;
    }

    public Div getOverlayContainer() {
        return this.overlayContainer;
    }

    // -- LABELS --

    /**
     * Sets the label for the overlay Start-DatePicker
     *
     * @param label
     */
    public void setStartLabel(final String label) {
        Objects.requireNonNull(label);
        this.getOverlay().getDpStart().setLabel(label);
    }

    /**
     * Sets the label for the overlay End-DatePicker
     *
     * @param label
     */
    public void setEndLabel(final String label) {
        Objects.requireNonNull(label);
        this.getOverlay().getDpEnd().setLabel(label);
    }

    /**
     * Sets the label for the overlay DateRange-ComboBox
     *
     * @param label
     */
    public void setDateRangeOptionsLabel(final String label) {
        Objects.requireNonNull(label);
        this.getOverlay().getCbDateRange().setLabel(label);
    }

    // --- DATA ---

    /**
     * Uses the given {@link DateRange} and calculates with the current Date
     * the {@link DateRangeModel}, which is then
     * set by {@link DateTimeRangePicker#setModel(DateRangeModel)}
     *
     * @param range
     */
    public void setDateRangeForToday(final D range) {
        range.calcFor(LocalDate.now()).ifPresent(
                result -> this.setValue(new DateRangeModel<>(result.getStart(), result.getEnd(), range)));
    }

    @Override
    public void setItems(final Collection<D> items) {
        this.overlay.setItems(items);
    }

    @Override
    public LocalDate getStart() {
        return this.model.getStart();
    }

    @Override
    public DateTimeRangePicker<D> setStart(final LocalDate start) {
        this.model.setStart(start);
        this.updateFromModel(true);
        return this;
    }

    @Override
    public LocalDate getEnd() {
        return this.model.getEnd();
    }

    @Override
    public DateTimeRangePicker<D> setEnd(final LocalDate end) {
        this.model.setEnd(end);
        this.updateFromModel(true);
        return this;
    }

    @Override
    public D getDateRange() {
        return this.model.getDateRange();
    }

    @Override
    public DateTimeRangePicker<D> setDateRange(final D dateRange) {
        this.model.setDateRange(dateRange);
        this.updateFromModel(true);
        return this;
    }

    @Override
    public void setValue(final DateRangeModel<D> value) {
        Objects.requireNonNull(value);

        this.model = value;
        this.updateFromModel(true);
    }

    @Override
    public DateRangeModel<D> getValue() {
        return this.model;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Registration addValueChangeListener(final ValueChangeListener<? super DateTimeRangeValueChangeEvent<D>> listener) {
        @SuppressWarnings("rawtypes") final ComponentEventListener componentListener =
                event -> listener.valueChanged((DateTimeRangeValueChangeEvent<D>) event);

        return ComponentUtil.addListener(this, DateTimeRangeValueChangeEvent.class, componentListener);
    }

    /**
     * DateRangePicker always has a value<br>
     * However for compatibility reasons (with Vaadin) this returns {@code null}
     *
     * @return {@code null}
     */
    @Override
    public DateRangeModel<D> getEmptyValue() {
        return null;
    }

    /**
     * DateRangePicker always has a value<br>
     * Therefore this always returns {@code false}
     *
     * @return {@code false}
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Do not use this method, as it throws a {@link UnsupportedOperationException}<br>
     * The calling of clear is not supported because DateRangePicker always has a value<br>
     * Use {@link DateTimeRangePicker#setValue(DateRangeModel)} instead.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("The calling of clear is not supported because DateRangePicker always has a value");
    }

    @Override
    public void setReadOnly(final boolean readOnly) {
        this.getOverlay().setReadOnly(readOnly);
    }

    @Override
    public boolean isReadOnly() {
        return this.getOverlay().isReadOnly();
    }

    /**
     * The required indicator is not implemented<br>
     * <br>
     * This method doesn't have any functionallity
     */
    @Override
    public void setRequiredIndicatorVisible(final boolean requiredIndicatorVisible) {
        // Not required/implemented
    }

    /**
     * The required indicator is not implemented<br>
     * This will always return {@code false}
     *
     * @return {@code false}
     */
    @Override
    public boolean isRequiredIndicatorVisible() {
        return false;
    }
}
