package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtils;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils 
{
	@Test
	public void practice() throws Throwable
	{
		JavaUtils j = new JavaUtils();
		int random = j.getRandomNumber();
		String date = j.getSystemDate();
		String SysDate = j.getSystemDateInFormat();
		
		System.out.println(random+"     "+date+"     "+SysDate);
		
		PropertyFileUtility p= new PropertyFileUtility();
		String BROWSER = p.readDataFromPropertyFile("browser");
		String URL = p.readDataFromPropertyFile("url");
		String USERNAME = p.readDataFromPropertyFile("username");
		
		System.out.println(BROWSER+"     "+URL+"     "+USERNAME);
		
		
		
		
		
		
		
		
		
		
		
	}

}
