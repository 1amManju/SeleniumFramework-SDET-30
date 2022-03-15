package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyMonthDate 
{
	@Test
	public void calenderPopup()
	{
		String date="12";
		String monthAndYear="May 2022";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		Actions action = new Actions(driver);
		action.moveByOffset(20, 30).click().perform();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String nextPath="//span[@aria-label='Next Month']";
		String datePath="//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";

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
