package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChallenge {
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the total possible quiz score: ");
		
		double totalPossible = scan.nextInt();
		
		System.out.println("Enter the amount of points you got right on the quiz out of " + String.format("%.0f", totalPossible) + ": ");
		
		double score = scan.nextInt();
		
		String letterGrade = new String();
		
		double grade = gradeCalc(score, totalPossible);
		
		if (grade >= 90) {
			letterGrade = "A";
		} else if (grade >= 80) {
			letterGrade = "B";
		} else if (grade >= 70) {
			letterGrade = "C";
		} else if (grade >= 60) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		
		System.out.println("The Student's Letter grade is " + letterGrade + ". That's " + String.format("%.0f", grade) + "% !");
		
		scan.close();
	}
	
	
	public static double gradeCalc(double score, double totalPossible) {
		return score / totalPossible * 100;
	}
	
	
}
