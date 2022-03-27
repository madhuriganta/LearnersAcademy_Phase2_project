package com.madhuri.LearnerAcademy.controller;

//import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.madhuri.LearnerAcademy.bean.TeachersBean;
import com.madhuri.LearnerAcademy.services.AdminService;

/**
 * Servlet implementation class TeacherServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget from TeachersServlet");
		AdminService service=new AdminService();
		String buttonValue=request.getParameter("button");
		
		if(buttonValue.equalsIgnoreCase("save"))
		{
			System.out.println("regno"+request.getParameter("regno"));
			
			String regNo=request.getParameter("regno");
			
			String tName=request.getParameter("tname"); 
			String subject=request.getParameter("subject"); 
			String address=request.getParameter("address"); 
			System.out.println("phone"+request.getParameter("phone"));
			int phone=Integer.parseInt(request.getParameter("phone")); 
			TeachersBean bean=new TeachersBean();
			bean.setRegno(regNo);
			bean.setTname(tName);
			bean.setSubject(subject);
		    bean.setAddress(address);
		    bean.setPhone(phone);

		    boolean insertStatus=service.saveTeacher(bean);
			    if(insertStatus == true)
			    {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Teachers.jsp");
			    	rd.forward(request, response);
			    }else {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
			    	rd.forward(request, response);
			    }
		    	
			}else if(buttonValue.equalsIgnoreCase("Update")) {
				
			     	String regNo=request.getParameter("regno");
					String tName=request.getParameter("tname"); 
					String subject=request.getParameter("subject"); 
					String address=request.getParameter("address"); 
					int phone=Integer.parseInt(request.getParameter("phone")); 
					
					TeachersBean bean=new TeachersBean();
					bean.setRegno(regNo);
					bean.setTname(tName);
					bean.setSubject(subject);
				    bean.setAddress(address);
				    bean.setPhone(phone);	
				    boolean insertStatus=service.updateTeacher(bean);
				    if(insertStatus == true)
				    {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Teachers.jsp");
				    	rd.forward(request, response);
				    }else {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
				    	rd.forward(request, response);
				    }
	
			
			}
			else if(buttonValue.equalsIgnoreCase("Delete"))
			{
				    String regNo=request.getParameter("regno");
					int value=service.deleteStudent(regNo);
					if(value > 0 )
					{
					    	RequestDispatcher rd=request.getRequestDispatcher("/Teachers.jsp");
					    	rd.forward(request, response);
					 }else {
					    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
					    	rd.forward(request, response);
					 }
					
			}else if(buttonValue.equalsIgnoreCase("Find"))
			{
				String regNo=request.getParameter("regno");
				TeachersBean bean=service.findTeacherById(regNo);
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
				 List<TeachersBean> list=service.findAllTeachers();
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

		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
