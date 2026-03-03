package org.automation.common;

import lombok.extern.slf4j.Slf4j;
import org.automation.driver.DriverManager;
import org.automation.utils.PropertyUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public abstract class BasePage {
    private static final long WAIT_TIMEOUT = Long.parseLong(PropertyUtil.get("timeout.explicitly"));
    private static final String BASE_URL = PropertyUtil.get("base.url");

    protected void open(String path) {
        getDriver().get(BASE_URL + path);
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void click(WebElement element) {
        waitElementIsClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        waitElementIsVisible(element).sendKeys(text);
    }

    protected void type(WebElement element, String text, boolean useKey, Keys key) {
        if (useKey) {
            waitElementIsVisible(element).sendKeys(text, key);
        } else {
            type(element, text);
        }
    }

    protected String getText(WebElement element) {
        return waitElementIsVisible(element).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
