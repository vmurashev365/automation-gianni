@contact-us
@regression

Feature: WebDriver University - Contact Us Page

  Background:
    Given I access the webdiver university contact us page

  Scenario: Validate Successful Submitting - Unique Data

    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click Submit button
    Then I should be presented with contact us submission message


  Scenario: Validate Successful Submitting - Specific  Data
    When I enter  a specific first name Sarah
    And I enter  a specific last name Woods
    And I enter a specific email address sarah_woods123@mail.com
    And I enter a specific comment "How are you?"
    And I click Submit button
    Then I should be presented with contact us submission message