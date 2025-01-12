<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
   
    
    String gadget=request.getParameter("gadgets");
		if(gadget.equals("mobile"))
		{
			//RequestDispatcher rd=request.getRequestDispatcher("/Mobile.jsp");
			//rd.forward(request, response);
%>
			<jsp:forward page="Mobile.jsp"/>;
<% 		}
		if(gadget.equals("laptop"))
		{
			//RequestDispatcher rd=request.getRequestDispatcher("/Laptop.jsp");
			//rd.forward(request, response);
%>
			<jsp:forward page="Page1.jsp"/>;
<% 		}
		if(gadget.equals("headphone"))
		{
			//RequestDispatcher rd=request.getRequestDispatcher("/Headphones.jsp");
			//rd.forward(request, response);
%>
			<jsp:forward page="Page1.jsp"/>;
<% 		}
%>
		