package com.revature.repositories;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {
	
	List<Account> findAll();
	int insert(Account a); // return the primary key
	List<Account> findByOwner(int userId);
	Account findById(int id);
	boolean update(Account a);
	boolean delete(int id);
	
	
	
}
