package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * Create Organization With Organization Name
	 * @param orgName
	 */
	public void createNewOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * Create Organization With Organization Name And Industry Type
	 * @param orgName
	 * @param indType
	 */
	public void createNewOrg(String orgName , String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(indType, industryDropdown);
		saveBtn.click();
	}
	
	/**
	 * Create Organization With Organization Name , Industry Type And Type DropDown
	 * @param orgName
	 * @param indType
	 * @param type
	 */
	public void createNewOrg(String orgName , String indType , String type)
	{
		orgNameEdt.sendKeys(orgName);
		select(indType, industryDropdown);
		select(type, typeDropdown);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
