package com.alysoft.geeksforgeeks.searching;

import java.util.Scanner;

public class BinarySearch
{
	public static void main(String args[])
	 {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			 
			int key =sc.nextInt();
			System.out.println(bin_search(arr,0,n-1,key));
		T--;
		}
	}
	public static int bin_search(int A[], int left, int right,  int k)
	{
	    if (right < left) return -1;
	    
	    int mid = (left+right)/2;
	    
	    if (A[mid] == k) {
	        return mid;
	    }
	    
	    if (A[mid] < k) {
	        return bin_search(A, mid+1, right, k);
	    } else {
	        return bin_search(A, left, mid-1, k);
	    }
	}
}
