@brand
Feature: Brand Filter

  Scenario Outline: Verify user can filter products by brand

    Given User is on Automation Exercise Home Page
    When User clicks on Products button
    And User clicks on "<Brand>" brand
    Then Brand page should be displayed

Examples:
  | Brand              |
  | Polo               |
  | H&M                |
  | Madame             |
  | Mast & Harbour     |
  | Babyhug            |
  | Allen Solly Junior |
  | Kookie Kids        |
  | Biba               |
