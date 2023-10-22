Feature: loginFail
Scenario: Failed login to saucedemo with incorrect username
Given  open Browser
And  Located saucedemo site
And Input username "xxxxxx" and password "secret_sauce"
When Hit login button
Then Error pop up should be appear