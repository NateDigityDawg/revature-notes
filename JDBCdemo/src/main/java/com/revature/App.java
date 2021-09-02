package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class App {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! If you are a new Customer please press  1. \n If you would like to log in please press 2.");
		
		
		// in your application think about the things that can go wrong here!
		// for example, what if the user puts in abc instead of a number
		
		int input = scan.nextInt();
		
		if (input == 1) {
			
			// create new user
			System.out.println("Enter your username");
			String username = scan.next();
			
			System.out.println("Enter your password");
			String password = scan.next();
			
			User u = new User(username, password, Role.Customer, new ArrayList<Account>());
			
			// our register method returns a User with a generated primary key as its ID
			u = userv.register(u);
			
			System.out.println("Would you like to open an account? Y/N");
			
			String yesOrNo = scan.next();
			
			if (yesOrNo.equalsIgnoreCase("y")) {
				
				// what parameter does the openAccount method take?
				// we need to pass through the id of the user who's making the account
				for(int i = 0; i < 2; i++) {
					System.out.println("Opening account #" + i);
					aserv.openAccount(u);
				}
				
			}
			
			aserv.viewAllAccountsByOwner(u.getId());
			
		} else {
			System.out.println("Goodbye");
			// call some method like userv.login()
			
		}
		
	}
	
	
}
