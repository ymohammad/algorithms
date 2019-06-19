package com.alysoft.algo.binarysearch;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

User Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
 * @author ymohammad
 *
 */
public class SmallestPositiveMissingNumber
{
	public static void main(String[] args) {
		int[] arr = {0, -10, 1, 3, -20};
		System.out.println(findMissing(arr, arr.length));
		
		int[] arr1 = {1, 2, 3, 4, 5};
		System.out.println(findMissing(arr1, arr1.length));
	}
	// function to find first positive missing number
    static int findMissing(int arr[], int size)
    {
        
        //0 -10 1 3 -20
        int p1 = 0;
        int p2 = size-1;
        while (p1<p2) {
            if (arr[p1] > 0) {
                p1++;
            } else {
                int temp = arr[p2];
                arr[p2] = arr[p1];
                arr[p1] = temp;
                p2--;
            }
        }
        //1 3 0 -10 -20
        for (int i=0; i<=p1; i++) {
            int x = Math.abs(arr[i])-1;
            int y = arr[x];
            if (y>0 && y <= size) {
                arr[x] = y*-1;
            }
        }
        for (int i=0; i<size; i++) {
            if (arr[i] > 0) {
                return i+1;
            }
        }
        
        return p1+2;
    }
    
    //Editorial answer.
    static int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
           if (arr[i] <= 0)  
           {
               int temp;
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;  // increment count of non-positive integers 
           }
        } 
        return j;
    }
    
    static int findMissingPositive(int arr[], int size)
    {
      // Mark arr[i] as visited by making arr[arr[i] - 1] negative. 
      // Note that 1 is subtracted because index start 
      // from 0 and positive numbers start from 1 
      int i;
      for(i = 0; i < size; i++)
      {
        if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
          arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
      }
      // Return the first index value at which is positive 
      for(i = 0; i < size; i++)
        if (arr[i] > 0)// 1 is added because indexes start from 0 
          return i+1;
      return size+1;
    }
    
    static int findMissing2(int arr[], int size)
    {
        // First separate positive and negative numbers
        int shift = segregate (arr, size);
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<(size);i++)
        {
            arr2[j] = arr[i];
            j++;
        }    
       return findMissingPositive(arr2, j);
    }
}
