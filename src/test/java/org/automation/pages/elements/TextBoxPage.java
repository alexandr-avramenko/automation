package org.automation.pages.elements;

import org.automation.core.BasePage;
import org.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage extends BasePage {

    private static final By userName= By.xpath("//input[@id='userName']");
    private static final By email= By.xpath("//input[@id='userEmail']");
    private static final By currentAddress= By.xpath("//textarea[@id='currentAddress']");
    private static final By permanentAddress= By.xpath("//textarea[@id='permanentAddress']");
    private static final By submitBtn= By.xpath("//button[@id='submit']");

    public void fillForm(User user) {
        driver.findElement(userName).sendKeys(user.getUsername() );
        driver.findElement(email).sendKeys(user.getEmail());
        driver.findElement(currentAddress).sendKeys(user.getCurrentAddress());
        driver.findElement(permanentAddress).sendKeys(user.getPermanentAddress());
    }

    public TextBoxPage submitForm() {
        WebElement btn = driver.findElement(submitBtn);
        waitElementIsClickable(btn);

        btn.click();
        return this;
    }
}
