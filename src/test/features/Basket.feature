Feature: Basket feature
  As a user
  I should be able to add/edit/remove items in bag

  Background: Login
    Given I am on home page "https://www.saucedemo.com"
    When I enter Username "standard_user" and password "secret_sauce"
    And I click login button
    And I should login successfully and gets directed to products page with heading "Products"

    @bag
  Scenario: Verify add product in bag
    When I choose a product "Sauce Labs Backpack"
    And I click add to cart button with count "1"
    And I click basket icon
    Then the product "Sauce Labs Backpack" in the bag

  Scenario: Verify remove an item from bag
    When I choose a product "Sauce Labs Backpack"
    And I click add to cart button with count "1"
    And I click basket icon
    And I click remove button
    Then the product "Sauce Labs Backpack" shouldn't be in the bag