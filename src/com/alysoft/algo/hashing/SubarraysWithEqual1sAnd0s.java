package com.alysoft.algo.hashing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given an array arr[] of size N containing 0s and 1s only. The task is to
 * count the subarrays having equal number of 0s and 1s.
 * 
 * Input Format: The first line of input contains an integer T denoting the
 * number of test cases. Then T test cases follow. Each test case consists of
 * two lines. First line of each test case contains an Integer N denoting size
 * of array and the second line contains N space separated 0 and 1.
 * 
 * Output Format: For each test case, in a new line, print the count of required
 * sub arrays in new line
 * 
 * Your Task: This is a function problem. You only need to complete the function
 * countSubarrWithEqualZeroAndOne that takes arr, and n as parameters and
 * returns count of required subarrays.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 106 0 <= A[i] <= 1
 * 
 * Example: Input: 2 7 1 0 0 1 0 1 1 5 1 1 1 1 0
 * 
 * Output: 8 1
 * 
 * Explanation: Testcase 1: The index range for the 8 sub-arrays are: (0, 1),
 * (2, 3), (0, 3), (3, 4), (4, 5) (2, 5), (0, 5), (1, 6)
 * 
 * @author ymohammad
 *
 */
public class SubarraysWithEqual1sAnd0s
{

	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0)
		{

			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
			{
				a[i] = in.nextInt();
			}
			System.out.println(countSubarrWithEqualZeroAndOne(a, n));
		}
	}
	/**
	 * 
	 * 1.
Approach: Following are the steps:

Consider all 0’s in arr[] as -1.
Create a hash table that holds the count of each sum[i] value, where sum[i] = sum(arr[0]+..+arr[i]), for i = 0 to n-1.
Now start calculating cumulative sum and then we get increment count by 1 for that sum represented as index in the hash table. 
Sub-array by each pair of positions with same value of cumulative sum constitute a continuous range with equal number of 1’s and 0’s.
Now traverse the hash table and get the frequency of each element in the hash table. Let frequency be denoted as freq. For each freq > 1 
we can choose any two pair of indices of sub-array by (freq * (freq – 1)) / 2 number of ways . Do the same for all freq and sum up the 
result that will be the number all possible sub-arrays containing equal number of 1’s and 0’s.
Also add freq of the sum 0 in the hash table to the final result.
Explanation:
Considering all 0’s as -1, if sum[i] == sum[j], where sum[i] = sum(arr[0]+..+arr[i]) and sum[j] = sum(arr[0]+..+arr[j]) and ‘i’ is 
less than ‘j’, then sum(arr[i+1]+..+arr[j]) must be 0. It can only be 0 if arr(i+1, .., j) contains equal number of 1’s and 0’s.
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static int countSubarrWithEqualZeroAndOne(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
		{
			if (arr[i] == 0)
			{
				arr[i] = -1;
			}
		}
		int currentSum = 0;
		int count = 0;
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
		{
			currentSum += arr[i];
			if (currentSum == 0)
			{
				count += 1;
			}
			if (hash.containsKey(currentSum))
			{
				count += hash.get(currentSum);
			}
			if (hash.containsKey(currentSum))
			{
				hash.put(currentSum, hash.get(currentSum) + 1);
			} else
			{
				hash.put(currentSum, 1);
			}

		}
		return count;
	}
	//Editorial.
	static int countSubarrWithEqualZeroAndOne2(int a[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum =0;
	       int flag=0;
	       for(int i=0;i<n;i++){
	           if(a[i] == 0){
	               a[i] =-1;
	           }
	           sum = sum+a[i];
	           if(sum == 0){
	               flag++;
	           }
	           if(hm.containsKey(sum))
	           flag += hm.get(sum);
	           if(!hm.containsKey(sum))
	           hm.put(sum,1);
	           else{
	               int x =hm.get(sum);
	               hm.put(sum,x+1);
	           }
	       }
	       return flag;
    }
}
