package org.automation.driver;

import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public enum Browser {
    CHROME(ChromeDriverFactory::new),
    FIREFOX(FirefoxDriverFactory::new);

    private final Supplier<DriverFactory> driver;

    Browser(Supplier<DriverFactory> driver) {
        this.driver = driver;
    }

    public WebDriver createDriver() {
        return driver.get().createDriver();
    }
}
