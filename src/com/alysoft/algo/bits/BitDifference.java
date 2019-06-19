package com.alysoft.algo.bits;

/**
 * You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is A and B separated by a space.

Output:
For each testcase, in a new line, print the number of bits needed to be flipped.

User Task:
The task is to complete the function countBitsFlip() which count the number of bits to be flipped to convert A to B.

Constraints:
1 ≤ T ≤ 100
1 ≤ A, B ≤ 103

Example:
Input:
1
10 20
Output:
4

Explanation:
Testcase1:
A  = 01010
B  = 10100
Number of bits need to flipped = set bit count in A XOR B value i.e. 4
 * @author ymohammad
 *
 */
public class BitDifference
{

	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		int x = countBitsFlip(a, b);
		System.out.println(x);
	}
	public static int countBitsFlip(int a, int b){
        
		int x = a^b;
		return getBitsSetCount(x);
    }
	private static int getBitsSetCount(int x)
	{
		int count = 0;
		while (x != 0) {
			x = x&(x-1);
			count++;
		}
		return count;
	}
}
