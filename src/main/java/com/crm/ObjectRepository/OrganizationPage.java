package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	public WebElement createOrgLookUpImg;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Business Library
	/**
	 * Create Organization
	 */
	public void createOrg()
	{
		createOrgLookUpImg.click();
	}

	public void clickOnCreateOrgImg() 
	{
		createOrgLookUpImg.click();
		
	}

}
