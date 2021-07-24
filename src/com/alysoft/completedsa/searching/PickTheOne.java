package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PickTheOne
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
				
			int x = getLastIndexOfZero(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	public static int getLastIndexOfZero(int arr[],int n) {
		if (arr[n-1] == 0) return n-1;
		
		if (arr[0] == 1) return -1;
		
		return binarySearch(arr, 0, n-1, n);
    }
	private static int binarySearch(int[] arr, int start, int end, int n)
	{
		if (start>end) return -1;
		int mid = (start+end)/2;
		if (mid>0 && arr[mid] == 1 && arr[mid-1]==0) {
			return mid-1;
		}
		if (mid < n-1 && arr[mid] == 0 && arr[mid+1] == 1) {
			return mid;
		}
		
		if (arr[mid] == 0) {
			return binarySearch(arr, mid+1, end, n);
		}
		return binarySearch(arr, start, mid-1, n);
	}
}
