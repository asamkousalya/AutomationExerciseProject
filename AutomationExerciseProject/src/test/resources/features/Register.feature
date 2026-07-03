@register
Feature: Register User
Scenario: Register new user successfully
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify New User SignUp is visible
When User enters name and email
And User clicks SignUp button
Then Verify account information page
When User enters account details
And User enters address details
And User clicks Create Account
Then Verify account created