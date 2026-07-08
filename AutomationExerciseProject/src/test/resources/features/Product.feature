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

  @SearchBox
  Scenario: Verify Search Box is Displayed
    When User clicks on Products button
    Then Search box should be displayed

  @SearchButton
  Scenario: Verify Search Button is Displayed
    When User clicks on Products button
    Then Search button should be displayed

  @ViewProduct
  Scenario: Verify First View Product Button
    When User clicks on Products button
    Then First View Product button should be displayed

  @ProductList
  Scenario: Verify Product List is Displayed
    When User clicks on Products button
    Then Product list should be displayed