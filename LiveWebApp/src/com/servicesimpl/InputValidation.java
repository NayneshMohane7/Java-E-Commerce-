package com.servicesimpl;

public class InputValidation {
        public static boolean validateUsername(String username)
        {
        	if(username!=null && username!="")
        		return true;
        	else
        		return false;
        }
        public static boolean validatePassword(String password)
        {
        	if(password!=null && password.length()>=3)
        		return true;
        	else
        		return false;
        }
}
