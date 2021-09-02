package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * JDBC API main Classes and Interfaces:
 * https://www.tutorialspoint.com/what-are-the-main-classes-and-interfaces-of-jdbc
 * 
 * (1) DriverManager class
 * 	- This class manages the JDBC drivers.
 * 	- Some static methods, such as getConnection() that we use to connect to a DB
 * 	- Used to obtain a Connection
 * 
 * (2) Connection Interface
 * 	- Represents a Connection to our DB
 * 	- Has methods to obtain Statements
 * 	- This interface provides methods such as close(), commit(), rollback(), 
 * 		createStatement(), prepareCall(), prepareStatement(), setAutoCommit() setSavepoint() etc.
 * 
 * (3) Statement Interface
 * 	- Represents a static SQL statement that will be performed against the DB
 * 	- There are sub-interfaces for specific use-cases
 * 		- PreparedStatement Interface 
 * 			- CallableStatement Interface
 * 	- Have methods to obtain ResultSets
 * 
 * (4) ResultSet Interface
 * 	- Represents data obtained from the DB
 * 	- Follows an "Iterator" structure
 * 		- Is pointing to individual rows
 * 		- Invoke the .next() method to step forward
 * 		- Starts at the position BEFORE the first row
 * 	- Has methods to obtain data from individual columns for that row
 * 		- getInt()
 * 		- getString()
 * 
 * (5) CallableStatement Interface
 * 	- Using an object of this interface you can execute stored procedures. 
 * 	- Methods include prepareCall()
 * 	- A stored procedure is a prepared SQL code that you can save, so the code can be reused over and over again.
 *
 */
public class UserDao implements IUserDao {
	
	private static Logger log = Logger.getLogger(UserDao.class);
	
	@Override
	public int insert(User u) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			// we start with a SQL String
			
			String sql = "INSERT INTO nathanl.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING nathanl.users.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			
			// the enum is tough because we have to accommodate for a separate custom ENUM type.
			stmt.setObject(3, u.getRole(), Types.OTHER);
			
			ResultSet rs; // our SQL statement will return a value we need to iterate over it
			
			if ((rs = stmt.executeQuery()) != null) {
				// moves the cursor
				rs.next();
				
				int id = rs.getInt(1);
				
				// log the user's id that was inserted
				log.info("Successfully inserts User id");
				
				
				return id;  // if everything goes well this is where the method returns
			}
			
		} catch (SQLException e) {
			log.error("Unable to insert User.");
			e.printStackTrace();
		}
		
		
		return -1; // if something doesn't go right return -1
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
}
