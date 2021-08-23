package com.revature.datatypes;

public class Driver {
	
	/**
	 * What is the purpose of the main method?
	 * 
	 * The main() method is where the JIT compiler begins program
	 * execution. The JIT compiler is a part of the JVM.
	 * @param args
	 */
	public static void main(String[] args) {
		// 8 Primitive datatypes
		
		boolean isCool = true; // 1 bit of reserved memory - 1 or 0.
		byte reallySmallNumber = 127; // 8 bits of reserved memory.
		short shortNumber = 32467; // 16 bits of reserved memory.
		char letter = 'm'; // 16 bits of reserved memory that represents an ASCII character.
		
		int standardNum = 100; // 32 bits of memory.
		float lessPreciseDecimal = 93.2f; // 32 bits of memory.
		
		double decimal = 145.63; // 64 bits of memory allows you to make decimal numbers.
		long veryLargeNum = 12345L; // 64 bits of memory.
		
		// Since Java 7 you can use an _ for readability in you code.
		
		long creditCardNumber = 1234_5678_7828_5252L;
		int secondsInADay = 86_400;
		
		int x = 4;
		int y = 10;
		System.out.println(x + y);
		
		// a String is NOT a primitive data type. It is technically a class
		String name = "Spongebob";
		
		System.out.println(name + " is " + (x + y * 100) + " years old.");
		
		// Casting 
		
		byte a = 49;
		short b = a;
		int c = b;
		double d = c;
		
		// Widening(implicit casting) is when we transform a small data type into a larger data type
		// This is one type of CASTING
		
		// a double is larger than an integer
		double dub = 900.9;
		int myInt = (int)dub;
		
		// narrow casting(explicit casting)
		
		System.out.println("the double that has been explicitly cast to an int is now equal to " + myInt);
		
		// Everything above that we've defined are Java Literals, which are simply hard-coded fixed values that we assign to a variable.
		
		
		
	}
}
