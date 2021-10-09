package com.org.pages;

import com.org.Interfaces.ISearchResult;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BingSearchResult implements ISearchResult {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(BingSearchResult.class);
    private By bing_selectFromSearchResult =By.xpath("//*[@id='b_results']//*[@class='b_algo']//a[@href]");

    public BingSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }

    @Override
    public void userClicksonMatchingSearchResult(String keyword) {
        log.info("Clicking On Matching search Result button");
        elementutil.scrollWebapage();
        elementutil.clickOnSearchResult(bing_selectFromSearchResult);
    }
}
