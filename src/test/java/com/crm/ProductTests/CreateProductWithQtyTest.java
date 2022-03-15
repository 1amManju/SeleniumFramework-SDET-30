package com.crm.ProductTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

@Listeners(com.crm.GenericLibrary.ListnerImplimentationClass.class)

public class CreateProductWithQtyTest extends BaseClass
{
	
	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyserImplimentation.class)
	public void createProductWithQtyTest() throws Throwable
	{
		Assert.fail();
		//READ data from excel sheet
		String proName = eLib.readDataFromExcel("Products", 4, 2);
		int qty = eLib.readNumericDataFromExcel("Products", 4, 3);
		String inType = eLib.readDataFromExcel("Products", 4, 4);
		
		/*Step 4: Navigate to Products*/
		HomePage hp = new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductPage pp = new ProductPage(driver);
		pp.createProduct();
		  
		/*Step 5: Create Product with Qty/Unit */
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProductWithQty(proName, qty);
	
		/*Step 6: Search Product by Qty/Unit */
		pp.searchByInType(driver, qty, inType);
			
		
	}
}
