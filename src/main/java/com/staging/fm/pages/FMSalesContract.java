package com.staging.fm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ctc.wstx.shaded.msv_core.verifier.jarv.Const;

import com.staging.fm.utils.Constants;
import com.staging.fm.utils.ElementUtil;
import com.staging.fm.utils.JavaScriptUtil;

public class FMSalesContract  {

	//1.declare drivers
	public ElementUtil eleUtil;
	private WebDriver driver;
	public JavaScriptUtil jsutil;
	
	//2. By locators
		private By orderfulfillment 	= By.cssSelector("ul.sidebar-menu>li:nth-of-type(2)");
		private By salesstart     		= By.xpath("//a[@href='/OrderFulfillment/Index?IntakeType=3']");
		private By addnewform			= By.xpath("//button[@id='btnAdd']");
		private By custname				= By.xpath("//input[@name='CustId_input']");
		private By custIDList			= By.id("CustId_listbox");
		public  By clickcustname     	= By.xpath("//input[@role='combobox' and @name='CustId_input']");
		
		private By unit					= By.xpath("//input[@name='DepartmentId_input']");
		private By unitIdList			= By.xpath("//span[@aria-controls='DepartmentId_listbox']");   
				
		private By salesrepresentative  = By.xpath("//input[@name='SalesRepresentativeId_input']");
		private By salesreplist			= By.xpath("//span[@aria-controls='SalesRepresentativeId_listbox']");
		
		private By clickbilldatebtn		= By.xpath("//span[@aria-controls='StartDate_dateview']");
		private By billdate				= By.xpath("//input[@id='StartDate']");
		private By clickdeliverydatebtn	= By.xpath("//span[@aria-controls='DeliveryDate_dateview']");
		private By deliverydate			= By.xpath("//input[@id='DeliveryDate']");
		
		private By patientname			= By.xpath("//input[@id='PatientName']");
		
		private By additem				= By.xpath("//button[@id='btnAddOrderItem']");
		private By searchdesc			= By.xpath("//input[@aria-label='Description']");
		private By searchsrno			= By.xpath("//input[@aria-label='Serial Number']");
		private By searchpartno			= By.xpath("//input[@aria-label='Part Number']");
		private By selectcheckbox		= By.xpath("//input[@aria-label='Select row']");
		//private By selectcheckbox		= By.xpath("//*[@id=\"gridAllItems\"]/div[2]/table/tbody/tr[2]/td[2]/input");
		private By addtoorder			= By.xpath("//input[@id='btnAddToOrder']");
		private By saveform				= By.xpath("//input[@id='btnSubmit']");
		private By saveorderpopup		= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[2]");
		
		//Edit rental locators
		private By formnumber 			= By.xpath("//span[@id='lblDisplayFormNumber']");
		private By editbtnpopup			= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[1]");
		private By editbtn				= By.id("btnEdit");
		private By confirmpopup			= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[3]");
		private By confirmpopupsync		= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[5]");
		
		private By statusdropdown		= By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[9]");
		private By statusDisabledDropdown = By.xpath("(//span[@class='k-dropdown-wrap k-state-disabled'])[8]");
		private By StatusValue          = By.xpath("//span[contains(text(),'Completed')]");
		private By StatusValuesync      = By.xpath("//span[contains(text(),'Sync')]");
		private By statusListBox        = By.id("StatusId_listbox");
		
		private By updatebtn			= By.xpath("//input[@id='btnSubmit']");
		private By saveorderpopuplast	= By.xpath("(//button[@type='button'][normalize-space()='Yes'])[4]");
		
		//3.constructor of page class
		public FMSalesContract(WebDriver driver) {
			this.driver= driver;
			eleUtil = new ElementUtil(driver);
			jsutil = new JavaScriptUtil(driver);
		}
		
		//4. page actions:features of page in the form of methods
		
		
		public void clickOnOrderFulfillment() {
			eleUtil.doClick(orderfulfillment);
		}
		
		public void clickOnSalesContractmenu() {
			eleUtil.doClick(salesstart);
		}
		public void clickOnAddNewBtn() {
			eleUtil.doClick(addnewform);
		}
		public void enterSalesDetails(String custid, String unitname, String salesrep) {
			eleUtil.selectcomboboxdata(custname, custIDList, Constants.DEFAULT_TIMEOUT, custid);
			eleUtil.selectcomboboxdata(unit, unitIdList, Constants.DEFAULT_TIMEOUT, unitname);
			eleUtil.selectcomboboxdata(salesrepresentative, salesreplist, Constants.DEFAULT_TIMEOUT, salesrep);
			
			eleUtil.doClick(clickbilldatebtn);
			eleUtil.selectDate(driver, "20", billdate);
			eleUtil.clickEnterBtn(billdate);
			eleUtil.doClick(clickdeliverydatebtn);
			eleUtil.selectDate(driver, "22", deliverydate);
			eleUtil.clickEnterBtn(deliverydate);
			
			eleUtil.doClick(additem);
			eleUtil.doClick(searchdesc);
		  //eleUtil.doSendKeys(searchdesc, "resp");
			eleUtil.doSendKeys(searchpartno, "453561505631");
			eleUtil.clickEnterBtn(searchdesc);
			eleUtil.doClick(selectcheckbox);
			eleUtil.doClick(addtoorder);
			eleUtil.doClick(saveform);
			eleUtil.doClick(saveorderpopup);
		}
		public void editSales() {
			
			eleUtil.doVisibilityOfElement(formnumber, Constants.DEFAULT_TIMEOUT);
			String SCFormNumber = eleUtil.doGetText(formnumber);
			System.out.println("Sales Contract Form Number is :"+ SCFormNumber);
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
			
			eleUtil.doClick(editbtn);
			eleUtil.doClickOnReady(confirmpopupsync, Constants.DEFAULT_TIMEOUT);
			eleUtil.invisibilityOfElementLocatedBy(statusDisabledDropdown, Constants.DEFAULT_TIMEOUT);
			JavaScriptUtil js1 = new JavaScriptUtil(driver);
			js1.scrollPageDown();
			eleUtil.doPresenceOfElementLocated(statusdropdown, Constants.DEFAULT_TIMEOUT);
			eleUtil.doClick(statusdropdown);
			eleUtil.doVisibilityOfElement(statusListBox, Constants.DEFAULT_TIMEOUT);
			eleUtil.doClick(StatusValuesync);
		}
}		
		
		
		
		
		
		
		
		
		
		
		
		
//		public void unit(String unitname) {
//			eleUtil.doSendKeys(unit, unitname);
//			eleUtil.doVisibilityOfElement(unitIdList, Constants.DEFAULT_TIMEOUT);
//			eleUtil.clickEnterBtn(unit);
//		}
		
//		public void salesrep(String salesrep){
//			eleUtil.selectcomboboxdata(salesrepresentative, salesreplist, Constants.DEFAULT_TIMEOUT, salesrep);
//			
//		}

		

