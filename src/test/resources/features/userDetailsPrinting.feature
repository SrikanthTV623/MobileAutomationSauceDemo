Feature: Validate Sauce Labs Application

  Scenario: User opens application, and print all details of login page
    Given user opens application
    Then verify user is on login page
    When user will scroll the login page
    And print the login details
