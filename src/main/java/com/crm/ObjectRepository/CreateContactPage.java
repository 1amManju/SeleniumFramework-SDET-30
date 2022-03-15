package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	//Initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	public WebElement getOrgNmaeImg() {
		return orgNameLookUpImg;
	}
	

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	//Business Library
	/**
	 * Create Contact 
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * Create Contact with Org Name
	 * @param driver
	 * @param lastName
	 * @param orgName
	 */
	public void createNewContact(WebDriver driver , String lastName , String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	/**
	 * Create Contact with Lead Source
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String lastName , String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource, leadsourceDropDown);
		saveBtn.click();
	}
	
	/**
	 * Create Contact with Org Name And Lead Source
	 * @param driver
	 * @param lastName
	 * @param orgName
	 * @param leadSource
	 */
	public void createNewContact(WebDriver driver , String lastName , String orgName , String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		select(leadSource, leadsourceDropDown);
		saveBtn.click();
	}
}
