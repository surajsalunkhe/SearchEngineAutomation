@userflow
Feature: Search Engine Website Navigation

  @regression
  Scenario Outline:: User search result in search engine and click on first result
    Given User navigate to search engine
    And User enter "<keyword>" to search in search Engine
    When User click on first search suggestion
    And User clicks on matching "<keyword>" search result
    Then verify user redirected to "<keyword>" provided website
  Examples:
  |browser|search|keyword|
  |chrome |google|fiserv|
