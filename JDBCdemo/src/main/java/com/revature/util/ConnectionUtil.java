package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // this is the JDBC
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Singleton design pattern instantiates an object ONCE
/**
 * Singleton design pattern
 * 
 * -- private constructors
 * -- static field of an instance
 * -- leverage a public static getInstance() (our getInstance method in this case 
 *  
 *  
 * @author leena
 *
 */
public class ConnectionUtil {
	
	private static Connection conn = null;
	
	// we want to make the constructor private
	private ConnectionUtil() {
		super();
	}
	
	
	// in a singleton design pattern you create a static getInstance() method	
	public static Connection getConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			
			// implement an error log here
			return null;
		}
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("C:\\Users\\leena\\Desktop\\revature-notes\\JDBCdemo\\src\\main\\resources\\application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			
			// TODO change this to a logging statement once we implement Log4J
			System.out.println("Connection Successful");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Add some logging
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Add some logging
			return null;
		}
		return conn;
		
	}
	
}
