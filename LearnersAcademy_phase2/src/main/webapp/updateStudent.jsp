<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.madhuri.LearnerAcademy.bean.StudentBean" %>
    <%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
    <%@page import="java.sql.*"%>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.PreparedStatement" %>;
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="float:center">
<br><br>
	<form id="form" method="get" action="StudentServlet" class="form-horizontal">
			<%
           		Connection con=DBConnection.getConnection();
                String stdID=request.getParameter("sid");
	            Statement stmt=con.createStatement();
	    		String query="select * from student where sId='"+stdID+"'";
	    		ResultSet rs=stmt.executeQuery(query);
	            while(rs.next())
	             {
        
            
            %>
			
         	<div class="form-group">
                <div  class="col-sm-4"></div>
                <div  class="col-sm-4 mx-auto">
                    <h2 style="text-align: center">Student Details</h2>
                </div>
            </div>
            <hr/>
           

            <div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >StudentId</label>
  					<input type="text" name="sid" class="form-control" id="sid" value="<%= rs.getString("sid")%>" readonly="readonly" >
                  </div>
			</div>
                        
			<div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >StudentName</label>
  					<input type="text" name="sname" class="form-control" id="sname" value="<%= rs.getString("studentname")%>" >
                  </div>
			</div>
			<div class="form-group">
                     <div  class="col-sm-4 mx-auto">
                        <label>Gender</label>
  				    	<input type="text" name="gender" class="form-control" id="gender" value="<%= rs.getString("gender")%>">
                     </div>
			</div>
			<div class="form-group">
                  <div  class="col-sm-4 mx-auto">
                  	<label>StudentClass</label>
  					<input type="text" name="stdClass" class="form-control" id="stdClass" value="<%= rs.getString("studentclass")%>">
                  </div>
			</div>
			
			<div class="form-group">
                    <div  class="col-sm-4 mx-auto">
                        <label>Age</label>
  						<input type="text" name="age" class="form-control" id="age" value="<%= rs.getInt("age")%>">
                    </div>
			</div>
			 <div class="form-group">
                     <div  class="col-sm-2 mx-auto">
                   		<input type="submit" id="submit" name="button" value="Update" class="btn btn-dark">
					                   
                     </div>
			</div>
			<%
				}
			%>
			 
                       
        </form>
		
</body>
</html>