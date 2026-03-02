package org.automation.driver;

import org.automation.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class ChromeDriverFactory extends AbstractDriverFactory {

    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICITLY_TIMEOUT));
        options.setPageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

        return new ChromeDriver(options);
    }
}
