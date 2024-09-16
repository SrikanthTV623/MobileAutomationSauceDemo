Feature: Validate Sauce Labs Application

  Scenario: User login and print all items names
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    And print all product items names
