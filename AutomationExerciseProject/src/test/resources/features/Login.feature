@login
Feature: Login User

Scenario Outline: Verify Login

Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters "<email>" and "<password>"
And User clicks Login button
Then Verify "<result>"

Examples:
| email                        | password    | result           |
| vaibhavmakne0601@gmail.com   | Vaibhav@100 | success          |
| wrong@gmail.com              | Wrong123    | error            |
| wrongemail                   | Vaibhav@100 | emailValidation  |
|                              | Vaibhav@100 | required         |


Scenario: Verify Logout

Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters "vaibhavmakne0601@gmail.com" and "Vaibhav@100"
And User clicks Login button
Then Verify "success"
When User clicks Logout button
Then Verify Login page displayed