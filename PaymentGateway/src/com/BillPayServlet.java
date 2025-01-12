package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillPayServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String amount=request.getParameter("amount");
		String pin=request.getParameter("pin");
		
		String cpin="java";
		if(pin.equals(cpin))
		{
			out.println("<html>");
			
			out.println("<center>");
			
			
			out.println("ORDER PLACED............");
			out.println("<br> <br>");
			out.println("<a href='http://localhost:8080/webApllicationTest/Gadgets.html'>Home Page..</a> <br> <br>");
			out.println("<a href='http://localhost:8080/webApllicationTest/Logout.html'>Want To Log-Out ?</a> ");
			
			out.println("</center>");
			out.println("</html>");
		}
		
		else{
			
			RequestDispatcher rd=request.getRequestDispatcher("/PaymentPage.html");
			rd.include(request, response); //include to Registration.html
			out.println("<html>");
			out.println("<center>");
			out.println("Invalid PIN..try again....");
			out.println("</center>");
			out.println("</html>");
		}	
	}
	

}
