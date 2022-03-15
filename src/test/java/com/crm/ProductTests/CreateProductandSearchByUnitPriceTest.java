package com.crm.ProductTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

public class CreateProductandSearchByUnitPriceTest extends BaseClass
{
	@Test
	public void createProductandSearchByUnitPriceTest() throws Throwable
	{
		//READ data from excel sheet
		String proName = eLib.readDataFromExcel("Products", 10, 2);
		 int unitPrice = eLib.readNumericDataFromExcel("Products", 10, 3);
		 String inType = eLib.readDataFromExcel("Products", 10, 4);
		
		/*Step 4: Navigate to Products*/
		HomePage hp = new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductPage pp = new ProductPage(driver);
		pp.createProduct();
		
		/*Step 5: Create Product with Unit Price */
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProductWithUnitPrice(proName, unitPrice);
		
	
		/*Step 6: Search Product by Unit Price */
		pp.searchByInType(driver, unitPrice, inType);
		
			
	}

}
