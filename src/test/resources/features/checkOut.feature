Feature: Validate Sauce Labs Application

  Scenario: User login, add item to cart and check out
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    When user add first item to cart in product page
    And user clicks on cart and checkout
    Then verify user is on checkout page
    When enters information "first.name" "last.name" "zip.code" in check out page
    Then verify order is placed


