package com.revature.repositories;

import com.revature.models.User;
/**
 * DAO is a data access object
 * 
 * it is used to separate our persistence logic from our business logic
 * @author leena
 *
 */
public interface IUserDao {
	
	int insert(User u); // we 
	
	
}
