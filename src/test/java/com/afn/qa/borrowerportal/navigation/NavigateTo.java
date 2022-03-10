package com.afn.qa.borrowerportal.navigation;

import com.afn.qa.borrowerportal.pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class NavigateTo {
    public static Performable theBorrowerHomePage() {
        return Task.where("{0} opens the BP home page",
                Open.browserOn().the(HomePage.class));
    }
}
