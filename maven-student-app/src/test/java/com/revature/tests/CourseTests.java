package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Course;

public class CourseTests {
	
	static Course c1;
	static Course c2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Running before all tests within test suite");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Running after all tests within test suite");
	}
	
	// something to execute before each test
	@Before
	public void setUp() {
		c1 = new Course("English 101");
		c2 = new Course("Astrophysics 550");
	}
	
	@After
	public void tearDown() {
		c1 = null;
		c2 = null;
	}
	
	@Test
	public void test() {
		System.out.println("I'm a test");
	}
	
	
	// Test get getName()
	@Test
	public void testGetName() {
		String expectedName = "English 101";
		
		String actualName = c1.getName();
		
		assertEquals(expectedName, actualName);
		
		
	}
	
	
	
	// Test set setName()
	@Test
	public void testSetName() {
//		String newName = "Spanish 202";
//		
//		c1.setName(newName);
//		
//		assertEquals(newName, c1.getName());
		
		String nameToSet = "CS 500";
		
		c1.setName(nameToSet);
		
		assertTrue(c1.getName().equals(nameToSet));
		
	}
	
	
	
}
