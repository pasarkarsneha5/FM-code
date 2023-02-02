package com.staging.fm.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.staging.fm.base.FMBaseTests;

	public class FMRentalContractTest extends FMBaseTests {
	
	@BeforeClass
	public void FMRentalContract() {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@Test
	public void clickOrderFulfillment() {
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		rentalcontract.clickOnOrderFulfillment(); 
	}
	@Test
	public void clickRentalContract() {
		rentalcontract.clickonRentalContractmenu();
		rentalcontract.clickOnAddNewBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		rentalcontract.enterRentalDetails("20188", "A1 PACU", "House");
		rentalcontract.editRental();
	}

	
}	
