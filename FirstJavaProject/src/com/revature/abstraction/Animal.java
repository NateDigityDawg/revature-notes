package com.revature.abstraction;

public abstract class Animal {
	/*
	 * An abstract class CANNOT be instantiated
	 */
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("Animal constructor is called!");
	}
	
	
	// getters and setters
	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// abstract methods are meant to be inherited and overridden
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("The animal is existing");
	}
	
}
