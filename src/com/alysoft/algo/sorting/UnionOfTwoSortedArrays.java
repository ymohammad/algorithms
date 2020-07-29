package com.alysoft.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given two sorted arrays arr[] and brr[] of size N and M respectively. The task is to find the union of these two arrays.

Union of two arrays can be defined as the common and distinct elements in the two arrays.

Input Format: 
First line of input contains number of testcases T. For each testcase, first line of input contains number of testcases T. 
For each testcase, first line of input contains size of two arrays N and M. Next two line contains N and M elements.

Output Format:
For each testcase, print the union (common and distinct) of two arrays in a single line. You need to print the union in sorted order.

Your Task:
This is a function problem. You only need to complete the function findUnion() that takes N and M as parameter and prints the 
union of two arrays. The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 100
1 <= N, M <= 105
1 <= arr[i], brr[i] <= 106

Example:
Input:
3
5 3
1 2 3 4 5
1 2 3
5 5
2 2 3 4 5
1 1 2 3 4
5 5
1 1 1 1 1
2 2 2 2 2

 

Output:
1 2 3 4 5
1 2 3 4 5
1 2

Explanation:
Testcase 1: Distinct elements including both the arrays are: 1 2 3 4 5.
Testcase 2: Distinct elements including both the arrays are: 1 2 3 4 5.
 * @author ymohammad
 *
 */
public class UnionOfTwoSortedArrays
{

	public static void main(String[] args)
	{

	}
	static void findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        int i = 0;
        int j = 0;
        
        HashSet<Integer> hash = new HashSet<Integer>();
        while (i<n && j<m) {
            if (arr1[i] < arr2[j]) {
                hash.add(arr1[i]);
                i++;
            } else {
                hash.add(arr2[j]);
                j++;
            }
        }
        while (i<n) {
            hash.add(arr1[i]);
            i++;
        }
        while (j<m) {
            hash.add(arr2[j]);
            j++;
        }
        List<Integer> listValues = new ArrayList<Integer>();
        for (Integer x : hash) {
        	listValues.add(x);
        }
        Collections.sort(listValues);
        StringBuffer buff = new StringBuffer();
        for (Integer x : listValues) {
            buff.append(x + " ");
        }
        System.out.print(buff.toString());
    }
	
	//Editorial..
	static void findUnion1(int arr1[], int arr2[], int n, int m)
    {
            int i = 0, j = 0; 
        while (i < n && j < m) 
        { 
              while(i+1<n&&arr1[i]==arr1[i+1])
              {
                  i++;
              }
              while(j+1<m&&arr2[j]==arr2[j+1])
              {
                  j++;
              }
              
            if (arr1[i] < arr2[j]) 
               System.out.print(arr1[i++]+ " "); 
              
            else if (arr2[j] < arr1[i]) 
               System.out.print(arr2[j++]+" "); 
              
            else
            { 
               System.out.print(arr2[j++]+" "); 
               i++; 
            } 
        } 
      
      
      
      while(i < n) 
      {
         while(i+1<n&&arr1[i]==arr1[i+1])
          i++;
         System.out.print(arr1[i++]+" "); 
      }
      
      while(j < m) 
      {
          while(j+1<m&&arr2[j]==arr2[j+1])
          j++;
        System.out.print(arr2[j++]+ " "); 
      }
    }
}
