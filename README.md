# SearchEngine Test Automation
BDD Cucumber Framework with Selenium,Java and Junit

Project Description:
  - Project have implemented to Automate the scenarios of SearchEngine Google.com
  - Here I have automated the flow of open search engine, Enter Keyword click on first auto suggested result and navigate to result End-to-End flow.
  - This project illustrate design of Hybrid Framework with Page Object Model (POM) with Cucumber BDD & Selenium.
  
Project Component:
  - Driver Factory Library - Initalize required ThreadLocal WebDriver depends on browser.
  - Component Library      - Provide all required element wrapper methods.
  - Element Utility        - Provide all required element action wrapper utility.
  - PropertiesFileManager  - Library that read properties from property file and store value in file
   -Excel Reader(Read Excel,Write Excel) Read and Write excel value
  
  
    feature Files              : Cucumber Feature file holds all required Cucumber feature file.
                                 /src/test/resources/featureFiles
                 
    Step Defination           : Holds respective step definations class.
                                /src/test/java/stepDefination
                                
    Page Library              : Page Classes for POM
                                /src/main/java/com/org/pages
                                Added pages for Chrome,Bing,Yahoo
                                
    Constant Library           : All input data  to be tried out by various test methods woulbe be going into this directory
                                 /src/main/java/com/org/util/Constants.java
                                
    Application Hooks         : Cucumber Hooks with before and after
                                /src/test/java/appHooks/ApplicationHook.java
                                
    Config                    : Holds input data that needs to be pass to Test Method.
                                /src/test/resources/config/config.properties
                                
    Test Runner               : Test Runners in JUnit
                                /src/test/java/TestRunner/TestRunner.java
                                
    Reporting Property        : All required input to generate HTML Extent Spark and PDF Report with Test Method results.
                                /src/test/resources/extent.properties
                                /src/test/resources/extent-config.xml
                                /src/test/resources/cucumber.properties
    
    Utility                 :  All required utility for Constant Reading,Read Data From Excel, Read Properties File, Element Util for Selenium Functions
                               /src/main/java/com/org/util/ExcelReader.java
                               /src/main/java/com/org/util/ElementUtil.java
                               /src/main/java/com/org/util/DataManager.java
                               /src/main/java/com/org/util/ConfigPropertyReader.java
                               /src/main/java/com/org/util/CommonUtility.java
                               /src/main/java/com/org/util/Constants.java
                               src/main/java/com/org/util/PropertiesFileManager.java
                               
                                
                                
 Technologies Used:

     1. Selenium WebDriver with Java Language binding
     2. Cucumber 6.x JVM library
     3. WebDriverManager
     4. JDK 1.8
     5. Maven (Build tool)
     6. Maven Plugins
     7. Cucumber extent report 6 adapter
     8. JUnit 4.x library
     9. IntelliJIDEA (IDE)
     10.APACHE POI 
     
     
Execution:

  - To Execute All the Feature file navigate to /src/test/java/TestRunner/TestRunner.java class and execute with help of JUnit 4.
  - To execute specific Feature file, mention the required feature file in TestRunner.java class and run with JUnit 4.
  - To Execute on Maven   ```mvn clean test```
    To Run on specified enviornemnt with Assertion from env folder File.
        ```clean integration-test -Denv=stage -Dcucumber.options=src/test/resources/featureFiles/SearchEngineNavigateToWebsite.feature "-Dcucumber.options=--tags @multiBrowser" -f pom.xml```
    User can specify broswer to run TC else default chrome will be chosen for TC automation.
  -Run script by right click on feature file.
  
  Sample Feature File:
  
       Feature: Search Engine Website Navigation
         @multiBrowser
         Scenario Outline:: User search result in search engine and click on first result
           Given User opens the "<browser>" browser
           And Navigate to url "<searchEngine>"
           And User enter "<keyword>" to search in search Engine
           When User click on first search suggestion
           And User clicks on matching "<keyword>" search result
           Then verify user redirected to "<keyword>" provided website
           And User quite the browser
       
           Examples:
             |browser|searchEngine|keyword|
             |chrome |google       |fiserv|
             |chrome |bing         |fiserv|
             |safari |google       |fiserv|
             |safari |bing         |fiserv|
             |firefox|google       |fiserv|
