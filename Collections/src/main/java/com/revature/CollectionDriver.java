package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.model.Animal;

public class CollectionDriver {

	public static void main(String[] args) {


		/***
		 * -- ordered Collection (sometimes called a sequence)
		 * -- may contain duplicates
		 * -- We use the list interface when we want to use the following operations
		 * 
		 * 
		 * 		+ Positional access
		 * 			- manipulating elements based on their numerical position in the list
		 * 			- for example use methods like get() set() add() remove() - think CRUD
		 * 
		 * 		+ Search
		 * 
		 * 		+ Iteration
		 * 
		 * 		+ Range-view (how big is the list)
		 * 
		 * 
		 */
		
		List<Animal> animalList = new ArrayList<Animal>();
		
		Animal a1 = new Animal("Dog", 12); // we have no way of  defining wether a1 and a3 are the same
		Animal a2 = new Animal("Tiger", 4);
		Animal a3 = new Animal("Dog", 12);
		
		animalList.add(a1);
		animalList.add(a2);
		animalList.add(a3);
		
		for(Animal a : animalList) {
			System.out.println(a.hashCode()); // after we override the hashCode() it will determine that a1 and a3 are the same
		}
		
		// vectors are synchronized (thread-safe)
		// vectors increase 100% when they need to expand
		List<Integer> numbers = new Vector<Integer>();
		
		numbers.add(3);
		numbers.add(74);
		numbers.add(-9000);
		
		System.out.println(numbers);
		
		/**
		 * sets
		 * 
		 * - unordered
		 * - DOES NOT allow duplicates
		 * 		+ They maintain a strong contract of the Object and its hashcode and equals() method		 
		 * 
		 */
		System.out.println("======================  SETS  =====================");
		
		Set<Animal> animalSet = new LinkedHashSet<Animal>(); // LinkedHashSet
		
		animalSet.add(a1); // this is the same as a3
		animalSet.add(a2);
		animalSet.add(a3); // the complier won't complain but the set won't add it (contingent on hashCode() and equals() being overridden
		
		for(Animal a : animalSet) {
			System.out.println(a);
		}
		
		
		
		/**
		 * Queue
		 * 
		 * - A Collection used to hold elements prior to processing
		 * - FIFO order (first in, first out)
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		System.out.println("=================  QUEUES  ===================");
		
		
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		
		// you can add duplicates in a Queue
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		while(animalQ.size() != 0) {
			System.out.println("Queue size: " + animalQ.size());
			System.out.println("Processing... " + animalQ.poll()); // poll() removes the head of the Queue
		}
		
		/**
		 * Collections utility Class! Note the 's'! Thisis different form the Collection Interface...
		 * 
		 * - static methods that operate on a Collection...
		 * - polymorphic algorithms
		 * 
		 */
		System.out.println("vector before sorting");
		System.out.println(numbers);
		System.out.println("sorting vector...");
		Collections.sort(numbers); // static method from Class Collections
		// this Collections Class only exists to call
		
		System.out.println(numbers);
		
		
		
		
		
		
		
		

	}

}
