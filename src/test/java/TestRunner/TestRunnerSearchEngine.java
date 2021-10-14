package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
Author: Suraj Salunkhe
Date:26th Sep 2021
*/
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "./src/test/resources/featureFiles/MyTest.feature" },
		glue = {"stepDefination", "appHooks" },
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		dryRun = false,
		monochrome = true
)
public class TestRunnerSearchEngine {

}
