package com.org.pages;

import com.org.driverFactory.DriverFactory;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    ElementUtil elementutil;
    DriverFactory driverfactory;
    Logger log = LoggerHelper.getLogger(BasePage.class);
    public BasePage(String browserName) {
        driverfactory=new DriverFactory();
        this.driver=driverfactory.init_Driver(browserName);
        elementutil=new ElementUtil(this.driver);
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }
}
