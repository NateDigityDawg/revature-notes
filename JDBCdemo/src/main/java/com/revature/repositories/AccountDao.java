package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDao implements IAccountDao {
	
	private static Logger log = Logger.getLogger(AccountDao.class);
	
	
	@Override
	public List<Account> findAll() { // here we have to make an actual query
		
		// start out with an empty list of accounts
		List<Account> accList = new ArrayList<Account>();
		// obtain a connection, surround with try
		
		try (Connection conn = ConnectionUtil.getConnection();) {
			
			// create a statement + a sql string to pass through and execute against the DBV
			
			String sql = "SELECT * FROM accounts";
			
			Statement stmt = conn.createStatement();
			
			// send the statement to the DB
			ResultSet rs = stmt.executeQuery(sql);
			
			// iterate through the response while(rs.next())
			while(rs.next()) {
				
				// for each row, grab the data of that account 
				int id = rs.getInt("id"); // you can specify the column number or the column name
				double balance = rs.getDouble("balance");
				
				// construct the account object
				Account a = new Account(id, balance);
				
				// add the account object to the list
				accList.add(a);
			}
						
		} catch (SQLException e) {
			// catch a sql error if necessary
			
			log.warn("A SQL Exception occured when querying all accounts.");
			e.printStackTrace();
		}
		// return the account list
		return accList;
	}

	@Override
	public int insert(Account a) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO nathanl.accounts (balance, acc_owner) VALUES (?, ?) RETURNING nathanl.accounts.id";
			
			// PreparedStatement...
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, a.getBalance());
			stmt.setInt(2, a.getOwnerId());
			
			ResultSet rs;
			
			if((rs = stmt.executeQuery()) != null) {
				
				rs.next();
				int id = rs.getInt(1);
				return id;
				
			}
			
			
		} catch (SQLException e) {
			log.warn("Unable to insert Account");
			e.printStackTrace();
			return -1;
		}
		
		
		return -1;
	}

	@Override
	public List<Account> findByOwner(int userId) {
		
		List<Account> ownedAccounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT nathanl.accounts.id, nathanl.accounts.balance \r\n"
					+ "FROM nathanl.accounts \r\n"
					+ "INNER JOIN nathanl.users_accounts_jt \r\n"
					+ "ON nathanl.accounts.id = nathanl.users_accounts_jt.account \r\n"
					+ "WHERE nathanl.users_accounts_jt.acc_owner = ?;"; // this will have to be a joins statement
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// how do set the ?
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				
				Account a = new Account(id, balance);
				
				// in the case there are duplicates, DON'T add them to the arrayList
				if(!ownedAccounts.contains(a)) {
					ownedAccounts.add(a);
				}
				
			}
			
		} catch (SQLException e) {
			log.warn("Failed to retrieve accoutns owned by user id " + userId);
			e.printStackTrace();
		} 
		
		return ownedAccounts;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
