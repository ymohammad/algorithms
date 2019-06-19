package com.alysoft.algo.binarysearch;

/**
 * Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N 
 * is an element that appears more than N/2 times in the array.

Input:  
The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of 
array and second line will be the elements of the array.

Output: 
For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.

User Task:
The task is to complete the function findMajority() which finds the majority element in the array.

Constraints:
1 <= T<= 100
1 <= N <= 107
0 <= Ai <= 106

Example:
Input:
2
5
3 1 3 3 2
3
1 2 3

Output:
3
-1

Explanation:
Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
 * @author ymohammad
 *
 */
public class Majority
{
	/* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size) 
    { 
        int maj_index = 0, count = 1; 
        for (int i = 1; i < size; i++) 
        { 
            if (a[maj_index] == a[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                maj_index = i; 
                count = 1; 
            } 
        } 
        return a[maj_index]; 
    }
    /* Function to check if the candidate 
        occurs more than n/2 times */
    static boolean isMajority(int a[], int size, int cand) 
    { 
        int count = 0; 
        for (int i = 0; i < size; i++) 
      
        if (a[i] == cand) 
        count++; 
          
        if (count > size/2) 
            return true; 
        else
            return false; 
    }
    static int majorityElement(int a[], int size)
    {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size); 
  
        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand) == true) 
        return cand;
        else
        return -1;
    }
}
