package com.crm.PRACTICE;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNG 
{
	@Test
	public void createOrg()
	{
		System.out.println("Org created");
		Reporter.log("Org Created - reort");//only n html report
	
	}
	
	@Test
	public void modifyOrg()
	{
		System.out.println("Org modified");
		Reporter.log("Org modified", true);	
	}

	@Test
	public void deleteOrg()
	{
		System.out.println("Org deleted");
	}
}
