package com.alysoft.algo.maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given a value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input Format:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output Format:
For each testcase, in a new line, print the answer of each test case.

Constraints :
1 <= T <= 105
1 <= N <= 109

Example:
Input :
3
6
10
30

Output :
1
2
3

Explanation:
Testcase 1: There is only one number 4 which has exactly three divisors 1, 2 and 4.

 
 
 * @author ymohammad
 *
 */
public class Divisors
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
	        while (t > 0)
	        {
	            int n = Integer.parseInt(br.readLine().trim());
	            
	            int nthTerm = exactly3Divisors(n);
	            System.out.println(nthTerm);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}
	public static int exactly3Divisors(int N)
    {
		int result = 0;
		int i = 2;
		while (i <= N) {
			int sqrt = (int)Math.sqrt(i);
			if (sqrt*sqrt == i && isPrime(sqrt)) {
				result++;
			}
			i++;
		}
		return result;
    }
	private static boolean isPrime(int sqrt)
	{
		int i = 2;
		while (i*i <= sqrt) {
			if (sqrt%i == 0) return false;
			
			i++;
		}
		return true;
	}
	
	 public int Median(int A[],int N)
	    {
	       //Your code here
	       Arrays.sort(A);
	       int mid = N/2;
	       if (N%2 == 0) {
	    	   return (A[mid-1] + A[mid])/2;
	       } else {
	    	   return A[mid];
	       }
	    }
}
