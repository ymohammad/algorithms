package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an n x m matrix, where every row and column is sorted in increasing order, and a number x . 
 * The task is to find whether element x is present in the matrix or not.

Expected Time Complexity : O(m + n)

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of three lines.
First line of each test case consist of two space separated integers N and M, denoting the number of element in a row and column respectively.
Second line of each test case consists of N*M space separated integers denoting the elements in the matrix in row major order.
Third line of each test case contains a single integer x, the element to be searched.
Output:

Corresponding to each test case, print in a new line, 1 if the element x is present in the matrix, otherwise simply print 0.

Constraints:
1<=T<=200
1<=N,M<=30

Example:

Input:
2
3 3
3 30 38 44 52 54 57 60 69
62
1 6
18 21 27 38 55 67
55

Output:
0
1
 * @author ymohammad
 *
 */
public class SearchMatrix
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int n = Integer.parseInt(arrayValues[0]);
            int m = Integer.parseInt(arrayValues[1]);
            int[][] arr = new int[n][m];
            int k = 0;
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            for (int i = 0; i<n; i++) {
            	for (int j = 0; j<m; j++) {
            		while (arrayValues[k] == null || arrayValues[k].trim().length() == 0) {
            			k++;
            		}
            		arr[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
            int x = Integer.parseInt(br.readLine().trim());
			int result = searchElement(arr, n, m, x);
			System.out.println(result);
            t--;
        }
	}

	public static int searchElement(int[][] arr, int rowCount, int columnCount, int findElement)
	{
		int rowIndex = rowCount-1;
		int columnIndex = 0;
		
		while (rowIndex <=0 && columnIndex < columnCount) {
			if (arr[rowIndex][columnIndex]<findElement) {
				columnIndex++;
			} else if (arr[rowIndex][columnIndex]>findElement) {
				rowIndex--;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
}
