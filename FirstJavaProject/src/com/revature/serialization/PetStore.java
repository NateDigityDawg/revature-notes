package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore {
	
	
	// every pet store has a database
	// here we'll first instantiate an ArrayList and infer that it will hold Pet Objects
	private List<Pet> petDB = new ArrayList<Pet>();
	
	
	
	
	
	public List<Pet> getPetDB() {
		return petDB;
	}





	public void setPetDB(List<Pet> petDB) {
		this.petDB = petDB;
	}





	// serialize() method
	public void serialize() { // java Object to byte code
		
		// we're writing to a file. We need to use the java.io package
		
		 try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))){
			 
			 // this is the code to execute!
			 oos.writeObject(this.petDB);
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// deserialize()
	@SuppressWarnings("unchecked")
	public void deserialize() { // byte code to java Object
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))){
			 
			 // when a petstore Objetc calls this method it will call it on its prtDB array
			 this.petDB = (ArrayList<Pet>) ois.readObject();
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
