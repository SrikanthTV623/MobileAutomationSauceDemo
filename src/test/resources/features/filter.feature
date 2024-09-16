Feature: Validate Sauce Labs Application

  Scenario: User login, filter items based on price and print those prices
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    When user applies filter on the products list "Price (high to low)"
    Then verify the prices are sorted