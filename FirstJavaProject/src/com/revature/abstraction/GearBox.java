package com.revature.abstraction;

// this is bad practice don't do this. THis is why we need interfaces
public class GearBox {
	private boolean clutchIsIn;
	
//	public void operateClutch(String inOrOut) {
//		
//		this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
//		
//	}
	
	
	// an interface is a contract specifying that the method signatures will not change!
	public void operateClutch(boolean inOrOut) {
		this.clutchIsIn = inOrOut;
	}
	
}
