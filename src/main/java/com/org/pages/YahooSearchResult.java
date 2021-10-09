package com.org.pages;

import com.org.Interfaces.ISearchResult;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchResult implements ISearchResult {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(YahooSearchResult.class);

    public YahooSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }

    @Override
    public void userClicksonMatchingSearchResult(String keyword) {

    }
}
