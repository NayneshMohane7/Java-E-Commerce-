<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" session="true"%>
    
<html>
   <h1>Your Cart Details are</h1>
</html>


<%
        String username=(String)session.getAttribute("user");
        ArrayList list=(ArrayList)session.getAttribute("item1");
        ArrayList list1=(ArrayList)session.getAttribute("price");
        int total=(Integer)session.getAttribute("totalPrice");
        
        out.println("Welcome User..."+username);
        out.println("you have purchased ...."+list);
        out.println("<P>your cart value is...</P>"+list1);
        out.println("<P>you have to pay Rs.....</P>"+total+" only");


        
        
   
%>

<a href='http://localhost:8081/LiveWebApp/PayPage.jsp'>Please pay the bill</a>