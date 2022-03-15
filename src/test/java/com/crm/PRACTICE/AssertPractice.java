package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice 
{
	@Test
	public void assertPractice()
	{
		System.out.println("heyyyy");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 0);
		System.out.println("looooo");
		Assert.assertEquals(1, 0);
		System.out.println("failooo");
		sa.assertAll();
		
	}

}
