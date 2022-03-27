<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.madhuri.LearnerAcademy.bean.StudentBean" %>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Student Details</h3>
<hr>
<%
	StudentBean bean=(StudentBean) request.getAttribute("stdObj");
%>
<table align="center" border="1">
			<tr>
				<td>StdID:</td>
				<td><%= bean.getSID() %></td>
			</tr>
			<tr>
				<td>StdName:</td>
				<td><%= bean.getStudentName() %></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><%= bean.getGender() %></td>
			</tr>
			<tr>
				<td>StdClass:</td>
				<td><%= bean.getStudentClass() %></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><%= bean.getAge() %></td>
			</tr>
			
		</table>
</body>
</html>