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
<title>Update Subject</title>
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="float:center">
<br><br>
	<form id="form" method="get" action="SubjectServlet" class="form-horizontal">
			<%
           		Connection con=DBConnection.getConnection();
                String subID=request.getParameter("subId");
	            Statement stmt=con.createStatement();
	    		String query="select * from subject where subId= '"+subID+"'";
	    		ResultSet rs=stmt.executeQuery(query);
	            while(rs.next())
	             {
        
            
            %>
			
         	<div class="form-group">
                <div  class="col-sm-4"></div>
                <div  class="col-sm-4 mx-auto">
                    <h2 style="text-align: center">Subject Update</h2>
                </div>
            </div>
            <hr/>
           

            <div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >Subject ID</label>
  					<input type="text" name="subId" class="form-control" id="subid" value="<%= rs.getString("subId")%>" readonly="readonly" >
                  </div>
			</div>
                        
			<div class="form-group">
                
                  <div  class="col-sm-4 mx-auto">
                  	<label >Subject</label>
  					<input type="text" name="subject" class="form-control" id="subject" value="<%= rs.getString("subject")%>" >
                  </div>
			</div>
			<
			 <div class="form-group">
                     <div  class="col-sm-4 mx-auto">
                   	<input type="submit" id="submit" name="button" value="Update" class="btn btn-dark">
					
                        
                     </div>
			</div>
			<%
				}
			%>
			 
                       
        </form>
		
</body>
</html>