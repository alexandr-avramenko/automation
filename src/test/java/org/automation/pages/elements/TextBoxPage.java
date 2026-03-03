package org.automation.pages.elements;

import org.automation.common.BasePage;
import org.automation.model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextBoxPage extends BasePage {
    private static final String PATH = "/text-box";

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@id='output']")
    private WebElement outputForm;
    @FindBy(xpath = "//p[@id='name']")
    private WebElement outputUsername;
    @FindBy(xpath = "//p[@id='email']")
    private WebElement outputEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement outputCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress;

    public TextBoxPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public TextBoxPage open() {
        super.open(PATH);
        return this;
    }

    public TextBoxPage fillForm(User user) {
        type(userName, user.getUsername());
        type(email, user.getEmail());
        type(currentAddress, user.getCurrentAddress());
        type(permanentAddress, user.getPermanentAddress());
        return this;
    }

    public TextBoxPage submitForm() {
        click(submitBtn);
        return this;
    }

    public boolean isOutputFormDisplayed() {
        return isDisplayed(outputForm);
    }

    public List<String> getDataFromOutput() {
        String delimiter = ":";
        if (isDataDisplaysInOutput()) {
            return Stream.of(outputUsername, outputEmail, outputCurrentAddress, outputPermanentAddress)
                    .map(element -> extractValue(element.getText(), delimiter))
                    .toList();
        }
        return List.of();
    }

    private boolean isDataDisplaysInOutput() {
        return Stream.of(outputUsername, outputEmail, outputCurrentAddress, outputPermanentAddress)
                .allMatch(this::isDisplayed);
    }

    private String extractValue(String text, String delimiter) {
        Pattern pattern = Pattern.compile(delimiter + "\\s*(.+)");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(1).trim() : "";
    }
}
