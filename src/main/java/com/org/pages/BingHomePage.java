package com.org.pages;

import com.org.Interfaces.IHomePage;
import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BingHomePage implements IHomePage {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(BingHomePage.class);

    private By bing_SearchBox=By.xpath("//input[@id='sb_form_q']");
    private By bing_searchButton =By.xpath("//label[@id='search_icon']");
    private By bing_searchResultList =By.xpath("//div[@class='sa_tm']");

    public BingHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }

    @Override
    public void lauchAppUrl(String url) {
        log.info("Opening Bing Search Engine");
        elementutil.launchUrl(url);
    }

    @Override
    public void enterKeywordAndSearch(String keyword) {
        log.info("Enter keyword and clicking on matching result");
        elementutil.doSendKeys(bing_SearchBox,keyword);
    }

    @Override
    public void userClickOnSearchButton() {
        log.info("Clicking On Search button");
        elementutil.doClick(bing_searchButton);
    }

    @Override
    public void userClickOnFirstResult() {
        elementutil.clickOnFirstElementFromList(bing_searchResultList);
    }

    @Override
    public void quitBrowser() {
        log.info("Quit the browser");
        elementutil.quitBrowser();
    }
}
