package com.afn.qa.borrowerportal.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;


public class LoginPage extends PageObject {

    public static final Target USERNAME_TARGET = Target.the("username").locatedBy("[type='text']");
    public static final Target PASSWORD_TARGET = Target.the("password").locatedBy("[type='password']");
    public static final Target LOGIN_TARGET= Target.the("login button").locatedBy("[type='submit']");
    public static final Target LOAN_HEADER = Target.the("loan Header").locatedBy("//*[@class='content-page-title']/h1");

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


}