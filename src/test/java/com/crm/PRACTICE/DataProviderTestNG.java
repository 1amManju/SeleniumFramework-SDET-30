package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG 
{
	@Test(dataProvider="getData")
	public void sampleDataProvider(String Name , String Model , int price , int Qty)
	{
		System.out.println(Name+"----"+Model+"----"+price+"----"+Qty);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][4];
		
		obj[0][0] = "MI";
		obj[0][1] = "Note 8 pro";
		obj[0][2] = 13000;
		obj[0][3] = 15;
		
		obj[1][0] = "Apple";
		obj[1][1] = "13 pro";
		obj[1][2] = 1500;
		obj[1][3] = 25;
		
		obj[2][0] = "Nokia";
		obj[2][1] = "Nokia 1100";
		obj[2][2] = 100000;
		obj[2][3] = 19;
		
		obj[3][0] = "Vivo";
		obj[3][1] = "V11 pro";
		obj[3][2] = 100;
		obj[3][3] = 9;
		return obj;
		
	}
}
