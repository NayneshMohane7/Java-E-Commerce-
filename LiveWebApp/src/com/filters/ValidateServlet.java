package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class ValidateServlet implements Filter {
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

   
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		if(name.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
			rd.include(request, response);
			out.println("Username cannot be empty");
		}
		else if(pass.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
			rd.include(request, response);
			out.println("Password cannot be empty");

		}
		else if(pass.length()<3)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
			rd.include(request, response);
			out.println("Password must be at least 3 characters");

		}
		else
		    chain.doFilter(request, response);
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}


	

}
