Feature: customers

  Background: below are the common steps
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers menu
    And Click on customers menu Item
@sanity
  Scenario:
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save Button
    Then User can view confirmation message "the new customer has been added successfully."
    And close browser
@regression
  Scenario: Search Customer by EmailID
    And Enter customer Email
    When Click on search button
    Then User should found Email in the search Table
    And close browser



