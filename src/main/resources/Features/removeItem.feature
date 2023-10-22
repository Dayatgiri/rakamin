Feature: remove item
Scenario: Remove item in cart
Given  Iwant open Browser to login
And I Located saucedemo website on login page
And I  Enter username "standard_user"
And I  Enter password "secret_sauce"
And I  tap login button with enter
And tap on add cart button
And I want go to  cart menu
When I delete item in cart
Then I back to product menu