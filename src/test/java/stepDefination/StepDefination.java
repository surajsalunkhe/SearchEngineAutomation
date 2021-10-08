package stepDefination;
import com.org.driverFactory.DriverFactory;
import com.org.managers.PageObjectManager;
import com.org.pages.*;
import com.org.util.DataManager;
import com.org.util.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/*
Author: Suraj Salunkhe
Date:26th Sep 2021
*/
public class StepDefination {

	WebDriver driver;
	GoogleHomePage googleHomePage;
	SearchResultWebsite searchResultWebsite;
	GoogleSearchResult googleSearchResult;
	PageObjectManager pageObjectManager;
	ElementUtil elementUtil;
	DataManager dataManager=new DataManager();
	DriverFactory driverFactory=new DriverFactory();


	@Given("User opens the {string} browser")
	public void user_open_browser(String browserName){
		//basePage=new BasePage(browserName);
		driver=driverFactory.init_Driver(browserName);
		pageObjectManager=new PageObjectManager(driver);
	}

	@Given("Navigate to url {string}")
	public void login_to_url(String url) {
		googleHomePage = pageObjectManager.getGoogleHomePage(driver);
		googleHomePage.lauchAppUrl(url);
	}

	@Given("User enter {string} to search in search Engine")
	public void user_enter_to_search_in_search_engine(String keyword) {
		googleHomePage.enterKeywordAndSearch(keyword);
	}

	@Given("User click on first search suggestion")
	public void user_click_on_first_suggestion() {
		googleSearchResult =pageObjectManager.getGoogleSearchResult(driver);
		googleSearchResult.userClickOnFirstResult();
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
		googleHomePage.userClickOnSearchButton();
	}

	@When("User clicks on matching {string} search result")
	public void user_clicks_on_matching_search_result(String keyword){
		googleHomePage.userClicksonMatchingSearchResult(keyword);
	}
	@Then("verify user redirected to {string} provided website")
	public void verify_user_redirected_to_website(String keyword){
		searchResultWebsite=pageObjectManager.getSearchResultWebsite(driver);
		searchResultWebsite.acceptWebsiteCookies();
		String websiteTitle=searchResultWebsite.getWebsiteTitle();
		String websiteUrl=searchResultWebsite.getWebsiteUrl();
		Assert.assertTrue(websiteUrl.contains(keyword));
		Assert.assertEquals("Website URL Not matched",dataManager.getDataProperty("WebSiteURL"),websiteUrl);
		Assert.assertEquals("WebPage Title Not matched",dataManager.getDataProperty("WebSiteTitle"),websiteTitle);
	}

	@Then("User quite the browser")
	public void quit_the_browser(){
		googleHomePage.quitBrowser();
	}



}


