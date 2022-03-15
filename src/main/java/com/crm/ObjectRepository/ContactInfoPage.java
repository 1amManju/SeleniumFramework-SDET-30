package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility
{
	
	//Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		
		//Initialization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getHeader() {
			return headerText;
		}
		
		//Business Library
		/**
		 * Get Contact Information
		 * @return
		 */
		public String contactNameInfo()
		{
			String contactInfo = headerText.getText();
			return contactInfo;
		}
		
	
	
	
	
	

}
