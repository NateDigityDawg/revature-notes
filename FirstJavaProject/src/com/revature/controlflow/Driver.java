package com.revature.controlflow;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		// if - else statement
		
		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's too cold out!");
		} else {
			System.out.println("It's not too cold out!");
		}
		
		// ternary operator
		System.out.println((temp < 32) ? "COLD!" : "NOT COLD!");
		
		int hungerLevel = 7;
		
		if (hungerLevel > 6) {
			System.out.println("Need food now!");
		} else if (hungerLevel >= 4) {
			System.out.println("I could snack");
		} else {
			System.out.println("Not hungry at all...");
		}
		
		
		do {
			System.out.println("In the do while loop");
		} while (false);
		
		int counter = 10;
		
		while (counter > 0) {
			// check if a condition is a true THEN execute the code
			System.out.println(counter);
			counter--;
		}
		Scanner scan = new Scanner(System.in);
		
		// for loop
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i is equal to " + i);
		}
		
		// in collections we'll work with enhanced for loop
		System.out.println("Enter a word an I'll spell it out");
		String word = scan.next();
		
		
		// Switch Case:
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
		
		System.out.println("Enter the number of your birthday month: ");
		
		int monthNum = scan.nextInt();
		
		scan.close();
		
		
		String month;
		
		// here we begin the switch case
		/**
		 * can use return statement
		 */
		switch (monthNum) {
		case 6:
			// we could execute some code here
			month = "June";
			break; // break statements are crucial
		case 7:
			month = "July";
			break; // ctrl + / to auto comment
		default:
			month = "Sorry lazy dev calendar doesn't include your birthday month";
			break;
		}
		
		System.out.println("You were born in " + month);
		
		
		
		
		
		
	}
}
