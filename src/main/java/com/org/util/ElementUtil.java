package com.org.util;

import java.util.List;

import com.org.helper.LoggerHelper;
import com.org.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(ElementUtil.class);
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void launchUrl(String url) {
		log.info("Navigating to Url="+url);
		driver.get(url);
	}
	public String getTitleOfWebsite(){
		log.info("Website Page Title="+driver.getTitle());
		return driver.getTitle();
	}
	public String getUrlOfWebsite(){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String url= (String) js.executeScript("return document.URL");
		log.info("Website URl="+url);
		return url;
	}
	public void switchWindow(String windID) {
		driver.switchTo().window(windID);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClickIfPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement wb = getElement(locator);
			log.info("Clicking WebElement If present");
			wb.click();
		} catch (Exception e) {
		}
	}

	public void doClick(By locator) {
		WebElement wb = getElement(locator);
		wb.click();
	}

	public void doSendKeys(By locator, String input) {
		WebElement wb = getElement(locator);
		log.info("Enterint Text in Field="+input);
		wb.sendKeys(input);
	}

	public void doClear(By locator) {
		WebElement wb = getElement(locator);
		log.info("Clearing data in the text field");
		wb.clear();
	}

	public String getReqText(By locator) {
		WebElement wb = getElement(locator);
		return wb.getText();
	}

	public WebElement waitTillDisplay(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean getDisplayStatus(By locator) {
		return waitTillDisplay(locator, 30).isDisplayed();
	}

	public void selectItemInElementList(By locator, String itemName) {
		List<WebElement> filterOption = getElements(locator);
		for (WebElement option : filterOption) {
			//System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(itemName)) {
				option.click();
				break;
			}
		}
	}

	public void selectItemWhenContainsInElementList(By locator, String itemName) {
		List<WebElement> filterOption = getElements(locator);
		for (WebElement option : filterOption) {
			//System.out.println(option.getText());
			if (option.getText().contains(itemName)) {
				option.click();
				break;
			}
		}
	}
	public void clickOnFirstElementFromList(By locator){
		List<WebElement> filterOption = getElements(locator);
		WebElement element=filterOption.get(0);
		log.info("Clicking on first element from list ="+element.getText());
		element.click();
	}

	public void clickOnSearchResult(By locator){
		List<WebElement> filterOption = getElements(locator);
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element=filterOption.get(0);
		try {
			log.info("Clicking on first result using JS executor ="+element.getText());
			safeJavaScriptClick(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void safeJavaScriptClick(WebElement element){
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script executor");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
}
