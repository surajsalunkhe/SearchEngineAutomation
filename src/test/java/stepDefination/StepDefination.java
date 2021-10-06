package stepDefination;
import com.org.pages.*;
import com.org.driverFactory.DriverFactory;
import com.org.util.DataManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/*
Author: Suraj Salunkhe
Date:26th Sep 2021
*/
public class StepDefination {
	DataManager dataManager=new DataManager();
	HomePage homepage = new HomePage(DriverFactory.getDriver());
	SearchResultWebsite searchResultWebsite=new SearchResultWebsite(DriverFactory.getDriver());
	SearchResult searchResult=new SearchResult(DriverFactory.getDriver());

	@Given("Navigate to url  {string}")
	public void login_to_url(String url) {
		homepage.lauchAppUrl(url);
	}

	@Given("User navigate to search engine")
	public void user_navigate_to_search_engine() {
		System.out.println("Navigated to search engine");
	}

	@Given("User enter {string} to search in search Engine")
	public void user_enter_to_search_in_search_engine(String keyword) {
		homepage.enterKeywordAndSearch(keyword);
	}

	@Given("User click on first search suggestion")
	public void user_click_on_first_suggestion() {
		searchResult.userClickOnFirstResult();
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
		homepage.userClickOnSearchButton();
	}

	@When("User clicks on matching {string} search result")
	public void user_clicks_on_matching_search_result(String keyword){
		homepage.userClicksonMatchingSearchResult(keyword);
	}
	@Then("verify user redirected to {string} provided website")
	public void verify_user_redirected_to_website(String keyword){
		searchResultWebsite.acceptWebsiteCookies();
		String websiteTitle=searchResultWebsite.getWebsiteTitle();
		String websiteUrl=searchResultWebsite.getWebsiteUrl();
		Assert.assertEquals("Website URL Not matched",dataManager.getDataProperty("WebSiteURL"),websiteUrl);
		Assert.assertEquals("WebPage Title Not matched",dataManager.getDataProperty("WebSiteTitle"),websiteTitle);
	}



}


