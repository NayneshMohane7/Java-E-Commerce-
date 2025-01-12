package com.listeners;

import java.net.ConnectException;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.jdbc.Connection;


public class ContextConnctionListener implements ServletContextListener {
	Connection con=null;

    public void contextInitialized(ServletContextEvent e) {
    	ServletContext context=e.getServletContext();
    	String driver=context.getInitParameter("driver");
    	String url=context.getInitParameter("url");
    	String username=context.getInitParameter("username");
    	String password=context.getInitParameter("password");
    	
    	try
    	{
    		Class.forName(driver);
    		con=(Connection) DriverManager.getConnection(url,username,password);
    		context.setAttribute("DbCon", con);
    	}
	    catch(Exception e1)
	    {
	    	e1.printStackTrace();
	    }
    	
    }

	
    public void contextDestroyed(ServletContextEvent e) {
        // TODO Auto-generated method stub
    	try
    	{
    		con=(Connection) e.getServletContext().getAttribute("DbCon");
        	con.close();
    	}
    	catch(Exception e1)
    	{
    		e1.printStackTrace();
    	}
    }
	
}
