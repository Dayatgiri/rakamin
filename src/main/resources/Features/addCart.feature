
Feature: Add item to cart menu
Scenario: Add item to cart
Given  I open Browser to login
And Located saucedemo website on login page
And I want Enter username "standard_user"
  And I want Enter password "secret_sauce"
  And I want tap login button with enter
  When I tap on add cart button
  Then I go to  cart menu

