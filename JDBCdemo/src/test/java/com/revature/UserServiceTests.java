package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.services.UserService;

public class UserServiceTests {
	
	// declare the Class to be tested
	private UserService uservice;
	
	// declare the DEPENDENCIES of the userservice
	// We will be using Mockito to "mock" the dao layer, that the UserService is dependent on
	private UserDao mockdao;
	
	private User dummyUser;
	
	@Before // before every test is run
	public void setup() {
		
		uservice = new UserService();
		
		// mock the dependency provided to the UserService
		mockdao = mock(UserDao.class);
		
		// every userService has a DAO this it relies on...
		uservice.udao = mockdao;
		
		dummyUser = new User();
		dummyUser.setAccounts(new ArrayList<Account>());
		dummyUser.setId(0);
		
		
		
	}
	
	@After // after each unit test runs
	public void teardown() {
		uservice = null;
		dummyUser = null;
		mockdao = null;
	}
	
	// whenever we insert a user, it returns a valid primary key
	// If it were NOT returning the right key we'd have some major problems
	@Test
	public void testRegisterUser_returnsNewPk() {
		dummyUser = new User(0, "spongebob", "pineapple", Role.Admin, new ArrayList<>());
		
		// generate a hard coded primary key that will be returned by the mockdao's insert method
		Random r = new Random();
		int fakePk = r.nextInt(100);
		
		// Here we are intercepting the UserService's call to the DAO layer
		when(mockdao.insert(dummyUser)).thenReturn(fakePk); // this user should never be inserted into our database
		
		// here we're testing does the register method properly call our DAO layer
		User registeredUser = uservice.register(dummyUser);
		assertEquals(registeredUser.getId(), fakePk);
	}
	
	
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_idGreaterThanZero_throwsException() {
		// here we try registering a user who's id is > 0
		
		List<Account> accounts = new ArrayList<Account>();
		Account a = new Account();
		a.setBalance(7000);
		
		accounts.add(a);
		
		dummyUser = new User(23, "Bob", "pass", Role.Customer, accounts);
		
		uservice.register(dummyUser); // this will throw an exception because the user we're trying to register has an id > 0
		
		
		
	}
	
	
	
	
	
	
	
	
}
