package com.alysoft.algorithms;

/**
 * Write a program that prints the integers from 1 to 100 (inclusive).
 * But:
 * 	-	for multiples of three, print Fizz (instead of the number)
 *  -	for multiples of five, print Buzz (instead of the number)
 *  -	for multiples of both three and five, print FizzBuzz (instead of the number).
 */
public class FizzBuzzProblem {

	public static void main(String[] args) {
		int initialNumb = 1;
		int finalNumber = 100;
		loopProgram1(initialNumb, finalNumber);
		loopProgram2(initialNumb, finalNumber);
		loopProgram3(initialNumb, finalNumber);
	}
	
	
	//This function can be used instead of Loop. It is not required to loop always to perform some repeted actions.
	private static void loopProgram1(int nextNumber, int limitNumber) {
		if (nextNumber > limitNumber) {
			return;
		}
		
		if (nextNumber % 3 == 0 && limitNumber % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (nextNumber % 3 == 0) {
			System.out.println("Fizz");
		} else if (nextNumber % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(nextNumber);
		}
		nextNumber++;
		loopProgram1(nextNumber, limitNumber);
	}
	//Second version of this program can be enhanced.
	// Instead of using expressions multiple times.
	// Store it in to variables.
	private static void loopProgram2(int nextNumber, int limitNumber) {
		if (nextNumber > limitNumber) {
			return;
		}
		
		boolean isFizzBuzz = (nextNumber % 3 == 0 && limitNumber % 5 == 0);
		boolean isFuzz = (nextNumber % 3 == 0);
		boolean isBuzz = (nextNumber % 5 == 0);
		String result = "";
		
		if (isFizzBuzz) {
			result = ("FizzBuzz");
		} else if (isFuzz) {
			result = ("Fizz");
		} else if (isBuzz) {
			result = ("Buzz");
		} else {
			result = "" + (nextNumber);
		}
		System.out.println(result);
		nextNumber++;
		loopProgram2(nextNumber, limitNumber);
	}
	
	//Third version of this program can be enhanced.
	// instead of using multiple if - else, lets use a single statement.
	private static void loopProgram3(int nextNumber, int limitNumber) {
		if (nextNumber > limitNumber) {
			return;
		}

		boolean isFizzBuzz = (nextNumber % 3 == 0 && limitNumber % 5 == 0);
		boolean isFuzz = (nextNumber % 3 == 0);
		boolean isBuzz = (nextNumber % 5 == 0);
		String result = isFizzBuzz ? "FizzBuzz" : isFuzz ? "Fizz"
				: isBuzz ? "Buzz" : Integer.toString(nextNumber);
		System.out.println(result);
		nextNumber++;
		loopProgram3(nextNumber, limitNumber);
	}
}
