package com.afn.qa.borrowerportal.stepdefinitions;
import com.afn.qa.borrowerportal.UIBaseTest;

import com.afn.qa.borrowerportal.tasks.AuthenticateUser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;


import static com.afn.qa.borrowerportal.pages.LoginPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;



public class LoginStepDefs extends UIBaseTest {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cleanup() {
        OnStage.drawTheCurtain();
    }

    @Given("user is registered borrower")
    public void userIsRegisteredBorrower() {
        String username =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(USERNAME);
        String password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(PASSWORD);
        theActor(DEFAULT_USER);
        theActorCalled(DEFAULT_USER).remember(USERNAME, username);
        theActorCalled(DEFAULT_USER).remember(PASSWORD, password);
    }


    @When("he login to his Borrower Portal account")
    public void heLoginToHisBorrowerPortalAccount() {
        StringBuilder loginUrl = new StringBuilder(webBaseUrl);
        Actor actor = theActorCalled(DEFAULT_USER);
        actor.wasAbleTo(AuthenticateUser.authenticate(loginUrl.toString(), actor.recall(USERNAME), actor.recall(PASSWORD))
        );
    }

    @Then("he verifies logged in successfully")
    public void heVerifiesLoggedInSuccessfully() {
        Ensure.that(LOAN_HEADER).isDisplayed();




    }

}
