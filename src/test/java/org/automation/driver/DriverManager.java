package org.automation.driver;

import lombok.extern.slf4j.Slf4j;
import org.automation.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;

@Slf4j
public class DriverManager {
    private static final String BROWSER_KEY = "browser";
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();


    public static WebDriver createDriver() {
        String browser = PropertyUtil.get(BROWSER_KEY).toUpperCase();
        Browser browserType;
        try {
            browserType = Browser.valueOf(browser);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Specified browser wasn't found in the list. Will be launched by default: Chrome. Error: {}", e.getMessage());
            browserType = Browser.CHROME;
        }
        log.info("Creating driver: {}", browserType.name());
        return browserType.createDriver();
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) DRIVER.set(createDriver());
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) DRIVER.get().quit();
        DRIVER.remove();
    }
}
