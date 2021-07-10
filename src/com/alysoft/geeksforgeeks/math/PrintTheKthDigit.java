package com.alysoft.geeksforgeeks.math;

import java.util.*;
import java.lang.*;
import java.io.*;

public class PrintTheKthDigit
{

	public static void main(String[] args)
	{
		// Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
        	int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            method2(a, b, k);
            t--;
        }
	 }
	
	public static void method1(int a, int b, int k) {
		// Input the size of the array
        
        String kString = Integer.toString(k);
        long d = (long)Math.pow(a, b);
        
        String value = Long.toString(d);
        if (k > value.length()) {
        	throw new RuntimeException("Invalid digit number " + k);
        }
        int digit = 1;
        for (int x = value.length()-1; x >= 0; x--) {
            if ( Integer.toString(digit).equals(kString)) {
            	System.out.println(value.charAt(x));
            	break;
            }
            digit++;
        }
	}
	
	public static void method2(int a, int b, int k) {
		long d = (long)Math.pow(a, b);
		int digit = 1;
		if (k > Long.toString(d).length()) {
        	throw new RuntimeException("Invalid digit number " + k);
        }
		while (d > 0 && digit <= k) {
			if (digit == k) {
				long x = (long)d%10;
				System.out.println(x);
				break;
			}
			d = d/10;
			digit++;
		}
	}
}
