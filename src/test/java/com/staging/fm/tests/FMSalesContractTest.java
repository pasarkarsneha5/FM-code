package com.staging.fm.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.staging.fm.base.FMBaseTests;

	public class FMSalesContractTest extends FMBaseTests{
	
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
	public void clickSalesContract() {
		salescontract.clickOnSalesContractmenu();
		salescontract.clickOnAddNewBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		salescontract.enterSalesDetails("20188", "A1 PACU", "House");
		//salescontract.enterSalesDetails(prop.getProperty("custid"),prop.getProperty("unitname"),prop.getProperty("salesrep"));
		salescontract.editSales();
		
	}
	
}
	

