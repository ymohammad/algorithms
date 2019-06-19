package com.alysoft.geeksofgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an n x n matrix .In the given matrix, you have to print the elements of the matrix in the snake pattern.


Input:
First line consists of T test cases. First line of every test case consists of N, denoting number of elements(N x N) in Matrix.
 Second line of every test case consists of N x N spaced integers denoting elements of Matrix elements.

	Output:
	Single line output, print the matrix in snake pattern.
	
	Constraints:
	1<=T<=100
	1<=N<=50
	
	Example:
	Input:
	1
	3
	45 48 54 21 89 87 70 78 15 
	
	Output:
	45 48 54 87 89 21 70 78 15 
	
 * @author ymohammad
 *
 */
public class MatrixInSnakePattern
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
			printInSnakePattern(arr, n);
            t--;
        }
	}

	private static void printInSnakePattern(int[][] arr, int n)
	{
		StringBuffer buff = new StringBuffer();	
		int j = 0;
		boolean isRevers = false;
        for (int i = 0; i<n; i++) {
        	while ((j<n && !isRevers) || (j>=0 && isRevers)) {
        		buff.append(arr[i][j] + " ");
        		if (isRevers) {
        			j--;
        		} else {
        			j++;
        		}
        	}
        	isRevers = !isRevers;
        	j = isRevers ? (n-1) : 0;
        }
        System.out.println(buff);
	}
}
