package com.crm.ContactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class Delete5thContactTest extends BaseClass
{
	@Test
	public void createContactTest() throws Throwable
	{	
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();

		List<WebElement> link = driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		WebElement w = link.get(5);
		w.click();
		WebElement del = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[10]/a[.='del']"));
		del.click();
		wLib.acceptAlert(driver);
	}

}
