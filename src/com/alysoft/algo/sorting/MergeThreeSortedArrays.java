package com.alysoft.algo.sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given three sorted arrays A, B and C of size N, M and P respectively. The task is to merge them into a single array which must be 
 * sorted in increasing order.

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains size of three arrays N, M and P. 
Next three lines contains N, M and P elements for arrays.

Output Format:
Output the merged sorted array.

Your Task:
This is a function problem. You only need to complete the function mergeThree() that takes A,B,C as parameters. The function returns 
an array or vector.

Constraints:
1 <= T <= 100
1 <= N, M, P <= 106
1 <= A[i], B[i], C[i] <= 106

Example:
Input:
2
4 5 6
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
2 3 4
1 2
2 3 4
4 5 6 7

Output:
1 1 1 2 2 2 3 3 3 4 4 4 5 5 6
1 2 2 3 4 4 5 6 7

 

Explanation:
Testcase 1: Merging these three sorted arrays, we have elements as 1 1 1 2 2 2 3 3 3 4 4 4 5 5 6.
 * @author ymohammad
 *
 */
public class MergeThreeSortedArrays
{

	static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
        System.out.print(x + " ");
    }
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    
		    int A[] = new int[a];
		    int B[] = new int[b];
		    int C[] = new int[c];
		    
		    for(int i = 0; i < a; i++)
		      A[i] = sc.nextInt();
		      
		    for(int i = 0; i < b; i++)
		      B[i] = sc.nextInt();
		      
		    for(int i = 0; i < c; i++)
		      C[i] = sc.nextInt();
		    
		    printSorted(merge3sorted(A, B, C));
		    System.out.println();
		    
		}
	}
	static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
		int n = A.length;
		int m = B.length;
		int p = C.length;
		ArrayList<Integer> returnList = new ArrayList<>(n+m);
		merge(returnList, A, B, n, m);
		Integer[] mergeArr = returnList.toArray(new Integer[n+m]);
		returnList = new ArrayList<>(n+m+p);
		merge(returnList, mergeArr, C, n+m, p);
		return returnList;
    }
	private static void merge(ArrayList<Integer> returnList, Integer[] a, int[] b, int n, int m)
	{
		int[] temp = new int[a.length];
		int i = 0;
		for (int x: a) {
			temp[i] = x;
			i++;
		}
		merge(returnList, temp, b, n, m);
	}
	private static void merge(ArrayList<Integer> returnList, int[] a, int[] b, int n, int m)
	{
		int i = 0;
		int j = 0;
		while (i<n && j<m) {
			if (a[i]<=b[j]) {
				returnList.add(a[i]);
				i++;
			} else {
				returnList.add(b[j]);
				j++;
			}
		}
		while (i<n) {
			returnList.add(a[i]);
			i++;
		}
		while (j<m) {
			returnList.add(b[j]);
			j++;
		}
	}
}
