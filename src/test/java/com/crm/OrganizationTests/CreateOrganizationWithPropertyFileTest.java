package com.crm.OrganizationTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithPropertyFileTest extends BaseClass
{
	@Test(groups="regression")
	public void propertyFle() throws Throwable
	{
		//Read data from Excel sheet
		String orgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		
		//Step 4: navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLnk();
				 
		//Step 5: Click on create organization link
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrg();
			
		//Step 6: Create org with mandatory field
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
			
	}
	
	@Test
	public void createSmpleTest()
	{
		System.out.println(" Sample test ");
	}
	
	@Test
	public void createSmpleTest1()
	{
		System.out.println(" Sample test 1");
	}
	
	@Test
	public void createSmpleTest2()
	{
		System.out.println(" Sample test 2");
	}
	
}
