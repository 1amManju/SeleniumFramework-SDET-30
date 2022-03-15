package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgTest extends BaseClass
{
	@Test(groups="smokeSuite")
	public void createOrgTest() throws Throwable
	{
		SoftAssert sa =new SoftAssert();
		
		//READ data from excel sheet
		String orgName = eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
		
		/*Step 4: NAVIGATE TO organization link */
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		String expected = "Organizations";
		String actual = driver.findElement(By.linkText("Organizations")).getText();
		Assert.assertEquals(actual, expected);
		
		/*Step 5: Click on create Organization*/
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrgLookUpImg.click();
		String expHeader = "Creating New Organization";
		String actHeader = driver.findElement(By.className("lvtHeaderText")).getText();
		sa.assertEquals(actHeader, expHeader);
		
		/*Step 6: Enter Mandatory field and Save */
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		//Step 7: Verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.orgNameInfo();
		Assert.assertTrue(actOrgName.contains(orgName));
		
//		if(actOrgName.contains(orgName))
//		{
//			System.out.println(actOrgName+"---> Data Verified");
//		}
//		else
//		{
//			System.out.println(actOrgName+"---> Data not Verified");
//		}
		
		sa.assertAll("All ok");
		
	}

}
