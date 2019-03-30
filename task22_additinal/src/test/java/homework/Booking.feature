@feature1
Feature: Test booking page

  @Sc1
  Scenario: Test hotels search
    Given I am on main application page
    When I search hotels by city name for current date
    Then I check that search result is not empty
  @Sc2 
  Scenario: Test hotels search by priority
    Given I am on main application page
    When I search hotels by city name for current date
    And I choose priority and open first hotel
    Then I check that priority more than 9
