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
<title>Classes page</title>

	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<br>
<a href="Home.jsp" class="btn btn-dark" style="float:right">Home</a>
	<h2>Add Classes</h2>
	<hr>
	<br>
	<div class="row">
		<div class="col-sm-4">
		<form  method="get" action="ClassesServlet">
			<div >
				<label class="form-label">Class Id</label>
				<input type="text" class="form-control"  name="cId" id="cId" requried>
			
			</div>
		
			<div >
				<label class="form-label">Section</label>
				<input type="text" class="form-control" name="section" id="section" requried>
			
			</div>
			<div >
				<label class="form-label">Teacher</label>
				<input type="text" class="form-control"  name="teacher" id="teacher" requried>
			
			</div>
			<div >
				<label class="form-label">Subject</label>
				<input type="text" class="form-control"  name="subject" id="subject" requried>
			
			</div>
			<br>
			<div >
				<input type="submit" id="submit" name="button" value="Save" class="btn btn-dark">
				<input type="reset" id="reset" name="reset" value="Reset" class="btn btn-dark">
			
				
			</div>
			
		</form>
		
		</div>
		<div class="col-sm-8">
			<div class="panel-body">
				<table id="tb1-student" class="table table reponsive table-bordered" cellpadding="0" width="100">
					<thead>
						<tr>
							<th>Class Id</th>
							<th>Section</th>
							<th>Teacher</th>
							<th>Subject</th>
							
							
							<th colspan="2">Action</th>
						</tr>
						<%
							ResultSet rs;
							Connection con=DBConnection.getConnection();
							Statement stmt=con.createStatement();
							String query="select * from classes";
							rs = stmt.executeQuery(query);
							while(rs.next())
							{
						
						%>
						
								<tr>
									<td><%=rs.getString("id") %></td>
									<td><%=rs.getString("section") %></td>
									<td><%=rs.getString("teacher") %></td>
									<td><%=rs.getString("subject") %></td>
									<td><a href="updateClasses.jsp?id=<%=rs.getString("id")%>">Edit</a></td>
									<td><a href="DeleteClasses.jsp?id=<%=rs.getString("id")%>" >Delete</a></td>
									
								</tr>
						<%
							}
						%>
						
						
					
					</thead>
					
				
				</table>
			
			</div>
		
		</div>
	</div>
</body>
</html>