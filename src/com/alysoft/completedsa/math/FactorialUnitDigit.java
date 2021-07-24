package com.alysoft.completedsa.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 * Given a number N. The task is to find the unit digit of factorial of given number N.

Input:
First line of input contains number of testcases T. For each testcase, there will be a single line containing N.

Output:
For each testcase, print the unit digit of factorial of N.

Constraints:
1 <= T <= 1000
1 <= N <= 1018

Example:
Input:
2
3
4

Output:
6
4
 */
public class FactorialUnitDigit
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            long n = Long.parseLong(br.readLine());
 
            System.out.println(getFactorialUnitPlace(n));
 
            t--;
        }
	}

	private static int getFactorialUnitPlace(long r) {
		if (r >= 5) return 0;
		
		int factorial = 1;
		while (r > 1) {
			factorial = (int)(factorial * r);
			r = r-1;
		}
		return factorial%10;
	}
}
