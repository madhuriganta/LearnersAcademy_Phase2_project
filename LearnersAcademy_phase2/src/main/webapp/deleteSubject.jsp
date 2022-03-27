<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="text-align:center">
<br><br>

  <%
	  Connection con=DBConnection.getConnection();
	  String subID=request.getParameter("subId");
	  Statement stmt=con.createStatement();
	  String query="delete from Subject where subId= '"+subID+"'";
	  //ResultSet rs=stmt.executeQuery(query);
	  
	  String msg = "";
	  try {
		  ResultSet rs=stmt.executeQuery(query);
		  
		  RequestDispatcher rd=request.getRequestDispatcher("/subjectPage.jsp");
	  	rd.forward(request, response);
	  } catch(Exception e) {
		  msg = e.getMessage();
	  }
	      	      
  %>
  
  <h2><%=msg %></h2>
  <a href="subjectPage.jsp" class="btn btn-dark" style="float:center"> Go Back</a>
  </body>
  </html>

