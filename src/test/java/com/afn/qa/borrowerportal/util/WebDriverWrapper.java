package com.afn.qa.borrowerportal.util;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class WebDriverWrapper {
    public static void waitForElementVisible(Actor actor, int timeout, By by) {
        new WebDriverWait(
                BrowseTheWeb.as
                        (actor).getDriver(), timeout).
                until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, int timeout, By by) {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitFor(WebDriver driver, int timeout) {
        new WebDriverWait(driver, timeout);
    }

    public static void switchTab(Actor actor, int tab) {
        WebDriver driver =
                BrowseTheWeb.as
                        (actor).getDriver();
        new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }


    public static void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }


}