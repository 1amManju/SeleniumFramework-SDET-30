package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvderPractice 
{
	@Test(dataProvider="getData")
	public void studentDataProvider(String Name , int number)
	{
		System.out.println(Name+"----"+number);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0] = "Manjunath";
		obj[0][1] = 987654321;
		
		obj[1][0] = "Chandan";
		obj[1][1] = 420420420;
		
		obj[2][0] = "Sudhakar";
		obj[2][1] = 420840;
		
		obj[3][0] = "Aishiiii";
		obj[3][1] = 840840840;
		
		obj[4][0] = "Shashi";
		obj[4][1] = 762874659;

		obj[5][0] = "Lekhana";
		obj[5][1] = 150150150;
		
	
		return obj;
		
	}

}
