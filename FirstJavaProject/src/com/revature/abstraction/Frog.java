package com.revature.abstraction;


// JAVA does not support multi-inheritance, meaning I can only extend ONE class
public class Frog extends Animal implements Ectothermic, Amphibious {

	@Override
	public void makeSound() {
		System.out.println("Ribbit Ribbit!");
		
	}
	
	// Polymorphism - overloading the above method
	public void makeSound(int times) {
		
		for(int i = 0; i <= times; i++) {
			System.out.println("ribbit...");
		}
		
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void canSwim() {
		// TODO Auto-generated method stub
		
	}

}
