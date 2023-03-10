package com.staging.fm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.staging.fm.factory.DriverFactory;
import com.staging.fm.utils.Constants;
import com.staging.fm.utils.ElementUtil;


public class FMLoginPage {
	
	//1.Declare private driver
	private WebDriver driver;
	public ElementUtil eleUtil;
	
	//3. By locators: OR
	
	private By email = By.id("logonIdentifier");
	private By password = By.id("password");
	private By loginButton = By.xpath("//button[@id='next']");
	private By forgetyourpasswordlink = By.id("forgotPassword");
	
	//2. constructor of the page class
	
	public FMLoginPage(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//4. page actions:features of page in the form of methods
	
	public String getLoginPageTitle() {
		return eleUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
		}
	
	public boolean isForgetPasswordLinkPresent() {
		return eleUtil.doDisplayed(forgetyourpasswordlink);
		}
	
	
	public FMHomePage doLogin(String un, String pwd) {
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return new FMHomePage(driver);
		
		
	}
	
	
	
}
