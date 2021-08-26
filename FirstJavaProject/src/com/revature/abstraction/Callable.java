package com.revature.abstraction;

public interface Callable {
	
	
	
	// all methods are inheritly public and abstract
	void powerOn();
	void dial(int phoneNumber);
	boolean callPhone(int phoneNumber);
	public boolean isRinging();
}
