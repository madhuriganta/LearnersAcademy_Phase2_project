package com.madhuri.LearnerAcademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madhuri.LearnerAcademy.bean.StudentBean;
import com.madhuri.LearnerAcademy.services.AdminService;


public class StudentServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget from studentservlet");
		AdminService service=new AdminService();
		String buttonValue=request.getParameter("button");
		if(buttonValue.equalsIgnoreCase("save"))
		{
			String stdID=request.getParameter("stdId");
			String StdName=request.getParameter("sname"); 
			String gender=request.getParameter("gender"); 
			String StdClass=request.getParameter("stdClass"); 
			int age=Integer.parseInt(request.getParameter("age")); 
			StudentBean bean=new StudentBean();
			bean.setSID(stdID);
			bean.setStudentName(StdName);
			bean.setGender(gender);
			bean.setStudentClass(StdClass);
			bean.setAge(age);	
		    boolean insertStatus=service.saveStudent(bean);
		    if(insertStatus == true)
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("/student.jsp");
		    	rd.forward(request, response);
		    }else {
		    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
		    	rd.forward(request, response);
		    }
		    	
			}else if(buttonValue.equalsIgnoreCase("Update")) {
				
					
				    String stdID=request.getParameter("stdId");
					String StdName=request.getParameter("sname"); 
					String gender=request.getParameter("gender"); 
					String StdClass=request.getParameter("stdClass"); 
					int age=Integer.parseInt(request.getParameter("age"));
					
					StudentBean bean=new StudentBean();
					bean.setSID(stdID);
					bean.setStudentClass(StdClass);
					bean.setGender(gender);
				    bean.setStudentName(StdName);
				    bean.setAge(age);
				    boolean insertStatus=service.updateStudent(bean);
				    if(insertStatus == true)
				    {
				    	RequestDispatcher rd=request.getRequestDispatcher("/student.jsp");
				    	rd.forward(request, response);
				    }else {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
				    	rd.forward(request, response);
				    }
	
			
			}
			else if(buttonValue.equalsIgnoreCase("Delete"))
			{
				   String stdID=request.getParameter("stdId");
					int value=service.deleteStudent(stdID);
					if(value > 0 )
					{
					    	RequestDispatcher rd=request.getRequestDispatcher("/student.jsp");
					    	rd.forward(request, response);
					 }else {
					    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
					    	rd.forward(request, response);
					 }
					
			}else if(buttonValue.equalsIgnoreCase("Find"))
			{
				String stdID=request.getParameter("stdId");
				StudentBean bean=service.findStudentById(stdID);
				if(bean == null )
			    {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
			    	rd.forward(request, response);
			    }else {
			    	request.setAttribute("stdObj", bean);
			    	RequestDispatcher rd=request.getRequestDispatcher("/ViewStudentDetails.jsp");
			    	rd.forward(request, response);
			    }
			
			}else if(buttonValue.equalsIgnoreCase("FindAll")) {
				 List<StudentBean> list=service.findAllStudents();
				 if(list == null )
			     {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
			    	rd.forward(request, response);
			     }else {
			    	request.setAttribute("listOfStdObj", list);
			    	System.out.println("Studentlist "+ list.size());
			    	RequestDispatcher rd=request.getRequestDispatcher("/student.jsp");
			    	rd.forward(request, response);
			    }
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
		

}
