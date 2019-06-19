package com.alysoft.algo.maths;

/**
 * Given an integer N. The task is to find the number of digits that appear in its factorial, where factorial is defined as, factorial(n) = 1*2*3*4……..*N and factorial(0) = 1.

Input Format:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of one line. The first line of each test case consists of an integer N.

Output Format:
Corresponding to each test case, in a new line, print the number of digits that appear in its factorial.

Your Task:
This is a function problem. You only need to complete the function digitsInFactorial() that takes N as parameter and returns number of digits in factorial of N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 104

Example:
Input:
2
5
120

Output:
3
199

Explanation:
Testcase 1: Factorial of 5 is 120. Number of digits in 120 is 3 (1, 2, and 0).
 
 * @author ymohammad
 *
 */
public class DigitsInFactorial
{

	public static void main(String[] args)
	{
		System.out.println("Digits in 5! :" + digitsInFactorial(5));
		System.out.println("Digits in 120! :" + digitsInFactorial(120));
	}
	public static int digitsInFactorial(int N)
    {
		double logVal = 0d;
		for (int i = 1; i<=N; i++) {
			logVal += Math.log10(i);
		}
        logVal = Math.ceil(logVal);
        return (int)logVal;
    }
}
