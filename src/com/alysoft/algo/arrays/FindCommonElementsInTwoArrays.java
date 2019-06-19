package com.alysoft.algo.arrays;

import java.util.ArrayList;

/**
 * Here both the arrays are sorted.
 * @author ymohammad
 *
 */
public class FindCommonElementsInTwoArrays
{

	public static ArrayList<Integer> getCommonElements(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0; int j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				//both are equals
				result.add(arr1[i]);
				i++;
				j++;
			}
		}
		return result;
	}
	public static void main(String[] args)
	{
		int[] array1 = { 2, 5, 8, 17, 18, 34, 37, 55 };
        int[] array2 = { 3, 4, 5, 18, 31, 32, 55 };

        ArrayList<Integer> commonList = getCommonElements(array1, array2);
        System.out.println(commonList);
	}
}
