package com.org.pages;

import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BingSearchResult {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(BingSearchResult.class);

    public BingSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }
}
