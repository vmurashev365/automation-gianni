@test123

Feature: WebDriver University - Contact Us Page, Test123

Scenario: Validate Successful Submitting - Specific  Data
Given I access the webdiver university contact us page
When I enter  a specific first name Sarah
And I enter  a specific last name Woods
And I enter a specific email address sarah_woods123@mail.com
And I enter a specific comment "How are you?"
And I click Submit button
Then I should be presented with contact us submission message