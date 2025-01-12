<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
    
<%
         session.invalidate();
         //RequestDispatcher rd=request.getRequestDispatcher("/LoginPage.html");
        // rd.forward(request , response);
%>
<jsp:forward page="HomePage.html"/>

    
