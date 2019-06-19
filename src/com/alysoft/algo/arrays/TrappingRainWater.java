package com.alysoft.algo.arrays;

/**
 * Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. 
 * Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.



Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. 
Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

User Task:
The task is to complete the function trappingWater() which returns the total amount of water that can be trapped.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.
 * @author ymohammad
 *
 */
public class TrappingRainWater
{
	public static void main(String[] args) {
		//int[] arr = {7, 4, 0, 9};
		//int[] arr = {6, 9, 9};
		int[] arr = {3,0,0,2,0,4};
		System.out.println("Total Trapped :" + trappingWater(arr, arr.length));
	}
	static int trappingWater(int arr[], int n) { 
        int[] leftMaxArray = new int[n];
        int[] rightMaxArray = new int[n];
        
        leftMaxArray[0] = arr[0];
        for (int i =1; i<n; i++) {
        	leftMaxArray[i] = Math.max(leftMaxArray[i-1], arr[i]);
        }
        
        rightMaxArray[n-1] = arr[n-1];
        for (int i =n-2; i>=0; i--) {
        	rightMaxArray[i] = Math.max(rightMaxArray[i+1], arr[i]);
        }
        int trapedWaterUnits = 0;
        for (int i=0; i<n; i++) {
        	int leftMax = leftMaxArray[i];
        	int rightMax = rightMaxArray[i];
        	int diff = Math.min(rightMax, leftMax);
        	trapedWaterUnits += Math.abs(arr[i]-diff);
        }
        return trapedWaterUnits;
    } 
}
