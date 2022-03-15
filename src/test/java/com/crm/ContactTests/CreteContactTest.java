package com.crm.ContactTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreteContactTest extends BaseClass
{
	@Test
	public void createContactTest() throws Throwable
	{		
		//READ data from excel sheet
		String lastName = eLib.readDataFromExcel("Contact", 1, 2);
		
		
		/*Step 4: NAVIGATE TO contact link */
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		
		/*Step 5: Click on create Organization*/
		ContactPage cp = new ContactPage(driver);
		cp.createContactLookUpImg.click();
		
		/*Step 6: Enter Mandatory field and Save */
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.createNewContact(lastName);
		
		/*Step 7:Verification */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.contactNameInfo();
		if(actLastName.contains(lastName))
		{
			System.out.println(actLastName+"---> Contact is Created");
		}
		else
		{
			System.out.println(actLastName+"---> Contact is not Created");
		}
	
	}


}
