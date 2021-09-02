package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	
	// Inject the dependency that account service needs to persist data
	public IAccountDao adao = new AccountDao();
	
	// create an openAccount method that will include a scanner and call the accDao.insert() method
	
	private static Scanner scan = new Scanner(System.in);
	
	public Account openAccount(User u) {
		// when this method is called 
		// it prompts the user to enter an initial deposit
		System.out.println("Enter an initial deposit for the account: ");
		double deposit = scan.nextDouble();
		
		// it reads back to the user the deposit entered
		System.out.println("You entered $" + deposit);
		
		// it creates a new account with the User's id as the account's owner id property...
		Account a = new Account(deposit, u.getId());
		
		// then it called the adao.insert method to persist the account on the DB
		int pk = adao.insert(a);
		
		// make sure you grab the generated PK from the insert method
		a.setId(pk);
		// return the full account object (with its generated PK)
		
		return a;
	}
	
	public void viewAllAccountsByOwner(int ownerId) {
		
		for(Account a: adao.findByOwner(ownerId)) {
			System.out.println(a);
		}
		
	}
	
	
	public List<Account> findByOwner(int userId){
		
		
		
		return adao.findByOwner(userId);
	}
	
	
	
	
}
