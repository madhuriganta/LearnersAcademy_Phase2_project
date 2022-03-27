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
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<a href="Home.jsp" class="btn btn-dark" style="float:right">Home</a>
<h1>Teacher Registration</h1>
	<br>
	<div class="row">
		<div class="col-sm-4">
		<form  method="get" action="TeacherServlet">
		<div align="left">
				<label class="form-label">Registration No</label>
				<input type="text" class="form-control" name="regno" id="regno" requried>
			
			</div>
		
			<div align="left">
				<label class="form-label">Teacher Name</label>
				<input type="text" class="form-control"  name="tname" id="tname" requried>
			
			</div>
			<div align="left">
				<label class="form-label">Subject</label>
				<input type="text" class="form-control"  name="subject" id="subject" requried>
			
			</div>
			<div align="left">
				<label class="form-label">Address</label>
				<input type="text" class="form-control"  name="address" id="address" requried>
			
			</div>
			<div align="left">
				<label class="form-label">Phone</label>
				<input type="text" class="form-control"  name="phone" id="phone" requried>
			
			</div>
			<br>
			<div align="left">
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
							<th>Reg-No</th>
							<th>Teacher Name</th>
							<th>Subject</th>
							<th>Address</th>
							<th>Phone</th>
							
							<th colspan="2">Action</th>
						</tr>
						<%
							ResultSet rs;
							Connection con=DBConnection.getConnection();
							Statement stmt=con.createStatement();
							String query="select * from teacher";
							rs = stmt.executeQuery(query);
							while(rs.next())
							{
						
						%>
						
								<tr>
									<td><%=rs.getString("regno") %></td>
									<td><%=rs.getString("tname") %></td>
									<td><%=rs.getString("subject") %></td>
									<td><%=rs.getString("address") %></td>
									<td><%=rs.getInt("phone") %></td>
									<td><a href="UpdateTeacher.jsp?regno=<%=rs.getString("regno")%>">Edit</a></td>
									<td><a href="deleteTeacher.jsp?regno=<%=rs.getString("regno")%>" >Delete</a></td>
								
									
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