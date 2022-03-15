package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignInfoPage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;

	//Initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getHeaderText() {
		return headerText;
	}

	//Business Library
	/**
	 * Get Campaign Information
	 * @return
	 */
	public String campaignNameInfo()
	{
		String campaignInfo = headerText.getText();
		return campaignInfo;
	}

}
