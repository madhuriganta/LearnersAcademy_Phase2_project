
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.logging.Level" %>
<%@page import="java.util.logging.Logger" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.madhuri.LearnerAcademy.util.DBConnection" %>
<%@page import="java.sql.*"%>

<%@page import="com.madhuri.LearnerAcademy.bean.TeachersBean" %>

<html>
    <head>    
        <title>Teacher Update</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
    <form id="form" method="get" action="TeacherServlet" >
    <%
    
           		Connection con=DBConnection.getConnection();
    			System.out.println("regno"+ request.getParameter("regno"));
                String regNo=request.getParameter("regno");
	            Statement stmt=con.createStatement();
	    		String query="select * from teacher where regno= '" +regNo+"'";
	    		System.out.println("Query"+ query);
	    		ResultSet rs=stmt.executeQuery(query);
	    		rs.next();
	    		System.out.println("result set: "+ rs.getRow());
            
            %>
			<br><br>
         	<div class="form-group">
                <div  class="col-sm-4"></div>
                <div  class="col-sm-4 mx-auto">
                    <h2 style="text-align: center">Teacher Details</h2>
                </div>
            </div>
            <hr/>
            
         
            <div class="form-group">
                
                 <div  class="col-sm-4 mx-auto">
	                  	<label>Registration No</label>
	  					<input type="text" name="regno" class="form-control" id="regno"  value=<%= rs.getString("regno") %> readonly="readonly">
                 </div>
			</div>
			<div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >Teacher Name</label>
  					<input type="text" name="tname" class="form-control" id="tname" value=<%= rs.getString("tname") %>>
                  </div>
			</div>
			<div class="form-group">
                  <div  class="col-sm-4 mx-auto">
                  	<label>Subject</label>
  					<input type="text" name="subject" class="form-control" id="subject" value=<%=rs.getString("subject") %>>
                  </div>
			</div>
			<div class="form-group">
                    <div  class="col-sm-4 mx-auto">
                        <label>Address</label>
  						<input type="text" name="address" class="form-control" id="address" value=<%= rs.getString("address") %>>
                    </div>
			</div>
            
			<div class="form-group">
                     <div  class="col-sm-4 mx-auto">
                        <label>Phone</label>
  				    	<input type="text" name="phone" class="form-control" id="phone" value=<%=rs.getInt("phone") %>>
                     </div>
			</div>
			
			 
			 <div class="form-group">
                     <div  class="col-sm-2 mx-auto">
	                     <input type="reset" id="reset" name="reset" value="Reset" class="btn btn-dark">	
						 <input type="submit" id="submit" name="button" value="Update" class="btn btn-dark">
						                     
                     </div>
			</div>
			 
                       
        </form>
		
     
    </body>
</html>
