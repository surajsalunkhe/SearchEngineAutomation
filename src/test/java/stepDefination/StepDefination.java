package stepDefination;
import com.org.driverFactory.DriverFactory;
import com.org.managers.PageObjectManager;
import com.org.pages.*;
import com.org.util.PropertiesFileManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/*
Author: Suraj Salunkhe
Date:9th Oct 2021
*/
public class StepDefination {

	WebDriver driver;
	GoogleHomePage googleHomePage;
	SearchResultWebsite searchResultWebsite;
	GoogleSearchResult googleSearchResult;
	PageObjectManager pageObjectManager;
	BingHomePage bingHomePage;
	BingSearchResult bingSearchResult;
	DriverFactory driverFactory=new DriverFactory();
	String searchEngine;


	@Given("User opens the {string} browser")
	public void user_open_browser(String browserName){
		driver=driverFactory.init_Driver(browserName);
		pageObjectManager=new PageObjectManager(driver);
	}

	@Given("Navigate to url {string}")
	public void login_to_url(String searchEngineFromUser) throws Exception {
		String url=PropertiesFileManager.getPropertyValue(searchEngineFromUser.toLowerCase());
		searchEngine=searchEngineFromUser.toLowerCase();
		driver.get(url);
	}

	@Given("User enter {string} to search in search Engine")
	public void user_enter_to_search_in_search_engine(String keyword) {
		if(searchEngine.equalsIgnoreCase("google")){
			pageObjectManager.getGoogleHomePage().enterKeywordAndSearch(keyword);
		}else if(searchEngine.equalsIgnoreCase("bing")){
			pageObjectManager.getBingHomePage().enterKeywordAndSearch(keyword);
		}
	}

	@Given("User click on first search suggestion")
	public void user_click_on_first_suggestion() {
		if(searchEngine.equalsIgnoreCase("google")){
			pageObjectManager.getGoogleHomePage().userClickOnFirstResult();
		}else if(searchEngine.equalsIgnoreCase("bing")){
			pageObjectManager.getBingHomePage().userClickOnSearchButton();
		}
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
		if(searchEngine.equalsIgnoreCase("google")){
			pageObjectManager.getGoogleHomePage().userClickOnSearchButton();
		}else if(searchEngine.equalsIgnoreCase("bing")){
			pageObjectManager.getBingHomePage().userClickOnSearchButton();
		}
	}

	@When("User clicks on matching {string} search result")
	public void user_clicks_on_matching_search_result(String keyword){
		if(searchEngine.equalsIgnoreCase("google")){
			pageObjectManager.getGoogleSearchResult().userClicksonMatchingSearchResult(keyword);
		}else if(searchEngine.equalsIgnoreCase("bing")){
			pageObjectManager.getBingSearchResult().userClicksonMatchingSearchResult(keyword);
		}
	}
	@Then("verify user redirected to {string} provided website")
	public void verify_user_redirected_to_website(String keyword){
		searchResultWebsite=pageObjectManager.getSearchResultWebsite();
		searchResultWebsite.acceptWebsiteCookies();
		String websiteTitle=searchResultWebsite.getWebsiteTitle();
		String websiteUrl=searchResultWebsite.getWebsiteUrl();
		Assert.assertTrue(websiteUrl.contains(keyword));
		Assert.assertEquals("Website URL Not matched", PropertiesFileManager.getPropertyValue("WebSiteURL"),websiteUrl);
		Assert.assertEquals("WebPage Title Not matched", PropertiesFileManager.getPropertyValue("WebSiteTitle"),websiteTitle);
	}

	@Then("User quit the browser")
	public void user_quit_the_browser() {
		driver.quit();
	}

}
