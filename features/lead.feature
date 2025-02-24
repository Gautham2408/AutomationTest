@lead
Feature: Lead Management

  Scenario: User creates a new lead successfully with one line item
		Given User is on the login page
		When User enters valid credentials
    And User navigates to Leads page
    And User fills out lead information
    And User fills out customer information
    And User fills out product information with 1 line item
    And User fills out lead contact details
    And User fills out lead activity details
    And User adds lead notes
    And User uploads an attachment
    Then User submits the lead
#
  #Scenario: User creates a new lead successfully with two line items
    #Given User is on the login page
    #When User enters valid credentials
    #And User navigates to Leads page
    #And User fills out lead information
    #And User fills out customer information
    #And User fills out product information with 2 line items
    #And User fills out lead contact details
    #And User fills out lead activity details
    #And User adds lead notes
    #And User uploads an attachment
    #And User checks and adds multiple attachments in create page
    #Then User submits the lead
#
  #Scenario: User creates a new lead successfully without attachment
    #Given User is on the login page
    #When User enters valid credentials
    #And User navigates to Leads page
    #And User fills out lead information
    #And User fills out customer information
    #And User fills out product information with 2 line items
    #And User fills out lead contact details
    #And User fills out lead activity details
    #And User adds lead notes
    #Then User submits the lead
