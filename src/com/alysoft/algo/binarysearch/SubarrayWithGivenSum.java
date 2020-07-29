package com.alysoft.algo.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. 
The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left 
if sum equals to subarray, else print -1.

User Task:
The task is to complete the function subarraySum() which finds starting and ending positions(1 indexing) of first such occuring subarray 
from the left if sum equals to subarray, else -1 is printed. The driver code automatically appends a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= Ai <= 1010

Example:
Input:
3
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
4 15
5 7 1 2
Output:
2 4
1 5
1 4

Explanation : 
Testcase1: sum of elements from 2nd position to 4th position is 12.
Testcase2: sum of elements from 1st position to 5th position is 15.
 
 * @author ymohammad
 *
 */
public class SubarrayWithGivenSum
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            subarraySum(n, s, m);
            System.out.println();
        }
	}
	//42 468
	//135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 
	//96 48 127 172 139 70 113 68 100 36 95 104 12 123 134
	static void subarraySum(int n, int s, int[] m) {
		int startInd = 0;
        int endInd = 1;
        int currSum = m[startInd];
        if (currSum == s) {
            System.out.print((startInd+1) + " " + (startInd+1));
            return;
        }
        while (endInd<n) {
            currSum += m[endInd];
            if (currSum > s) {
                while (currSum > s) {
                    currSum -= m[startInd];
                    startInd++;
                }
            }
            if (currSum == s) {
                System.out.print((startInd+1) + " " + (endInd+1));
                return;
            }
            endInd++;
        }
        System.out.print(-1);
		/*
        int p1 = 0;
		int p2 = 0;
		int sum = 0;
		while (p1<n || p2<n) {
			 
			if (sum < s && p2<n) {
				sum += m[p2];
				p2++;
				while (sum < s && p2<n) {
                    sum += m[p2];
                    p2++;
                }
			}
			if (sum > s && p1<n) {
				sum = sum-m[p1];
				p1++;
				while (sum > s && p1<n) {
                    sum -= m[p1];
                    p1++;
                }
			}
			if (sum == s) {
				System.out.print((p1+1) + " " + (p2));
				return;
			}
		}
		System.out.print("-1");
		*/
    }
}
