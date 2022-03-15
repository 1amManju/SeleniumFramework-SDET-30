package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductPage extends WebDriverUtility
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(name = "search_field")
	private WebElement inDropDown;
	

	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUpImg() {
		return createProductLookUpImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getInDropDown() {
		return inDropDown;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//Business Library
		/**
		 * Create Product
		 */
		public void createProduct()
		{
			createProductLookUpImg.click();
		}
		
		
		public void searchByLetter(WebDriver driver , char character)
		{
			HomePage hp = new HomePage(driver);
			hp.clickOnProductLnk();
			driver.findElement(By.xpath("//td[.='"+character+"']")).click();
		}
		
		public void searchByInType(WebDriver driver , String proName , String inType)
		{
			HomePage hp = new HomePage(driver);
			hp.clickOnProductLnk();
			searchEdt.sendKeys(proName);
			select(inType, inDropDown);
			submitBtn.click();
			
		}
		
		public void searchByInType(WebDriver driver , int unitPrice , String inType)
		{
			HomePage hp = new HomePage(driver);
			hp.clickOnProductLnk();
			searchEdt.sendKeys(""+unitPrice+"");
			select(inType, inDropDown);
			submitBtn.click();
			
		}
		
		
}
