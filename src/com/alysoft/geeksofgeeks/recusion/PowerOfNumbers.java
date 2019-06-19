package com.alysoft.geeksofgeeks.recusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a number N, let the reverse of the number be R. The task is to print the output of the Expression pow(N,R), where pow function 
 * represents N raised to power R.
Note: As answers can be very large, print the result modulo 1000000007.

Input:
The first line of the input consists of an integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of a single line containing an integer N.

Output:
Corresponding to each test case, print in a new line, the output of the expression pow as described above.

Constraints:
1 <= T <= 103
1 <= N <= 105

Example:
Input:
2
2
12

Output:
4
864354781

Explanation:
Testcase 1: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 by dividing 1000000007.
 * @author ymohammad
 *
 */
public class PowerOfNumbers
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	String line = br.readLine().trim();
        	String reverseLine = new StringBuffer(line).reverse().toString();
            int n = Integer.parseInt(line);
            int k = Integer.parseInt(reverseLine);
				
			
			System.out.println(getPower(n, k));
            t--;
        }
	}

	private static long getPower(int n, int k)
	{
		int d = 1000000007;
		long result = 1L;
		for (int i = 0; i<k; i++) {
			result = result * n;
			result = result%d;
		}
		return result;
	}
}
