@pandashop

Feature: PandaShop ordering product

  Scenario: Validate searching and preparing order in Panda Shop
    Given I access the Pandashop home page
    When I click on search field, type sven ps-295 and click on search button
    And Product named Sven PS-295 Blue should be returned as result of the searching
    And Click on the link related to the found Sven PS-295 Blue to buy it
    And Click on Buy button
    And Click on Add-To-Cart button
    And Click on Processed To Checkout Button
    And I enter Panda username vmurashev@gmail.com
    And I enter Panda password Adonai!!!
    And Click on Enter button



