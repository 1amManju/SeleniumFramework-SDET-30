package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtils;

public class SelectCurrentDate 
{
	@Test
	public void calenderPopup()
	{
		JavaUtils jLib = new JavaUtils();
		String date=jLib.getCurrentDate();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions action = new Actions(driver);
		action.moveByOffset(20, 30).click().perform();

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
	}
}