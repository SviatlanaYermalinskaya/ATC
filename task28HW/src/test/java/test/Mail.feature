@mail
Feature: Test mail.ru mail

  Scenario: Test login page
    Given I am on main application page
    When I login as user with correct password
    Then I see expected element 
 