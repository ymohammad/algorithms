package com.alysoft.algo.hashing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given an unsorted array arr[] of N integers and a sum. The task is to count the number of subarray which adds to a given number.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case contains an integer N denoting the size of the array. The next line contains N space separated integers forming the array. 
The last line contains an integer denoting the value of the sum.

Output Format:
For each testcase, in a new line, print the count of the subarray which adds to the given sum.

Your Task:
This is a function problem. You only need to complete the function subArraySum() that takes arr, n, sum as parameters and returns the count.

Constraints:
1 <= T <= 200
1 <= N <= 105
-105 <= arr[i] <= 105
-105 <= sum <= 105

Example:
Input:
2
5
10 2 -2 -20 10
-10
6
1 4 20 3 10 5
33

Output:
3
1

Explanation:
Testcase 1: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
 * @author ymohammad
 *
 */
public class SubarrayRangeWithGivenSum
{
	public static void main (String[] args)
	 {
   	 Scanner sc=new Scanner(System.in);
   	 int t=sc.nextInt();
   	 while(t-->0)
   	 {
   	        int n = sc.nextInt();
   		    int arr[] = new int[n];
   		    for(int i=0;i<n;i++)
   		    {
   		        arr[i] = sc.nextInt();
   		    }
   		    int sum = sc.nextInt();
   		    System.out.println(subArraySum(arr, n, sum));
   		    
   		}
	}
	static int subArraySum(int arr[], int n, int sum)
    {
        // add your code here
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int currentSum = 0;
        for (int x: arr) {
            currentSum += x;
            if (currentSum-sum == 0) {
            	count += 1;
            }
            if (hashMap.containsKey(currentSum-sum)) {
                count += hashMap.get(currentSum-sum);
            } 
            //else {
                if (hashMap.containsKey(currentSum)) {
                    hashMap.put(currentSum, hashMap.get(currentSum)+1);
                } else {
                    hashMap.put(currentSum, 1);
                }
            //}
        }
        return count;
    }
}
