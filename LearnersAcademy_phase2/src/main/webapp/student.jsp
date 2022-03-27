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
<body>
<br>
<a href="Home.jsp" class="btn btn-dark" style="float:right">Home</a>
	<h2 >Student Registration</h2>
	<hr>
	<br>
	<div class="row">
		<div class="col-sm-4">
		<form  method="get" action="StudentServlet">
			<div >
				<label class="form-label">StudentId</label>
				<input type="text" class="form-control"  name="stdId" id="stdId" requried>
			
			</div>
		
			<div >
				<label class="form-label">StudentName</label>
				<input type="text" class="form-control" name="sname" id="sname" requried>
			
			</div>
			<div >
				<label class="form-label">StudentClass</label>
				<input type="text" class="form-control"  name="stdClass" id="sclass" requried>
			
			</div>
			<div >
				<label class="form-label">Age</label>
				<input type="text" class="form-control"  name="age" id="age" requried>
			
			</div>
			<div align="left">
				<label class="form-label">Gender</label>
				<input type="text" class="form-control"  name="gender" id="gender" requried>
			
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
							<th>StdID</th>
							<th>StdName</th>
							<th>Age</th>
							<th>StdClass</th>
							<th>Gender</th>
							
							<th colspan="2">Action</th>
						</tr>
						<%
							ResultSet rs;
							Connection con=DBConnection.getConnection();
							Statement stmt=con.createStatement();
							String query="select * from student";
							rs = stmt.executeQuery(query);
							while(rs.next())
							{
						
						%>
						
								<tr>
									<td><%=rs.getString("sid") %></td>
									<td><%=rs.getString("studentname") %></td>
									<td><%=rs.getString("gender") %></td>
									<td><%=rs.getString("studentclass") %></td>
									<td><%=rs.getInt("age") %></td>
									<td><a href="updateStudent.jsp?sid=<%=rs.getString("sid")%>">Edit</a></td>
									<td><a href="deleteStudent.jsp?sid=<%=rs.getString("sid")%>">Delete</a></td>
								
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