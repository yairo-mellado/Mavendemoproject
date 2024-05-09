@test
Feature: Test Feature
  Test Feature

  Scenario: First Scenario
    When I go to Sauce page
    And login with user "standard_user" and pass "secret_sauce"
    And add "Sauce Labs Bolt T-Shirt" item to the cart
    Then verify that "Sauce Labs Bolt T-Shirt" was added
