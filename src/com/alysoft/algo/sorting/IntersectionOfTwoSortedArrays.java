package com.alysoft.algo.sorting;

/**
 * Given two sorted arrays arr1[] and arr2[] of sizes N and M respectively. The task is to find intersection of the two arrays.

Intersection of two arrays contains the elements common to both the arrays. The intersection should not count duplicate elements.

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains size of arrays N and M. 
Next two lines contains N and M elements.

Output Format:
For each testcase, there will be a single line of output containing intersection elements of the two arrays in sorted order.

Your Task:
This is a function problem. You only need to complete the function printIntersection() that takes N and M as parameters and prints 
the intersection of two arrays. If the intersection is empty then print -1.
The newline is appended by driver code.

Constraints:
1 <= T <= 100
1 <= N, M <= 105
1 <= arr[i], brr[i] <= 106

Example:
Input:
3
4 5
1 2 3 4
2 4 6 7 8
5 6
1 2 2 3 4
2 2 4 6 7 8
2 3
1 2
3 4

Output:
2 4
2 4
-1

Explanation:
Testcase 2: 2 an 4 are only the common elements.
Testcase 3: no common elements so print -1.
 * @author ymohammad
 *
 */
public class IntersectionOfTwoSortedArrays
{

	public static void main(String[] args)
	{
		
	}
	static void printIntersection(int arr1[], int arr2[], int n, int m) 
    {
        // add your code here
        int i = 0;
        int j = 0;
        StringBuffer buff = new StringBuffer();
        while (i<n&&j<m) {
            while ((i+1)<n && arr1[i] == arr1[i+1]) {
                i++;
            }
            while ((j+1)<m && arr2[j] == arr2[j+1]) {
                j++;
            }
            if (arr1[i]<arr2[j]) {
                i++;
            } else if (arr2[j]<arr1[i]) {
                j++;
            } else {
                buff.append(arr1[i] + " ");
                i++;
                j++;
            }
        }
        if (buff.length() == 0) {
            System.out.print(-1);
        } else {
            System.out.print(buff.toString());
        }
    }
}
