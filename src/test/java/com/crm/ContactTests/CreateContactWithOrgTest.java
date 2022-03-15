package com.crm.ContactTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		//READ data from excel sheet
		String lastName = eLib.readDataFromExcel("Contact", 4, 2);
		String orgName = eLib.readDataFromExcel("Contact", 4, 3)+""+jLib.getRandomNumber();
				
		//Navigate to organization Link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		//Click on create Organization
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrgLookUpImg.click();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		//Organization Verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.orgNameInfo();
		
		if(orgHeader.contains(lastName))
		{
			System.out.println(orgHeader+"---> Organization is Created");
		}
		else
		{
			System.out.println(orgHeader+"---> Organization is not Created");
		}
		
		
		
		/*Step 4: NAVIGATE TO Contact link */
		hp.getContactsLnk().click();
		
		/*Step 5: Click on create Contact*/
		ContactPage cp = new ContactPage(driver);
		cp.createContactLookUpImg.click();
		
		/*Step 6: Enter Mandatory field, choose any Organization name and Save */
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(driver, lastName, orgName);
		
		//Contact Verification
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.contactNameInfo();
		if(conHeader.contains(lastName))
		{
			System.out.println(conHeader+"---> Contact is Created");
		}
		else
		{
			System.out.println(conHeader+"---> Contact is not Created");
		}
		
	
	}

}
