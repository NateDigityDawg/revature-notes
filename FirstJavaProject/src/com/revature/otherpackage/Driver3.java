package com.revature.otherpackage;

import com.revature.accessmods.Driver1;

public class Driver3 extends Driver1 { // by extending we are inheriting the properties (fields) & behaviors of the parent class

	Driver3 d3 = new Driver3();
	
	int i = d3.publicField; // this already exists because we are inheriting it through Driver1
	
//	int j = d3.defaultField; we can't inherit that because it's default
	
	int k = d3.protectedField; // this field is inherited automatically from Driver1
	
	
}
