package test.java.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class lead {
    private WebDriver driver = LoginSteps.getDriver(); // Reusing existing driver
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User navigates to Leads page")
    public void user_navigates_to_leads_page() {
        WebElement salesAndMarketingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#menu3']")));
        salesAndMarketingMenu.click();
        
        WebElement crm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'CRM')]")));
        crm.click();
        
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);

        WebElement leadMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuid-7252']")));
        leadMenu.click();
    }

    @When("User fills out lead information")
    public void user_fills_out_lead_information() {
        // Lead Date
        WebElement leadDate = driver.findElement(By.xpath("//input[@id='leadDate']"));
        leadDate.click();
        driver.findElement(By.xpath("//td[text()='" + LocalDate.now().getDayOfMonth() + "']")).click();

        // Reference
        WebElement reference = driver.findElement(By.xpath("//select[@id='reference.id']"));
        new Select(reference).selectByIndex(2);

        // Reference Note
        driver.findElement(By.xpath("//input[@id='referenceNumber']")).sendKeys("reference note");

        // Status
        WebElement status = driver.findElement(By.xpath("//select[@id='status']"));
        new Select(status).selectByIndex(2);

        // Target Date (Last available day)
        WebElement targetDate = driver.findElement(By.id("targetDate"));
        targetDate.click();
        List<WebElement> days = driver.findElements(By.xpath("//td[contains(@class, 'day') and not(contains(@class, 'disabled'))]"));
        days.get(days.size() - 1).click();

        driver.findElement(By.xpath("//input[@id='active']")).click();
    }

    @And("User fills out customer information")
    public void user_fills_out_customer_information() throws InterruptedException {
        driver.findElement(By.id("customerName-search")).sendKeys("a");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='tt-suggestion tt-selectable'][2]")).click();

        WebElement classification = driver.findElement(By.xpath("//select[@id='classification']"));
        new Select(classification).selectByIndex(2);
    }

    @And("User fills out product information with {int} line item(s)")
    public void user_fills_out_product_information(int numberOfProducts) {
        String productText = "A"; // Enter 'A' for both rows

        for (int i = 0; i < numberOfProducts; i++) {
            enterProductDetails(i, productText, i); // Select different suggestions for each row

            if (i < numberOfProducts - 1) { // Click "+" button only if another row needs to be added
                WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'glyphicon-plus-sign')]")));
                plusButton.click();

                // Wait for the new row to appear
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='productName" + (i + 1) + "-search']")));
            }
        }
    }


    private void enterProductDetails(int rowIndex, String productText, int suggestionIndex) {
        try {
            // Locate and interact with product input field
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='productName" + rowIndex + "-search']")));
            product.click();
            product.clear();
            product.sendKeys(productText);

            // Wait for dropdown suggestions to appear
            By dropdownLocator = By.xpath("(//div[@class='tt-dataset tt-dataset-itemName03'])[" + (rowIndex + 1) + "]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));

            // Get all suggestions excluding "+ New Item"
            List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("(//div[@class='tt-dataset tt-dataset-itemName03'])[" + (rowIndex + 1) + "]//div[contains(@class, 'tt-suggestion') and not(contains(text(), '+ New Item'))]")
            ));

            if (suggestions.isEmpty()) {
                System.out.println("No suggestions available for row: " + rowIndex);
                return;
            }

            // Select the desired suggestion if available
            if (suggestions.size() > suggestionIndex) {
                WebElement selectedItem = suggestions.get(suggestionIndex);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedItem);
                wait.until(ExpectedConditions.elementToBeClickable(selectedItem)).click();

                // Ensure the value is updated in the field
                wait.until(ExpectedConditions.attributeContains(product, "value", selectedItem.getText()));
            } else {
                System.out.println("Suggestion index out of bounds for row: " + rowIndex);
                return;
            }

            // Fill Description, Quantity, and Price (with extra wait)
            enterFieldValue("leadManagerItems[" + rowIndex + "].remark", "Desc " + (rowIndex + 1));
            enterFieldValue("leadManagerItems[" + rowIndex + "].quantity", "5");
            enterFieldValue("leadManagerItems[" + rowIndex + "].amount", "10");

            // Verify values are properly entered before proceeding
            verifyFieldValue("leadManagerItems[" + rowIndex + "].remark", "Desc " + (rowIndex + 1));
            verifyFieldValue("leadManagerItems[" + rowIndex + "].quantity", "5");
            verifyFieldValue("leadManagerItems[" + rowIndex + "].amount", "10");

        } catch (Exception e) {
            System.out.println("Error in enterProductDetails for row " + rowIndex + ": " + e.getMessage());
        }
    }

    /**
     * Helper method to enter values into fields reliably.
     */
    private void enterFieldValue(String fieldName, String value) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.name(fieldName)));
        field.clear();
        field.sendKeys(value);
    }

    /**
     * Helper method to verify that field value is properly set.
     */
    private void verifyFieldValue(String fieldName, String expectedValue) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(fieldName)));
        wait.until(ExpectedConditions.attributeToBe(field, "value", expectedValue));
    }


    @And("User fills out lead contact details")
    public void user_fills_out_lead_contact_details() {
        driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#showNewContact']")).click();
        driver.findElement(By.xpath("//input[@id='personNameNew0']")).sendKeys("contact1");
        driver.findElement(By.xpath("//input[@id='designationNew0']")).sendKeys("designation");
        driver.findElement(By.xpath("//input[@id='emailNew0']")).sendKeys("abc@abc.com");
        driver.findElement(By.xpath("//input[@id='phoneNew0']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@id='alterPhoneNew0']")).sendKeys("9786543210");
    }

    @And("User fills out lead activity details")
    public void user_fills_out_lead_activity_details() {
        driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#addActivity']")).click();
        driver.findElement(By.id("leadActivities[0].activityType")).click();
        driver.findElement(By.xpath("//select[@id='leadActivities[0].activityType']//option[@value!='']")).click();
        driver.findElement(By.xpath("//input[@id='leadActivities[0].subject']")).sendKeys("subject");

        driver.findElement(By.id("leadActivities[0].dueDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='25']")).click();

        driver.findElement(By.id("leadActivities[0].activityDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='24']")).click();

        driver.findElement(By.id("leadActivities[0].priority")).click();
        driver.findElement(By.xpath("//select[@id='leadActivities[0].priority']//option[@value!='']")).click();

        driver.findElement(By.id("leadActivities[0].status.id")).click();
        driver.findElement(By.xpath("//select[@id='leadActivities[0].status.id']//option[@value!=''][3]")).click();

        driver.findElement(By.id("leadActivities[0].reminder")).click();
        driver.findElement(By.xpath("//select[@id='leadActivities[0].reminder']//option[@value!='']")).click();

        driver.findElement(By.id("leadActivities[0].contactPerson.id")).click();
        List<WebElement> contactOptions = driver.findElements(By.xpath("//select[@id='leadActivities[0].contactPerson.id']//option[@value!='']"));
        if (!contactOptions.isEmpty()) contactOptions.get(0).click();

        driver.findElement(By.id("leadActivities[0].assignTo.id")).click();
        List<WebElement> assignOptions = driver.findElements(By.xpath("//select[@id='leadActivities[0].assignTo.id']//option[@value!='']"));
        if (!assignOptions.isEmpty()) assignOptions.get(0).click();

        driver.findElement(By.id("leadActivities[0].result")).sendKeys("Result");
        driver.findElement(By.id("leadActivities[0].description")).sendKeys("Notes");
    }

    @And("User uploads an attachment")
    public void user_uploads_an_attachment() {
        driver.findElement(By.xpath("//span[contains(@class, 'btn') and contains(@data-target, '#addFiles') and contains(text(), 'File Attachment')]")).click();
        driver.findElement(By.id("fileUpload")).sendKeys("/home/vyoog-desktop/Inventory.html");
    }
    @And("User checks and adds multiple attachments in create page")
    public void user_checks_and_adds_multiple_attachments_in_edit_page() {
        List<WebElement> fileAttachmentButtons = driver.findElements(By.xpath("//span[contains(@class, 'btn') and contains(@data-target, '#addFiles') and contains(text(), 'File Attachment')]")
        );

        if (!fileAttachmentButtons.isEmpty()) {
            WebElement fileAttachmentButton = fileAttachmentButtons.get(0);
            fileAttachmentButton.click();

            // File paths to be uploaded
            String[] files = {
                "/home/vyoog-desktop/Inventory.html",
                "/home/vyoog-desktop/ob.html",
                "/home/vyoog-desktop/lead.html"
            };

            for (String filePath : files) {
                // Click the "+" button inside the attachment section
                WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'appendToClone')]//span[contains(@class, 'glyphicon-plus-sign') and contains(@onclick, 'FileUpload')]")
                ));
                addButton.click();

                // Wait for the new file input field to appear
                List<WebElement> uploadFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'appendToClone')]//input[contains(@id, 'fileUpload') and @type='file']")
                ));

                // Find the last (newest) file input field and upload the file
                WebElement latestUploadField = uploadFields.get(uploadFields.size() - 1);
                latestUploadField.sendKeys(filePath);
                
                System.out.println("Uploaded: " + filePath);
            }

            System.out.println("All files uploaded successfully.");
        } else {
            System.out.println("No File Attachment button found, skipping file upload.");
        }
    }

    @And("User adds lead notes")
    public void user_adds_lead_notes() {
        driver.findElement(By.xpath("//span[contains(@class, 'btn') and @data-target='#salesHistory' and contains(text(), 'Lead Notes')]")).click();
        driver.findElement(By.xpath("//input[@id='salesNoteSubject']")).sendKeys("Subject");

        WebElement notesDate = driver.findElement(By.xpath("//input[@id='salesNoteEntryDate']"));
        notesDate.click();
        driver.findElement(By.xpath("//td[text()='" + LocalDate.now().getDayOfMonth() + "']")).click();

        driver.findElement(By.xpath("//select[@id='salesNoteType']//option[@value!=''][3]")).click();
        driver.findElement(By.xpath("//input[@id='followup-search']")).sendKeys("Employee");
        driver.findElement(By.xpath("//input[@id='salesNoteNote']")).sendKeys("Lead note");
    }

    @Then("User submits the lead")
    public void user_submits_the_lead() {
        driver.findElement(By.xpath("//input[@id='create']")).click();
        wait.until(ExpectedConditions.urlContains("VyoogErp3/leadManager/show/"));
        System.out.println("Show page loaded successfully: " + driver.getCurrentUrl());
    }
    }
    
    

