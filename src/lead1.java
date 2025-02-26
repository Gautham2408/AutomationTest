import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;


public class lead1 {
    public static void main(String[] args) throws Throwable {
                System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");

       
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://192.168.1.101:8086/VyoogErp3/");
        driver.manage().window().maximize();

        driver.findElement(By.id("loginDatasource")).click();
        driver.findElement(By.id("loginDatasource")).clear();
        driver.findElement(By.id("loginDatasource")).sendKeys("makwin");
        driver.findElement(By.id("loginDatasource")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("loginDatasource")).sendKeys(Keys.TAB);
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("makwinadmin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("vyg06");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        
        // Wait for the close button of the modal
        WebDriverWait waitCloseButton = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton = waitCloseButton.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info btn-sm']")));
        closeButton.click();

        // Wait for the modal backdrop to disappear after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
        
        WebElement salesAndMarketingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#menu3']")));
        salesAndMarketingMenu.click();
        
        WebElement crm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'CRM')]")));
        crm.click();
        
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.ARROW_DOWN);
        body.sendKeys(Keys.ARROW_DOWN);

        WebElement leadMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuid-7252']")));
        leadMenu.click();
        
        //start of lead info
        WebElement leadDate = driver.findElement(By.xpath("//input[@id='leadDate']"));
        leadDate.click();
        driver.findElement(By.xpath("//td[text()='" + LocalDate.now().getDayOfMonth() + "']")).click();
        
        WebElement reference = driver.findElement(By.xpath("//select[@id='reference.id']"));
        Select dd=new Select(reference);
        dd.selectByIndex(2);

        
        WebElement refnote=driver.findElement(By.xpath("//input[@id='referenceNumber']"));
        refnote.sendKeys("reference note");
        
//        WebElement relatedTo=driver.findElement(By.xpath("//select[@id=product.id']"));
//        relatedTo.click();
        
        WebElement status = driver.findElement(By.xpath("//select[@id='status']"));
        status.click();
        Select dd1=new Select(status);
        dd1.selectByIndex(2);
        
        WebElement targetDate = driver.findElement(By.id("targetDate"));
        targetDate.click();

        // Find all days in the calendar
        List<WebElement> days = driver.findElements(By.xpath("//td[contains(@class, 'day') and not(contains(@class, 'disabled'))]"));

        // Select the last available day
        days.get(days.size() - 1).click();
        
        driver.findElement(By.xpath("//input[@id='active']")).click();
        //end of lead info
        
        //start of customer info
        driver.findElement(By.id("customerName-search")).sendKeys("a");
        Thread.sleep(5000);

        // Select the first customer (skipping "+ New Customer")
        driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable'][2]")).click();
        
        WebElement classification = driver.findElement(By.xpath("//select[@id='classification']"));
        classification.click();
        Select dd2=new Select(classification);
        dd2.selectByIndex(2);
        //end of customer info
        
        //start of product info
        WebElement product = driver.findElement(By.xpath("//input[@id='productName0-search']"));
        product.click();
        product.sendKeys("A");

        // Wait for the dropdown suggestions list to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tt-dataset-itemName03")));

        // Find the first valid suggestion excluding "+ New Item"
        WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tt-dataset tt-dataset-itemName03']//div[contains(@class, 'tt-suggestion') and not(text()='+ New Item')]")));
        firstItem.click();

        driver.findElement(By.xpath("//input[@id='remark']")).sendKeys("Desc");
                
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("5");
        
        driver.findElement(By.xpath("//input[@id='amount']")).clear();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("10");
        //end of product info
        
        //start of lead contact
        driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#showNewContact']")).click();
        driver.findElement(By.xpath("//input[@id='personNameNew0']")).sendKeys("contact1");
        driver.findElement(By.xpath("//input[@id='designationNew0']")).sendKeys("designation");
        driver.findElement(By.xpath("//input[@id='emailNew0']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='phoneNew0']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@id='alterPhoneNew0']")).sendKeys("9786543210");
        //end of lead contact
        
        //start of lead activity
        driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#addActivity']")).click();
        // Click on the dropdown field
        driver.findElement(By.id("leadActivities[0].activityType")).click();
        // Select the first option excluding "Please Select"
        driver.findElement(By.xpath("//select[@id='leadActivities[0].activityType']//option[@value!='']")).click();
        driver.findElement(By.xpath("//input[@id='leadActivities[0].subject']")).sendKeys("subject");
     // Click on the calendar input and select the 25th day
        driver.findElement(By.id("leadActivities[0].dueDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='25']")).click();
        
        driver.findElement(By.id("leadActivities[0].activityDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='24']")).click();
        // Click on the dropdown field
        driver.findElement(By.id("leadActivities[0].priority")).click();
        // Select the first option excluding "Please Select"
        driver.findElement(By.xpath("//select[@id='leadActivities[0].priority']//option[@value!='']")).click();
        // Click on the dropdown field
        driver.findElement(By.id("leadActivities[0].status.id")).click();
        // Select the first option excluding "Please Select"
        driver.findElement(By.xpath("//select[@id='leadActivities[0].status.id']//option[@value!=''][3]")).click();
        // Click on the dropdown field
        driver.findElement(By.id("leadActivities[0].reminder")).click();
        // Select the first option excluding "Please Select"
        driver.findElement(By.xpath("//select[@id='leadActivities[0].reminder']//option[@value!='']")).click();
        driver.findElement(By.id("leadActivities[0].contactPerson.id")).click();

     // Get valid options excluding "Please Select"
     List<WebElement> options = driver.findElements(By.xpath("//select[@id='leadActivities[0].contactPerson.id']//option[@value!='']"));

     // Select the first valid option or move to the next field
     if (!options.isEmpty()) {
         options.get(0).click();
     } else {
         driver.findElement(By.id("leadActivities[0].assignTo.id")).click(); // Replace with actual next field ID
     }
     driver.findElement(By.id("leadActivities[0].assignTo.id")).click();

     // Get valid options excluding "Please Select"
     List<WebElement> options1 = driver.findElements(By.xpath("//select[@id='leadActivities[0].contactPerson.id']//option[@value!='']"));

     // Select the first valid option or move to the next field
     if (!options1.isEmpty()) {
         options1.get(0).click();
     } else {
         driver.findElement(By.id("leadActivities[0].result")).click(); // Replace with actual next field ID
     }
     driver.findElement(By.id("leadActivities[0].result")).sendKeys("Result");
     driver.findElement(By.id("leadActivities[0].description")).sendKeys("Notes");
     //end of lead activity
     
     //Start of attachment
     driver.findElement(By.xpath("//span[contains(@class, 'btn') and contains(@data-target, '#addFiles') and contains(text(), 'File Attachment')]")).click();
     WebElement fileUpload = driver.findElement(By.id("fileUpload"));
     fileUpload.sendKeys("/home/vyoog-desktop/Inventory.html");
     //End of attachment
   
     //Start of lead notes
     driver.findElement(By.xpath("//span[contains(@class, 'btn') and @data-target='#salesHistory' and contains(text(), 'Lead Notes')]")).click();
     driver.findElement(By.xpath("//input[@id='salesNoteSubject']")).sendKeys("Subject");
     WebElement notesDate = driver.findElement(By.xpath("//input[@id='salesNoteEntryDate']"));
     notesDate.click();
     driver.findElement(By.xpath("//td[text()='" + LocalDate.now().getDayOfMonth() + "']")).click();
     driver.findElement(By.xpath("//select[@id='salesNoteType']//option[@value!=''][3]")).click();
     driver.findElement(By.xpath("//input[@id='followup-search']")).sendKeys("Employee");
     driver.findElement(By.xpath("//input[@id='salesNoteNote']")).sendKeys("LEad note");
     //end of lead notes
   
     //Start of remark
     driver.findElement(By.xpath("//textarea[@id='remarks']")).sendKeys("Any Remark");
     //End of remark
     

     // Save process
     driver.findElement(By.xpath("//input[@id='create']")).click();

     // Wait until the URL contains 'VyoogErp3/leadManager/show/'
     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait1.until(ExpectedConditions.urlContains("VyoogErp3/leadManager/show/"));

     System.out.println("Show page loaded successfully: " + driver.getCurrentUrl());
     Thread.sleep(5000);
     driver.quit();
     //end of save
     
    }
}