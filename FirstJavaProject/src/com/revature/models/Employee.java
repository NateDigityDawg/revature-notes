package com.revature.models;

import java.io.Serializable;
import java.util.Objects;



/**
 * A Java Bean IS a type of POJO, but more specific and specialized
 * 
 * -- it's serializable
 * -- have getter/setters
 * -- have an overridden hashcode() and equals() method
 *
 */
public class Employee extends Person  implements Serializable {
	
	
	
	/**
	 * Serialization is the process of persisting an Object from memory
	 * to sequence of bits, for instance, like saving it onto your disk.
	 */
	private static final long serialVersionUID = -764832017168368438L;
	// all the properties of Person are present in Employee but abstracted away from us
	private String dept;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//here we're calling the constructor of the super class
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}
	
	// all the methods like getName() and setAge() already exist because of inheritance

	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return super.toString() + " dept =" + dept;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dept); // this began in JAVA 7
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}

	
	
	
	
}
