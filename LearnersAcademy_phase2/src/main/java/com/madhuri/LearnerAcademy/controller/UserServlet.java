package com.madhuri.LearnerAcademy.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.madhuri.LearnerAcademy.bean.UserBean;
import com.madhuri.LearnerAcademy.services.UserService;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");  
//        PrintWriter out=response.getWriter();  
//          
//        request.getRequestDispatcher("home.html").include(request, response);  
          
        HttpSession session=request.getSession();  
        session.invalidate();  
		
//		HttpSession session=request.getSession();
//		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post of UserServlet ");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean beanFromUser=new UserBean();
		beanFromUser.setUsrname(userName);
		beanFromUser.setPassword(password);
		
		UserService service=new UserService();
		String type= service.login(beanFromUser);
		HttpSession session = request.getSession();
		
		if(type == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/LoginError.html");
			rd.forward(request, response);
		}else if(type.equals("student"))
		{
			session.setAttribute("userName", userName);
			RequestDispatcher rd=request.getRequestDispatcher("/StudentHome.html");
			rd.forward(request, response);
		}else if(type.equals("admin"))
		{
			session.setAttribute("userName", userName);
			RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
			
		}
		
	
		
	}

}
