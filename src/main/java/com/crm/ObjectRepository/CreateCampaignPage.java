package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "campaignname")
	private WebElement campNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement productLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	//Initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCampNameEdt() {
		return campNameEdt;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	//Business Libraries
	/**
	 * This method will create New Campaign
	 * @param campName
	 */
	public void createNewCampaign(String campName)
	{
		campNameEdt.sendKeys(campName);
		saveBtn.click();
	}
	
	/**
	 * This method will create New Campaign with Product
	 * @param driver
	 * @param campName
	 * @param proName
	 */
	public void createNewCampaign(WebDriver driver , String campName , String proName)
	{
		campNameEdt.sendKeys(campName);
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(proName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+proName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
		
	}
	


}
