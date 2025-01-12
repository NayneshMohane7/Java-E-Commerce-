package com.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.DAOInterface;
import com.bean.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DAOImplClass implements DAOInterface {
	
	Connection con;
    PreparedStatement pst;
	
	public void provideConnection(Connection con)
	{
		this.con=con;
	}

	public boolean insertUser(User u) {
		// TODO Auto-generated method stub
		ResultSet rs;
	   try
	   {
		
		   String username=u.getUsername();
		   String password=u.getPassword();
		   //String sqn=u.getSqn();
		   boolean out=false;
		
		
			pst=(PreparedStatement) con.prepareStatement("select * from login1 where usename=?");
			pst.setString(1, username);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				System.out.println("username already exists........ ");
				out=false;
			}
			else
			{
				 pst=(PreparedStatement) con.prepareStatement("insert into login1 values(?, ?)");
			     pst.setString(1, username);
			     pst.setString(2, password);
			    // pst.setString(3, sqn);
			     pst.executeUpdate();
			     
			     System.out.println("inserted sucessfully");
			     out=true;
			}
			return out;
		} 
		
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	
	public User retriveUser(String username) {
		ResultSet rs=null;
		User us=null;
		
		try
		{
			 pst= (PreparedStatement) con.prepareStatement("select * from login1 where usename=?");
			 pst.setString(1,username);
			 rs=pst.executeQuery();
			 
			 if(rs.next())
			 {
				 String u=rs.getString(1);
				 String p=rs.getString(2);
				 //String sqn=rs.getString(3);
				 us=new User(u,p);
				 
			 }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return us;
	}
	public int getPrice(String gadType)
	{
		ResultSet rs;
		int price = 0;
		try
		{
			pst=(PreparedStatement) con.prepareStatement("select * from mobiles1 where gadgets=?");
			pst.setString(1, gadType);
			rs=pst.executeQuery();
			if(rs.next())
			{
				price=rs.getInt(2);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return price;
	}

	

}
