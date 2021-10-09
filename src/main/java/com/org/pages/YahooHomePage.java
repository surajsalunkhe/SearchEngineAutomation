package com.org.pages;

import com.org.Interfaces.IHomePage;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YahooHomePage implements IHomePage {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(YahooHomePage.class);

    public YahooHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }

    @Override
    public void lauchAppUrl(String url) {

    }

    @Override
    public void enterKeywordAndSearch(String keyword) {

    }

    @Override
    public void userClickOnSearchButton() {

    }

    @Override
    public void userClickOnFirstResult() {

    }

    @Override
    public void quitBrowser() {

    }
}
