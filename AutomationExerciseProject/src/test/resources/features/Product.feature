@product
Feature: Product Module

  Background:
    Given User is on Automation Exercise Home Page

  @ProductDetails
  Scenario: Verify All Products and Product Detail Page

    When User clicks on Products button
    Then User should navigate to All Products page
    When User clicks on first View Product
    Then Product details should be displayed
    
  @SearchProduct
  Scenario: Search Product

    When User clicks on Products button
    Then User should navigate to All Products page
    When User searches for product "Blue Top"
    Then Matching products should be displayed