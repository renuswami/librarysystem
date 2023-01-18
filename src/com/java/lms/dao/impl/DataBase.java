package com.java.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class DataBase {
	
	public static final String URL = "jdbc:mysql://localhost:3306/library";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection getConnection() throws ClassNotFoundException {
		
		Connection conn = null;
		try{
		Class.forName(DRIVER); 
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e){
			System.out.println(e);
		}
		return conn;
	}

}
