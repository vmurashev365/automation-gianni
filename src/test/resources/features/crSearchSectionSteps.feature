@regression

Feature: Test cases for Crunchroll

  Scenario: TC3.1 - Search in the top results section
    Given I am on the CR Beta as any user
    When I click on the search icon
    And I fill in the search field with "the"
    And I click on any card from the top results section
    Then I should be redirected to the desired content page