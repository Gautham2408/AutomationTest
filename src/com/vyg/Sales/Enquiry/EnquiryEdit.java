package com.vyg.Sales.Enquiry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnquiryEdit {
	WebDriver driver;
	
	@Given("^open the firefox and launch the application$")
	public void open_the_firefox_and_launch_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();
		driver.get("http://192.168.1.18:8082/VyoogErp3/enquiry/show/153919");
	    
	}

	@When("^update the enquiry$")
	public void update_the_enquiry() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  

		driver.findElement(By.cssSelector(".btn-warning")).click();
	    driver.findElement(By.id("make")).click();
	    driver.findElement(By.id("make")).sendKeys("make");
	    driver.findElement(By.id("modelNo")).click();
	    driver.findElement(By.id("modelNo")).sendKeys("model");
	    driver.findElement(By.name("enquiryItems[0].itemDescription")).click();
	    driver.findElement(By.name("enquiryItems[0].itemDescription")).sendKeys("ee");
	    driver.findElement(By.cssSelector(".addCloneButton")).click();
	    driver.findElement(By.xpath("(//input[@id=\'productItemName1-search\'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@id=\'productItemName1-search\'])[2]")).sendKeys("a");
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.cssSelector(".tt-open .tt-suggestion:nth-child(4)")).click();
	   
	    driver.findElement(By.name("enquiryItems[1].itemDescription")).click();
	    driver.findElement(By.name("enquiryItems[1].itemDescription")).sendKeys("as");
	    driver.findElement(By.name("enquiryItems[1].noOfQuantity")).click();
	    driver.findElement(By.name("enquiryItems[1].noOfQuantity")).sendKeys("5");
	    driver.findElement(By.name("enquiryItems[1].approximatePrice")).click();
	    driver.findElement(By.name("enquiryItems[1].approximatePrice")).sendKeys("500");
	    driver.findElement(By.id("remark")).click();
	    driver.findElement(By.id("remark")).sendKeys("timer");
		driver.findElement(By.id("update")).click();
	    
	}

	@Then("^enquiry was updated successfully$")
	public void enquiry_was_updated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}
