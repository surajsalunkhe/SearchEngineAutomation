package com.org.driverFactory;

import java.io.File;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	//WebDriver driver;
	static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public static String browser=System.getProperty("browser");
	public static String searchEngine=System.getProperty("searchEngine");
	public static String environment=System.getProperty("env");

	/**
	 * This method is used to initialize the threadlocal driver on the basis of
	 * given browser
	 * 
	 * param browser
	 * return this will return tlDriver
	 */
	public WebDriver init_Driver(Properties prop) {
		System.out.println("Browser="+browser+"\tSarchEngine="+searchEngine+"\tenvironment="+environment);
		String browserType=browser.toLowerCase();
		String searchEngineType=searchEngine.toLowerCase();
		switch (browserType){
			case "chrome":
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
						chromeOptions.addExtensions(new File(System.getProperty("user.dir")+"/src/main/resources/tools/ublocker.crx"));
						chromeOptions.addArguments("--disable-notifications");
						chromeOptions.addArguments("--disable-popup-blocking");
						DesiredCapabilities caps=new DesiredCapabilities();
						caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
						chromeOptions.merge(caps);
						WebDriverManager.chromedriver().setup();
						tldriver.set(new ChromeDriver(chromeOptions));
						break;

			case "firefox":
						WebDriverManager.firefoxdriver().setup();
						tldriver.set(new FirefoxDriver());
						break;
			case "safari":
						tldriver.set(new SafariDriver());
						break;
			default:
						WebDriverManager.chromedriver().setup();
						tldriver.set(new ChromeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty(searchEngineType));
		return getDriver();

	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

}
