package com.alysoft.algo.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Given an array of positive integers. Your task is to find the leaders in the array.

Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader. 

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print all the leaders.

User Task:
The task is to complete the function leader() which returns an array of leaders in same order as they appear in the array. 
The printing is automatically done by driver code.

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Ai <= 107

Example:
Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3

Explanation:
Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side 
of 7 (at index 3) are smaller than 7. 
And, the last element 3 is itself a leader since no elements are on its right.
 * @author ymohammad
 *
 */
public class LeadersInAnArray
{

	public static void main(String[] args)
	{
		int[] arr = {16, 17, 4, 3, 5, 2};
		System.out.println(leaders(arr, arr.length));

	}
	static ArrayList<Integer> leaders(int arr[], int n){
        
        // Your code here
        
        
        /******************
	     * You just need to complete this
	     * function and return the vector
	     * containing the leaders.
	     * ***************/
	     Stack<Integer> returnList = new Stack<Integer>();
	     returnList.push(arr[n-1]);
	     int localMax = arr[n-1];
	     int i = n-2;
	     while (i >= 0) {
	    	 if (arr[i]>localMax) {
	    		 returnList.push(arr[i]);
	    		 localMax = arr[i];
	    	 }
	    	 i--;
	     }
	     ArrayList<Integer> list = new ArrayList<Integer>(returnList.size());
	     while (!returnList.isEmpty()) {
	    	 list.add(returnList.pop());
	     }
	     return list;
    }
}
