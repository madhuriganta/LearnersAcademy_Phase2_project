package com.madhuri.LearnerAcademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madhuri.LearnerAcademy.bean.ClassesBean;

import com.madhuri.LearnerAcademy.services.AdminService;

/**
 * Servlet implementation class ClassesServlet
 */
public class ClassesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget from ClassesServlet");
		AdminService service=new AdminService();
		String buttonValue=request.getParameter("button");
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			String cId=request.getParameter("cId");
			String section=request.getParameter("section"); 
			String teacher=request.getParameter("teacher"); 
			String subject=request.getParameter("subject"); 
			
			ClassesBean bean=new ClassesBean();
			bean.setId(cId);
			bean.setSection(section);
			bean.setSubject(subject);
			bean.setTeacher(teacher);
			
		    boolean insertStatus=service.saveClasses(bean);
			    if(insertStatus == true)
			    {
			    	RequestDispatcher rd=request.getRequestDispatcher("/classesPage.jsp");
			    	rd.forward(request, response);
			    }else {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
			    	rd.forward(request, response);
			    }
		    	
			}else if(buttonValue.equalsIgnoreCase("Update")) {
				System.out.println("cid"+request.getParameter("cId"));
				
				String cId=request.getParameter("cId");
				String section=request.getParameter("section"); 
				String teacher=request.getParameter("teacher"); 
				String subject=request.getParameter("subject"); 
			
				ClassesBean bean=new ClassesBean();
				bean.setId(cId);
				bean.setSection(section);
				bean.setSubject(subject);
				bean.setTeacher(teacher);
				
				boolean insertStatus=service.updateClass(bean);
				if(insertStatus == true)
				 {
				    	RequestDispatcher rd=request.getRequestDispatcher("/classesPage.jsp");
				    	rd.forward(request, response);
				 }else {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
				    	rd.forward(request, response);
				 }
	
			
			}else if(buttonValue.equalsIgnoreCase("Delete"))
			{
				String cId=request.getParameter("cId");
				int value=service.deleteClasses(cId);
				if(value > 0 )
				{
				    	RequestDispatcher rd=request.getRequestDispatcher("/classesPage.jsp");
				    	rd.forward(request, response);
				 }else {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
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
