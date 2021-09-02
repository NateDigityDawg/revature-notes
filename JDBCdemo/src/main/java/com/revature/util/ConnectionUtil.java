package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // this is the JDBC
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

// Singleton design pattern instantiates an object ONCE
/**
 * What is JDBC?
 * 
 * JDBC (Java Database Connectivity) is the Java API that manages 
 * connecting to a database, issuing queries and commands, 
 * and handling result sets obtained from the database
 * 
 * Singleton Class is a software design pattern that ensures there will be one
 * single instance of that class.
 * 
 * -- private constructors
 * -- static field of an instance of the class to be returned
 * -- leverage a public static getInstance() (our getInstance method in this case is the getConnection() method)
 *  
 *  
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 */
public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	private static Connection conn = null;
	
	// we want to make the constructor private
	private ConnectionUtil() {
		super();
	}
	
	
	// in a singleton design pattern you create a static getInstance() method	
	public static Connection getConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				log.info("returned reused connection");
				return conn;
			}
		} catch (SQLException e) {
			log.error("we failed to re-use a connection.");
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
			log.info("Database Connection Established");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Cannot locate application.properties file.");
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("Cannot establish database connection");
			return null;
		}
		return conn;
		
	}
	
}
