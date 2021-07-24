package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find the missing element from  an ordered array A[ ], consisting of N elements representing an Arithmetic Progression (AP) .
 

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
The first line of each test case contains an integer N, where N is the size of the array A[ ].
The second line of each test case contains N space separated integers of an Arithmetic Progression denoting elements of the array A[ ].
 

Note: The series should have a missing element in between a perfect A.P. with no missing element will not be considered.
 

Output:
Print out the missing element. 
 * @author ymohammad
 *
 */
public class MissingElementOfAP
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
            int sum = 0;
			while(i<n) {
			    if (arrayValues[i].trim().length() > 0) {
			        a[i]= Integer.parseInt(arrayValues[i].trim());
			        sum += a[i];
			        i++;
			    }
			}
				
			int x = getMissingAPElement(a, n, sum);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getMissingAPElement(int[] a, int n, int sum)
	{
		int apSum = ((n+1))*(a[0] + a[n-1]);
		apSum = apSum/2;
		return apSum-sum;
	}
	
	//We can also find the solution using binary search
	
}
