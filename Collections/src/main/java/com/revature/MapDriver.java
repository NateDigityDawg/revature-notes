package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	public static void main(String[] args) {
		
		// create a simple HashMap
		Map<String, String> languages = new HashMap<String, String>();
		
		
		languages.put("Java", "a compiled high-level object oriented platform independent language");
		languages.put("Python", "an interpereted OOP language");
		languages.put("JavaScript", "interpereted language, lightweight runs in browser or Node.js");
		
		/**
		 * The Map Interface does NOT extend Iterable.
		 * 
		 * - You cannot have duplicate keys!!
		 * - but you can duplicate values.
		 * 
		 */
		
		
		// this would replace the previous value
		languages.put("Javascript", "NOT Java...!");
		
		System.out.println("I like to program in Java which is " + languages.get("Java"));
		
		/**
		 * How to iterate over a MAp?
		 */
		
		// want to get all keys?
		
		for(String key : languages.keySet()) {
			System.out.println("The key is " + key);
		}
		
		// for values it's essentially the same... languages.values()
		
		
		// how do we iterate over both the keys and the values within that Map?
		for(Map.Entry<String, String> entry : languages.entrySet()) {
			
			System.out.println(entry);
		}
		/**
		 * .replace()
		 * .remove()
		 */
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
