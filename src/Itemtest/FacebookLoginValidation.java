package Itemtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class FacebookLoginValidation {
    private WebDriver driver;

    public FacebookLoginValidation(WebDriver driver) {
        this.driver = driver;
    }

    public void validateFacebookLoginPage() {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Validation 1: Check Page Title
        String expectedTitle = "Facebook - log In or Sign Up";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

        // Validation 2: Check Email or Phone Field
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        softAssert.assertTrue(emailField.isDisplayed(), "Email or Phone field is not displayed!");

        // Validation 3: Check Password Field
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        softAssert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed!");

        // Validation 4: Check Log In Button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
        softAssert.assertTrue(loginButton.isEnabled(), "Log In button is not enabled!");

        // Finalize all soft assertions
        softAssert.assertAll(); // This will report all failures
    }
}
