package com.alysoft.algo.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Given an array arr and a number K where K is smaller than size of array, the task is to find the K’th smallest element in the given array. 
 * It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of 
three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer 
denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the desired output in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
 * @author ymohammad
 *
 */
public class KthSmallestElement
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int k = Integer.parseInt(br.readLine().trim());
			//int x = getKthSmallest(a, n, k);
			int x = kthsmallest(a, 0, n-1, k);
			System.out.println(x);
            t--;
        }
	}

	private static int getKthSmallest(int[] arr, int n, int k)
	{
		int[] newArr = new int[100000];
	    for (int a: arr) {
	        newArr[a] = 1;
	    }
	    int i = 0;
	    for (int j = 0; j<newArr.length; j++) {
	        if (newArr[j] == 1)  {
	            i++;
	        }
	        if (i == k) {
	            return j;
	        }
	    }
	    return 0;
	}
	
	//Editorial
	static int kthsmallest(int arr[], int low, int high, int k)
	{
		// If k is smaller than number of elements in array
		if (k > 0 && k <= high - low + 1)
		{
			int pos = randomPartition(arr, low, high);

			if (pos - low == k - 1)
				return arr[pos];
			if (pos - low > k - 1)
				return kthsmallest(arr, low, pos - 1, k);
			return kthsmallest(arr, pos + 1, high, k - pos + low - 1);
		}

		return Integer.MAX_VALUE;
	}

	static int partition(int arr[], int l, int r)
	{
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++)
		{
			if (arr[j] <= x)
			{
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
		}
		int temp = arr[r];
		arr[r] = arr[i];
		arr[i] = temp;
		return i;
	}

	static int randomPartition(int arr[], int l, int r)
	{
		Random rand = new Random();
		int n = r - l + 1;
		int pivot = rand.nextInt(n);
		int temp = arr[r];
		arr[r] = arr[l + pivot];
		arr[l + pivot] = temp;

		return partition(arr, l, r);
	}
}
