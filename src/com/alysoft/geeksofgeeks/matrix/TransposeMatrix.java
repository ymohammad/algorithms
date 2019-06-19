package com.alysoft.geeksofgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a program to find transpose of a square matrix of size N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case contains an 
integer N, denoting the size of the square matrix. Then in the next line are N*N space separated values of the matrix.

Output:
For each test case output will be the space separated values of the transpose of the matrix

Input:
2
4
1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4
2
1 2 -9 -2

Output:
1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4
1 -9 2 -2

Explanation:
Testcase 1: The matrix after rotation will be: 1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4.
 * @author ymohammad
 *
 */
public class TransposeMatrix
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
            int[][] arr = new int[n][n];
            int k = 0;
            for (int i = 0; i<n; i++) {
            	for (int j=0; j<n; j++) {
            		arr[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
			StringBuffer buff = new StringBuffer();	
            for (int i = 0; i<n; i++) {
            	for (int j=0; j<n; j++) {
            		buff.append(arr[j][i] + " ");
            	}
            }
            System.out.println(buff);
            t--;
        }
	}
}
