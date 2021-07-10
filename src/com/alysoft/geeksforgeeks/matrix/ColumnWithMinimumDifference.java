package com.alysoft.geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a matrix mat of n*n. The task is to find the minimum difference between two columns Cj and Ci such that i < j, 
 * i.e., we need to find minimum value of sum(Cj) – sum(Ci) such that column i comes before column j.

Input:
The first line of input contains test cases denoted by T. Each test cases follow. The first line of every test case contains n. 
Second line contains elements of the matrix mat.

Output:
For every test case you need to print the minimum difference. Print "Not Possible" (without quotes), if difference cannot be calculated.

Constraints:
1 <= T <= 100
1 <= n <= 100
-1000 <= mat[i][j] = 1000

Example:
Input:
1
3
4 5 6
3 2 3
1 9 10

Output:
3

Explanation:
Testcase 1: Sum of first column elements 8, second column elements is 16 and last column elements is 19. 
So minimum difference is in between columns second and last with difference 3.
 * @author ymohammad
 *
 */
public class ColumnWithMinimumDifference
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        while (t > 0)
        {
        	String line=null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
        	int n = Integer.parseInt(line.trim());
            String[] arrayValues = null;
            int[][] arr = new int[n][n];
            for (int a = 0; a<n; a++) {
            	line = br.readLine();;
            	arrayValues = line.trim().split(" ");
            	if (arrayValues.length == (n*n)) {
            		prepareSingleLineArray(arrayValues, arr, n, n);
            		break;
            	}
            	int k=0;
            	for (int j = 0; j<n; j++) {
            		arr[a][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
            
            printMinDifferenceColumn(arr, n);
            t--;
        }
	}
	private static void printMinDifferenceColumn(int[][] arr, int n)
	{
		if (n<2) {
			System.out.println("Not Possible");
			return;
		}
		int[] sumArr = new int[n];
		int k = 0;
		for (int i=0; i<n; i++) {
			int total = 0;
			for (int j=0; j<n; j++) {
				total += arr[j][i];
			}
			sumArr[k] = total;
			k++;
		}
		k = 1;
		int minDiff = Integer.MAX_VALUE;
		while (k<n) {
			int diff = sumArr[k]-sumArr[k-1];
			if (diff<minDiff) {
				minDiff = diff;
			}
			k++;
		}
		int diff = sumArr[0]-sumArr[n-1];
		if (diff<minDiff) {
			minDiff = diff;
		}
		System.out.println(minDiff);		
	}
	public static void prepareSingleLineArray (String[] line, int[][] arr, int n, int m) {
		int k=0;
		for (int a = 0; a<n; a++) {
        	for (int j = 0; j<m; j++) {
        		arr[a][j] = Integer.parseInt(line[k]);
        		k++;
        	}
        }
	}
}
