package com.crm.GenericLibrary;
/**
 * This Class Consist of generic methods wrt to Java
 * @author Manjunath
 *
 */

import java.util.Date;
import java.util.Random;

public class JavaUtils 
{
	/**
	 * This method will return Random Number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int random = r.nextInt(500);
		return random;
	}
	
	/**
	 * This method will return System Date 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will generate System Date in the format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
		String year = date[5];
		String time = date[3].replace(":", "-");
		
		String DateFormat = day+"-"+mon+"-"+year+"-"+time;
		return DateFormat;
		
	}
	
	public String getCurrentDate()
	{
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String week = date[0];
		String mon = date[1];
		String day = date[2];
		int pDay = Integer.parseInt(day);
		if(pDay<10)
		{
			int rem = pDay%10;
			pDay=rem;
		}
		
		String year = date[5];
	
		String DateFormat = week+" "+mon+" "+pDay+" "+year;
		return DateFormat;
		
	}
	
	public String getCurrentMonthAndYear()
	{
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String year = date[5];
		
		String DateFormat = mon+" "+year;
		return DateFormat;
		
	}
	
}
