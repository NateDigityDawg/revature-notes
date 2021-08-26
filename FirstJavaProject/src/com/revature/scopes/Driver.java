package com.revature.scopes;


/**
 * 
 * 1. Class Scope (Static/Global scope)
 * 2. Instance Scope (these are variables that belong to an Object only)
 * 3. Method Scope
 * 4. Block Scope (You can nest these as much as you want)
 * 
 * The term "Field" refers to a static or instance scoped variable
 * The "Local Variable" referring to a method or block scope 
 *
 */
public class Driver {
//	String str = methodVar; // I can't access method scope from outside the method
	
	public static void main(String[] args) {
		
		// where we will instatiate MyClass Objects
		
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVar;
		
		double z = mcObj.myInstanceVar; // here we access the field declared in the instance scope
		
//		static int j = 8; // you CANNOT declarre static variables inside of a method
		
		int b = 5;
		
		while(b > 0) {
			
			// here we're declaring a variable within a block scope...(int result)
			int result = b * b;
			for(int i = result; i < 100; i++) {
				
			}
			
			System.out.println(result);
			
			b--;
		}
		// you CAN'T access a block scoped variable from outside the block
		// System.out.println(result);
		
	}
	
	public void anotherMethod() {
		int y = MyClass.myStaticVar;
		
		// you can't access another method's variable within ANOTHER method
		
		String methodVar = "Hello";
		
	}
	
	
	
}
