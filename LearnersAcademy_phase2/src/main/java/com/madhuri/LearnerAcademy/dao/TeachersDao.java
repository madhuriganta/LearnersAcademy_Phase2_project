package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.madhuri.LearnerAcademy.bean.TeachersBean;
import com.madhuri.LearnerAcademy.util.DBConnection;

public class TeachersDao {
	public boolean insertTeacher(TeachersBean bean)
	{ 
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
			// Statement stmt=con.createStatement();
			String query="insert into teacher values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getRegno() );
			pstmt.setString(2, bean.getTname());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getAddress());
			pstmt.setInt(5,bean.getPhone());
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
	public TeachersBean getTeacherById(String tId)
	{
		TeachersBean bean=new TeachersBean();
		try {
		
		Connection con= DBConnection.getConnection(); 
		Statement stmt=con.createStatement();
		String query="select * from teacher where tId="+tId;
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{
			bean.setRegno(rs.getString(1));
			bean.setTname(rs.getString(2));
			bean.setSubject(rs.getString(3));
			bean.setAddress(rs.getString(4));
			bean.setPhone(rs.getInt(5));
		}else {
			bean=null;
		}
	
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return bean;
		
		
	}
	public List<TeachersBean> getAllTeachers()
	{
		List<TeachersBean> listOfStudents=new ArrayList<TeachersBean>();
		try {
				Connection con=DBConnection.getConnection();
				Statement stmt=con.createStatement();
				String query="select * from teacher";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					TeachersBean bean =new TeachersBean();
					bean.setRegno(rs.getString(1));
					bean.setTname(rs.getString(2));
					bean.setSubject(rs.getString(3));
					bean.setAddress(rs.getString(4));
					bean.setPhone(rs.getInt(5));
					listOfStudents.add(bean);
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			return listOfStudents;
		
	}
	public  int deleteTeacherById(String regno) {
		int deleteCount=0;
		try {
			Connection con=DBConnection.getConnection();
			String query="delete teacher where regno=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, regno);
			deleteCount =pstmt.executeUpdate();
			System.out.println("Rows Impacted :"+deleteCount);
			 
		} catch (Exception ex){
			ex.printStackTrace();
			
		}
		return deleteCount;
		
	}
	public boolean updateTeacherById(TeachersBean bean)
	{
		boolean updateStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
		    String query="update teacher set tname=?, subject=?,address=?,phone=? where regno=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, bean.getTname());
			pstmt.setString(2,bean.getSubject());
			pstmt.setString(3, bean.getAddress());
			pstmt.setInt(4, bean.getPhone() );
			pstmt.setString(5, bean.getRegno());
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

}
