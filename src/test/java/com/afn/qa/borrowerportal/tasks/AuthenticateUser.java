package com.afn.qa.borrowerportal.tasks;

import com.afn.qa.borrowerportal.util.WebDriverWrapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;


import static com.afn.qa.borrowerportal.pages.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AuthenticateUser implements Task {
    private final String loginUrl;
    private final String userName;
    private final String password;

    public AuthenticateUser(String loginUrl, String userName, String password) {
        this.loginUrl = loginUrl;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(loginUrl));
        actor.attemptsTo(
                Enter.theValue(userName).into(USERNAME_TARGET),
                Enter.theValue(password).into(PASSWORD_TARGET),
                Click.on(LOGIN_TARGET)
        );
        WebDriverWrapper.waitFor(BrowseTheWeb.as(actor).getDriver(),10);
    }

    public static AuthenticateUser authenticate(String loginUrl, String userName, String password) {
        return instrumented(AuthenticateUser.class, loginUrl, userName, password);
    }

}