package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class leadedit {
    private WebDriver driver = LoginSteps.getDriver(); // Reusing existing driver
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And("User navigates to Leads list page")
    public void user_navigates_to_leads_page() {
        WebElement salesAndMarketingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#menu3']")));
        salesAndMarketingMenu.click();

        WebElement crm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'CRM')]")));
        crm.click();

        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);

        WebElement leadlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuid-7251']")));
        leadlist.click();
    }

    @And("User clicks on the first lead with Lead Stage as Lead")
    public void user_clicks_on_first_lead_with_stage_lead() throws InterruptedException {
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchTableAjax")));
        Thread.sleep(5000);

        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        for (WebElement row : rows) {
            WebElement leadStageColumn = row.findElement(By.xpath("./td[last()]"));
            String leadStageText = leadStageColumn.getText().trim();

            if (leadStageText.equalsIgnoreCase("Lead")) {
                WebElement leadCodeLink = row.findElement(By.xpath("./td[1]/a"));
                leadCodeLink.click();
                return;
            }
        }

        throw new NoSuchElementException("No lead found with Lead Stage as 'Lead'");
    }

    @And("User clicks the Edit button on the Lead details page")
    public void user_clicks_the_edit_button() throws InterruptedException {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'btn-edit')]")));
        editButton.click();
        Thread.sleep(2000);
    }

    @And("User updates the lead date to the previous day")
    public void user_updates_lead_date_to_previous_day() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        int previousDay = yesterday.getDayOfMonth();

        WebElement leadDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("leadDate")));
        leadDate.click();

        WebElement previousDayElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//td[text()='" + previousDay + "' and not(contains(@class, 'disabled'))]"))
        );
        previousDayElement.click();
    }

    @And("User updates the target date to the last day of the current month")
    public void user_updates_target_date_to_last_day() {
        LocalDate lastDayOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        int lastDay = lastDayOfMonth.getDayOfMonth();

        WebElement targetDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("targetDate")));
        targetDate.click();

        WebElement lastDayElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//td[text()='" + lastDay + "' and not(contains(@class, 'disabled'))]"))
        );
        lastDayElement.click();
    }

    @And("User updates the quantity to 10 and price to 15 for the second line item")
    public void user_updates_quantity_and_price_for_second_item() {
        List<WebElement> quantityFields = driver.findElements(By.name("leadManagerItems[1].quantity"));
        List<WebElement> priceFields = driver.findElements(By.name("leadManagerItems[1].amount"));

        if (quantityFields.isEmpty() || priceFields.isEmpty()) {
            // No second line item, move to the next step
            return;
        }

        WebElement quantityField = wait.until(ExpectedConditions.elementToBeClickable(quantityFields.get(0)));
        quantityField.clear();
        quantityField.sendKeys("10");

        WebElement priceField = wait.until(ExpectedConditions.elementToBeClickable(priceFields.get(0)));
        priceField.clear();
        priceField.sendKeys("15");
    }

    
    @And("User removes the line item")
    public void user_removes_first_line_item() {
        List<WebElement> minusButtons = driver.findElements(By.xpath("//span[contains(@class, 'glyphicon-minus-sign')]"));
        int itemCount = minusButtons.size(); // Count available line items

        if (itemCount <= 1) {
            System.out.println("Only one line item present, skipping removal.");
            return; // Move to the next step
        }

        for (int i = 0; i < Math.min(2, itemCount - 1); i++) { 
            driver.findElements(By.xpath("//span[contains(@class, 'glyphicon-minus-sign')]")).get(0).click();
        }
    }


    @And("User adds an extra line item in the edit page")
    public void user_adds_extra_line_item_in_edit_page() {
        String productText = "b"; // Example product name

        // Find the number of existing product rows
        List<WebElement> existingRows = driver.findElements(By.xpath("//input[contains(@id, 'productName') and contains(@id, '-search')]"));
        int rowIndex = existingRows.size(); // New row index will be after the last row

        // Click "+" button to add a new row
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'glyphicon-plus-sign')]")));
        plusButton.click();

        // Wait for the new row's product input field to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='productName" + rowIndex + "-search']")));

        // Fill product details in the new row
        enterProductDetails(rowIndex, productText, 0); // Always select the first suggestion
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
            enterFieldValue("leadManagerItems[" + rowIndex + "].quantity", "7"); // Different quantity for edit
            enterFieldValue("leadManagerItems[" + rowIndex + "].amount", "15"); // Different price for edit

            // Verify values are properly entered before proceeding
            verifyFieldValue("leadManagerItems[" + rowIndex + "].remark", "Desc " + (rowIndex + 1));
            verifyFieldValue("leadManagerItems[" + rowIndex + "].quantity", "7");
            verifyFieldValue("leadManagerItems[" + rowIndex + "].amount", "15");

        } catch (Exception e) {
            System.out.println("Error in enterProductDetails for row " + rowIndex + ": " + e.getMessage());
        }
    }
    /**
     * Helper method to verify that field value is properly set.
     */
    private void verifyFieldValue(String fieldName, String expectedValue) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(fieldName)));
        wait.until(ExpectedConditions.attributeToBe(field, "value", expectedValue));
    }
    /**
     * Helper method to enter values into fields reliably.
     */
    private void enterFieldValue(String fieldName, String value) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.name(fieldName)));
        field.clear();
        field.sendKeys(value);
    }
    @And("User fills out lead contact details in edit")
    public void user_fills_out_lead_contact_details() {
        // Expand the contact section if not already expanded
        WebElement contactSection = driver.findElement(By.xpath("//div[@id='showNewContact']"));
        if (!contactSection.isDisplayed()) {
            driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#showNewContact']")).click();
        }

        // Check if the first contact row exists
        List<WebElement> firstContactField = driver.findElements(By.xpath("//input[@id='personNameNew0']"));

        if (firstContactField.isEmpty()) {
            // Edge case: No contact row exists at all, handle accordingly
            System.out.println("No contact row found. Please check if the form is rendering correctly.");
        } else {
            WebElement firstContactName = firstContactField.get(0);
            if (!firstContactName.getAttribute("value").isEmpty()) {
                // If data is present, click on the '+' button to add a new row
                WebElement addContactButton = driver.findElement(By.xpath("//span[contains(@class, 'glyphicon-plus-sign') and contains(@class, 'addContactClone')]"));
                addContactButton.click();

                // Wait for the new row to appear
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='personNameNew1']")));

                // Enter data in the new row
                enterContactDetails(1, "contact1", "designation", "abc@abc.com", "9876543210", "9786543210");
            } else {
                // If no data is present, use the existing empty row
                enterContactDetails(0, "contact1", "designation", "abc@abc.com", "9876543210", "9786543210");
            }
        }
    }

    /**
     * Helper method to enter contact details in the specified row.
     */
    private void enterContactDetails(int rowIndex, String name, String designation, String email, String phone, String altPhone) {
        driver.findElement(By.xpath("//input[@id='personNameNew" + rowIndex + "']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='designationNew" + rowIndex + "']")).sendKeys(designation);
        driver.findElement(By.xpath("//input[@id='emailNew" + rowIndex + "']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='phoneNew" + rowIndex + "']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='alterPhoneNew" + rowIndex + "']")).sendKeys(altPhone);
    }

    @And("User checks and adds multiple attachments in edit page")
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
    @And("User removes attachments based on count")
    public void user_removes_attachments_based_on_count() {
    	 List<WebElement> fileAttachmentButtons = driver.findElements(By.xpath("//span[contains(@class, 'btn') and contains(@data-target, '#addFiles') and contains(text(), 'File Attachment')]")
    		        );

    		        if (!fileAttachmentButtons.isEmpty()) {
    		            WebElement fileAttachmentButton = fileAttachmentButtons.get(0);
    		            fileAttachmentButton.click();


        List<WebElement> removeButtons = driver.findElements(By.xpath("//div[contains(@class, 'appendToClone')]//span[contains(@class, 'glyphicon-minus-sign') and contains(@onclick, 'removeLeadFile')]"));

        int attachmentCount = removeButtons.size();

        if (attachmentCount == 1) {
            // Remove the only attachment
            removeButtons.get(0).click();
            System.out.println("Removed single attachment.");
        } else if (attachmentCount >= 2) {
            // Remove the first two attachments
            removeButtons.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(removeButtons.get(0))); // Wait for removal
            
            removeButtons = driver.findElements(By.xpath("//div[contains(@class, 'appendToClone')]//span[contains(@class, 'glyphicon-minus-sign') and contains(@onclick, 'removeLeadFile')]"));
            removeButtons.get(0).click();
            
            System.out.println("Removed first two attachments.");
        } else {
            System.out.println("No attachments found to remove.");
        }
    }
    }
    @And("User fills out lead activity details1")
    public void user_fills_out_lead_activity_details() {
        driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#addActivity']")).click();

        // Find existing rows
        List<WebElement> existingRows = driver.findElements(By.xpath("//select[contains(@name, 'leadActivities') and contains(@name, 'activityType')]"));
        int existingCount = existingRows.size(); // Get count of existing rows

        if (existingCount == 0) {
            // If no activities exist, fill the first row
            fillLeadActivityDetails(0);
        } else {
            // If activities exist, click the plus button once and add a new row
            WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'appendToClone')]//span[contains(@class, 'glyphicon-plus-sign') and contains(@onclick, 'Activity')]")
            ));
            addButton.click();

            // Wait for the new row to appear
            int newIndex = existingCount; // The new row will be at this index
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("leadActivities[" + newIndex + "].activityType")));

            // Fill the new row details
            fillLeadActivityDetails(newIndex);
        }
    }

    private void fillLeadActivityDetails(int index) {
        driver.findElement(By.name("leadActivities[" + index + "].activityType")).click();
        driver.findElement(By.xpath("//select[@name='leadActivities[" + index + "].activityType']//option[@value!='']")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].subject")).sendKeys("Subject " + index);
        
        driver.findElement(By.name("leadActivities[" + index + "].dueDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='25']")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].activityDate")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='24']")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].priority")).click();
        driver.findElement(By.xpath("//select[@name='leadActivities[" + index + "].priority']//option[@value!='']")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].status.id")).click();
        driver.findElement(By.xpath("//select[@name='leadActivities[" + index + "].status.id']//option[@value!=''][3]")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].reminder")).click();
        driver.findElement(By.xpath("//select[@name='leadActivities[" + index + "].reminder']//option[@value!='']")).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].contactPerson.id")).click();
        List<WebElement> contactOptions = driver.findElements(By.xpath("//select[@name='leadActivities[" + index + "].contactPerson.id']//option[@value!='']"));
        if (!contactOptions.isEmpty()) contactOptions.get(0).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].assignTo.id")).click();
        List<WebElement> assignOptions = driver.findElements(By.xpath("//select[@name='leadActivities[" + index + "].assignTo.id']//option[@value!='']"));
        if (!assignOptions.isEmpty()) assignOptions.get(0).click();
        
        driver.findElement(By.name("leadActivities[" + index + "].result")).sendKeys("Result " + index);
        driver.findElement(By.name("leadActivities[" + index + "].description")).sendKeys("Notes " + index);
    }
    @And("User removes lead activity details")
    public void user_removes_lead_activity_details() {
        WebElement addActivityButton = driver.findElement(By.xpath("//span[@class='btn btn-info btn-sm btn-md btns' and @data-toggle='collapse' and @data-target='#addActivity']"));
        addActivityButton.click();

        // Wait for the minus button to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'glyphicon-minus-sign') and contains(@onclick, 'removeLeadActivity')]")));

        List<WebElement> minusButtons = driver.findElements(By.xpath("//span[contains(@class, 'glyphicon-minus-sign') and contains(@onclick, 'removeLeadActivity')]"));

        if (!minusButtons.isEmpty()) {
            WebElement minusButton = wait.until(ExpectedConditions.elementToBeClickable(minusButtons.get(0)));
            
            // Click using JavaScript if needed
            try {
                minusButton.click();
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", minusButton);
            }
        }
    }


    @Then("User updates the lead")
    public void user_submits_the_lead() {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("_action_update")));
        updateButton.click();
        wait.until(ExpectedConditions.urlContains("VyoogErp3/leadManager/show/"));
        System.out.println("Show page loaded successfully: " + driver.getCurrentUrl());
    }

}