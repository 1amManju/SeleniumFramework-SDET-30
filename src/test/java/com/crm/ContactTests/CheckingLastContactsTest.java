package com.crm.ContactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckingLastContactsTest extends BaseClass
{
	@Test
	public void createContactTest() throws Throwable
	{	
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();

		List<WebElement> link = driver.findElements(By.xpath("//input[@name='selected_id']"));
		int count = link.size();
		
		WebElement w = link.get(count-1);
		w.click();
			
		Thread.sleep(2000);
	}

}
