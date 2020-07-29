package com.alysoft.algo.arrays;

/**
 * Find the total number of subsequences (length 0 to K )of a given array of length N such that it contains all distinct elements where 0<=k<=N
 * 
 * Example: A = {2,2,2,3,3,3,3,4,5} and K = 3 Then,

For k = 0 : Ans = 1

For k = 1 : Ans = 9

For k = 2 : Ans = 27 (sub sequences = (2,3),(2,4)(2,5)(3,4),(3,5),(4,5) but consider each of their frequencies also.Hence we have to do the sum of product of their individual frequencies)

For k = 3 : Ans = 31 (subsequences = (2,3,4),(2,3,5),(2,4,5),(3,4,5) and perform sum of product of frequencies.)

Hence our final ans should be = 1+9+27+31 = 68
 * @author ymohammad
 *
 */
public class SubSequences
{
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {2, 3};
		System.out.println(productOfSubsetSums(arr, arr.length) );
	}
	
	static long productOfSubsetSums(int arr[], int n) 
	{ 
	    long ans = 1; 
	    for (int i = 0; i < n; ++i ) 
	        ans = (ans * (arr[i] + 1))%1000000007;
	    return ans-1;
	}
}
