@login
Feature: Login User
 
Scenario: Login with correct credentials
 
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
 
When User clicks SignUp Login button
 
Then Verify Login section visible
 
When User enters email and password
And User clicks Login button
 
Then Verify logged in username