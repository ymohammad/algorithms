package com.alysoft.algo.binarysearch;

import java.util.HashMap;

/**
 * Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case contains an integer n denoting the size of the array. Then the next line contains n space separated integers forming the array. 
The last line of input contains an integer k.

Output:
Print the count of elements in array that appear more than n/k times.

User Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

Constraints:
1 <= T <= 102
1 <= N <= 106
1 <= a[i] <= 106
1 <= k <= N

Example:
Input:
2
8
3 1 2 2 1 2 3 3
4
4
2 3 3 2
3

Output:
2
2

Explanation:
Testcase 1: In the given array, 3 and 2 are the only elements that appears more than n/k times.
 
 * @author ymohammad
 *
 */
public class CountElementOccurences
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public int countOccurence2(int[] arr, int n, int k)
    {
        //your code here, return the answer
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int a: arr) {
            if (hash.containsKey(a)) {
                hash.put(a, hash.get(a) + 1);
            } else {
                hash.put(a, 1);
            }
        }
        int count = 0;
        int filter = arr.length/k;
        for (int a: arr) {
            if (hash.get(a) > filter) {
                count++;
                hash.put(a, -1);
            }
        }
        return count;
    }
	
	//Editorial
	// Prints elements with more than n/k occurrences in arr[] of
    // size n. If there are no such elements, then it prints nothing.
    static int countOccurence(int arr[], int n, int k)
    {
        int count = 0;
        
        // k must be greater than 1 to get some output 
        if(k < 2)
          return 0;
        /* Step 1: Create a temporary array (contains element 
	        and count) of size k-1. Initialize count of all 
	       elements as 0 */
        eleCount temp[] = new eleCount[k];
        
        for(int i = 0; i < k; i++)
         temp[i] = new eleCount(0, 0);
         
        /* Step 2: Process all elements of input array */
	    for (int i = 0; i < n; i++) 
    	{ 
    		int j = 0; 
    
    		/* If arr[i] is already present in 
    		the element count array, then increment its count */
    		for (j=0; j<k; j++) 
    		{ 
    			if (temp[j].e == arr[i]) 
    			{ 
    				temp[j].c += 1; 
    				break; 
    			} 
    		} 
    
    		/* If arr[i] is not present in temp[] */
    		if (j == k) 
    		{ 
    			int l = 0; 
    			
    			/* If there is position available in temp[], then place 
    			arr[i] in the first available position and set count as 1*/
    			for (l=0; l<k; l++) 
    			{ 
    				if (temp[l].c == 0) 
    				{ 
    				   
    					temp[l].e = arr[i]; 
    					temp[l].c = 1; 
    					break; 
    				} 
    			} 
    
    			/* If all the position in the temp[] are filled, then 
    			decrease count of every element by 1 */
    			if (l == k) 
    				for (l=0; l<k; l++) 
    					temp[l].c -= 1; 
    		} 
    	} 

	/*Step 3: Check actual counts of potential candidates in temp[]*/
	for (int i=0; i<k; i++) 
	{ 
		// Calculate actual count of elements 
		int ac = 0; // actual count 
		for (int j=0; j<n; j++) 
			if (arr[j] == temp[i].e) 
				ac++; 

		// If actual count is more than n/k, then print it 
		if (ac > n/k) 
		    count++; 
	}
	
	 return count;
    }
    
    static class eleCount
    {
        int e; // Element
        int c; // Count
        eleCount(int a, int b)
        {
            this.e = a;
            this.c = b;
        }
    }
}
