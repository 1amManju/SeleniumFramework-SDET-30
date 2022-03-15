package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getHeader() {
		return headerText;
	}
	
	//Business Library
	/**
	 * To get Organization Header
	 * @return
	 */
	public String orgNameInfo()
	{
		String orgInfo = headerText.getText();
		return orgInfo;
	}
	

}
