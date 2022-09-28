@login

Feature: WebDriver University - login page

  Scenario: Validate Successful Login
    Given I access the webdiver university login page
    When I enter username "webdriver"
    And I enter password webdriver123
    And I click on login button
    Then I should presented with successful login message

  Scenario: Validate Unsuccessful Login
    Given I access the webdiver university login page
    When I enter username "webdriver"
    And I enter password test123
    And I click on login button
    Then I should presented with unsuccessful login message