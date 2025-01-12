package com.servicesimpl;

import com.DAOImpl.DAOImplClass;
import com.bean.User;
import com.exception.InvalidInputException;
import com.mysql.jdbc.Connection;
import com.services.LoginServices;
import com.servicesimpl.InputValidation;

public class LoginServicesImpl implements LoginServices {
    
	User u;
	Connection con;
	DAOImplClass dao=new DAOImplClass();
	
	@Override
	public void setConnection(Connection con) {
		this.con=con;
		dao.provideConnection(con);
	}    
	
	

	
	@Override
	public boolean signup(String username, String password)
	{
		
    	    
   			 u=new User(username,password); 
   			 if(dao.insertUser(u))
   			 {
   				 return true;
   			 }
   			 else
   			 {
   				 return false;
   			 }
   			 
	
	}

	@Override
	public boolean LogIn(String username, String password) {
		User un=null;
		boolean outcome=false;
	  try
	  {
		 un=dao.retriveUser(username);
		 if(un.getUsername().equals(username) && un.getPassword().equals(password))
		 {
    		 outcome=true;
		 }
		 else
		 {
    	     outcome=false;
		 }
		 return outcome;
	
	  }
	  catch(Exception e)
      {
			e.printStackTrace();
			 return false;
	  }

	}
	
	@Override
	public int price(String gadType)
	{
		int gadPrice=0;
		gadPrice=dao.getPrice(gadType);
		return gadPrice;
	}


	
	

}
