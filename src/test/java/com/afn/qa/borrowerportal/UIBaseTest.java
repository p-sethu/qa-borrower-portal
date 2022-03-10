package com.afn.qa.borrowerportal;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class UIBaseTest {
    public static final String WEBDRIVER_BASE_URL = "webdriver.base.url";

    public static EnvironmentVariables environmentVariables;
    public static String webBaseUrl;
    protected static String DEFAULT_USER = "borrower";

    static {
        environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        webBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(WEBDRIVER_BASE_URL);
    }
}
