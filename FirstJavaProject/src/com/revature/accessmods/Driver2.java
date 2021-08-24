package com.revature.accessmods;

public class Driver2 {
	
	
	// we'll set field of this class equal to the value of Driver1 Object
	
	private Driver1 d1 = new Driver1();
	
	int y = d1.publicField;
//	int x = d1.privateField; we can't access private field in a separate class
	
	int z = d1.protectedField;
	int w = d1.defaultField;
	
	
}
