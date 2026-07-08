@contact
Feature: Contact Us Functionality

Scenario: Verify Contact Us Form

Given User launches browser
When User opens Automation Exercise website
Then Home page should be visible

When User clicks Contact Us button
Then GET IN TOUCH should be visible

When User enters contact details


And User uploads file
And User clicks submit button
And User accepts alert

Then Success message should be displayed

When User clicks Home button
Then User should navigate to home page
