Feature: Search Engine Website Navigation
  @multiBrowser
  Scenario Outline:: User search result in search engine and click on first result
    Given User opens the "<browser>" browser
    And Navigate to url "<searchEngine>"
    And User enter "<keyword>" to search in search Engine
    When User click on first search suggestion
    And User clicks on matching "<keyword>" search result
    Then verify user redirected to "<keyword>" provided website

    Examples:
      |browser|searchEngine|keyword|
      |chrome |google       |fiserv|
      |chrome |bing         |fiserv|
      |safari |google       |fiserv|
      |safari |bing         |fiserv|
      |firefox|google       |fiserv|
