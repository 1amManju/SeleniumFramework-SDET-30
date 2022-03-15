package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "unit_price")
	private WebElement unitPriceEdt;
	
	@FindBy(name = "qty_per_unit")
	private WebElement utyUnitEdt;
	
	
	//Initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getUnitPriceEdt() {
		return unitPriceEdt;
	}


	public WebElement getUtyUnitEdt() {
		return utyUnitEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Scenarios
	public void createProduct(String proName)
	{
		productNameEdt.sendKeys(proName);
		saveBtn.click();
	}
	
	public void createProductWithUnitPrice(String proName , int unitPrice)
	{
		productNameEdt.sendKeys(proName);
		unitPriceEdt.clear();
		unitPriceEdt.sendKeys(""+unitPrice+"");
		saveBtn.click();
	}
	
	public void createProductWithQty(String proName , int qty)
	{
		productNameEdt.sendKeys(proName);
		unitPriceEdt.sendKeys(""+qty+"");
		saveBtn.click();
	}
	
}
