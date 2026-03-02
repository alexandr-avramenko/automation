package org.automation.driver;

import org.automation.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxDriverFactory extends AbstractDriverFactory {

    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICITLY_TIMEOUT));
        options.setPageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

        return new FirefoxDriver(options);
    }
}
