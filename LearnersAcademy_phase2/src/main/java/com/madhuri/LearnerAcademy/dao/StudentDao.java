 package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.madhuri.LearnerAcademy.bean.StudentBean;
import com.madhuri.LearnerAcademy.util.DBConnection;



public class StudentDao {
	public boolean insertStudent(StudentBean bean)
	{ 
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
			String query="insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getSID() );
			pstmt.setString(2, bean.getStudentName());
			pstmt.setString(4, bean.getStudentClass());
			pstmt.setInt(5, bean.getAge());
			pstmt.setString(3,bean.getGender());
			System.out.println("Query is:"+ query);
			int value =pstmt.executeUpdate();
			if(value>0) {
				insertStatus=true;
			}
			
			System.out.println("Rows impacted: "+value);
			
			
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return insertStatus;
		
	}
	public StudentBean getStudentById(String sId)
	{
		StudentBean bean=new StudentBean();
		try {
		
		Connection con= DBConnection.getConnection(); 
		Statement stmt=con.createStatement();
		String query="select * from student where sId="+sId;
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{
			bean.setSID(rs.getString(1));
			bean.setStudentName(rs.getString(2));
			bean.setGender(rs.getString(3));
			bean.setStudentClass(rs.getString(4));
			bean.setAge(rs.getInt(5));
		}else {
			bean=null;
		}
	
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return bean;
		
		
	}
	public List<StudentBean> getAllStudents()
	{
		List<StudentBean> listOfStudents=new ArrayList<StudentBean>();
		try {
				Connection con=DBConnection.getConnection();
				Statement stmt=con.createStatement();
				String query="select * from student";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					StudentBean bean =new StudentBean();
					bean.setSID(rs.getString(1));
					bean.setStudentName(rs.getString(2));
					bean.setGender(rs.getString(3));
					bean.setStudentClass(rs.getString(4));
					bean.setAge(rs.getInt(5));
					listOfStudents.add(bean);
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			return listOfStudents;
		
	}
	public  int deleteStudentById(String sId) {
		int deleteCount=0;
		try {
			Connection con=DBConnection.getConnection();
			// Statement stmt=con.createStatement();
			String query="delete student where sId=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, sId);
			deleteCount =pstmt.executeUpdate();
			System.out.println("Rows Impacted :"+deleteCount);
			 
		} catch (Exception ex){
			ex.printStackTrace();
			
		}
		return deleteCount;
		
	}
	public boolean updateStudentById(StudentBean bean)
	{
		boolean updateStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
		    String query="update student set studentname=?, gender=?,studentclass=?,age=? where sid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, bean.getStudentName());
			pstmt.setString(2, bean.getGender());
			pstmt.setString(3, bean.getStudentClass());
			pstmt.setInt(4,bean.getAge());
			pstmt.setString(5, bean.getSID() );
			System.out.println("Query is:"+ query);
			int value =pstmt.executeUpdate();
			if(value>0) {
				updateStatus=true;
			}
			
			System.out.println("Rows impacted: "+value);
			
			
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return updateStatus;
		
				
	}
	public static void main(String[] args)
	{
		StudentBean bean = new StudentBean();
		bean.setSID("123");
		bean.setStudentName("Madhuri Ganta");
		bean.setStudentClass("10E");
		bean.setAge(15);
		bean.setGender("Female");
		System.out.println(new StudentDao().updateStudentById(bean));
		
	}

}
