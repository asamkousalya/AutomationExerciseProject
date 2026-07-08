@category
Feature: Category Filter

  Scenario Outline: Verify category filter

    Given User is on Automation Exercise Home Page
    When User clicks on Products button
    And User clicks "<Category>" category
    Then "<Category>" products should be displayed

    Examples:
      | Category |
      | Women    |
      | Men      |
      | Kids     |