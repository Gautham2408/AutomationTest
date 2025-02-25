package test.java.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {
    private static WebDriver driver;

    public static WebDriver getDriver() { // ✅ Add this method
        return driver;
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.get("http://192.168.1.101:8086/VyoogErp3/");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginField = driver.findElement(By.id("loginDatasource"));
        loginField.clear();
        loginField.sendKeys("makwin", Keys.DOWN, Keys.TAB);
        driver.findElement(By.id("userName")).sendKeys("makwinadmin");
        driver.findElement(By.id("password")).sendKeys("vyg06", Keys.ENTER);

        try {
            // Try to find and click the close button
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info btn-sm']")));
            closeButton.click();

            // Wait for the modal to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
            System.out.println("Close button clicked successfully.");
            
        } catch (TimeoutException e) {
            // If the button is not found in 2 seconds, move on
            System.out.println("Close button not found within 2 seconds. Moving to the next step.");
        } catch (Exception e) {
            // Handle any unexpected issues
            System.out.println("An error occurred while clicking the close button: " + e.getMessage());
        }}

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            driver = null;
        }
    }
}
