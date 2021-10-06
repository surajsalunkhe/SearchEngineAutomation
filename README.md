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
  - ConfigReader           - Library that read properties from property file.
  - Data Manager           - Library that read and store the values Data file 
  
  
    feature Files              : Cucumber Feature file holds all required Cucumber feature file.
                                 /src/test/resources/featureFiles
                 
    Step Defination           : Holds respective step definations class.
                                /src/test/java/stepDefination
                                
    Page Library              : Page Classes for POM
                                /src/main/java/com/org/pages
                                
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
                               src/main/java/com/org/util/DataManager.java
                               src/main/java/com/org/util/ConfigPropertyReader.java
                               src/main/java/com/org/util/CommonUtility.java
                               
                                
                                
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
     with Tag on Chrome Browser:
             ```mvn clean integration-test -Dbrowser=chrome -Denv=stage -DsearchEngine=google -Dcucumber.options=--tags @regression```
     Single Feature File Run on Firefox Browser:
            ```mvn clean integration-test -Dbrowser=firefox -Denv=stage -DsearchEngine=google -Dcucumber.options=src/test/resources/featureFiles/SearchEngineNavigateToWebsite.feature```             
