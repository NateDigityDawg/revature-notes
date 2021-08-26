package com.revature.abstraction;

public class Cat extends Animal {

	// thanks to abstraction, all # of legs, and color props are abstracted
	private String breed;
	private boolean hasFur;
	
	public Cat() {
		super();
		this.hasFur = true;
		System.out.println("Cat has been created");
	}
	
	
	@Override // Polymorphism!
	public void makeSound() {
		System.out.println("MEOW!");
		
	}

	// getters and setters


	public String getBreed() {
		return breed;
	}




	public void setBreed(String breed) {
		this.breed = breed;
	}




	public boolean isHasFur() {
		return hasFur;
	}




	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	
	
	

}
