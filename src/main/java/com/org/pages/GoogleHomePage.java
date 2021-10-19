package com.org.pages;

import com.org.Interfaces.IHomePage;
import com.org.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.org.util.ElementUtil;
import org.openqa.selenium.support.PageFactory;


public class GoogleHomePage implements IHomePage {
	WebDriver driver;
	ElementUtil elementutil;
	Logger log = LoggerHelper.getLogger(GoogleHomePage.class);


	 private By google_SearchBox =By.xpath("//input[@title='Search']");
	 private By google_searchButton =By.xpath("//input[@name='btnK'and @type='submit']");
	 private By google_searchResultList =By.xpath("//div[@role='presentation']//div[@role='option']");
	
	public GoogleHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil=new ElementUtil(driver);
	}
	public void enterKeywordAndSearch(String keyword){
		log.info("Enter keyword and clicking on matching result");
		elementutil.doSendKeys(google_SearchBox,keyword);
	}

	public void userClickOnSearchButton(){
		log.info("Clicking On Search button");
		elementutil.doClick(google_searchButton);
	}

	public void userClickOnFirstResult(){
		elementutil.clickOnFirstElementFromList(google_searchResultList);
	}
}
