@login

Feature: WebDriver University - login page

  Background:
    Given I access the webdiver university login page

  Scenario: Validate Successful Login
    When I enter username "webdriver"
    And I enter password webdriver123
    And I click on login button
    Then I should presented with successful login message

  Scenario: Validate Unsuccessful Login
    When I enter username "webdriver"
    And I enter password test123
    And I click on login button
    Then I should presented with unsuccessful login message