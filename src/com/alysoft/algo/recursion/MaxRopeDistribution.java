package com.alysoft.algo.recursion;

/**
 * Given a rope of Length 'n' and numbers (a, b, c). We need to make maximum pieces such that
 * every piece should be in the set (a, b, c).
 * 
 * IP: n = 5, (1, 2, 3).
 * OP: 5 (We can make 5 pieces of length 5).
 * 
 * IP: n = 23, (9, 11, 12)
 * OP: 2 (Piece of length 11 and length 12).
 * 
 * IP: n =5, (2, 4, 6).
 * OP: -1
 * @author ymohammad
 *
 */
public class MaxRopeDistribution
{
	public static void main(String[] args) {
		System.out.println("(5, 1, 2, 3) =>" + getMaxLengthPices(5, 1, 2, 3));
		System.out.println("(23, 9, 11, 12) =>" + getMaxLengthPices(23, 9, 11, 12));
		System.out.println("(5, 2, 4, 6) =>" + getMaxLengthPices(5, 2, 4, 6));
	}

	public static int getMaxLengthPices(int n, int a, int b, int c) {
		/*
		int aSizeLengthPices = getPieces(n, a, 0);
		int bSizeLengthPices = getPieces(n, b, 0);
		int cSizeLengthPices = getPieces(n, c, 0);
		*/
		
		if (n<0) return -1;
		if (n == 0) return 0;
		
		int aSizeLengthPices = getMaxLengthPices(n-a, a, b, c);
		int bSizeLengthPices = getMaxLengthPices(n-b, a, b, c);
		int cSizeLengthPices = getMaxLengthPices(n-c, a, b, c);

		int finalVal = Math.max(aSizeLengthPices, Math.max(bSizeLengthPices, cSizeLengthPices));
		return (finalVal == -1 ? -1 : (1+finalVal));
	}

	private static int getPieces(int n, int aSize, int res)
	{
		if (n == 0) return res;
		
		if (n < 0) return -1;
		
		return getPieces(n-aSize, aSize, res+1);
	}
}
