package com.alysoft.geeksforgeeks.math;

import java.math.BigInteger;

public class FindNCR
{

	public static void main(String[] args) {
		System.out.println("Value :" + getNpR(778, 116));
		System.out.println("Factorial 116" + getFactorial(116));
		System.out.println("NCR :" + getnCr(778, 116));
	}
	public static int getnCr(int n, int r) {
		if (r>=n) return 0;
		
		BigInteger npR = getNpR(n, r);
		BigInteger rFactorial = getFactorial(r);
		npR = npR.divide(rFactorial);
		System.out.println("Total Value :" + npR);
		npR = npR.mod(new BigInteger(Integer.toString(1000000007)));
		System.out.println("After Modulus Value :" + npR);
		return npR.intValue();
	}

	private static BigInteger getNpR(int n, int r)
	{
		BigInteger bg = new BigInteger("1");
		long breaker = (n-r);
		while (n > breaker) {
			bg = bg.multiply(new BigInteger(Integer.toString(n)));
			n = n-1;
		}
		
		return bg;
	}
	private static BigInteger getFactorial(int r) {
		BigInteger bg = new BigInteger("1");
		while (r > 1) {
			bg = bg.multiply(new BigInteger(Integer.toString(r)));
			r = r-1;
		}
		return bg;
	}
}
