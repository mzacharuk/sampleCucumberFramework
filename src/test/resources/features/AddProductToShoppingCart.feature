@dev
Feature: add product to shopping cart

  As a customer
  I want to add chosen product to shopping cart
  In order to remember product i've chosen

  Background:
    Given I am on home page

  Scenario: add product to shopping cart from product details page
    Given I go to product details page by product name link
    When I click on add product to shopping cart button
    Then I see popup with following success message
      | Product successfully added to your shopping cart |