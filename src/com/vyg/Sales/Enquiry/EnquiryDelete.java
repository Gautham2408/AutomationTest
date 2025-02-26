package com.vyg.Sales.Enquiry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnquiryDelete {
	
	WebDriver driver;

	@Given("^Open the Firefox and launch the application1$")
	public void open_the_Firefox_and_launch_the_application1() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();
	}
	@When("^click delete button in the screen$")
	public void click_delete_button_in_the_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		driver.get("http://192.168.1.18:8082/VyoogErp3/enquiry/index");
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.cssSelector("td:nth-child(1) > .form-control")).sendKeys("20");
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.cssSelector("td:nth-child(1) > .form-control")).click();
	   
	    driver.findElement(By.linkText("ENQ-2220")).click();
	    driver.findElement(By.name("_action_delete")).click();
	    assertThat(driver.switchTo().alert().getText(), is("Are you sure?"));
	    driver.switchTo().alert().accept();
	    throw new PendingException();
	}
	private void assertThat(String text, Object object) {
		// TODO Auto-generated method stub
		
	}
	private Object is(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	@Then("^Enquiry was deleted successfully$")
	public void enquiry_was_deleted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
