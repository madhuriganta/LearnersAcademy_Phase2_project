<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.logging.Level" %>
<%@page import="java.util.logging.Logger" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
<%@page import="java.sql.ResultSet" %>
 <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>    
        <title>Subject Update</title>
        	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<br>
	
	<a href="Home.jsp" class="btn btn-dark" style="float:right">Home</a>
	<h2>Subjects</h2>
	<br>
	<hr>
	<br>
	<div class="row">
		<div class="col-sm-4">
		<form  method="get" action="SubjectServlet" >
			<div >
				<label class="form-label">SubjectId</label>
				<input type="text" class="form-control"  name="subId" id="subId" requried>
			
			</div>
		
			<div >
				<label class="form-label">Subject</label>
				<input type="text" class="form-control" name="subject" id="subject"  requried>
			
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
							<th>SubID</th>
							<th>Subject</th>
							
													
							<th colspan="2" style="text-align:center" >Action</th>
						</tr>
						<%
							ResultSet rs;
							Connection con=DBConnection.getConnection();
							Statement stmt=con.createStatement();
							String query="select * from subject";
							rs = stmt.executeQuery(query);
							while(rs.next())
							{
						
						%>
						
								<tr>
									<td><%=rs.getString("subId") %></td>
									<td><%=rs.getString("subject") %></td>
									<td><a href="updateSubject.jsp?subId=<%=rs.getString("subId")%>">Edit</a></td>
									<td><a href="deleteSubject.jsp?subId=<%=rs.getString("subId")%>">Delete</a></td>
								
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