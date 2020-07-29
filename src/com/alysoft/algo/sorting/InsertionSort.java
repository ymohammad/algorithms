package com.alysoft.algo.sorting;

public class InsertionSort
{

	public static void main(String[] args) {
		
		int[] arr = {5, 4, 3, 52, 1};
		insert(arr, arr.length);
		printArray(arr, arr.length);
	}
	
	public static void insert(int arr[],int n)
	  {
	      for(int i = 1; i<n; i++) {
	          int x = arr[i];
	          int hole = i;
	          while (hole>0 && arr[hole-1]>x) {
	             arr[hole] = arr[hole-1];
	              hole--;
	          }
	          arr[hole] = x;
	      }
	  }
	
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
}
