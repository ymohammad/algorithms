package com.alysoft.geeksforgeeks.sorting;

import java.util.Scanner;

public class Merge_Sort
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    static void mergeSort(int arr[], int l, int r)
    {
        GfG g = new GfG();
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            g.merge(arr, l, m, r);
        }
    }
    
	public static void main(String args[])
	{
		//System.out.println("Random number between 1 and 5 :" + getRandomInteger(5, 1));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			Merge_Sort ms = new Merge_Sort();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			GfG g = new GfG();
			mergeSort(arr,0,arr.length-1);
			ms.printArray(arr);
		T--;
		}
	}
}
class GfG
{
	
   // Merges two subarrays of arr[].  First subarray is arr[l..m]
   // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
         int[] leftArr = new int[m-l+1];
         int[] rightArr = new int[r-m+1];
         int a = 0;
         for (int i = l; i<=m; i++) {
             leftArr[a] = arr[i];
             a++;
         }
         a = 0;
         for (int i = m+1; i<=r; i++) {
             rightArr[a] = arr[i];
             a++;
         }
         
         int n = leftArr.length;
         int x = rightArr.length;
         int k = l;
         int i = 0;
         int j = 0;
         while (i<n && j<x) {
             if (leftArr[i] != 0 && rightArr[j] != 0) {
                if (leftArr[i]<=rightArr[j]) {
                    arr[k] = leftArr[i];
                    i++;
                } else {
                     arr[k] = rightArr[j];
                     j++;
                }
                k++; 
             } else {
                 break;
             }
         }
         while (i<n) {
             if (leftArr[i] != 0) {
                 arr[k] = leftArr[i];
                 k++;
             }
             i++;
         }
         while (j<x) {
             if (rightArr[j] != 0) {
                 arr[k] = rightArr[j];
                 k++;
             }
            j++;
         }
    }
}
