import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginTest {
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

        // Wait for the "Sales and Marketing" menu to be clickable
        WebElement salesAndMarketingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#menu3']")));
        salesAndMarketingMenu.click();
        
        // Scroll down the menu bar using ArrowDown key to ensure the "Sale Order" link is visible
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.ARROW_DOWN); // Scroll down by one step
        body.sendKeys(Keys.ARROW_DOWN); // Scroll down another step (optional, if needed)
        
        // Wait for the "Sale Order" option to be clickable
        WebDriverWait waitSaleOrder = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saleOrderMenu = waitSaleOrder.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Sale Order')]"))); 
        saleOrderMenu.click();
        
        // Scroll down the menu bar using ArrowDown key to ensure the "New Sale Order" link is visible
        WebElement body1 = driver.findElement(By.tagName("body"));
        body1.sendKeys(Keys.ARROW_DOWN);  // Scroll down by one step
        body1.sendKeys(Keys.ARROW_DOWN);  // Scroll down another step (optional, if needed)

        // Wait for the "New Sale Order" option to be clickable
        WebDriverWait waitNewSaleOrderMenu = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newSaleOrderMenu = waitNewSaleOrderMenu.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuid-7259']")));
        newSaleOrderMenu.click();

        // Find and click the 'Type' dropdown to open it
        WebElement typeDropdown = driver.findElement(By.xpath("//button[@data-id='bookingType']")); 
        typeDropdown.click(); 

        WebElement openOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Open']")));
        openOption.click();
        
        WebElement dateField = driver.findElement(By.xpath("//input[@id='orderBookingDate']"));
        dateField.click();
        //code to select current date
        driver.findElement(By.xpath("//td[text()='" + java.time.LocalDate.now().getDayOfMonth() + "']")).click();


        // Enter 'a' in the customer field
        driver.findElement(By.id("customerName-search")).sendKeys("a");
        Thread.sleep(5000);

        // Select the first customer (skipping "+ New Customer")
        driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable'][2]")).click();
        
        WebElement type1dropdown = driver.findElement(By.xpath("//button[@data-id='orderType']"));
        type1dropdown.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regularOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-id='orderType']/following-sibling::div//span[text()='Regular']")));
        regularOption.click();
        
        driver.findElement(By.xpath("//input[@id='poNumber']")).sendKeys("PO12345");     
        
        // Open the calendar by clicking on the PO Date field
        driver.findElement(By.id("poDate")).click();

        // Find and click on the first day of the month in the calendar
        driver.findElement(By.xpath("//td[text()='1']")).click();       

        driver.findElement(By.id("referencePerson-search")).sendKeys("a");
        // Wait for the dropdown menu to be visible
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the first suggestion becomes clickable
        WebElement firstOption = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'tt-menu') and not(contains(@style, 'display: none;'))]//div[contains(@class, 'tt-suggestion')][1]")));
        firstOption.click();
       
        // Open the date picker
        WebElement dateField1 = driver.findElement(By.xpath("//input[@id='deliveryDate']"));
        dateField1.click();

        // Get the last day of the current month dynamically
        int lastDayOfMonth = java.time.YearMonth.now().lengthOfMonth();

        // Wait until the calendar is visible
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker-days')]")));

        // Find and click the last day of the current month
        WebElement lastDay = driver.findElement(By.xpath("//td[contains(@class, 'day') and not(contains(@class, 'old')) and not(contains(@class, 'new')) and text()='" + lastDayOfMonth + "']"));
        lastDay.click();
        
        WebElement product = driver.findElement(By.xpath("//input[@id='productName-search']"));
        product.click();
        product.sendKeys("a");

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the tt-menu (suggestions list) to be visible
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("tt-dataset-itemName03")));

        // Find the first valid suggestion excluding the "+ New Item"
        WebElement firstValidSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tt-dataset tt-dataset-itemName03']//div[contains(@class, 'tt-suggestion') and not(text()='+ New Item')]")));

        // Click on the first valid suggestion
        firstValidSuggestion.click();
        
       driver.findElement(By.xpath("//textarea[@id='itemDescription']")).sendKeys("Desc");
       
       driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("5");
       
       driver.findElement(By.xpath("//input[@id='unitPrice-0']")).clear();
       driver.findElement(By.xpath("//input[@id='unitPrice-0']")).sendKeys("10");
       
       WebElement dateField2 = driver.findElement(By.xpath("//input[@id='deliverydate']"));
       dateField2.click();
       //code to select current date
       driver.findElement(By.xpath("//td[text()='" + java.time.LocalDate.now().getDayOfMonth() + "']")).click();
       
       WebElement firstCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox' and @name='generalTerms1'])[1]"));
       firstCheckbox.click();

       WebElement firstCheckbox1 = driver.findElement(By.xpath("(//input[@type='checkbox' and @name='paymentTerms'])[1]"));
       firstCheckbox1.click();
       
       driver.findElement(By.xpath("//textarea[@id='remark']")).sendKeys("Any Remark");
       
       // Locate the file input field
       WebElement fileUpload = driver.findElement(By.id("fileUpload"));

       // Provide the absolute file path (Ensure the file exists in the given path)
       fileUpload.sendKeys("/home/vyoog-desktop/Inventory.html"); // Replace with your actual file path
       
       driver.findElement(By.xpath("//input[@id='create']")).click();
       
    // Wait until the unique order number appears on the show page
       WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement orderNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
           By.xpath("//span[contains(@class, 'input-mui') and contains(text(), 'OB-')]")
       ));

       System.out.println("Show page loaded with Order No: " + orderNumberElement.getText());

       // Wait for 5 seconds
       Thread.sleep(5000);

       // Close the browser
       driver.quit();


    }
}
