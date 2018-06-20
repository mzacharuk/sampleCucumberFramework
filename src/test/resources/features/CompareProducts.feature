@dev_out
Feature: compare products

  Background:
    Given I am on home page
    And I go to dresses category page

  Scenario: compare two products
    Given I add "sth" to compare
    And I add "sth" to compare
    When I click on compare button
    Then I am on compare products page
    And I see correct details of both products