package com.revature.accessmods;

public class Driver1 {
	
	/**
	 * 4 Pillars of OOP
	 * 
	 * - Abstraction
	 * - Polymorphism
	 * - Inheritance
	 * - Encapsulation
	 * 
	 * 
	 * Encapsulation is a mechanism in which data and methods can be
	 * wrapped together within a single unit.
	 * 
	 * 
	 */
	
	public int publicField = 1;
	protected int protectedField = 2;
	int defaultField = 3;
	private int privateField = 4;

	public static void main(String[] args) {
		/**
		 * public = visible within the entire project
		 * 
		 * private = visible only within the class
		 * 
		 * default = visible within the same package
		 * 
		 * protected = visible within same package and child classes
		 * 
		 * 
		 */
		
		Driver1 d1 = new Driver1();
		
		// no problem accessing all of these fields
		System.out.println(d1.publicField);
		System.out.println(d1.privateField);
		System.out.println(d1.defaultField);
		System.out.println(d1.protectedField);

	}

}
