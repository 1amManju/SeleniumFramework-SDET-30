
  package com.crm.CampaignsTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

public class CreateCampaignwithProductTest extends BaseClass
{
	@Test
	public void createCampaignwithProductTest() throws Throwable
	{
		//READ data from excel sheet
		String proName = eLib.readDataFromExcel("Campaigns", 1, 3)+""+jLib.getRandomNumber();
		String camName = eLib.readDataFromExcel("Campaigns", 1, 2)+""+jLib.getRandomNumber();
		
		/*Step 4: Navigate to Products and create product*/
		HomePage hp = new HomePage(driver);
		hp.getProductsLnk().click();
		
		//Click on Create Product Img
		ProductPage pp = new ProductPage(driver);
		pp.createProduct();
		
		//Create Product
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(proName);
		
		/*Step 5: Verification Product */
		ProductInfoPage pip = new ProductInfoPage(driver);
		String header = pip.productNameInfo();
		if(header.contains(proName))
		{
			System.out.println(header);
			System.out.println("Product created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Product not created");
		}
		
		/*Step 6: Navigate to Campaigns link*/
		hp.clickOnCampaignLnk();
		
		/*Step 7: Create Campaigns with product*/
		CampaignPage cp = new CampaignPage(driver);
		cp.createCamaign();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createNewCampaign(driver, camName, proName);
				
		
		/*Step 9: Verify Campaign*/
		CampaignInfoPage page = new CampaignInfoPage(driver);
		String head = page.campaignNameInfo();
		if(head.contains(camName))
		{
			System.out.println(head);
			System.out.println("Campaign created");
		}
		else 
		{
			System.out.println(head);
			System.out.println("Campaign not created");
		}
			
	}	
}
