package com.alysoft.algo.bits;

import java.math.BigInteger;

public class PowerOf2
{

	public static void main(String[] args)
	{
		BigInteger b = new BigInteger("1099511627776");
		System.out.println("PowerOf2.main() " + isPowerofTwo(b));
		System.out.println("PowerOf2.main() 0" + isPowerofTwo(BigInteger.ZERO));
		System.out.println("PowerOf2.main() " + isPowerofTwo(new BigInteger("1")));
	}
	public static boolean isPowerofTwo(BigInteger n){
		if (n.equals(BigInteger.ZERO)) return false;
		
		BigInteger b = n.subtract(BigInteger.ONE);
		BigInteger and = n.and(b);
		return and.equals(BigInteger.ZERO);
	}
	    
}
