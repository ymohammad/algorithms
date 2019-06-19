package com.alysoft.codechef.dp;

public class FibonacciSeries
{
	public static void main(String[] args) {
		printFibonacciSeries(7000);
	}

	static void printFibonacciSeries(int n) {
		//long x = getFibonacciSeries(n, new long[n+1]);
		//long x = getFibNacciSeriesRec(n);
		long x = getFibNacciSeriesIterative(n);
		System.out.println("Fibonacci Number for " + n + ": " + x);
	}

	private static long getFibonacciSeries(int n, long[] mom)
	{
		if (n == 0 || n == 1 ) return n;

		if (mom[n] == 0) {
			mom[n] = getFibonacciSeries(n-1, mom) + getFibonacciSeries(n-2, mom);
		}
		
		return mom[n];		
	}
	
	static long getFibNacciSeriesRec(int n) {
		if (n == 0 || n == 1 ) return n;

		return getFibNacciSeriesRec(n-1) + getFibNacciSeriesRec(n-2);
	}
	
	static long getFibNacciSeriesIterative(int n) {
		if (n == 0) return 0;
		
		long a = 0L;
		long b = 1L;
		
		for (int i=2; i<n; i++) {
			long c = a + b;
			a = b;
			b = c;
		}
		return (a+b);
	}
}
