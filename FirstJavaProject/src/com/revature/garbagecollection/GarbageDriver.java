package com.revature.garbagecollection;

import com.revature.models.Employee;

public class GarbageDriver {
	
	/*
	 *	Final:
	 *
	 * Variable: never change the variable
	 * method: never override the method
	 * class: never extend the class
	 * 
	 */
	
	
	final int neverChange = 9000;
	
	public static void main(String[] args) {
		
		// you CANNOT reassign b to any other Object because it's declared with FINAL
		final Employee b = new Employee("Bob", 50, 94, 184, "Finance");
		
		// we can't change what Object b refers to
		// b = new Employee(null, 0, 0, 0, null);
		
		b.setAge(51);
		
		// can't do this!
//		neverChange = 10_000;
		
		
		System.out.println("Instantiating GarbageDriver Object...");
		
		GarbageDriver gd = new GarbageDriver();
		// Currently the "gd" ref variable exists in the stack, and the Object exist in the heap
		
		System.out.println("GarbageDrive Object successfully created");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {
			System.out.println("Finally block is running!");
		}
		
		
		
		
		gd = null;
		
		/*
		 * Garbage Collection is nondeterministic meaning that we can encourage it, but never fully guarantee it memory cleaning
		 * 
		 * (System.gc)
		 */
		
		
		/**
		 * Every Object that extends the java.lang.Object Class has a special method called finalize()
		 * 
		 * when an Object's finalize method is called, the Object is removed from the heap
		 */
		
		System.gc();
		
		
		for(;;) {
			System.out.println("...");
		}
		
	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize method has been called!!!!!!!");
		
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		
		System.out.println("Goodbye!");
		
		System.exit(0);

	}
}
