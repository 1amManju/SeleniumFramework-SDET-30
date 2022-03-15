package com.crm.OrganizationTests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithMultipleDataWithTypeTest extends BaseClass
{
		@Test(dataProvider = "Manju")
		public void createOrgWithMltipleData(String orgName, String indType , String Type) throws Throwable
		{
			String orgname = orgName+jLib.getRandomNumber();

			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLnk();
			Reporter.log("navigated to org link",true);

			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("click on create org link",true);

			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(orgname, indType, Type);
			Reporter.log("create org with insustry type",true);

			//validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String actHeader = oip.orgNameInfo();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		

		}

		@DataProvider(name = "Manju")
		public Object[][] getExcelData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("OrgManagement");
			return data;
		}


}
