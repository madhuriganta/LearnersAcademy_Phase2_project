<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
<%@page import="java.sql.*" %>
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
      System.out.println(request.getParameter("regno"));
	  String regNo=request.getParameter("regno");
	  Statement stmt=con.createStatement();
	  String query="delete from teacher where regno= '"+regNo+"'";
	  String msg = "";
	  try {
		  ResultSet rs=stmt.executeQuery(query);
		  
		  RequestDispatcher rd=request.getRequestDispatcher("/Teachers.jsp");
	  	rd.forward(request, response);
	  } catch(Exception e) {
		  msg = e.getMessage();
	  }
	      
  %>
  
  <h2><%=msg %></h2>
  <a href="subjectPage.jsp" class="btn btn-dark" style="float:center"> Go Back</a>
  </body>
  </html>