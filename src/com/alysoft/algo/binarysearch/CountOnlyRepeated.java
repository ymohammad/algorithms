package com.alysoft.algo.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array arr[] of N positive integers, where elements are consecutive. Also, there is a single element 
 * which is repeating X (any variable) number of times. Now, the task is to find the element which is repeated and number of times it is repeated.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements 
in the array N. Next line contains the array elements.

Output:
For each testcase, there will be a single line containing the element which is repeated and the number of times it is repeated, seperated by space.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 1015

Input:
2
5
1 2 3 3 4
5
2 3 4 5 5

Output:
3 2
5 2

Example:
Testcase 1: In the given array, 3 is occuring two times.
 * @author ymohammad
 *
 */
public class CountOnlyRepeated
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
				
			printRepeatingAndCount(a, n);
            t--;
        }
	}
	public static void printRepeatingAndCount(int[] arr, int n) {
	    int repeatingNum = -1;
	    for (int i = 0; i<n; i++) {
	        int x = Math.abs(arr[i])-1;
	        if (arr[x]<0) {
	           repeatingNum = x+1;
	           break;
	        } else {
	            arr[x] = -arr[x];
	        }
	    }
	    int count = 0;
	    for (int i=0; i<n; i++) {
	        if (Math.abs(arr[i]) == repeatingNum) {
	            count++;
	        }
	    }
	    System.out.println(repeatingNum + " " + count);
	}
	
	//Editorial
	static int arr[] = new int[10000000];
    public static void main1(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            //int arr[]= new int[n];
            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
               arr[i] = Integer.parseInt(st[i]);
            
            Pair ans;
            ans = findRepeating(n);
           
            System.out.println(ans.a + " " + ans.b);  
            
        }
    }
    
    static Pair findRepeating(int n)
    {
        // return 0, 0 when n== 0
        if(n == 0)
        {
            
            return new Pair(0, 0);
        }
        
        // when all the elements are distinct
        if(n-(arr[n-1]-arr[0]) == 1)
        {
            
            return new Pair(-1, -1);
        }
        
        int lo = 0, hi = n-1;
        int mid = 0;
        
        // apply binary search to find the repeating element
        while(lo < hi)
        {
        
            mid = (lo+hi)/2;
        
            if(arr[mid] >= mid + arr[0]){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        
         
        return new Pair(arr[mid],n-(arr[n-1]-arr[0]));
    }
    static class Pair
    {
        int a = 0;
        int b = 0;
        Pair(int x, int y)
        {
            a= x;
            b = y;
        }
    }
}
