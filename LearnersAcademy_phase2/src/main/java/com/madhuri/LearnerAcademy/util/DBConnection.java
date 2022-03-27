package com.madhuri.LearnerAcademy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con= null;
	public static Connection getConnection() {
		if(con==null) {
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ganta");
				System.out.println("Connection Success!");
				
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			
		} return con;
		
	}
}
