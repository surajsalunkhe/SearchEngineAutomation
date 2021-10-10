package com.org.pages;

import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultWebsite {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(SearchResultWebsite.class);
    private By acceptCookies=By.xpath("//button[@id='_evidon-decline-button']");
    private By websiteLogo=By.xpath("//img[@alt='Fiserv Logo']");

    public SearchResultWebsite(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementutil=new ElementUtil(driver);
    }

    public void acceptWebsiteCookies(){
        log.info("Accepting web page cookies On Seach button");
        elementutil.doClickIfPresent(acceptCookies);
    }
    public String getWebsiteTitle(){
        log.info("Get Website Page Title");
        return elementutil.getTitleOfWebsite();
    }
    public String getWebsiteUrl(){
        log.info("Get Website URL");
        return elementutil.getUrlOfWebsite();
    }
    public void waitWebsiteToLoad(){
        log.info("wait till webpage completely loaded");
        elementutil.waitTillDisplay(websiteLogo,10);
    }

}

