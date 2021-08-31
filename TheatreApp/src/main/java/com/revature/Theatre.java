package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName; // we will initialize it inside the constructor
	private List<Seat> seats = new ArrayList<>();
	
	/**
	 * When do you use an ArrayList over a LinkedList and vice versa?
	 * 
	 * ArrayList:
	 * Better: for SEARCHING get(): is done in O(1)
	 * Worse: for INSERTING and DELETING add(): done in O(n) linear time
	 * 
	 * LinkedList:
	 * Better for: INSERTING and DELETING: done in O(1) constant time (because LinkedList consists of nodes that have addresses)
	 * Worse for: SEARCHING: sometimes O(n) other times more complex...
	 * 
	 * 
	 */
	
	
	
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for(char row = 'A'; row<= lastRow; row++) {
			
			// nested for loop for each row, to make seats for each row
			for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				
				seats.add(seat);
				
			}
		}
	}
	
	public String getTheaterName() {
		return theatreName;
	}
	
	public void getSeats() {
		
		for(Seat seat :seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	// I'd like to reserve seat G07
	// BRUTE FORCE ALGORITHM - I will check every single seat to check if it's the one I want to reserve
	public boolean reserveSeat(String seatNumber) { // someone could enter invalid seat
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			
			System.out.println("...");
			
			if (seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}
		if(requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	// BINARY reserve seat algorithm
	public boolean reserveSeatBinary(String seatNumber) {
		int low = 0;
		int high = seats.size();
		
		while(low<=high) {
			
			System.out.println("....");
			
			// capture the middle value
			int mid = (low + high) / 2;
			
			// use the middle value to capture the middle seat of the row
			Seat midVal = seats.get(mid); // get() is a method to retrieve that value from the array
			
			// we have to check is the seatNumber passed through > or < the midVal
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			// 0 if equal, -1 if less than, 1 if greater than
			
			if (cmp<0) {
				low = mid + 1;
			} else if(cmp > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
			
			
			
		}
		System.out.println("There is no seat " + seatNumber);
		return false;
	}
	
	
	
	/*
	 * Comparable is a special interface that allows us to define the order of a user-defined Class
	 */
	
	
	// this is a nested Class
	private class Seat implements Comparable<Seat> { // Comparable is an interface we use to define order within a user-created class
		
		private final String seatNumber; // A11 - G11
		private boolean reserved = false;
		
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}


		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserve() {
			
			if(!this.reserved) {
				this.reserved = false;
				
				System.out.println("Seat " + seatNumber + " has been reserved.");
				
				return true;
			} else {
				return false;
			}
		}

		// This is how we define if a set is greater than or less than another
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
		
	}
	
	
}
