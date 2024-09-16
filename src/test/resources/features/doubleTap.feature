Feature: Validate Sauce Labs Application

  Scenario: User login and add item to cart and perform double tap
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    And user click on add to cart button using double tap
    Then verify add to cart button is not changed