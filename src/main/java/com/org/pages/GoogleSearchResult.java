package com.org.pages;

import com.org.helper.LoggerHelper;
import com.org.util.ElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResult {
    WebDriver driver;
    ElementUtil elementutil;
    Logger log = LoggerHelper.getLogger(GoogleSearchResult.class);
    private By selectFromSuggestionGoogle=By.xpath("//div[@role='presentation']//div[@role='option']");

    public GoogleSearchResult(WebDriver driver) {
        this.driver=driver;
        elementutil=new ElementUtil(driver);
    }
    public void userClickOnFirstResult(){
        elementutil.clickOnFirstElementFromList(selectFromSuggestionGoogle);
    }

}
