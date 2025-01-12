package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.provider.ObjectCreator;
import com.services.LoginServices;
import com.servicesimpl.LoginServicesImpl;


public class ControllerServlet extends HttpServlet {
	Connection con;
	ArrayList item;
	ArrayList price1;
	
	public void init()
	{
		item=new ArrayList <String>();
		price1=new ArrayList<Integer>();
		con=(Connection) getServletConfig().getServletContext().getAttribute("DbCon");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		  
		LoginServices service=new LoginServicesImpl();
		service.setConnection(con);
		String gadget=null;
		int netPrice=0;
		int sum=0;
		
		
	
		
		String page=request.getParameter("page");
		
		if(page.equals("signup"))
	    {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//String sqn=request.getParameter("sqn");
			
			try
			{ 
				if(service.signup(username, password))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
					rd.forward(request, response);
				}
				else
				{
					out.println("username already exists ....please try again");
				}
					
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(page.equals("signin"))
		{
			String username=(String) request.getAttribute("user");
			String password=request.getParameter("password");
			try
			{
				if(service.LogIn(username, password))
				{
					HttpSession session=request.getSession(true);
				    session.setAttribute("user", username);
					
					RequestDispatcher rd=request.getRequestDispatcher("/Gadgets.html");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
					rd.include(request, response);
					out.println("Invalid credentials ....Try Again");
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(page.equals("mobile") || page.equals("laptop") || page.equals("hp"))
		{
			if(page.equals("mobile"))
			{
				gadget="phones";
			}
			if(page.equals("laptop"))
			{
				gadget="laptops";
			}
			if(page.equals("hp"))
			{
				gadget="headphones";
			}
			
			String gadType=request.getParameter(gadget);
			item.add(gadType);
			int gadPrice=service.price(gadType);
			price1.add(gadPrice);
			
			Iterator itr=price1.iterator();//getting the iteration
			  while(itr.hasNext())
			  {
				  sum=(int) itr.next();
				  netPrice=netPrice+sum;
			  }
			  
			HttpSession session=request.getSession(false);
			session.setAttribute("item1",item);
			session.setAttribute("price",price1);
			session.setAttribute("totalPrice", netPrice);
			
			RequestDispatcher rd= request.getRequestDispatcher("/BillingPage.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
