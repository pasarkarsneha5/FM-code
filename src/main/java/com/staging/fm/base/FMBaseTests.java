package com.staging.fm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.staging.fm.factory.DriverFactory;
import com.staging.fm.pages.FMHomePage;
import com.staging.fm.pages.FMLoginPage;
import com.staging.fm.pages.FMRentalContract;
import com.staging.fm.pages.FMSalesContract;

public class FMBaseTests {

	public DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	public FMLoginPage loginpage;
	public FMHomePage homepage;
	public FMRentalContract rentalcontract;
	public FMSalesContract salescontract;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginpage = new FMLoginPage(driver);
		rentalcontract = new FMRentalContract(driver);
		salescontract = new FMSalesContract(driver);  
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
