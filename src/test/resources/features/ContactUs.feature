@contact-us

Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submitting - Unique Data
    Given I access the webdiver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click Submit button
    Then I should be presented with contact us submission message


