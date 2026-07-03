@login
Feature: Login User

Scenario: Login with correct credentials
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters valid email and password
And User clicks Login button
Then Verify logged in username

Scenario: Login with invalid credentials
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters invalid email and password
And User clicks Login button
Then Verify login error message

Scenario: Verify login with invalid email format
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters invalid email format and password
And User clicks Login button
Then Verify email validation message

Scenario: Verify login with empty fields
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User leaves email and password empty
And User clicks Login button
Then Verify required field validation