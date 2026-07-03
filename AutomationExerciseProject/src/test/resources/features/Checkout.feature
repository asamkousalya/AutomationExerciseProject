@checkout
Feature: Checkout

Scenario: Place Order - Login Before Checkout
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User clicks SignUp Login button
Then Verify Login section visible
When User enters email and password
And User clicks Login button
Then Verify logged in username
When User adds product to cart
And User opens cart
And User clicks Proceed To Checkout
Then Verify Address Details page
When User enters order comment
And User clicks Place Order
And User enters payment details
And User clicks Pay and Confirm Order
Then Verify Order placed successfully

Scenario: Place Order - Register Before Checkout
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
When User adds product to cart
And User opens cart
And User clicks Proceed To Checkout
Then Verify Address Details page
When User enters order comment
And User clicks Place Order
And User enters payment details
And User clicks Pay and Confirm Order
Then Verify Order placed successfully

Scenario: Place Order - Register While Checkout
Given User launches browser
When User opens automation exercise website
Then Verify home page is visible
When User adds product to cart
And User opens cart
And User clicks Proceed To Checkout
And User clicks Register Login link
Then Verify New User SignUp is visible
When User enters name and email
And User clicks SignUp button
Then Verify account information page
When User enters account details
And User enters address details
And User clicks Create Account
Then Verify account created
When User opens cart
And User clicks Proceed To Checkout
Then Verify Address Details page
When User enters order comment
And User clicks Place Order
And User enters payment details
And User clicks Pay and Confirm Order
Then Verify Order placed successfully