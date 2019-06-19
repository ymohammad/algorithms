package com.alysoft.algo.recursion;

/**
 * Given an integer set and a number, print all subsets whose sum is equal to the given number.
 * set[] = {2, 3, 8, 5, 9, 4}
 * Sum = 7
 * OP: {2, 5}, {3, 4}
 * @author ymohammad
 *
 */
public class AllSubsetsSum
{
	public static void main(String[] args) {
		int[] arr = {2, 3, 8, 5, 9, 4};
		int sum = 7;
		printAllSubsets(arr, sum, -1, "", 0);
	}
	public static void printAllSubsets(int[] arr, int sum, int index, String resultSet, int result) {
		if (index >= (arr.length-1) || sum == result) {
			if (sum == result)
				System.out.println(resultSet);
			return;
		}
		printAllSubsets(arr, sum, index+1, resultSet, result);
		printAllSubsets(arr, sum, index+1, resultSet+ " " + arr[index+1], result+arr[index+1]);
	}
}
