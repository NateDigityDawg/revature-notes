package com.revature.serialization;

import java.io.Serializable;
import java.util.Objects;

/**
 * Java Bean
 * 
 * -- implements serializable
 * -- make all the instance fields private
 * -- getters/setters
 * -- overridden hashCode and equals method
 * 
 * 
 * @author leena
 *
 */
public class Pet implements Serializable {
	
	/**
	 * In the case that we have multiple Classes with the same name,
	 * we are able to determine exactly which Class this is.
	 */
	private static final long serialVersionUID = 8384900016936037818L;
	private String name;
	private int tagNumber;
	private String breed;
	private String ownerName;
	private int age;
	private Color color;
	
	// no args constructor
	
	public Pet() {
		
	}

	public Pet(String name, int tagNumber, String breed, String ownerName, int age, Color color) {
		super();
		this.name = name;
		this.tagNumber = tagNumber;
		this.breed = breed;
		this.ownerName = ownerName;
		this.age = age;
		this.color = color;
	}


	// getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	
	// hashCode and equals
	
	@Override
	public int hashCode() {
		// this means that if there is another Pet Object with the SAME combination
		// of instance variables (state of the Object) then it IS the same Object
		
		return Objects.hash(age, breed, color, name, ownerName, tagNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(breed, other.breed) && color == other.color
				&& Objects.equals(name, other.name) && Objects.equals(ownerName, other.ownerName)
				&& tagNumber == other.tagNumber;
	}

	
	// to String
	
	@Override
	public String toString() {
		return "Pet [name=" + name + ", tagNumber=" + tagNumber + ", breed=" + breed + ", ownerName=" + ownerName
				+ ", age=" + age + ", color=" + color + "]";
	}
	
	
	
	
	
}
