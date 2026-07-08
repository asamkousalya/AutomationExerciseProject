@cart
Feature: Cart Functionality
 
Scenario: Add Products to Cart
Given User opens products page
When User adds first and second product
And User opens cart
Then Products should display in cart
 
Scenario: Verify Product Quantity
Given User opens products page
When User opens product details
And User increases quantity to "4"
And User adds product into cart
Then Product quantity should display correctly
 
Scenario: Remove Product From Cart
Given User added products
When User removes product
Then Product should be removed
 
Scenario: View Brand Products
Given User opens products page
When User selects brand
Then Brand products should display
 
Scenario: Search Products and Verify Cart
Given User searches product
When User adds searched products to cart
And User login and open cart
Then Products should remain in cart
 