package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{
	Connection con;
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException
	{
		try
		{
		//step 1: register to driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: get connector from database =- provide DB name
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("conn established");
				
		//step 3: issue create statement
		Statement state = con.createStatement();
		
		//step 4: execute query
		//insert into student values(4,'Nagaraj','Male');
		int result = state.executeUpdate("insert into student values(6,'Shruti','Female');");
		
		if(result==1)
		{
			System.out.println("Row is affected");
		}
		else
		{
			System.out.println("Row is not affected");
		}
		}
		finally 
		{
			//step 5: close DB
			con.close();
			System.out.println("conn closed");
			
		}
		
		
		
	}

}
