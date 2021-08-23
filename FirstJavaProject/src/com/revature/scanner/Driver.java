package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		// An object is a reusable component within our code.
		
		// Classes are blueprints of an object, and they define how Objects behave.
		
		Scanner scan = new Scanner(System.in); // the new keyword instantiates an Object from the Class that's invoked
		

		
		// prompt the user to enter their name
		System.out.println("Please enter your name: ");
		
		
		// capture the user's input into a variable called name
		String name = scan.nextLine();
		
		// print the user's name back to the screen with a message
		System.out.println("Hello " + name);
		
		// prompt the user for their age
		System.out.println("What's your age?");
		
		
		// capture the user's age
		int age = scan.nextInt();
		
		// print back to the user what their age will be in 100 years by invoking a method that we create...
		System.out.println("In the future you, " + name +", will be " + getFutureAge(age) + ".");
		
		
	}
/**
 * public = access modifier (this method can be accessed anywhere in our application)
 * 
 * static = means that I don't need to instantiate this class in order to call this method
 * 
 * int = return type of the method
 * 
 * parameter = 
 * 
 * @param currentAge
 * @return
 */
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}
	

}
