package com.alysoft.algo.maths;

/**
 * Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output:
For each testcase, in a new line, print the answer of each test case.

Your Task:
This is a function problem. You only need to complete the function exactly3Divisors() that takes N as parameter and returns 
count of numbers less than or equal to N with exactly 3 divisors.

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
public class Exactly3Divisors
{
	public static void main(String[] args) {
		Exactly3Divisors obj = new Exactly3Divisors();
		System.out.println(obj.exactly3Divisors(25));
	}
	public int exactly3Divisors(int N)
    {
        int returnVal = 0;
        if (N > 3) {
        	for (int i = 4; i<=N; i++) {
        		int sq = (int) Math.sqrt(i);
        		if ((sq*sq) == i && isPrime(sq)) {
        			returnVal++;
        		}
        	}
        }
        return returnVal;
    }

	private boolean isPrime(int sq)
	{
		if (sq == 2) return true;
		
		for (int i = 2; (i*i)<=sq; i++) {
			if (sq%i == 0) {
				return false;
			}
		}
		return true;
	}
}
