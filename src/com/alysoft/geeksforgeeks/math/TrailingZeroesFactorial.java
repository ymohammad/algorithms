package com.alysoft.geeksforgeeks.math;

public class TrailingZeroesFactorial
{

	public static void main(String[] args)
	{
		System.out.println("getTrailingZerosCount(60) :" + getTrailingZerosCount(60));
		System.out.println("getTrailingZerosCount(5) :" + getTrailingZerosCount(5));
		System.out.println("getTrailingZerosCount(4) :" + getTrailingZerosCount(4));
		System.out.println("getTrailingZerosCount(9) :" + getTrailingZerosCount(9));
	}
	public static int getTrailingZerosCount(int n) {
		int count = 0;
		int devisor = 5;
		while (n/devisor != 0) {
			count = count + (n/devisor);
			devisor = devisor*5;
		}
		return count;
	}
}
