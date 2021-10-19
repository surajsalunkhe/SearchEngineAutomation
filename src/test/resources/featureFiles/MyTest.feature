Feature: Try one browser
  @myTest
  Scenario Outline:: try browser
    Given User opens the "<browser>" browser
    And Navigate to url "<searchEngine>"
    And User enter "<keyword>" to search in search Engine
    When User click on first search suggestion
    And User clicks on matching "<keyword>" search result
    Then verify user redirected to "<keyword>" provided website
    Then User quit the browser
    Examples:
      |browser|searchEngine|keyword|
      |chrome |google       |fiserv|
