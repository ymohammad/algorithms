package com.alysoft.geeksofgeeks.math;

public class BinomialCoefficient
{

	public static void main(String[] args) {
		//System.out.println("getBinomialCoefficient :" + getBinomialCoeffientWithDP(10, 5));
		System.out.println("getBinomialCoefficient :" + binomialWithInt(778, 116));
	}
	
	public static int getBinomialCoefficient(int n, int r) {
		if (r == 0 || r == n) return 1;
		
		return (getBinomialCoefficient(n-1, r-1) + getBinomialCoefficient(n-1, r));
	}
	public static long binomialWithInt(int n, int k) {
		long res = 1L;
		
		//As we know.. C(n, k) = C(n, n-k) if k > n-k
		if (k > n-k) {
			k = n-k;
		}
		for (int i = 0; i<k; i++) {
			res *= (n-i);
			res /= (i+1);
		}
		return res%1000000007;
	}
	public static int getBinomialCoeffientWithDP(int n, int r) {
		int[][] dpArray = new int[n+1][r+1];
		int i, j;
		
		for (i = 0; i<=n; i++) {
			for (j = 0; j<=Math.min(i, r); j++) {
				if (j == 0 || j == i) {
					dpArray[i][j] = 1; 
				} else {
					dpArray[i][j] = dpArray[i-1][j-1] + dpArray[i-1][j];
				}
			}
		}
		return dpArray[n][r];
	}
}
