package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	
	private static Scanner scan = new Scanner(System.in);
	
	
	private static int globalId = 1000; // every time a student is instantiated I will increase this by 1.

	// fistname
	// lastname
	// gradeyear
	// studentID
	// list of courses
	// tuition balance
	private String firstName;
	private String lastName;
	private int gradeYear; // 1 - Freshman 2 - Sophmore
	private String studentId; // we are concatenating the grade year to an autogenreated id
	private List<Course> courses = new ArrayList<Course>();
	
	// here we are declaring DYNAMIC data structure and inferring generics.
	// ArrayLists allow me to add and remove with ease
	private double tuitionBalance = 0;
	
	
	
	
	
	
	

	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		// call setStudentId()
		setStudentId();
		
		System.out.println(firstName + " " + lastName + " " + globalId);
		
	}
	
	// first student -> 21001
	// second student (senior) -> 41002
	
	// getters and setters
	
		public String getStudentId() {
			return studentId;
		}
		
	


	// setStudentId() gradeYear concatenated static id field
	private void setStudentId() {
		globalId++;
		this.studentId = gradeYear + "" + globalId; // necessary to SMUSH the ints together not return as a string
	}
	
	
	// enroll()
	public void enroll() {
		
		
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		boolean isDone = false;
		
		
		while(!isDone) {
			
			System.out.println("Enter a course to enroll in: ");
			
			String courseName = scan.next();
			
			// if the user presses q to quit we quit out of the loop
			
			if(!courseName.equalsIgnoreCase("q")) {
				
				Course newCourse = new Course(courseName);
				
				coursesToAdd.add(newCourse);
				tuitionBalance += Course.COST_OF_COURSE;
				
				scan.nextLine();
				
			} else {
				System.out.println("======= QUITTING ======");
				isDone = true;
			}
			
			courses = coursesToAdd;
			
			System.out.println("ENROLLED IN: " + courses.toString());
			
			
			
		}
		
		
	}
	
	
	// viewBalance()
	public void viewBalance() {
		System.out.println("Your balance is $" + tuitionBalance);
	}
	
	
	
	// payTuition()
	public void payTuition() {
		viewBalance();
		
		System.out.println("Enter your payment amount: ");
		
		double payment = scan.nextDouble();
		tuitionBalance -= payment;
		
		System.out.println("Thank you for you payment of " + payment);
		
		viewBalance();
	}
	
	
	
	// showStatus()
	public void showStatus() {
		System.out.println("\nName: " + firstName + " " + lastName + "\nStudent ID: " + studentId + 
						   "\nCourses enrolled in: " + courses.toString() + "\nTuition: " + tuitionBalance);
	}
	
	
}
