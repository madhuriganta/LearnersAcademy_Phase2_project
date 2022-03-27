<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<style>
    /* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
    body{        
        padding-top: 60px;
        padding-bottom: 40px;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    .fixed-header {
        width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
    }
    .fixed-footer{
       width: 100%;
        position: fixed;        
        background: #333;
        padding: 10px 0;
        color: #fff;
        text-align:center;
    
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }    
    /* Some more styles to beutify this example */
    nav a{
        color: #fff;
        text-decoration: none;
        padding: 7px 25px;
        display: inline-block;
    }
    .container p{
        line-height: 200px; /* Create scrollbar to test positioning */
    }
</style>
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="#" style="font-size:x-large">Learner's Academy</a>
               
                            
            </nav>
        </div>
    </div>
    <div class="container">
    <br><br><br>
    <form action="UserServlet" method="post">
    <h2 class="col-sm-4 mx-auto">Admin Login!</h2>
    <br>
    		<div class="form-group">
                    <div  class="col-sm-4 mx-auto">
                     	<input type="text" name="username" class="form-control" id="username" placeholder="Username">
                    </div>
			</div>
            
			<div class="form-group">
                     <div  class="col-sm-4 mx-auto">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                     </div>
			</div>
			 
			 <div class="form-group">
                     <div  class="col-sm-2 mx-auto">
                     	
                     	<input type="submit" id="submit" name="button" value="Login" class="btn btn-dark">
			       </div>
			</div>
			 
    </form>
  
    
    </div> 
       
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2022  Learner's Academy</div>        
    </div>
</body>
</html>