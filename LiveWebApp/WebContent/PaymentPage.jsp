<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>


<%
    String pin=request.getParameter("pin");
    if(pin.equals("1234"))
    {
	    out.println("order placed");
%>
        <jsp:forward page="Logout.html"/>
<% 

	
    }
    else
	    out.println("wrong pin....try again");


%>
