package com.staging.fm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.staging.fm.utils.Constants;
import com.staging.fm.utils.ElementUtil;
import com.staging.fm.utils.JavaScriptUtil;

public class FMRentalContract {

	//1.declare drivers
	public ElementUtil eleUtil;
	private WebDriver driver;
	public JavaScriptUtil jsutil;
	
	//2. By locators
	private By orderfulfillment 	= By.cssSelector("ul.sidebar-menu>li:nth-of-type(2)");
	private By rentalstart     		= By.xpath("//a[@href='/OrderFulfillment/Index?IntakeType=2']");//cssSelector("ul.treeview-menu.menu-open>li:nth-of-type(1)");
	private By addnewform			= By.xpath("//button[@id='btnAdd']");
	private By reason				= By.xpath("//span[@aria-controls='ReasonId_listbox']");
	private By custname				= By.xpath("//input[@name='CustId_input']");
	private By custIDList			= By.id("CustId_listbox");
	public  By clickcustname     	= By.xpath("//input[@role='combobox' and @name='CustId_input']");
	private By contactname			= By.xpath("//input[@id='ContactName']");
	private By contactphone			= By.xpath("//input[@id='ContactPhone']");
	private By unit					= By.xpath("//input[@name='DepartmentId_input']");
	private By unitIdList			= By.xpath("//span[@aria-controls='DepartmentId_listbox']");   
			
	private By salesrepresentative  = By.xpath("//input[@name='SalesRepresentativeId_input']");
	private By salesreplist			= By.xpath("//span[@aria-controls='SalesRepresentativeId_listbox']");
	
	private By ponumber				= By.xpath("//input[@id='PoNumber']");
	private By clickstartdatebtn	= By.xpath("//span[@aria-controls='StartDate_dateview']");
	private By startdate			= By.xpath("//input[@id='StartDate']");
	private By clickdeliverydatebtn = By.xpath("//span[@aria-controls='DeliveryDate_dateview']");
	private By deliverydate 		= By.id("DeliveryDate");
	//private By deliverydate			= By.xpath("//input[@id='DeliveryDate' and @name='DeliveryDate']");
	private By additem				= By.xpath("//button[@id='btnAddOrderItem']");
	private By searchdesc			= By.xpath("//input[@aria-label='Description']");
	private By searchsrno			= By.xpath("//input[@aria-label='Serial Number']");
	private By searchpartno			= By.xpath("//input[@aria-label='Part Number']");
	private By selectcheckbox		= By.xpath("//input[@aria-label='Select row']");
	//private By selectcheckbox		= By.xpath("//*[@id=\"gridAllItems\"]/div[2]/table/tbody/tr[2]/td[2]/input");
	private By addtoorder			= By.xpath("//input[@id='btnAddToOrder']");
	private By saveform				= By.xpath("//input[@id='btnSubmit']");
	private By saveorderpopup		= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[2]");
	private By dailyrate			= By.xpath("//*[@id=\"gridOrderItems\"]/div[2]/table/tbody/tr/td[6]");
	
	//Edit rental locators
	private By formnumber 			= By.xpath("//span[@id='lblDisplayFormNumber']");
	private By editbtnpopup			= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[1]");
	private By editbtn				= By.id("btnEdit");
	private By confirmpopup			= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[3]");
	
	private By statusdropdown		= By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[9]");
	private By statusDisabledDropdown = By.xpath("(//span[@class='k-dropdown-wrap k-state-disabled'])[8]");
	private By StatusValue          = By.xpath("//span[contains(text(),'Completed')]");
	private By statusListBox        = By.id("StatusId_listbox");
	
	private By updatebtn			= By.xpath("//input[@id='btnSubmit']");
	private By saveorderpopuplast			= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[4]");
	
//("//button[@type='button'][normalize-space()='Yes'][1]/ancestor::div[@role='toolbar']/preceding-sibling::div[@id='mdConfirm']");
//	By yesFromEditPopup = By.xpath("(//button[@type='button'][normalize-space()='Yes'])[2]");
	
	//3.constructor of page class
	public FMRentalContract(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
		jsutil = new JavaScriptUtil(driver);
	}
	
	//4. page actions:features of page in the form of methods
	
	
	public void clickOnOrderFulfillment() {
		eleUtil.doClick(orderfulfillment);
	}
	
	/**
	 * this method used to click on Rental Contract menu
	 */
	public void clickonRentalContractmenu() {
		eleUtil.doClick(rentalstart);
	}
	
	/**
	 * This Method is used to Click on Create New button on Rental Contract screen
	 */
	public void clickOnAddNewBtn() {
		eleUtil.doClick(addnewform);
	}
	public void enterRentalDetails(String custid, String unitname, String salesrep) {
		eleUtil.selectcomboboxdata(custname, custIDList, Constants.DEFAULT_TIMEOUT, custid);
		eleUtil.selectcomboboxdata(unit, unitIdList, Constants.DEFAULT_TIMEOUT, unitname);
		eleUtil.selectcomboboxdata(salesrepresentative, salesreplist, Constants.DEFAULT_TIMEOUT, salesrep);

		eleUtil.waitForElementToBeClickable(clickstartdatebtn, Constants.DEFAULT_TIMEOUT);
		eleUtil.doClick(clickstartdatebtn);
		eleUtil.selectDate(driver, "22", startdate);
		eleUtil.clickEnterBtn(startdate);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		eleUtil.doClick(clickdeliverydatebtn);
		eleUtil.selectDate(driver, "22", deliverydate);
		eleUtil.clickEnterBtn(deliverydate);
		
		eleUtil.doClick(additem);
		eleUtil.doClick(searchdesc);
	
		eleUtil.doSendKeys(searchpartno, "453561505631");
		eleUtil.clickEnterBtn(searchdesc);
		eleUtil.doClick(selectcheckbox);
		eleUtil.doClick(addtoorder);
		eleUtil.doClick(saveform);
		eleUtil.doClick(saveorderpopup);
		
	}
	public void editRental() {
		
		eleUtil.doVisibilityOfElement(formnumber, Constants.DEFAULT_TIMEOUT);
		String RCFormNumber = eleUtil.doGetText(formnumber);
		System.out.println("RC Form Number is :"+ RCFormNumber);
		eleUtil.doClick(editbtn);
		eleUtil.doClickOnReady(confirmpopup, Constants.DEFAULT_TIMEOUT);
		eleUtil.invisibilityOfElementLocatedBy(statusDisabledDropdown, Constants.DEFAULT_TIMEOUT);
		JavaScriptUtil js = new JavaScriptUtil(driver);
		js.scrollPageDown();
		eleUtil.doPresenceOfElementLocated(statusdropdown, Constants.DEFAULT_TIMEOUT);
		eleUtil.doClick(statusdropdown);
		eleUtil.doVisibilityOfElement(statusListBox, Constants.DEFAULT_TIMEOUT);
		eleUtil.doClick(StatusValue);
		
		eleUtil.doClick(updatebtn);
		eleUtil.doClick(saveorderpopuplast);
	}
	
	
	
	

	
	
	
}
