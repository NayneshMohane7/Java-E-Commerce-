package com.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

    
   
    public void sessionCreated(HttpSessionEvent e) {
        // TODO Auto-generated method stub
    	HttpSession session=e.getSession();
    	session.setMaxInactiveInterval(70);
    }

	
    public void sessionDestroyed(HttpSessionEvent e) {
        // TODO Auto-generated method stub
    }
	
}
