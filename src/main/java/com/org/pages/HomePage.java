package com.org.pages;

import com.org.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.org.util.ElementUtil;


public class HomePage {
	WebDriver driver;
	ElementUtil elementutil;
	Logger log = LoggerHelper.getLogger(HomePage.class);


	 private By searchboxGoogle=By.xpath("//input[@title='Search']");
	 private By searchButtonGoogle=By.xpath("//input[@name='btnK'and @type='submit']");
	 private By searchResultsByGoogle=By.xpath("//div[@id='search']//a[@href]");
	 private By Bing_SearchBox=By.xpath("/div[@id='search']//a[@href]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	public void  lauchAppUrl(String url)
	{
		log.info("Opening URL");
		elementutil.launchUrl(url);
	}
	public void enterKeywordAndSearch(String keyword){
		log.info("Entering keyword and clicking on matching result");
		elementutil.doSendKeys(searchboxGoogle,keyword);
	}

	public void userClickOnSearchButton(){
		log.info("Clicking On Search button");
		elementutil.doClick(searchButtonGoogle);
	}
	public void userClicksonMatchingSearchResult(String selectResult){
		log.info("Clicking On Matching search Result button");
		elementutil.clickOnSearchResult(searchResultsByGoogle);
	}
}
