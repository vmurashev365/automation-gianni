@login
@regression

Feature: WebDriver University - login page

  Background:
    Given I access the webdiver university login page

    @login1
  Scenario: Validate Successful Login
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on the login button
    Then I should be presented with the successful login message

  Scenario: Validate Unsuccessful Login
    When I enter a username webdriver
    And I enter a password password123
    And I click on the login button
    Then I should be presented with the unsuccessful login message

    @smoke
  Scenario Outline: Validate Successful & Unsuccessful Login
    When I enter username <username>
    And I enter password <password>
    And I click on login button
    Then I should presented with the following login validation message <loginValidationMessage>
    Examples:
      | username  | password     | loginValidationMessage |  |
      | webdriver | webdriver123 | validation succeeded   |  |
      | webdriver | test123      | validation failed      |  |
      | joe_blogs | password1    | validation failed      |  |