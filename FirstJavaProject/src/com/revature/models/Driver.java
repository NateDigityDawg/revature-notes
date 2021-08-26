package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		
		// Can you instantiate an Object from a Class where you have not defined a constructor
		// A reference type is a "custom type". THis is a User defined Class
//		Person p1 = new Person(); // we are instantiating a Class with a default no args constructor
		
		Person p1 = new Person("Fred", 30, 64, 160.50);
		
		System.out.println(p1);
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		Person p2 = new Person();
		p2 = p1;
		
		System.out.println("Fred's BMI is " + p2.calculateBMI(p2.getWeight(), p2.getHeight()));
		
		System.out.println(Person.MAX_AGE); // here we are invoking a static variable at the class level
//		System.out.println(p2.MAX_AGE);
//		System.out.println(p1.MAX_AGE);
		
//		public Employee(String name, int age, double height, double weight, String dept) {
//			super(name, age, height, weight);
//			this.dept = dept;
//		}
		
		// Below 2 different Objects are being instantiated
		Employee e1 = new Employee("Bob", 2, 3, 4, "Finance");
		Employee e2 = new Employee("Bob", 2, 3, 4, "Finance");
		
		// are e1.equals(e2);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		System.out.println(e1 == e2); // == check for the address in memory
		
		// What if I want to put Employee Object inside a data structure 
		// (like some type of a set that doesn't allow duplicates)

	}

}
