package com.vaadin.tutorial.crm.ui.views.login;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static com.vaadin.tutorial.crm.ui.UiUtils.createDarkModeToggleButton;

@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm login = new LoginForm();

    public LoginView() {
        this.addClassName("login-view");
        this.setSizeFull();

        this.setJustifyContentMode(JustifyContentMode.CENTER);
        this.setAlignItems(Alignment.CENTER);

        this.login.setAction("login");

        HorizontalLayout header = this.createHeader();
        this.add(this.login);
    }

    private HorizontalLayout createHeader() {
        Button buttonToggleDarkMode = createDarkModeToggleButton(true);
        buttonToggleDarkMode.setEnabled(false);
        buttonToggleDarkMode.setVisible(false);

        HorizontalLayout header = new HorizontalLayout(buttonToggleDarkMode);
        header.addClassName("header");
        header.setWidth("0");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        return header;
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            this.login.setError(true);
        }
    }

}
