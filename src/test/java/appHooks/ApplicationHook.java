package appHooks;

import java.io.IOException;

import com.org.util.PropertiesFileManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.org.driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/*
Author: Suraj Salunkhe
Date:26th July 2021
*/
public class ApplicationHook {
	DriverFactory driverfactory;
	WebDriver driver;
	PropertiesFileManager readPropertiesFile;
	
	@Before(order=0)
	public void setUpConfig()
	{

		readPropertiesFile=new PropertiesFileManager();
	}
	/*@Before(order=1)
	public void setUpWebDriver()
	{
		 driverfactory=new DriverFactory();
		 driver=driverfactory.init_Driver();
	}*/
	
	@After(order=1)
	public void captureScreenshot(Scenario sc) throws IOException
	{
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replace(" ", "_");
			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		     sc.attach(screenshot, "image/png", screenshotName); 
		}
		
	}
	
	/*@After(order = 0)
	public void tearDown() {
		driver.quit();
		
	}*/



}
