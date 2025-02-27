@leadedit
Feature: Lead Edit Management

  Scenario: User clicks on the first lead with Lead Stage as Lead and Edit
    Given User is on the login page
    When User enters valid credentials
    And User navigates to Leads list page
    And User clicks on the first lead with Lead Stage as Lead
    And User clicks the Edit button on the Lead details page
		Then User updates the lead


		Scenario: User Remove attachment in edit
    Given User is on the login page
    When User enters valid credentials
    And User navigates to Leads list page
    And User clicks on the first lead with Lead Stage as Lead
    And User clicks the Edit button on the Lead details page
    And User updates the lead date to the previous day
    And User updates the target date to the last day of the current month
    And User updates the quantity to 10 and price to 15 for the second line item
    And User adds an extra line item in the edit page
		And User fills out lead contact details in edit
		And User removes attachments based on count
		And User removes lead activity details	
		Then User updates the lead

		
			Scenario: User Remove lead activity details in edit
    Given User is on the login page
    When User enters valid credentials
    And User navigates to Leads list page
    And User clicks on the first lead with Lead Stage as Lead
    And User clicks the Edit button on the Lead details page
    And User updates the lead date to the previous day
    And User updates the target date to the last day of the current month
    And User updates the quantity to 10 and price to 15 for the second line item
		And User fills out lead contact details in edit
		And User removes attachments based on count
		And User removes lead activity details	
		Then User updates the lead

			Scenario: User Adds attachment in edit
    Given User is on the login page
    When User enters valid credentials
    And User navigates to Leads list page
    And User clicks on the first lead with Lead Stage as Lead
    And User clicks the Edit button on the Lead details page
    And User updates the lead date to the previous day
    And User updates the target date to the last day of the current month
    And User updates the quantity to 10 and price to 15 for the second line item
		And User fills out lead contact details in edit
		And User checks and adds multiple attachments in edit page
		Then User updates the lead
