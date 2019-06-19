package com.alysoft.algo.bits;

/**
 * Given a number N. The task is to find the length of the longest consecutive 1s in its binary representation.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the length of the longest consecutive 1's in N's binary representation.

User Task:
The task is to complete the function maxConsecutiveOnes() which returns the length of longest consecutive 1s in the binary representation of given N.

Constraints:
1 <= T < 100
1 <= N <= 103

Example:
Input:
2
14
222

Output:
3 
4

Explanation:
Testcase 1: Binary representation of 14 is 1110, in which 111 is the longest consecutive set bits and length is 3.
 * @author ymohammad
 *
 */
public class ConsecutiveOne
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Result 14 " + maxConsecutiveOnes(14));
		System.out.println("Result 222 " + maxConsecutiveOnes(222));
	}
	public static int maxConsecutiveOnes(int x) {
        int maxLength = 0;
        int localLength = 0;
        while (x != 0) {
        	int r = x&1;
        	if (r == 1) {
        		localLength++;
        	} else {
        		maxLength = Math.max(maxLength, localLength);
        		localLength = 0;
        	}
        	x = x>>1;
        }
        maxLength = Math.max(maxLength, localLength);
        return maxLength;
    }
	public static int maxConsecutiveOnes2(int x) {
        int count = 0;
        while (x!=0) {
            x = (x & (x << 1));
            count++;
        }
        return count;
    }
}
