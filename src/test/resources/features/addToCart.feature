Feature: Validate Sauce Labs Application

  Scenario: User login and add item to cart
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    And user add first item to cart in product page
    Then verify item is added to cart

