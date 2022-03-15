package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignPage extends WebDriverUtility 
{
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	public WebElement createCamaignLookUpImg;
	
	//Initialization
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateCamaignLookUpImg() {
		return createCamaignLookUpImg;
	}

	//Business Library
	/**
	 * Create Product
	 */
	public void createCamaign()
	{
		createCamaignLookUpImg.click();
	}
	
}
