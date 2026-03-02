package org.automation.core;

import lombok.Setter;
import org.automation.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    @Setter
    protected static WebDriver driver;

    protected WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
