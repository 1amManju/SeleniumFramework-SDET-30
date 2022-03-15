package com.crm.OrganizationTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithIndustryAndTypeTest extends BaseClass
{
	@Test
	public void createOrgWithIndustryTest() throws Throwable
	{
		
		//READ data from excel sheet
		String orgName = eLib.readDataFromExcel("Org", 7, 2)+"_"+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("Org", 7, 3);
		String type = eLib.readDataFromExcel("Org", 7, 4);
		
		/*Step 4: NAVIGATE TO organization link */
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		/*Step 5: Click on create Organization*/
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrgLookUpImg.click();
		
		/*Step 6: Enter Mandatory field and choose Healthcare and Press and Save */
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName, indType, type);
		
		//Step 7: Verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeadre = oip.orgNameInfo();
		if(actHeadre.contains(orgName))
		{
			System.out.println(actHeadre+"---> Organization Created");
		}
		else
		{
			System.out.println(actHeadre+"---> Organization not Created");
		}
			
	}

}
