package com.org.managers;

import com.org.pages.*;
import org.openqa.selenium.WebDriver;
/*Author: Suraj Salunkhe
8th Oct 2021
Page Object Manager for Pages and Code Maintability
 */
public class PageObjectManager {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private GoogleSearchResult googleSearchResult;
    private BingHomePage bingHomePage;
    private BingSearchResult bingSearchResult;
    private YahooHomePage yahooHomePage;
    private YahooSearchResult yahooSearchResult;
    private SearchResultWebsite searchResultWebsite;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
     }
    public GoogleHomePage getGoogleHomePage(WebDriver driver) {
        return (googleHomePage==null)?googleHomePage=new GoogleHomePage(this.driver):googleHomePage;
    }
    public GoogleSearchResult getGoogleSearchResult(WebDriver driver){
        return (googleSearchResult==null)?googleSearchResult=new GoogleSearchResult(this.driver):googleSearchResult;
    }
    public SearchResultWebsite getSearchResultWebsite(WebDriver driver){
        return (searchResultWebsite==null)?searchResultWebsite=new SearchResultWebsite(this.driver):searchResultWebsite;
    }
    public BingHomePage getBingHomePage(WebDriver driver){
        return (bingHomePage==null)?bingHomePage=new BingHomePage(this.driver):bingHomePage;
    }
    public BingSearchResult getBingSearchResult(WebDriver driver){
        return (bingSearchResult==null)?bingSearchResult=new BingSearchResult(this.driver):bingSearchResult;
    }
    public YahooHomePage getYahooHomePage(WebDriver driver){
        return (yahooHomePage==null)?yahooHomePage=new YahooHomePage(this.driver):yahooHomePage;
    }
    public YahooSearchResult getYahooSearchResult(WebDriver driver){
        return (yahooSearchResult==null)?yahooSearchResult=new YahooSearchResult(this.driver):yahooSearchResult;
    }
}
