package com.revature.serialization;

public class Driver {
public static void main(String[] args) {
		
		
		// instantiate Pet Objects
		PetStore petco = new PetStore();
		PetStore petsmart = new PetStore();
		
//		// 2 ways to add a Pet Object to petco's petDB
//		
//		// 1) First we instantiate the Object then we add it to the Collection
//		Pet p1 = new Pet("Finn", 1004, "Cat", "Jerry", 4, Color.GREY);
//		
//		petco.petDB.add(p1);
//		
//		
//		// 2) immediately call the Collection and add AND instantiate the Object at the same time
//		petco.petDB.add(new Pet("Spot", 3002, "Dog", "Larry", 10, Color.BROWN));
//		
//		System.out.println("Below is our ArrayList of pets from the petco petDB");
//
//		System.out.println("++++++++++++++++++++++++++++++++++");
//		
//		// enhance for loop
//		for (Pet p : petco.petDB) {
//			System.out.println(p.getName());
//		}
//		
//		// serialize my entire petco
//		
//		petco.serialize();
		
		petsmart.deserialize();
		
		for (Pet newPet : petsmart.getPetDB()) {
			
			System.out.println("The newly deserialized pet is...");
			System.out.println(newPet);
			
		}
		
		
	}
}
