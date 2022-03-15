package com.crm.ContactTests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactWithMultipleDataTest extends BaseClass
{
			@Test(dataProvider = "Manju")
			public void createOrgWithMltipleData(String lastName) throws Throwable
			{
				/*Step 4: NAVIGATE TO contact link */
				HomePage hp = new HomePage(driver);
				hp.getContactsLnk().click();
				Reporter.log("navigated to Contact link",true);
				
				/*Step 5: Click on create Contact*/
				ContactPage cp = new ContactPage(driver);
				cp.createContactLookUpImg.click();
				Reporter.log("click on create contact link",true);
				
				/*Step 6: Enter Mandatory field and Save */
				CreateContactPage ccp= new CreateContactPage(driver);
				ccp.createNewContact(lastName);
				Reporter.log("create contact with LastName",true);
				
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
				Reporter.log("verification successful",true);	
				
			
			}

			@DataProvider(name = "Manju")
			public Object[][] getExcelData() throws Throwable
			{
				Object[][] data = eLib.readmultipleDataFromExcel("CreateContact");
				return data;
			}

}
