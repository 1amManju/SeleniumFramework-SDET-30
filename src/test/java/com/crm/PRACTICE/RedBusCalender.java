package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedBusCalender 
{
	@Test
	public void calenderPopup()
	{
		String date="12";
		String month="Apr 2022";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");

		Actions action = new Actions(driver);
		action.moveByOffset(20, 30).click().perform();

		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		String nextPath="//button[.='>']";
		String datePath="//td[.='"+month+"']/ancestor::tbody/descendant::td[.='"+date+"']";

		for(;;)
		{
			try 
			{
				driver.findElement(By.xpath(datePath)).click();
				break;
			} 
			catch (Exception e) 
			{
				driver.findElement(By.xpath(nextPath)).click();
			}
		}	
	}

}
