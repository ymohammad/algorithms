package com.alysoft.geeksforgeeks.sorting;

public class CountSort
{
	public static void main(String[] args) {
		int[] arr = {1, 4, 1, 2, 7, 5, 2};
		countingSort(arr, arr.length, 9);
	}
	public static void countingSort(int[] arr, int n, int range) {
		printArray("Given Array :", arr);
		
		int[] countArr = new int[range];
		for (int x: arr) {
			countArr[x]++;
		}
		printArray("Count Array :", countArr);
		
		for(int i=1; i<range; i++) {
			countArr[i] += countArr[i-1];
		}
		
		printArray("Count After :", countArr);
		
		int[] output = new int[n];
		 // Build the output character array 
        // To make it stable we are operating in reverse order. 
        for (int i = n-1; i>=0; i--) 
        { 
            output[countArr[arr[i]]-1] = arr[i]; 
            --countArr[arr[i]]; 
        } 
        
        printArray("Output Array :", output);
	}
	
	public static void printArray(String msg, int[] arr) {
		System.out.print(msg);
		for (int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
