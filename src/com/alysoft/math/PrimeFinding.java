package com.alysoft.math;

public class PrimeFinding
{

	public static boolean isPrime(int n) {
		n = Math.abs(n);
		
		if (n < 2) return false;
		
		if (n%2 == 0) return n==2; 
		
		//by this point, it is establish that n is not an even number and a >= 3.
		
		/**
		 * Based on formula,
		 * Let 'a' be integer, a >= 2. Then a is prime if and only if no integer i such that
		 * 1 < i^2 <= a divides a.
		 */
		int i = 3;
		while ((i*i)<=n) {
			if (n%i == 0) return false;
			i = i + 2; //Assign next odd number.
		}
		return true;
	}
	public static void main(String[] args)
	{
		System.out.println("is Prime 107 :" + isPrime(107));
		System.out.println("is Prime -2468 :" + isPrime(-2468));
		System.out.println("is Prime 10 :" + isPrime(10));
		System.out.println("is Prime 9 :" + isPrime(9));
		System.out.println("is Prime 99999 :" + isPrime(99999));
		System.out.println("is Prime 23 :" + isPrime(23));
		System.out.println("is Prime 91 :" + isPrime(91));
	}

}
