package com.revature;

public class MainMethodDemo {
	
	
	/**
	 * The JVM's JIT Compiler searches for the main() method
	 * @param args
	 * 
	 * 		args is an array of commands that could follow the execution command
	 */
	public static void main(String[] args) {
		
		System.out.println("Tesing 1 2 3");
		
		// build an enhanced for loop to print out each argument in args
		
		for(String word : args) {
			System.out.println("The command was " + word);
		}
		
		// Explicitly print the 3rd word in args _0_ _1_ _2_
		try {
			System.out.println("The third command after executing the main method is " + args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough arguments passed in!");
		}
		
		// get to this line of code
		System.out.println("I got to this line of code!");

	}

}
