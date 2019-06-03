package web;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider 
{
	private static Connection con;
	
	static 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
			System.out.println("MyConnectionProvider.enclosing_method()::connection Established");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection establishConnection() 
	{
		return con;

	}

}