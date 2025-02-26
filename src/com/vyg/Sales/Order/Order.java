package com.vyg.Sales.Order;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Order{
	
	WebDriver driver;

@Given("^Opened the application$")
public void opened_the_application() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("OPEN FIREFOX");
	System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
	driver = new Login().getLogin(); 
}

@When("^enquiry to saleorder flow can be created$")
public void enquiry_to_saleorder_flow_can_be_created() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get("http://localhost:8085/VyoogErp3/dashboard/common");
	
	driver.findElement(By.cssSelector(".nav-item:nth-child(8) p")).click();
    driver.findElement(By.cssSelector("#menu7 > .panel:nth-child(10) a > div")).click();
    driver.findElement(By.id("menuid-3505")).click();
    driver.findElement(By.id("customerName-search")).click();
    driver.findElement(By.id("customerName-search")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
   
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(13)")).click();
    driver.findElement(By.id("custReference")).click();
    driver.findElement(By.id("custReference")).sendKeys("13rt");
    driver.findElement(By.cssSelector(".filter-option")).click();
    driver.findElement(By.cssSelector("li:nth-child(8) .text")).click();
    driver.findElement(By.id("enquiryStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("enquiryStatus"));
      dropdown.findElement(By.xpath("//option[. = 'Quoted']")).click();
    }
    driver.findElement(By.cssSelector("#enquiryStatus > option:nth-child(4)")).click();
    driver.findElement(By.id("receivedBy-search")).click();
    driver.findElement(By.id("receivedBy-search")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-open .tt-suggestion:nth-child(11)")).click();
    driver.findElement(By.id("active")).click();
    driver.findElement(By.id("externalReference")).click();
    driver.findElement(By.id("externalReference")).sendKeys("as1313");
    driver.findElement(By.id("followedBy-search")).click();
    driver.findElement(By.id("followedBy-search")).sendKeys("a");
    driver.findElement(By.cssSelector(".tt-open .tt-suggestion:nth-child(5)")).click();
    driver.findElement(By.id("make")).click();
    driver.findElement(By.id("make")).sendKeys("maked");
    driver.findElement(By.id("modelNo")).click();
    driver.findElement(By.id("modelNo")).sendKeys("modeled");
    driver.findElement(By.cssSelector(".row:nth-child(5) > .col-md-3:nth-child(3)")).click();
    driver.findElement(By.id("enquiryType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("enquiryType"));
      dropdown.findElement(By.xpath("//option[. = 'TENDER']")).click();
    }
    driver.findElement(By.cssSelector("#enquiryType > option:nth-child(3)")).click();
    driver.findElement(By.id("validityDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(7)")).click();
    driver.findElement(By.id("offerResponsible")).click();
    driver.findElement(By.id("offerResponsible")).sendKeys("pwer");
    driver.findElement(By.id("responsible")).click();
    driver.findElement(By.id("responsible")).sendKeys("hpweer");
    driver.findElement(By.id("offerStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("offerStatus"));
      dropdown.findElement(By.xpath("//option[. = 'LIVE']")).click();
    }
    driver.findElement(By.cssSelector("#offerStatus > option:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".btn-info:nth-child(4)")).click();
    driver.findElement(By.id("personNameNew0")).click();
    driver.findElement(By.id("personNameNew0")).sendKeys("admin");
    driver.findElement(By.id("designationNew0")).sendKeys("staff");
    driver.findElement(By.id("emailNew0")).click();
    driver.findElement(By.id("emailNew0")).sendKeys("staff@admin");
    driver.findElement(By.id("phoneNew0")).click();
    driver.findElement(By.id("phoneNew0")).sendKeys("9955898945");
    driver.findElement(By.id("alterPhoneNew0")).click();
    driver.findElement(By.id("alterPhoneNew0")).sendKeys("4848954848");
    driver.findElement(By.cssSelector(".addContactClone")).click();
    driver.findElement(By.id("personNameNew1")).click();
    driver.findElement(By.id("personNameNew1")).sendKeys("ash");
    driver.findElement(By.id("designationNew1")).click();
    driver.findElement(By.id("designationNew1")).sendKeys("staff");
    driver.findElement(By.id("emailNew1")).click();
    driver.findElement(By.id("emailNew1")).sendKeys("ash@admin");
    driver.findElement(By.id("phoneNew1")).click();
    driver.findElement(By.id("phoneNew1")).sendKeys("494964949");
    driver.findElement(By.id("alterPhoneNew1")).click();
    driver.findElement(By.id("alterPhoneNew1")).sendKeys("484894848");
    driver.findElement(By.cssSelector(".col-md-10 > .row:nth-child(1)")).click();
    driver.findElement(By.id("productItemName0-search")).click();
    driver.findElement(By.id("productItemName0-search")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    JavascriptExecutor jsee = (JavascriptExecutor)driver;
   	jsee.executeScript("window.scrollBy(0,750)");
   	TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(5)")).click();
    driver.findElement(By.name("enquiryItems[0].itemDescription")).click();
    driver.findElement(By.name("enquiryItems[0].itemDescription")).sendKeys("filter");
    driver.findElement(By.name("enquiryItems[0].customerItemName")).click();
    driver.findElement(By.name("enquiryItems[0].customerItemName")).sendKeys("filter regulator");
    driver.findElement(By.id("noOfQuantity")).click();
    driver.findElement(By.id("noOfQuantity")).sendKeys("7");
    driver.findElement(By.name("enquiryItems[0].approximatePrice")).click();
    driver.findElement(By.name("enquiryItems[0].approximatePrice")).sendKeys("700");
    driver.findElement(By.cssSelector("#parent-clone-0 > .col-md-1:nth-child(8)")).click();
    driver.findElement(By.cssSelector(".addCloneButton")).click();
    driver.findElement(By.xpath("(//input[@id=\'productItemName1-search\'])[2]")).click();
    driver.findElement(By.xpath("(//input[@id=\'productItemName1-search\'])[2]")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(4)")).click();
    driver.findElement(By.name("enquiryItems[1].itemDescription")).click();
    driver.findElement(By.name("enquiryItems[1].itemDescription")).sendKeys("dome");
    driver.findElement(By.name("enquiryItems[1].customerItemName")).sendKeys("dome valve");
    driver.findElement(By.name("enquiryItems[1].noOfQuantity")).sendKeys("7");
    driver.findElement(By.name("enquiryItems[1].approximatePrice")).click();
    driver.findElement(By.name("enquiryItems[1].approximatePrice")).sendKeys("590");
    driver.findElement(By.cssSelector(".col-md-10 > .row:nth-child(1)")).click();
    driver.findElement(By.cssSelector("#child-clone-0 > #parent-clone-0 .btn-success")).click();
    driver.findElement(By.xpath("(//input[@id=\'productItemName2-search\'])[2]")).click();
    driver.findElement(By.xpath("(//input[@id=\'productItemName2-search\'])[2]")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(13)")).click();
    driver.findElement(By.name("enquiryItems[2].itemDescription")).click();
    driver.findElement(By.name("enquiryItems[2].itemDescription")).sendKeys("self");
    driver.findElement(By.name("enquiryItems[2].customerItemName")).sendKeys("self21");
    driver.findElement(By.name("enquiryItems[2].noOfQuantity")).sendKeys("9");
    driver.findElement(By.name("enquiryItems[2].approximatePrice")).click();
    driver.findElement(By.name("enquiryItems[2].approximatePrice")).sendKeys("789");
    driver.findElement(By.cssSelector(".buttons > div")).click();
    driver.findElement(By.cssSelector(".row:nth-child(16) > .col-md-2")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".row:nth-child(16) > .col-md-2"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.linkText("+ Add Note")).click();
    driver.findElement(By.id("salesNoteEntryDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(5)")).click();
    {
      WebElement dropdown = driver.findElement(By.id("salesNoteType"));
      dropdown.findElement(By.xpath("//option[. = 'WhatsApp']")).click();
    }
    driver.findElement(By.cssSelector("#salesNoteType > option:nth-child(4)")).click();
    driver.findElement(By.id("salesNoteSubject")).click();
    driver.findElement(By.id("salesNoteSubject")).sendKeys("whatsapp");
    driver.findElement(By.id("followup-search")).click();
    driver.findElement(By.id("followup-search")).sendKeys("aswin");
    driver.findElement(By.id("salesNoteNote")).click();
    driver.findElement(By.id("salesNoteNote")).sendKeys("connect");
    driver.findElement(By.cssSelector(".btn-md:nth-child(3)")).click();
    {
      WebElement dropdown = driver.findElement(By.id("leadActivities[0].activityType"));
      dropdown.findElement(By.xpath("//option[. = 'Task']")).click();
    }
    driver.findElement(By.cssSelector("#leadActivities\\[0\\]\\.activityType > option:nth-child(2)")).click();
    driver.findElement(By.id("leadActivities[0].subject")).click();
    driver.findElement(By.id("leadActivities[0].subject")).sendKeys("task");
    driver.findElement(By.id("leadActivities[0].dueDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(4)")).click();
    driver.findElement(By.id("leadActivities[0].activityDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(7)")).click();
    driver.findElement(By.id("leadActivities[0].priority")).click();
    {
      WebElement dropdown = driver.findElement(By.id("leadActivities[0].priority"));
      dropdown.findElement(By.xpath("//option[. = 'Medium']")).click();
    }
    driver.findElement(By.cssSelector("#leadActivities\\[0\\]\\.priority > option:nth-child(3)")).click();
    driver.findElement(By.id("leadActivities[0].status.id")).click();
    {
      WebElement dropdown = driver.findElement(By.id("leadActivities[0].status.id"));
      dropdown.findElement(By.xpath("//option[. = 'In-Progress']")).click();
    }
    driver.findElement(By.cssSelector("#leadActivities\\[0\\]\\.status\\.id > option:nth-child(5)")).click();
    driver.findElement(By.id("leadActivities[0].reminder")).click();
    {
      WebElement dropdown = driver.findElement(By.id("leadActivities[0].reminder"));
      dropdown.findElement(By.xpath("//option[. = 'Weekly']")).click();
    }
    driver.findElement(By.cssSelector("#leadActivities\\[0\\]\\.reminder > option:nth-child(3)")).click();
    driver.findElement(By.id("leadActivities[0].contactPerson.id")).click();
    driver.findElement(By.id("leadActivities[0].result")).click();
    driver.findElement(By.id("leadActivities[0].result")).sendKeys("done");
    driver.findElement(By.id("leadActivities[0].description")).click();
    driver.findElement(By.id("leadActivities[0].description")).sendKeys("done");
    driver.findElement(By.id("remark")).click();
    driver.findElement(By.id("remark")).sendKeys("remarks");
    driver.findElement(By.id("create")).click();
    driver.findElement(By.cssSelector(".btn-demo > .btn-info")).click();
    driver.findElement(By.id("quotationType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("quotationType"));
      dropdown.findElement(By.xpath("//option[. = 'Spares']")).click();
    }
    driver.findElement(By.cssSelector("#quotationType > option:nth-child(6)")).click();
    driver.findElement(By.id("quotationDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(6)")).click();
    driver.findElement(By.id("classification")).click();
    {
      WebElement dropdown = driver.findElement(By.id("classification"));
      dropdown.findElement(By.xpath("//option[. = 'B']")).click();
    }
    driver.findElement(By.cssSelector("#classification > option:nth-child(3)")).click();
    driver.findElement(By.id("employee-search")).click();
    driver.findElement(By.id("employee-search")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(9)")).click();
    driver.findElement(By.name("deliveryCount")).click();
    driver.findElement(By.name("deliveryCount")).sendKeys("12");
    driver.findElement(By.id("subject")).click();
    driver.findElement(By.id("subject")).sendKeys("quotation");
    driver.findElement(By.cssSelector(".row:nth-child(10) > .col-md-3:nth-child(3)")).click();
    driver.findElement(By.id("targetDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(6) > .day:nth-child(2)")).click();
    driver.findElement(By.id("quotation-item-line-1")).click();
    driver.findElement(By.id("quotation-item-line-0")).click();
    driver.findElement(By.id("quotation-item-line-2")).click();
    driver.findElement(By.id("quotation-item-line-2")).click();
    driver.findElement(By.linkText("+ Add Note")).click();

    JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,750)");
    driver.findElement(By.id("salesNoteEntryDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(4)")).click();
    {
      WebElement dropdown = driver.findElement(By.id("salesNoteType"));
      dropdown.findElement(By.xpath("//option[. = 'Email']")).click();
    }
    driver.findElement(By.cssSelector("#salesNoteType > option:nth-child(3)")).click();
    driver.findElement(By.id("salesNoteSubject")).click();
    driver.findElement(By.id("salesNoteSubject")).sendKeys("email");
    JavascriptExecutor jsie = (JavascriptExecutor)driver;
   	jsie.executeScript("window.scrollBy(0,750)");
    driver.findElement(By.id("followup-search")).click();
    driver.findElement(By.id("followup-search")).sendKeys("ash");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-open .tt-suggestion")).click();
    driver.findElement(By.id("salesNoteNote")).click();
    driver.findElement(By.id("salesNoteNote")).sendKeys("email the details");
    driver.findElement(By.id("general43")).click();
    driver.findElement(By.id("general57")).click();
    JavascriptExecutor je = (JavascriptExecutor)driver;
	je.executeScript("window.scrollBy(0,750)");

    driver.findElement(By.id("general75")).click();
    driver.findElement(By.id("general56")).click();
    driver.findElement(By.id("fixedSaveButton")).click();
    driver.findElement(By.cssSelector(".content > .container-fluid")).click();
    driver.findElement(By.id("orderBookingCreate")).click();
    driver.findElement(By.id("bookingType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("bookingType"));
      dropdown.findElement(By.xpath("//option[. = 'Open']")).click();
    }
    driver.findElement(By.cssSelector("#bookingType > option:nth-child(4)")).click();
    driver.findElement(By.id("orderBookingDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(6) > .day:nth-child(2)")).click();
    driver.findElement(By.id("orderValue")).click();
    driver.findElement(By.id("orderValue")).sendKeys("170000");
    driver.findElement(By.cssSelector(".col-md-12:nth-child(2)")).click();
    driver.findElement(By.id("orderType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("orderType"));
      dropdown.findElement(By.xpath("//option[. = 'Retrofitting']")).click();
    }
    driver.findElement(By.cssSelector("#orderType > option:nth-child(5)")).click();
    driver.findElement(By.id("poNumber")).click();
    driver.findElement(By.id("poNumber")).sendKeys("178178");
    driver.findElement(By.id("poDate")).click();
    driver.findElement(By.cssSelector("tr:nth-child(5) > .day:nth-child(4)")).click();
    driver.findElement(By.id("referencePerson-search")).click();
    driver.findElement(By.id("referencePerson-search")).sendKeys("a");
    TimeUnit.SECONDS.sleep(1);
    driver.findElement(By.cssSelector(".tt-suggestion:nth-child(4)")).click();
    driver.findElement(By.id("deliveryDate")).click();
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(4)")).click();
    driver.findElement(By.name("paymentTerms")).click();
    driver.findElement(By.cssSelector(".gt-3653")).click();
    driver.findElement(By.cssSelector(".gt-3652")).click();
    driver.findElement(By.cssSelector(".row > .modal-body")).click();
   
}
@Then("^saleorder flow created sucessfully$")
public void saleorder_flow_created_sucessfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 
  driver.findElement(By.id("create")).click();

    throw new PendingException();
}
}