<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.madhuri.LearnerAcademy.bean.StudentBean" %>
<%@page import="java.util.List" %>
<%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
<%@page import="java.sql.ResultSet" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="float:center">
<br>
<a href="Home.jsp" class="btn btn-dark" style="float:right">Home</a>
<form style="float:center" action="ClassReportServlet" method="post">
	<h2 >Class Report</h2>
	<hr>
	<br>
	
		<div class="col-sm-8">
			<div class="panel-body">
				<table id="tb1-student" class="table table reponsive table-bordered" cellpadding="0" width="100">
					<thead>
						<tr>
							<th>Class</th>
							<th>StudentName</th>
							<th>Subject</th>
							<th>Teacher</th>
							
						</tr>
						<%
							ResultSet rs;
							Connection con=DBConnection.getConnection();
							Statement stmt=con.createStatement();
							String query=" select s.studentName, c.section, t.tName, su.subject from\r\n"
									+ "student s,\r\n"
									+ "classes c,\r\n"
									+ "teacher t,\r\n"
									+ "subject su\r\n"
									+ "where s.StudentClass = c.id\r\n"
									+ "AND    c.teacher = t.regNo\r\n"
									+ "AND c.subject = su.subid\r\n" ;
							rs = stmt.executeQuery(query);
							while(rs.next())
							{
						
						%>
						
						<tr>					
							<td><%=rs.getString("studentname") %></td>
							<td><%=rs.getString("section") %></td>
							<td><%=rs.getString("tname") %></td>
							<td><%=rs.getString("subject") %></td>
																	
						</tr>
						<%
							}
						%>
							
											
					
					</thead>
					
				
				</table>
			
			</div>
		
		</div>
		</form>
	

</body>
</html>