package com.alysoft.algo.arrays;

/**
 * Given two arrays L[] and R[] consisting of N ranges of the form L and R, L[i] consists of starting point of range and R[i] consists 
 * of corresponding end point of the range. The task is to find the maximum occurred integer in all the ranges. If more than one such 
 * integer exits, print the smallest one.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an 
integer n denoting the size of the ranges. The next two lines contain the n space separated elements of L and R respectively.

Output:
Print the smallest maximum occured integer in all the ranges.

User Task:
The task is to complete the function maxOccured() which returns the maximum occured integer in all ranges.

Constraints:
1 <= T <= 102
1 <= n <= 106
0 <= L[i], R[i] <= 106

Example:
Input:
2
4
1 4 3 1
15 8 5 4
5
1 5 9 13 21
15 8 12 20 30

Output:
4
5

Explanation:
Testcase 1: 4 is the most occurring element after considering all the ranges. So, output is 4.
 * @author ymohammad
 *
 */
public class MaximumOccuredInteger
{

	public static void main(String[] args)
	{
		int[] L = {1, 5, 9, 13, 21};
		int[] R = {15, 8, 12, 20, 30};
		System.out.println(maxOccured(L, R, L.length, 0));
	}
	public static int maxOccured(int L[], int R[], int n, int maxx){
        
        int[] preSumArr = new int[50];
        int maxOccValue = 0;
        int maxOccFreq = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            int low = L[i];
            int high = R[i];
            preSumArr[low] = preSumArr[low]+1;
            preSumArr[high+1] = preSumArr[high+1]-1;
        }
        for (int i = 1; i<preSumArr.length; i++) {
            preSumArr[i] = preSumArr[i-1]+preSumArr[i];
            if (maxOccFreq < preSumArr[i]) {
                maxOccFreq = preSumArr[i];
                maxOccValue = i;
            }
        }
        return maxOccValue;
    }
}
