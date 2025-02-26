package com.vyg.Sales.Quotation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuotationCreate2 {

	WebDriver driver;

	@Given("^Open the application$")
	public void open_the_application() throws Throwable {
		System.out.println("OPEN FIREFOX");
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();

	}

	@When("^Enter the quotation  details$")
	public void enter_the_quotation_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("OPEN QUOTA");
		TimeUnit.SECONDS.sleep(1);
		driver.get("http://localhost:8085/VyoogErp3/Enquiry/index");
		TimeUnit.SECONDS.sleep(1);
		 driver.findElement(By.cssSelector(".odd:nth-child(1) a")).click();
		    
		driver.findElement(By.cssSelector(".btn-demo > .btn-info")).click();
		driver.findElement(By.name("deliveryCount")).click();
		driver.findElement(By.name("deliveryCount")).sendKeys("12");
		driver.findElement(By.cssSelector("td:nth-child(10)")).click();
		driver.findElement(By.id("quotation-item-line-0")).click();
		driver.findElement(By.linkText("+ Add Note")).click();
		{
			WebElement element = driver.findElement(By.linkText("+ Add Note"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.id("salesNoteEntryDate")).click();
		driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(5)")).click();
		driver.findElement(By.id("salesNoteType")).click();
		{
			WebElement dropdown = driver.findElement(By.id("salesNoteType"));
			dropdown.findElement(By.xpath("//option[. = 'Call']")).click();
		}
		driver.findElement(By.cssSelector("#salesNoteType > option:nth-child(2)")).click();
		driver.findElement(By.id("salesNoteSubject")).click();
		driver.findElement(By.id("salesNoteSubject")).sendKeys("call");
		driver.findElement(By.id("followup-search")).click();
		driver.findElement(By.id("followup-search")).sendKeys("a");
		TimeUnit.SECONDS.sleep(1);
		
		driver.findElement(By.cssSelector(".tt-suggestion:nth-child(2)")).click();
		driver.findElement(By.id("salesNoteNote")).click();
		driver.findElement(By.id("salesNoteNote")).sendKeys("call");
		driver.findElement(By.id("general85")).click();
		driver.findElement(By.id("fixedSaveButton")).click();
		driver.findElement(By.cssSelector(".alert-success")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".alert-success"));
			assert (elements.size() > 0);
		}

	}

	@Then("^New quotation was created successfully$")
	public void new_quotation_was_created_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
