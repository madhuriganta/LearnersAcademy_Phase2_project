<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
        
        font-size:100px; /* Create scrollbar to test positioning */
    }
</style>
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="Home.jsp" style="font-size:x-large">Learner's Academy</a>
                <a href="student.jsp">Students</a>
                <a href="Teachers.jsp">Teachers</a>
                <a href="classesPage.jsp">Classes</a>
                <a href="subjectPage.jsp">Subjects</a>
                <a href="classReport.jsp">ClassReport</a>
                <a href="Login.jsp" style="float:right">Logout</a>
                
            </nav>
        </div>
    </div>
    <div class="container">
     
    <div class="container">
    <p>Welcome to Learner's Academy</p>
    
    </div> 
    
    </div>    
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2200 Learner's Academy</div>        
    </div>
</body>
</html>