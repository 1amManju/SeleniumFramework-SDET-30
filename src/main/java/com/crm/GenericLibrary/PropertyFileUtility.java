 package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will read data from Property File and Return Value to user
 * @author Manjunath
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method will read data from Property File and return the value for the particular key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	
	}

}
