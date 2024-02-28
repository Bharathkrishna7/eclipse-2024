Feature: Customers

  Background: Below are common steps for every scenario
    Given User launch chrom window
    When user open url "https://admin-demo.nopcommerce.com/login"
    And User enter email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then user can view Dashboard page
@Sanity
  Scenario: Add a new customer
    When user click on customers menu
    And Click on customer menuitem
    And Click on Addnew button
    Then user can see Add new Customer page
    When user enter customer info
    And Click on save button
    Then user can see conformation message "The new customer has been added successfully."
    And close browser
@regression
  Scenario: Search Customer by email
    When user click on customers menu
    And Click on customer menuitem
    When User Enters Customers email
    And Click on Search button
    Then User should find email in the search table
    And close browser
