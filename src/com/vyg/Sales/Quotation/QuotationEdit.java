package com.vyg.Sales.Quotation;

import java.util.List;
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


public class QuotationEdit {
	

	WebDriver driver;

	@Given("^open the quotation in the application$")
	public void open_the_application() throws Throwable {
		System.out.println("OPEN FIREFOX");
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		driver = new Login().getLogin();

	}
	
	@When("^Enter the values in the edit quotation$")
	public void enter_the_values_in_the_edit_quotation() throws Throwable {
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.cssSelector(".nav-item:nth-child(8) p")).click();
		TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.cssSelector("#menu7 > .panel:nth-child(11) a > div")).click();
	    driver.findElement(By.id("menuid-22")).click();
	    driver.findElement(By.linkText("QUO-687")).click();
	    driver.findElement(By.cssSelector(".col-md-6 > .btn-warning")).click();
	    driver.findElement(By.cssSelector(".appendItem > .row:nth-child(6)")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.cssSelector(".row:nth-child(6) > .col-md-3:nth-child(2)"));
	      assert(elements.size() > 0);
	    }
	    
	 
	    driver.findElement(By.name("deliveryCount")).click();
	    {
	      WebElement element = driver.findElement(By.name("deliveryCount"));
	      Boolean isEditable1 = element.isEnabled() && element.getAttribute("readonly") == null;
	      assertTrue(isEditable1);
	    }
	    driver.findElement(By.id("quoteNumber")).sendKeys("54");
	    driver.findElement(By.id("classification")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("classification"));
	      dropdown.findElement(By.xpath("//option[. = 'D']")).click();
	    }
	    driver.findElement(By.cssSelector("#classification > option:nth-child(5)")).click();
	    driver.findElement(By.id("subject")).click();
	    driver.findElement(By.id("subject")).sendKeys("quo-2396");
	    driver.findElement(By.name("deliveryCount")).click();
	    driver.findElement(By.name("deliveryCount")).click();
	    {
	      WebElement element = driver.findElement(By.name("deliveryCount"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    driver.findElement(By.name("deliveryCount")).sendKeys("26");
	    driver.findElement(By.id("item-search")).click();
	    driver.findElement(By.id("item-search")).sendKeys("a");
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(4)")).click();
	    driver.findElement(By.cssSelector(".col-md-3 > .btn")).click();
	    
	    driver.findElement(By.id("itemDescription1")).click();
	    driver.findElement(By.id("itemDescription1")).click();
	    driver.findElement(By.id("itemDescription1")).sendKeys(" 	PI-24/Flat (M.S)- 25 X 3mm");
	    driver.findElement(By.id("quotationQty1")).click();
	    driver.findElement(By.id("quotationQty1")).sendKeys("3");
	    driver.findElement(By.name("newUnitPrice")).click();
	    driver.findElement(By.name("newUnitPrice")).sendKeys("333");
	    driver.findElement(By.cssSelector(".col-md-10 > .col-md-2")).click();
	    driver.findElement(By.linkText("+ Add Note")).click();
	    driver.findElement(By.id("salesNoteEntryDate")).click();
	    driver.findElement(By.cssSelector("tr:nth-child(3) > .day:nth-child(4)")).click();
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
	    driver.findElement(By.id("followup-search")).sendKeys("EMP-7-MANECK NAVEEN");
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,750)");
	    driver.findElement(By.id("salesNoteNote")).click();
	    driver.findElement(By.id("salesNoteNote")).sendKeys("email");
	    driver.findElement(By.cssSelector(".col-md-4:nth-child(51)")).click();
	    driver.findElement(By.id("general49")).click();
	    driver.findElement(By.id("general47")).click();
	    driver.findElement(By.id("general27")).click();
	    driver.findElement(By.id("general24")).click();
	    driver.findElement(By.id("general33")).click();
	    driver.findElement(By.id("general36")).click();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,750)");
		driver.findElement(By.cssSelector(".btn-md")).click();
	    driver.findElement(By.id("leadActivityType")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("leadActivityType"));
	      dropdown.findElement(By.xpath("//option[. = 'Event']")).click();
	    }
	    driver.findElement(By.cssSelector("#leadActivityType > option:nth-child(3)")).click();
	    driver.findElement(By.id("leadActivitySubject")).click();
	    driver.findElement(By.id("leadActivitySubject")).sendKeys("call");
	    driver.findElement(By.id("leadActivityDueDate")).click();
	    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(4)")).click();
	    driver.findElement(By.id("leadActivityDate")).click();
	    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(5)")).click();
	    driver.findElement(By.id("leadActivityPriority")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("leadActivityPriority"));
	      dropdown.findElement(By.xpath("//option[. = 'Medium']")).click();
	    }
	    driver.findElement(By.cssSelector("#leadActivityPriority > option:nth-child(3)")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("leadActivityStatus"));
	      dropdown.findElement(By.xpath("//option[. = 'In-Progress']")).click();
	    }
	    driver.findElement(By.cssSelector("#leadActivityStatus > option:nth-child(5)")).click();
	    driver.findElement(By.id("leadActivityReminder")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("leadActivityReminder"));
	      dropdown.findElement(By.xpath("//option[. = 'Weekly']")).click();
	    }
	    driver.findElement(By.cssSelector("#leadActivityReminder > option:nth-child(3)")).click();
	    driver.findElement(By.id("fixedSaveButton")).click();
	  
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	
		// TODO Auto-generated method stub
		
	}
	

	private void assertTrue(Boolean isEditable1) {
		// TODO Auto-generated method stub
		
	}

	@Then("^update the quotation$")
	public void update_the_quotation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
