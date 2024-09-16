Feature: Validate Sauce Labs Application

  Scenario: User login, select the web view, opens website and print those content
    Given user opens application
    Then verify user is on login page
    When user enter valid login credentials
    Then verify user is on products page
    When user clicks on hamburger menu  and select the web view
    And user enters the website "web.site"
    Then print the contexts of application
    When user enter search keyword "search.key"
    Then verify search result is displayed
    When user clicks on hamburger menu
    And click on logout link
    Then verify user is on login page



