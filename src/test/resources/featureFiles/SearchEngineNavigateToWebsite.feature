@userflow
Feature: Search Engine Website Navigation


  Scenario:: User search result in search engine and click on first result
    Given User opens the "chrome"
    And Navigate to url "https://google.com"
    And User enter "fiserv" to search in search Engine
    Then User quite the browser