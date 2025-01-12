package com.services;

import com.exception.InvalidInputException;
import com.mysql.jdbc.Connection;

public interface LoginServices {
	 //public boolean signup(String username,String password,String sqn);
     public boolean LogIn(String username,String password);
	 public void setConnection(Connection con);
	 public int price(String gadType);
	boolean signup(String username, String password);
}
