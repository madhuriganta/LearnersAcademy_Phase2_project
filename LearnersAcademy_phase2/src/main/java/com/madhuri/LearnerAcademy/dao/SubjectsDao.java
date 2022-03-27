package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.madhuri.LearnerAcademy.bean.SubjectBean;
import com.madhuri.LearnerAcademy.util.DBConnection;

public class SubjectsDao {
	public boolean insertSubject(SubjectBean bean)
	{ 
		boolean insertStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
			String query="insert into subject values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, bean.getSubId() );
			pstmt.setString(2, bean.getSubject());
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
	public SubjectBean getSubjectById(String sId)
	{
		SubjectBean bean=new SubjectBean();
		try {
		
		Connection con= DBConnection.getConnection(); 
		Statement stmt=con.createStatement();
		String query="select * from subject where sId="+sId;
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next())
		{
			
			bean.setSubId(rs.getString(2));
			bean.setSubject(rs.getString(5));
			
		}else {
			bean=null;
		}
	
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return bean;
		
		
	}
	public List<SubjectBean> getAllsubjects()
	{
		List<SubjectBean> listOfsubjects=new ArrayList<SubjectBean>();
		try {
				Connection con=DBConnection.getConnection();
				Statement stmt=con.createStatement();
				String query="select * from subject";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					SubjectBean bean =new SubjectBean();
					bean.setSubId(rs.getString(1));
					bean.setSubject(rs.getString(2));
					listOfsubjects.add(bean);
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			return listOfsubjects;
		
	}
	public  int deleteSubjectById(String subId) {
		int deleteCount=0;
		try {
			Connection con=DBConnection.getConnection();
			// Statement stmt=con.createStatement();
			String query="delete subject where subId=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, subId);
			deleteCount =pstmt.executeUpdate();
			System.out.println("Rows Impacted :"+deleteCount);
			 
		} catch (Exception ex){
			ex.printStackTrace();
			
		}
		return deleteCount;
		
	}
	public boolean updateSubjectById(SubjectBean bean)
	{
		boolean updateStatus=false;
		try 
		{
			Connection con= DBConnection.getConnection(); 
		    String query="update subject set subject=? where subId=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, bean.getSubject());
			pstmt.setString(2,bean.getSubId());
			
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
	public boolean insertClasses(ClassesDao bean) {
		// TODO Auto-generated method stub
		return false;
	}

}
