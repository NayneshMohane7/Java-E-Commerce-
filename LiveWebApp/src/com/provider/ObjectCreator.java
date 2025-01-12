package com.provider;

import java.io.FileInputStream;
import java.util.Properties;

import com.services.LoginServices;

public class ObjectCreator {
     public static LoginServices createObj()
     {
    	 LoginServices object = null;
    	 try
    	 {
    		 FileInputStream fin=new FileInputStream(".//resources//information.properties");
    		 Properties p=new Properties();
    		 p.load(fin);
    		 String className=p.getProperty("blogicClass");
    		 object = (LoginServices)Class.forName(className).newInstance();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 return object;
     }
}
