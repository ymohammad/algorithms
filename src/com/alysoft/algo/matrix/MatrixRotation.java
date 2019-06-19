package com.alysoft.algo.matrix;

public class MatrixRotation
{
	public static void main(String[] args)
	{
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		rotateMatrixBruteForce(arr, 4, 4);
		printArray(arr, 4, 4);
	}
	private static void printArray(int[][] arr, int m, int n)
	{
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void rotateMatrixBruteForce(int[][] arr, int m, int n)
	{
		int[][] tempArray = new int[m][n];
		for (int i =0; i<m; i++)
		{
			int k = m-1;
			for(int j=0; j<n; j++)
			{
				tempArray[k][i] = arr[i][j];
				k--;
			}
		}
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				arr[i][j] = tempArray[i][j];
			}
		}
	}
}
