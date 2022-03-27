package com.madhuri.LearnerAcademy.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.madhuri.LearnerAcademy.bean.SubjectBean;
import com.madhuri.LearnerAcademy.services.AdminService;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost from subjectservlet");
		AdminService service=new AdminService();
		String buttonValue=request.getParameter("button");
		if(buttonValue.equalsIgnoreCase("save"))
		{
			String subId=request.getParameter("subId");
			String subject=request.getParameter("subject"); 
			
			SubjectBean bean=new SubjectBean();
			bean.setSubId(subId);
			bean.setSubject(subject);
			
		    boolean insertStatus=service.saveSubject(bean);
		    if(insertStatus == true)
			    {
			    	RequestDispatcher rd=request.getRequestDispatcher("/subjectPage.jsp");
			    	rd.forward(request, response);
			    }else {
			    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
			    	rd.forward(request, response);
			    }
		    	
			}else if(buttonValue.equalsIgnoreCase("Update")) {
				
					System.out.println("subID"+ request.getParameter("subId"));
					String subId=request.getParameter("subId");
					String subject=request.getParameter("subject"); 
					SubjectBean bean=new SubjectBean();
					
					bean.setSubject(subject);
					bean.setSubId(subId);
				    boolean insertStatus=service.updateSubject(bean);
				    if(insertStatus == true)
				    {
				    	RequestDispatcher rd=request.getRequestDispatcher("/subjectPage.jsp");
				    	rd.forward(request, response);
				    }else {
				    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
				    	rd.forward(request, response);
				    }
	
			
			}
			else if(buttonValue.equalsIgnoreCase("Delete"))
			{
				String subId=request.getParameter("subId");
					int value=service.deleteSubject(subId);
					if(value > 0 )
					{
					    	RequestDispatcher rd=request.getRequestDispatcher("/subjectPage.jsp");
					    	rd.forward(request, response);
					 }else {
					    	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
					    	rd.forward(request, response);
					 }
					
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
