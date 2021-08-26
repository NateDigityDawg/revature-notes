package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		
		/**
		 * Strings are used to store a sequence of characters but they're treated as Objects
		 * because they come from the String CLASS!
		 * 
		 * - (1). String Object created with the new keyword -> goes to the general heap
		 * - (2). String Literal created with "some sentence" -> goes to the String Pool INSIDE the heap
		 * 
		 */
		
		String stringObject = new String("straight to the general heap we go");
		System.out.println(stringObject);
		
		String stringLiteral = "straight to the String pool we go...";
		System.out.println(stringLiteral);
		
		String str1 = "Hello"; // JVM crates an Object in the String pool
		
		String str2 = "Hello"; // JVM checks if this same String Object already exists in the String pool
		
		// .equals() checks for value...do they have the same value
		System.out.println("Does str1 have the same value as str2? " + str1.equals(str2));
		
		// do they point to the same location in memory
		System.out.println("Does str1 have the same mem location as str2? " + (str1 == str2));
		
		String strObj2 = new String("Hello");
		
		// does the String Object instantiated with new point to the same location in memory as str1 & str2
		System.out.println("Does the String Object instantiated with new point to the same location in memory as str1 & str2? " + (strObj2 == str1));;
		
		String str3 = "Hello World";
		
		String str4 = "Hello " + "World";
		
		System.out.println(str3 == str4);
		
		System.out.println("Hashcode of String literal str1: " + str1.hashCode());
		System.out.println("Hashcode of String literal str2: " + strObj2.hashCode());
		// even though they have the same hashcode, they DON'T point to the same place in memory
		
		String str5 = "Hello ";
		
		String str6 = str5 + "World"; // is this going to the general heap or to the String pool? this is equivalent to using the new keyword due to the immutability of String Objects
		
		// to send something to the String pool, you call the intern() method
		
		System.out.println(str6 == str3);
		
		String str6InPool = str6.intern();
		
		System.out.println("has str6inPool successfully been sent to the String pool? " + (str6InPool == str3));
		
		/**
		 * The String API
		 * 
		 * tons of methods to perform operations on Strings
		 */
		
		String newStrObject = str6InPool.concat("something"); // creating a new String Object in the general heap NOT the String pool
		
		System.out.println(newStrObject);
		
		String test = "The quick brown fox jumped over the lazy dog";
		
		String chopped = test.substring(5);
		
		System.out.println(chopped); // returns that part of the String literal as an Object
		
		
		/*
		 * indexOf()
		 * charAt()
		 * split()
		 * length()
		 * isEmpty()
		 * etc...
		 */
		
		// StringBuffer and StringBuilder are mutable versions of the String Class
		// StringBuuffer is thread-safe and slower than stringBuilder
		
		StringBuilder sBuild = new StringBuilder("Hello");
		
		sBuild.append(" ");
		sBuild.append("World"); // modifying the same Object! Can't do this with regular String Objects...
		
		// you can take this StringBuilder Object and send it to the String pool!
		System.out.println(sBuild);
		String myString = sBuild.toString(); // now it's sent OUTside of the String pool.
		System.out.println(myString);
		
		
		String sbInPool = myString.intern();
		
		System.out.println(str6InPool == myString); // false..
		System.out.println(sbInPool == str6InPool); // true because we used intern()
		
		
		
		
	}

}
