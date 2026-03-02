package org.automation.core;

import lombok.extern.slf4j.Slf4j;
import org.automation.driver.Browser;
import org.automation.utils.PropertyUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Slf4j
public abstract class BaseTest {
    private static final String BROWSER_KEY = "browser";
    protected static final String URL = PropertyUtil.get("url");
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = createDriver();
        BasePage.setDriver(driver);
    }

    @AfterEach()
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    protected void open(String url) {
        driver.get(url);
    }

    public void clearCacheAndCookies() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean toClear = Boolean.parseBoolean(PropertyUtil.get("clear.cacheAndCookie"));

        if (toClear) {
            driver.manage().deleteAllCookies();
            jsExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    private static WebDriver createDriver() {
        String browser = PropertyUtil.get(BROWSER_KEY).toUpperCase();
        Browser browserType;
        try {
            browserType = Browser.valueOf(browser);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Specified browser wasn't found in the list. Will be launched by default: Chrome. Error: {}", e.getMessage());
            browserType = Browser.CHROME;
        }
        return browserType.createDriver();
    }
}
