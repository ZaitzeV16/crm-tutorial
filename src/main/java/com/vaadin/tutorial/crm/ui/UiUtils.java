package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

public class UiUtils {

    public static Button createDarkModeToggleButton(boolean toggled) {
        Button buttonToggleDarkMode = new Button("Toogle theme");

        if (toggled) {
            toggleDarkMode(buttonToggleDarkMode);
        }

        updateBtnDarkMode(buttonToggleDarkMode);
        setupDarkModeToggle(buttonToggleDarkMode);

        return buttonToggleDarkMode;
    }

    public static void setupDarkModeToggle(Button buttonToggleDarkMode) {
        buttonToggleDarkMode.addClickListener(ev -> toggleDarkMode(buttonToggleDarkMode));
    }

    private static void toggleDarkMode(Button buttonToggleDarkMode) {
        final ThemeList themeList = UI.getCurrent().getElement().getThemeList();

        if (themeList.contains(Lumo.DARK)) {
            themeList.remove(Lumo.DARK);
        } else {
            themeList.add(Lumo.DARK);
        }

        updateBtnDarkMode(buttonToggleDarkMode);
    }

    public static void updateBtnDarkMode(Button buttonToggleDarkMode) {
        final boolean isDarkMode = UI.getCurrent().getElement().getThemeList().contains(Lumo.DARK);
        buttonToggleDarkMode.setText(!isDarkMode ? "Enter the darkness" : "Turn the light on");
        buttonToggleDarkMode.setIcon(!isDarkMode ? VaadinIcon.MOON_O.create() : VaadinIcon.SUN_O.create());
    }

}
