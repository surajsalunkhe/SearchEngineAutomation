package stepDefination;
import com.org.pages.*;
import com.org.driverFactory.DriverFactory;
import com.org.util.DataManager;
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
	DataManager dataManager=new DataManager();
	BasePage basePage;
	GoogleHomePage googleHomePage;
	SearchResultWebsite searchResultWebsite;
	GoogleSearchResult googleSearchResult;

	//WebDriver ldriver=basePage.getWebDriver();
	//GoogleHomePage googleHomePage=new GoogleHomePage(ldriver);
	//SearchResultWebsite searchResultWebsite=new SearchResultWebsite(ldriver);
	//GoogleSearchResult googleSearchResult=new GoogleSearchResult(ldriver);

	@Given("User opens the {string}")
	public void user_open_browser(String browserName){
		 basePage=new BasePage(browserName);
		WebDriver ldriver=basePage.getWebDriver();
		googleHomePage = new GoogleHomePage(ldriver);
		searchResultWebsite=new SearchResultWebsite(ldriver);
		googleSearchResult =new GoogleSearchResult(ldriver);
		//basePage.launchBrowser(browserName);
	}

	@Given("Navigate to url {string}")
	public void login_to_url(String url) {
		googleHomePage.lauchAppUrl(url);
	}

	@Given("User navigate to search engine")
	public void user_navigate_to_search_engine() {
		System.out.println("Navigated to search engine");
	}

	@Given("User enter {string} to search in search Engine")
	public void user_enter_to_search_in_search_engine(String keyword) {
		googleHomePage.enterKeywordAndSearch(keyword);
	}

	@Given("User click on first search suggestion")
	public void user_click_on_first_suggestion() {
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
		searchResultWebsite.acceptWebsiteCookies();
		String websiteTitle=searchResultWebsite.getWebsiteTitle();
		String websiteUrl=searchResultWebsite.getWebsiteUrl();
		Assert.assertEquals("Website URL Not matched",dataManager.getDataProperty("WebSiteURL"),websiteUrl);
		Assert.assertEquals("WebPage Title Not matched",dataManager.getDataProperty("WebSiteTitle"),websiteTitle);
	}

	@Then("User quite the browser")
	public void quit_the_browser(){
		googleHomePage.quitBrowser();
	}



}


