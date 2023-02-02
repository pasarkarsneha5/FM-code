package com.staging.fm.tests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.staging.fm.base.FMBaseTests;
import com.staging.fm.pages.FMLoginPage;
import com.staging.fm.utils.Constants;



public class FMLoginPageTest extends FMBaseTests {

	Logger log = LogManager.getLogger(FMLoginPageTest.class);
	//static Logger log = Logger.getLogger(FMLoginPageTest.class);
	
	
	@Test(priority = 4)
	
	public void loginPageTitleTest() { 
		String fmTitle = loginpage.getLoginPageTitle();
		System.out.println("Page Title is :" + fmTitle);
		Assert.assertEquals(fmTitle, Constants.LOGIN_PAGE_TITLE);
		log.info("this is FM title" + fmTitle);
		
	}
	@Test(priority = 3)
	public void loginPageUrlTest() {
		String fmUrl = loginpage.getLoginPageUrl(); 
		System.out.println("Login Url is :"+ fmUrl);
		Assert.assertTrue(fmUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
		log.info("URL successful");
	}
	@Test(priority = 1)
	public void ForgetPasswordLinkPresent() {
		Assert.assertTrue(loginpage.isForgetPasswordLinkPresent());
		log.info("This is URL");
		
	}
	
	
	@Test(priority = 2)
	public void doLogin() {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(homepage.getTitleOfThePage(), Constants.HOME_PAGE_TITLE);
		log.info("Login successful");
	}
}




