package com.vyg.Sales.Quotation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuotationCreate1 {
	public static void name() {
		
	}
	WebDriver driver;
	
	@Given("^Go to the application$")
	public void go_to_the_application() throws Throwable {
		System.out.println("OPEN FIREFOX");
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();
 
	}

	@When("^Enter the details about new quotation$")
	public void enter_the_details_about_new_quotation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver.get("http://localhost:8085/VyoogErp3/quotation/index");
		   
		    driver.findElement(By.cssSelector(".btn-primary")).click();
		    {
		    	TimeUnit.SECONDS.sleep(1);
		      WebElement element = driver.findElement(By.cssSelector(".sticky-table"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).clickAndHold().perform();
		    }
		    {
		      WebElement element = driver.findElement(By.cssSelector(".sticky-table"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
		    {
		      WebElement element = driver.findElement(By.cssSelector(".sticky-table"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).release().perform();
		    }
		    driver.findElement(By.cssSelector(".even:nth-child(1773) .btn")).click();
		    driver.findElement(By.id("quotationType")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("quotationType"));
		      dropdown.findElement(By.xpath("//option[. = 'ESP']")).click();
		    }
		    driver.findElement(By.cssSelector("#quotationType > option:nth-child(3)")).click();
		    driver.findElement(By.name("deliveryCount")).click();
		    driver.findElement(By.name("deliveryCount")).sendKeys("13");
		    driver.findElement(By.id("quoteNumber")).click();
		    driver.findElement(By.id("quoteNumber")).sendKeys("12fg");
		    driver.findElement(By.id("subject")).click();
		    driver.findElement(By.id("subject")).sendKeys("quotation");
		    driver.findElement(By.id("targetDate")).click();
		    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(5)")).click();
		    driver.findElement(By.id("active")).click();
		    driver.findElement(By.id("quotation-item-line-0")).click();
		    driver.findElement(By.id("general80")).click();
		    
		     driver.findElement(By.id("general83")).click();
		    
		    driver.findElement(By.id("general86")).click();
		    driver.findElement(By.linkText("+ Add Note")).click();
		    driver.findElement(By.id("salesNoteEntryDate")).click();
		    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(4)")).click();
		    driver.findElement(By.id("salesNoteType")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("salesNoteType"));
		      dropdown.findElement(By.xpath("//option[. = 'Email']")).click();
		    }
		    driver.findElement(By.cssSelector("#salesNoteType > option:nth-child(3)")).click();
		    driver.findElement(By.id("salesNoteSubject")).click();
		    driver.findElement(By.id("salesNoteSubject")).sendKeys("email");
		    driver.findElement(By.id("followup-search")).click();
		    driver.findElement(By.id("followup-search")).sendKeys("a");
		    TimeUnit.SECONDS.sleep(1);
		    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(4)")).click();
		    TimeUnit.SECONDS.sleep(1);
		    
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,750)");
		    
		    driver.findElement(By.id("salesNoteNote")).click();
		    driver.findElement(By.id("salesNoteNote")).sendKeys("email");
		   
		  }
		
	
	@Then("^save the new quotation$")
	public void save_the_new_quotation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("fixedSaveButton")).click();
	    throw new PendingException();
	}

}
