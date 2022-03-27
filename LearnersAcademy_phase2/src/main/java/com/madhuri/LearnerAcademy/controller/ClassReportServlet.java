package com.madhuri.LearnerAcademy.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.madhuri.LearnerAcademy.bean.ClassReport;
import com.madhuri.LearnerAcademy.bean.StudentBean;
import com.madhuri.LearnerAcademy.services.AdminService;

/**
 * Servlet implementation class ClassReportServlet
 */
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dopost from ClassReport");
		AdminService service=new AdminService();
		String buttonValue=request.getParameter("button");
		if(buttonValue.equalsIgnoreCase("FindAll"))
		{
			List<ClassReport> list=service.getClassReport();
			if(list == null )
		    {
		   	RequestDispatcher rd=request.getRequestDispatcher("/Failure.html");
		   	rd.forward(request, response);
		    }else {
		   	request.setAttribute("listOfClsRtObj", list);
		   	System.out.println("Studentlist "+ list.size());
		   	RequestDispatcher rd=request.getRequestDispatcher("/classReport.jsp");
		   	rd.forward(request, response);
		   }
		}
	}
}

