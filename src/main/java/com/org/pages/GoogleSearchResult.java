package com.org.pages;

import com.org.Interfaces.ISearchResult;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult implements ISearchResult {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(GoogleSearchResult.class);

    private By google_selectFromSearchResult =By.xpath("//div[@id='search']//a[@href]");

    public GoogleSearchResult(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }
    @Override
    public void userClicksonMatchingSearchResult(String keyword) {
        log.info("Clicking On Matching search Result button");
        elementutil.clickOnSearchResult(google_selectFromSearchResult);
    }
}

