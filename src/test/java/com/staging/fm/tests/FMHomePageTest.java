package com.staging.fm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.staging.fm.base.FMBaseTests;
import com.staging.fm.utils.Constants;

public class FMHomePageTest extends FMBaseTests{

	@BeforeClass 
	public void FMHomePage() {
		 homepage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@Test
	public void homePageTitle() {
		String homeTitle = homepage.getTitleOfThePage();
		System.out.println("The Homepage Title is :"+ homeTitle);
		Assert.assertEquals(homeTitle, Constants.HOME_PAGE_TITLE);
	}
	@Test
	public void checkUsername() {
		homepage.clickOnUserNameMenu();
	}
	@Test
	public void signOut() {
		homepage.clickOnSignout();
	}
}
