package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration 
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getMoreLnk() {
		return moreLnk;
	}


	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}


	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	//Business Libraries
	/**
	 * This Method is used Sign Out from App
	 * @param driver
	 */
	public void signOutofApp(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOutLnk.click();
	}
	
	/**
	 * This method is used to click on Campaign
	 */
	public void clickOnCampaignLnk()
	{
		moreLnk.click();
		campaignsLnk.click();
	}


	public void clickOnOrgLnk() 
	{
		organizationsLnk.click();
		
	}
	
	public void clickOnContactLnk() 
	{
		contactsLnk.click();
		
	}
	
	public void clickOnProductLnk() 
	{
		productsLnk.click();
		
	}
	
}
