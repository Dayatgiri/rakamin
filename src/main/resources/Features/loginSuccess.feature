Feature: loginTest

  Scenario: login Successfully on saucedemo
    Given  I Went open Browser
    And I Located saucedemo website
    And I Enter right username "standard_user" and password "secret_sauce"
    When I tap login button
    Then redirect to main menu


