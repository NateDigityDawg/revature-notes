package com.revature.abstraction;

public class Deskphone implements Callable {
	
	// it would be a goo desing decision tyo delegate these shared fields to an abstract Class...NOT an interface because
	// all fields within an interface are PUBLIC, STATIC, and FINAL.
	private int myNumber;
	private boolean isRinging;
	
	/**
	 * CHALLENGE: take the above properties and in the Cellphone Class and
	 * put this in an abstract class
	 * 
	 * 
	 * @param myNumber
	 */
	
	
	public Deskphone (int myNumber) {
		super();
		this.myNumber = myNumber;
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dial(int phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRinging() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
