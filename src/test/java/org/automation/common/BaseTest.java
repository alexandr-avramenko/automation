package org.automation.common;

import lombok.extern.slf4j.Slf4j;
import org.automation.driver.DriverManager;
import org.automation.utils.PropertyUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Slf4j
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        log.info("Starting test: {}", testInfo.getDisplayName());
        driver = getDriver();
//        clearCacheAndCookies();
    }

    @AfterEach()
    public void tearDown(TestInfo testInfo) {
        log.info("Finishing test: {}", testInfo.getDisplayName());
        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    private void clearCacheAndCookies() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean toClear = Boolean.parseBoolean(PropertyUtil.get("clear.cacheAndCookie"));

        if (toClear) {
            driver.manage().deleteAllCookies();
            jsExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
}
