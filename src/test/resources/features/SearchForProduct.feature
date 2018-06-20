@dev_out
Feature: Search engine test

  Scenario Outline: Search for different phrases
    Given I search for phrase <phrase>
    When I press search button
    Then I should see the messege <message>

    Examples:
      | phrase                      | message                                     |
      | xyz                         | No results were found for your search "asd" |
      | Faded Short Sleeve T-shirts | Faded Short Sleeve T-shirts                 |