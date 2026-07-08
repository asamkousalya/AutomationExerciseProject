@subscription

Feature: Subscription Functionality

Scenario: Verify Subscription in Home Page

Given User launches browser
When User opens Automation Exercise website
Then Home page should be visible

When User scrolls to footer
Then Subscription text should be displayed

When User enters email for subscription
And User clicks subscription button

Then Subscription success message should appear


Scenario: Verify Subscription in Cart Page

Given User launches browser
When User opens Automation Exercise website
Then Home page should be visible

When User clicks Cart button
And User scrolls to footer

Then Subscription text should be displayed

When User enters email for subscription
And User clicks subscription button

Then Subscription success message should appear