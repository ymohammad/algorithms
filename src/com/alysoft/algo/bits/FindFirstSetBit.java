package com.alysoft.algo.bits;

import java.util.Scanner;

/**
 * Given an integer an N. The task is to print the position of first set bit found from right side in the binary representation of the number.

Input:
The first line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. 
The only line of the each test case contains an integer N.

Output:
For each test case print in a single line an integer denoting the position of the first set bit found form right side of the 
binary representation of the number. If there is no set bit print "0".

User Task:
The task is to complete the function getFirstSetBit() to find the position of first set bit.

Constraints:
1 <= T <= 200
0 <= N <= 106

Example:
Input:
2
18
12

Output:
2
3

Explanation:
Testcase 1: Binary representation of the 18 is 010010, the first set bit from the right side is at position 2.
 * @author ymohammad
 *
 */
public class FindFirstSetBit
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			System.out.println(getFirstSetBitPos(n));
		}
		sc.close();
	}
	public static int getFirstSetBitPos(int n){
	    int index = 1;
	    while (n > 0) {
	        
	        if ((n&1) == 1) {
	            return index;
	        }
	        index++;
	        n = n>>1;
	    }
	    return 0;
	}
}
