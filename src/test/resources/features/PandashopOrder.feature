@regression
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
    And I enter Panda password QWRvbmFpISEh
    And Click on Enter button
    Then I enter my name and last name Victor Murasev
    #And I enter my phone +37369278883
    And I select delivery by Courier to address: city mun. Chişinău, str. Zelinski, bl. 32/4, ap. 8
    And I select to pay by Bank Transfer to Company Urbanconstruct, Bank AGRNMD2X, IBAN MD70AG000000022511781341, address Mt.Gurie Grosu 17, fiscal 1010600033952
    And I buy with bonuses 44
    And I enter the following note Note to the order




