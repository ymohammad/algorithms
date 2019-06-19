package com.alysoft.euler;

public class Problem1
{
	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 * 
	 */
	
	public static void bruteForceMultiples(int x, int y, int n) {
		int sum = 0;
		for (int i = 1; i<n; i++) {
			if (i%x == 0 || i%y == 0) {
				sum += i;
			}
		}
		System.out.println("Sum :" + sum);
	}
	public static void main(String[] args)
	{
		bruteForceMultiples(3, 5, 10);
		bruteForceMultiples(3, 5, 1000);
	}

}
