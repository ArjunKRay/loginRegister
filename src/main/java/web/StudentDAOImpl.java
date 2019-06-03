package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAOImpl implements StudentDAO
{

	String query;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	
	public boolean addUser(Student u)
	{
		con=MyConnectionProvider.establishConnection();
		query="INSERT INTO Student(name,email,address,contact,username,password) values(?,?,?,?,?,?)";
		
		try
		{
			ps=con.prepareStatement(query);
			
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getAddress());
			ps.setString(4,u.getContact());
			ps.setString(5,u.getUsername());
			ps.setString(6,u.getPassword());
			
			row=ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean login(String username, String password) 
	{
		con=MyConnectionProvider.establishConnection();
		query="SELECT username,password FROM Student WHERE username=? AND password=?";
		
		try
		{
			ps=con.prepareStatement(query);
			
			ps.setString(1,username);
			ps.setString(2,password);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
		return false;
	}


	public boolean forgotPassword(String username, String password) 
	{
		con=MyConnectionProvider.establishConnection();
		query="UPDATE Student SET password=? WHERE username=?";
		
		try
		{
			
			ps=con.prepareStatement(query);	
			ps.setString(1,password);
			ps.setString(2,username);
			
			row=ps.executeUpdate();		
			
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
		return false;
	}

}