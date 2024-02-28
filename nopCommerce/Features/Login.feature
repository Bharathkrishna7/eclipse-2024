Feature: Login

@Sanity
  Scenario: Login with Valid credenrails
    Given User launch chrom window
    When user open url "https://admin-demo.nopcommerce.com/login"
    And User enter email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When use click on logout link
    Then page title is "Your store. Login"
    And close browser
 @regression
  Scenario Outline: Login with data driven
    Given User launch chrom window
    When user open url "https://admin-demo.nopcommerce.com/login"
    And User enter email as "<email>" and Password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When use click on logout link
    Then page title is "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@gmail.com     | admin    |
