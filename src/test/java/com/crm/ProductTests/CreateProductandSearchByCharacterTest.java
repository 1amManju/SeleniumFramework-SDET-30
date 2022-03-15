package com.crm.ProductTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

public class CreateProductandSearchByCharacterTest extends BaseClass
{
	@Test
	public void createProductWithQtyUnitTest() throws Throwable
	{
		//READ data from excel sheet
		String proName = eLib.readDataFromExcel("Products", 13, 2);
		
		
		/*Step 4: Navigate to Products*/
		HomePage hp = new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductPage pp = new ProductPage(driver);
		pp.createProduct();
		
		/*Step 5: Create Product  */
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(proName);
		
		/*Step 6: Search Product by Character */
		pp.searchByLetter(driver, 'N');  
			
	}

}
