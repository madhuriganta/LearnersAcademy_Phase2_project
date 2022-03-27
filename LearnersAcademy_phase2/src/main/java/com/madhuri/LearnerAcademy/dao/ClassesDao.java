package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.madhuri.LearnerAcademy.bean.ClassesBean;
import com.madhuri.LearnerAcademy.util.DBConnection;

public class ClassesDao {
		public boolean insertClass(ClassesBean bean)
		{ 
			boolean insertStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection(); 
				String query="insert into classes values(?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, bean.getId() );
				pstmt.setString(2, bean.getSection());
				pstmt.setString(3, bean.getTeacher());
				pstmt.setString(4, bean.getSubject());
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
		public ClassesBean getClassById(String cId)
		{
			ClassesBean bean=new ClassesBean();
			try {
			
			Connection con= DBConnection.getConnection(); 
			Statement stmt=con.createStatement();
			String query="select * from classes where Id="+cId;
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				bean.setId(rs.getString(1));
				bean.setSection(rs.getString(2));
				bean.setTeacher(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setTime(rs.getString(5));
			}else {
				bean=null;
			}
		
			} catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			return bean;
			
			
		}
		public List<ClassesBean> getAllClasses()
		{
			List<ClassesBean> listOfStudents=new ArrayList<ClassesBean>();
			try {
					Connection con=DBConnection.getConnection();
					Statement stmt=con.createStatement();
					String query="select * from classes";
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next())
					{
						ClassesBean bean =new ClassesBean();
						bean.setId(rs.getString(1));
						bean.setSection(rs.getString(2));
						bean.setTeacher(rs.getString(3));
						bean.setSubject(rs.getString(4));
						bean.setTime(rs.getString(5));
						listOfStudents.add(bean);
					}
					
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
				return listOfStudents;
			
		}
		public  int deleteClassById(String Id) {
			int deleteCount=0;
			try {
				Connection con=DBConnection.getConnection();
				
				String query="delete classes where Id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, Id);
				deleteCount =pstmt.executeUpdate();
				System.out.println("Rows Impacted :"+deleteCount);
				 
			} catch (Exception ex){
				ex.printStackTrace();
				
			}
			return deleteCount;
			
		}
		public boolean updateClassById(ClassesBean bean)
		{
			boolean updateStatus=false;
			try 
			{
				Connection con= DBConnection.getConnection(); 
			    String query="update classes set section=?, teacher=?, subject=?  where Id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, bean.getSection());
				pstmt.setString(2, bean.getTeacher());
				pstmt.setString(3, bean.getSubject());
				
				pstmt.setString(4, bean.getId() );
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
