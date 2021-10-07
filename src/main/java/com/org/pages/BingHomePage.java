package com.org.pages;

import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BingHomePage {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(BingHomePage.class);

    public BingHomePage(WebDriver driver) {
        this.driver=driver;
        elementutil=new ElementUtil(driver);
    }
}
