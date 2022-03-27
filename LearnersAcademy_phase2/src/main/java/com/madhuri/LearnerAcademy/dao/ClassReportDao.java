package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.madhuri.LearnerAcademy.bean.ClassReport;
import com.madhuri.LearnerAcademy.bean.ClassesBean;
import com.madhuri.LearnerAcademy.util.DBConnection;

public class ClassReportDao {
	
	
	public List<ClassReport> getClassReport()
	{ 
		List<ClassReport> listOfRecords=new ArrayList<ClassReport>();
		try 
		{
			Connection con= DBConnection.getConnection(); 
			Statement stmt=con.createStatement();
			String query=" select s.studentName, c.section, t.tName, su.subject from\r\n"
					+ "student s,\r\n"
					+ "classes c,\r\n"
					+ "teacher t,\r\n"
					+ "subject su\r\n"
					+ "where s.StudentClass = c.id\r\n"
					+ "AND    c.teacher = t.regNo\r\n"
					+ "AND c.subject = su.subid\r\n" ;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				ClassReport bean =new ClassReport();
				bean.setClassName(rs.getString(1));
				bean.setStudentName(rs.getString(2));
				bean.setSubject(rs.getString(3));;
				bean.setTeacher(rs.getString(4));
				listOfRecords.add(bean);
			}
			
			
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return listOfRecords;
		
	}
	
	
	public static void main(String[] args) {
		ClassReport bean =new ClassReport();
		System.out.println(new ClassReportDao().getClassReport());

		
		
	}
	 
	

}
