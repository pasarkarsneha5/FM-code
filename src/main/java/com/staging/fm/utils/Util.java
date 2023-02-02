package com.staging.fm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	WebDriver driver;
	
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method is used to create webelement on basis of By locator
	 * @param locator
	 * @return
	 */
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("There is some error...");
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public void doClick (By locator) {
		try {
		getElement(locator).click();
		}catch (Exception e) {
			System.out.println("some exception occured while click on webelement");
			System.out.println(e.getMessage());
		}
	}
	
	public void doSendKeys(By locator, String value) {
		try {
		getElement(locator).sendKeys(value);
		}catch(Exception e) {
			System.out.println("some exception occured while entering on webelement");
			System.out.println(e.getMessage());
		}
	}
	
	public void takePageScreenshot(WebDriver driver, String filename) {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./target/screenshot/"+filename+ ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element, value).perform();
	}
	
	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element).perform();
	}
	
	// wait custom methods
	
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return getElement(locator);
	}
	
	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	 public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return getElement(locator);
	 }
	 
	 public WebElement waitForElementToBeVisibilityLocated(By locator, int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return getElement(locator);
	 }
	 
	 public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			return getElement(locator);
	 }
	 /**
	  * this method is used to select multiple values in dropdown
	  * @param driver
	  * @param value
	  */
		public static void selectChoiceValue(WebDriver driver, String... value){
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//ul//li//span[@class='comboTreeItemTitle']"));
			
			if(!value[0].equalsIgnoreCase("ALL")) {
				for (int i =0; i<list.size(); i++) {
					System.out.println(list.get(i).getText());
					String text =list.get(i).getText();
					 
					for (int k =0; k<value.length; k++) { // this is to array 
						if(text.equals(value[k])) {
							list.get(i).click();
							break;
						}
					}
				}
			}
			// this code is for selection of all values
			else {
				try {
				for(int all=0; all<list.size(); all++) {
					list.get(all).click();
				}
			}
				catch (Exception e){
					
				}
			}
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
