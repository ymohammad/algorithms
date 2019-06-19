package com.alysoft.algo.arrays;

/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element 
 * should be max value, second should be min value, third should be second max, fourth should be second min and so on.

Note: O(1) extra space is allowed. Also, try to modify the input array as required.

Input:
First line of input conatins number of test cases T. First line of test case contain an integer denoting the array size N and second 
line of test case contain N space separated integers denoting the array elements.

Output:
Output the modified array with alternated elements.

User Task:
The task is to complete the function rearrange() which rearranges elements and shouldn't print anything. Printing of the modified array 
will be handled by driver code.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 107

Example: 
Input:
2
6
1 2 3 4 5 6
11 
10 20 30 40 50 60 70 80 90 100 110

Output:
6 1 5 2 4 3
110 10 100 20 90 30 80 40 70 50 60

Explanation:
Testcase 1: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.
 * @author ymohammad
 *
 */
public class RearrangeArrayAlternately
{

	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};
		//int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
		rearrange(arr, arr.length);
		printArray(arr);
	}
	private static void printArray(int[] arr)
	{
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}
	public static void rearrange(int arr[], int n){
		int maxIndex = n-1;
		int minIndex = 0;
		
		int maxValue = arr[maxIndex]+1;
		for (int i =0; i<n; i++) {
			if (i%2 == 0) {
				int mulVal = (arr[maxIndex]%maxValue);
				arr[i] += mulVal*maxValue;
				maxIndex--;
			} else {
				int mulMinVal = arr[minIndex]%maxValue;
				arr[i] += (mulMinVal)*maxValue;
				minIndex++;
			}
		}
		for (int i =0; i<n; i++) {
			arr[i] = arr[i]/maxValue;
		}
	}
	public static void rearrange1(int arr[], int n){
        
		int i = 0;
		int low = 0;
		int high = n-1;
		int firstMax = 0;
		int secondMax = 0;
		int firstMin = 0;
		int secondMin = 0;
		firstMax = arr[high];
		high--;
		firstMin = arr[low];
		low++;
		while (high>low) {
			
			secondMax = arr[high];
			high--;
			secondMin = arr[low];
			low++;
			
			arr[i] = firstMax;
			i++;
			arr[i] = firstMin;
			i++;
			firstMax = secondMax;
			firstMin = secondMin;
		}
		arr[i] = firstMax;
		i++;
		arr[i] = firstMin;
    }
    
}
