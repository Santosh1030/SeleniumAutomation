Feature: search

  As a user i should retrieve the relevant products using search
@smoke
  @Search
  Scenario Outline: verify products returned are relevant
    Given Im on home page <url> with title as <expectedPageTitle>
    When I search for "t shirts"
    And I click search
    Then I should get relevant products as result
    Examples:
      | url                        | expectedPageTitle                                                         | expectedPageHeading |
      | "https://www.amazon.co.uk" | "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more" | "RESULTS"           |

    Scenario: verify products with irrelevant searchTerm
      Given Im on home page "https://www.amazon.co.uk" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"
      When I search for "jsgfgbeycubakuybcli"
      And I click search
      Then I should be landed on productListPage with heading text as "No results for jsgfgbeycubakuybcli."