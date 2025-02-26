package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Update with your path
            driver = new FirefoxDriver();  // Ensure driver is initialized
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized!");
        }
        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver
        }
    }
}
