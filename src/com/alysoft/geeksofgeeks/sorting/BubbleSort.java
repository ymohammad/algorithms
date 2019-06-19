package com.alysoft.geeksofgeeks.sorting;

import java.util.Scanner;

/**
 * The task is to complete bubble function which is used to implement Bubble Sort !
 * @author ymohammad
 *
 */
public class BubbleSort
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			bubbleSort(arr);
			printArray(arr);
			
		t--;	
		}
	}
	private static void bubbleSort(int[] arr)
	{
		int n = arr.length;
		for (int i=0; i<n; i++) {
			for (int j=0; j <n-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
