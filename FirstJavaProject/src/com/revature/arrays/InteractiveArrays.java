package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	private static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		System.out.println("Enter the size of array you would like: ");
		int size = scan.nextInt();
		
		int[] numbersArray = getIntegers(size);
		double avg = getAverage(numbersArray);
		printArray(numbersArray);
		printAverage(avg);
		
	}
	
	
	// step 1: Let's create a method that asks the user to create an
	// array and input some custom values to populate the array
	static int[] getIntegers(int capacity) {
		
		
		System.out.println("Enter " + capacity + " integers");
		
		int[] values = new int[capacity];
		
		for(int i = 0; i < values.length; i++) {
			
			values[i] = scan.nextInt();
			
		}
		
		
		return values;
		
	}
	
	
	// returns the average of all integers in the array
	static double getAverage(int[] arr) {
		double total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		
		return total / arr.length;
	}
	
	// prints out the array
	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	// prints the average of all the integers in the array
	static void printAverage(double average) {
		System.out.println("The average of all the numbers in the array is " + average);
	}
	
	
	
	
}
