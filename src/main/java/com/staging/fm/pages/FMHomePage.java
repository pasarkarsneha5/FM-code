package com.staging.fm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.staging.fm.utils.Constants;
import com.staging.fm.utils.ElementUtil;

public class FMHomePage{
	// 1. declare drivers
	public ElementUtil eleUtil;
	private WebDriver driver;
	
	//2. By locator
	private By header  = By.xpath("//h1[@id='pageTitle']");
	private By usernamemenu = By.xpath("//label[@id='BranchIdForLogin']");
	private By signout = By.xpath("//a[contains(text(),'Sign out')]");
	private By modulelist = By.cssSelector("ul.sidebar-menu>li:nth-of-type(2)");
	
	
	//3.constructor of page class
	public FMHomePage(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//4. page actions:features of page in the form of methods
	public String getTitleOfThePage() {
		return eleUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}
	
	public void clickOnUserNameMenu() {
		eleUtil.doClick(usernamemenu);
	}
	
	public void clickOnSignout() {
		 eleUtil.doClick(signout);
	}
	
//	public List<String>  getfmModuleList() {
//		List<WebElement> modlist = eleUtil.waitForElementsToBeVisible(modulelist, 20);
//		List<String> modseclist = new ArrayList<String>();
//		for(WebElement e : modlist) {
//			String text = e.getText();
//			modseclist.add(text);
//		}
//		return modseclist;
		
	}

