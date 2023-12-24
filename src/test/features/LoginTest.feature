Feature: Login feature
  As a user
  I should login and use the app

  @smoke @reg @login
  Scenario: Verify valid login
    Given I am on home page "https://www.saucedemo.com"
    When I enter Username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should login successfully and gets directed to products page with heading "Products"

  @reg @login
  Scenario: Verify invalid login
    Given I am on home page "https://www.saucedemo.com"
    When I enter Username "standard_user_inv" and password "secret_sauce_inv"
    And I click login button
    Then I shouldn't be allowed login and gets error message "Epic sadface: Username and password do not match any user in this service"

    @login
  Scenario Outline: Verify all valid login credentials
    Given I am on home page "https://www.saucedemo.com"
    When I enter Username "<username>" and password "<password>"
    And I click login button
    Then I should login successfully and gets directed to products page with heading "Products"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | visual_user             | secret_sauce |
      | performance_glitch_user | secret_sauce |