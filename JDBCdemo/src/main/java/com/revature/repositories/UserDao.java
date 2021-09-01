package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDao implements IUserDao {

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
				rs.next();
				
				int id = rs.getInt(1);
				
				return id;  // if everything goes well this is where the method returns
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return -1; // if something doesn't go right return -1
	}

	
	
	
	
	
}
