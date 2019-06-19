package com.alysoft.algo.bits;

/**
 * Given a number N.  The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set  in the binary representation.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is number 'N'.

Output:
Print '1' if the number is sparse and '0' if the number is not sparse.

User Task:
The task is to complete the function checkSparse() which checks if the given number is sparse or not.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
2
3

Output:
1
0

Explanation:
Testcase 1: Binary Representation of 2 is 10, which is not having consecutive set bits. So, it is sparse number.
Testcase 2: Binary Representation of 3 is 11, which is having consecutive set bits in it. So, it is not a sparse number.
 * @author ymohammad
 *
 */
public class SparseNumber
{

	public static void main(String[] args)
	{
		System.out.println("2 :" + isSparse(2));
		System.out.println("3 :" + isSparse(3));
	}
	public static boolean isSparse(int n){
        boolean isParse = true;
        boolean flag = false;
        while (n != 0) {
        	int x = n&1;
        	if (x == 1) {
        		if (flag) {
        			return false;
        		} else {
        			flag = true;
        		}
        	} else {
        		flag = false;
        	}
        	n = n>>1;
        }
        return isParse;
    }
	public static boolean isSparse2(int n) {
		return (n&(n>>1)) == 0;
	}
}
