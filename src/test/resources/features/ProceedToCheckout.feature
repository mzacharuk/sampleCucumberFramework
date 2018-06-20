@dev
Feature: Add few products to cart

  Background:
    Given I am on home page
    And I go to product details page by product name link

  Scenario Outline: add product to shopping cart from product details page
    Given I increase product quantity by <increaseQuantity>
    And I click on add product to shopping cart button
    When I click on proceed to checkout button
    Then I am on shopping cart page
    And I see added product in shopping cart summary
    And I see correct number of product in shopping cart summary

    Examples:
    |increaseQuantity|
    |1               |
    |2               |