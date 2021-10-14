Feature: Try one browser
  @myTest
  Scenario Outline:: try browser
    Given User opens the "<browser>" browser
    And Navigate to url "<searchEngine>"
    And User enter "<keyword>" to search in search Engine
    Examples:
      |browser|searchEngine|keyword|
      |chrome |google       |fiserv|
