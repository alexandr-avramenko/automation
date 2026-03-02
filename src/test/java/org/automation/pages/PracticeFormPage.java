package org.automation.pages;

import org.automation.config.ConfigProvider;
import org.automation.core.BasePage;
import org.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage extends BasePage {
    private static final String PATH = "automation-practice-form";

//    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userMail")
    private WebElement mail;

    @FindBy(id = "genterWrapper")
    private WebElement genderWrapper;

    @FindBy(id = "currentAddress")
    private WebElement address;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public PracticeFormPage() {
        driver.get(ConfigProvider.URL + PATH);
        PageFactory.initElements(driver, this);
    }

    public PracticeFormPage fillAndSubmitPracticeForm(User user) {
        By xpath = By.xpath("//input[@id='firstName']");
        driver.findElement(xpath);
        firstName.sendKeys(user.getUsername());
        lastName.sendKeys("Secret");
        address.sendKeys("Ukraine");
        submitBtn.click();

        return this;
    }
}
