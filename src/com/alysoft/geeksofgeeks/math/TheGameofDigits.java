package com.alysoft.geeksofgeeks.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a number N. Find a number K such that product of digits of K must be equal to N.
Note : K must be as small as possible.

Input: First line of input contains number of testcases T. For each testcase, there will be a single line containing N.

Output: For each testcase, output single integer. If K is not possible, print "-1" (without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 1015

Example:
Input:
2
12
5

Output:
26
5

Explanation:
Testcase 1: 26 is the smallest number, and product of 2 and 6 is 12.
Testcase 2: 5 is the smallest number which is itself equal to 5.
 * @author ymohammad
 *
 */
public class TheGameofDigits
{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            long n = Long.parseLong(br.readLine());
 
            System.out.println(getDigitProduct(n));
 
            t--;
        }
	}

	private static String getDigitProduct(long n)
	{
		if (isPrime(n)) return Long.toString(n);
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> factorsQ = getAllFactors(n);
		//System.out.println("All factors :" + factorsQ);
		sb.append(factorsQ.remove());
		
		long productComparision = 1L;
		while(!factorsQ.isEmpty()) {
			int temp = factorsQ.remove();
			productComparision = productComparision*temp;
			
			if (factorsQ.peek() == null) {
				sb.append(temp);
				continue;
			}
			int product = temp*factorsQ.peek();
			int appendValue = Integer.parseInt(temp+""+factorsQ.peek());
			if ( product < 9) {
				productComparision = productComparision*temp;
				sb.append(temp*factorsQ.remove());
			} else if (product <= appendValue){
				sb.append(temp*factorsQ.remove());
			} else {
				factorsQ.remove();
				sb.append(appendValue);
			}
		}
		
		return verifyNReturn(sb.toString(), n);
	}
	
	private static boolean isPrime(double number)
	{
		if (number == 1) return false;
		if (number == 2) return true;
		double numberSqrt = Math.sqrt(number);
		for (int x=2; x<=numberSqrt; x++) {
			if (number%x == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static String verifyNReturn(String sb, long n)
	{
		if (sb.length() > 15) {
			return "-1" ;
		}
		String[] digits = sb.split("");
		long product = 1L;
		for (String s: digits) {
			product = product * Long.parseLong(s);
			if (product > n) {
				return "-1";
			}
		}
		
		if (product != n) return "-1";
		
		return sb;
	}

	public static Queue<Integer> getAllFactors(long n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		if (n%2 == 0) {
			queue.add(2);
			n = n/2;
		}
		int maxFactor = 1;
		while (n%2 == 0) {
			if (maxFactor == 8) {
				queue.add(maxFactor);
				maxFactor = 1;
			} else {
				maxFactor = maxFactor*2;
			}
			n = n/2;
		}
		if (maxFactor != 1) queue.add(maxFactor);
		
		for (int p = 3; p*p < n; p = p+2) {
			while (n%p == 0) {
				queue.add(p);
				n = n/p;
			}
		}
		
		if (n>2) {
			queue.add((int)n);
		}
		return queue;
	}
}
