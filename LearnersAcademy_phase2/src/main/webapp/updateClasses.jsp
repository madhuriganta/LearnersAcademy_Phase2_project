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
    <form id="form" method="get" action="ClassesServlet" >
    <%
    
           		Connection con=DBConnection.getConnection();
    			System.out.println("id"+ request.getParameter("cId"));
    			String id=request.getParameter("id");
	            Statement stmt=con.createStatement();
	    		String query="select * from classes where id= '" +id+"'";
	    		System.out.println("Queery"+ query);
	    		ResultSet rs=stmt.executeQuery(query);
	    		rs.next();
	    		System.out.println("result set: "+ rs.getRow());
            
            %>
			
         	<div class="form-group">
                <div  class="col-sm-4"></div>
                <div  class="col-sm-4 mx-auto">
                    <h2 style="text-align: center">Classes Update</h2>
                </div>
            </div>
            <hr/>
            
         
            <div class="form-group">
                
                 <div  class="col-sm-4 mx-auto">
	                  	<label>Class Id</label>
	  					<input type="text" name="cId" class="form-control" id="cId"  value=<%= rs.getString("id") %> readonly="readonly">
                 </div>
			</div>
			<div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >Section</label>
  					<input type="text" name="section" class="form-control" id="section" value=<%= rs.getString("section") %>>
                  </div>
			</div>
			<div class="form-group">
                  <div  class="col-sm-4 mx-auto">
                  	<label>Teacher</label>
  					<input type="text" name="teacher" class="form-control" id="teacher" value=<%=rs.getString("teacher") %>>
                  </div>
			</div>
			<div class="form-group">
                    <div  class="col-sm-4 mx-auto">
                        <label>Subject</label>
  						<input type="text" name="subject" class="form-control" id="subject" value=<%= rs.getString("subject") %>>
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
