package Itemtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    public WebDriver driver;

    public void initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
