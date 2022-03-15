package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class CreateOrganizationTest extends BaseClass
{
	@Test
	public void createOrganizationTest() throws Throwable
	{
		
		//Step 3: navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		 
		//Step 4: Click on create organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create org with mandatory field
		driver.findElement(By.name("accountname")).sendKeys("ALL Out");
		
		//Step 6: save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
	}

}
