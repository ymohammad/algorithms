package com.alysoft.geeksforgeeks.sorting;

public class QuickSort
{

	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 3, 9, 7, 10, 12, 8, 32, 78, 11, 14, 25, 54, 36, 55, 87, 12};
		//int[] arr = {5, 4, 3, 2, 1};
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
		for (int x: arr) {
			System.out.println(" between 0 and 1 :" + getRandomInteger(2, 0));
			//System.out.println(" between 7 and 9 :" + getRandomInteger(9, 7));
		}
		
	}

	private static void printArray(int[] arr)
	{
	    StringBuffer buff = new StringBuffer();
		for (int x: arr) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString().trim());
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) return;
		
		int pIndex = randomPartion(arr, start, end);
		quickSort(arr, start, pIndex-1);
		quickSort(arr, pIndex+1, end);
	}
	public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
    public static int randomPartion(int arr[], int l, int r) {
		int x = getRandomInteger(r, l);
		swap(arr, x, r);
		return partitionArray(arr, l, r);
	}
	public static int partitionArray(int[] arr, int start, int end) {
		int pIndex = start;
		int pivot = arr[end];
		for (int i= start; i<=end-1; i++) {
			if (arr[i]<= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, end, pIndex);
		return pIndex;
	}
	public static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
