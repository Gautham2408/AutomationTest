package com.vyg.Sales.Enquiry;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnquiryCreate {
	WebDriver driver;

	@Given("^Open the Firefox and launch the application$")
	public void open_the_Firefox_and_launch_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();
	}

	@When("^Enter the 	New enquiry  details$")
	public void enter_the_New_enquiry_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		TimeUnit.SECONDS.sleep(1);
		 driver.get("http://localhost:8085/VyoogErp3/enquiry/create");
		
		    driver.findElement(By.id("customerName-search")).sendKeys("s");
		    driver.findElement(By.id("customerName-search")).click();
		    
		    
		    
		    TimeUnit.SECONDS.sleep(5);
		    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(1)")).click();
		    driver.findElement(By.name("classification")).click();
		    {
		      WebElement dropdown = driver.findElement(By.name("classification")); 
		      dropdown.findElement(By.xpath("//option[. = 'A']")).click();
		    }
		    driver.findElement(By.id("receivedBy-search")).sendKeys("a");
		    driver.findElement(By.id("receivedBy-search")).click();
		   
		    TimeUnit.SECONDS.sleep(5);
		    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(2)")).click();
		    driver.findElement(By.cssSelector("#classification > option:nth-child(2)")).click();
		    driver.findElement(By.id("validityDate")).click();
		    driver.findElement(By.cssSelector("tr:nth-child(3) > .day:nth-child(4)")).click();
		    driver.findElement(By.cssSelector("div:nth-child(3) > .row:nth-child(7)")).click();
		    driver.findElement(By.id("productItemName0-search")).sendKeys("a");
		    driver.findElement(By.id("productItemName0-search")).click();
		    TimeUnit.SECONDS.sleep(5);
		    driver.findElement(By.cssSelector(".tt-open .tt-suggestion:nth-child(4)")).click();
		    driver.findElement(By.name("enquiryItems[0].itemDescription")).click();
		    driver.findElement(By.name("enquiryItems[0].itemDescription")).sendKeys("aa");
		    driver.findElement(By.id("noOfQuantity")).click();
		    driver.findElement(By.id("noOfQuantity")).sendKeys("5");
		    driver.findElement(By.name("enquiryItems[0].approximatePrice")).click();
		    driver.findElement(By.name("enquiryItems[0].approximatePrice")).sendKeys("1000");
		    driver.findElement(By.cssSelector(".buttons > div")).click();
		    driver.findElement(By.id("create")).click();
		  }
	@Then("^Enquiry was created successfully$")
	public void Enquiry_was_created_successfully() throws Throwable {
		
		TimeUnit.SECONDS.sleep(5);
	
		
}
}
