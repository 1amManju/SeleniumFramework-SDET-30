package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteQuery 
{
	Connection con;
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		
		try
		{
		//step 1: register the driver+
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: get connector from database =- provide DB name
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//step 3: issue create statement
		Statement state = con.createStatement();
		
		//step 4: Execute Query
		ResultSet result = state.executeQuery("select * from student;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		}
		
		finally 
		{
			//step 5: exit from DB
			con.close();
			
		}
		
		
	}

}
