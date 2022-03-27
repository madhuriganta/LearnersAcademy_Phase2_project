
package com.madhuri.LearnerAcademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.madhuri.LearnerAcademy.bean.UserBean;
import com.madhuri.LearnerAcademy.util.DBConnection;



public class UserDao {

	public UserBean getUserByUserName(String username)
	{
		UserBean bean=new UserBean();
		try 
		{
			
			Connection con= DBConnection.getConnection(); 
			Statement stmt=con.createStatement();
			// String query="select * from login where usrname="+username;
			ResultSet rs=stmt.executeQuery("select * from login where usrname = '" + username + "'");
			if(rs.next())
			{
				bean.setUsrname(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setType(rs.getString(3));
			
			}else {
				bean=null;
			}
			
			
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return bean;
		
		
	}

}
