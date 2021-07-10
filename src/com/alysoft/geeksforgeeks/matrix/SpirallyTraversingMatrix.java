package com.alysoft.geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a 2D matrix of size M*N. Traverse and print the matrix in spiral form.

Input: 
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. 
Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Constraints:
1 <=T<= 100
2 <= M, N <= 10
0 <= Ai <= 100

Example:
Input:
1
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class SpirallyTraversingMatrix
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
			printArrayInSpiralForm(arr, n, m);
            t--;
        }
	}

	public static void printArrayInSpiralForm(int[][] arr, int n, int m)
	{
		int rowIndexStart = 0;
		int columnIndexStart = 0;
		int rowIndexEnd = n-1;
		int columnIndexEnd = m-1;
		StringBuffer result = new StringBuffer();
		
		while (rowIndexStart <= rowIndexEnd && columnIndexStart<=columnIndexEnd) {
			//Read a Row.
			//if (columnIndexStart != columnIndexEnd) 
			{
				for (int i=columnIndexStart; i<= columnIndexEnd; i++) {
					result.append(arr[rowIndexStart][i] + " ");
				}
			}
			//read a column (no columsn to read if only 1 row is exist
			if (rowIndexStart != rowIndexEnd) {
				for (int i=rowIndexStart+1; i<= rowIndexEnd; i++) {
					result.append(arr[i][columnIndexEnd] + " ");
				}
			}
			
			//read a column (if it is a signle row left, that is already read)
			if (rowIndexStart != rowIndexEnd && columnIndexStart != columnIndexEnd) {
				//Read a row
				for (int i=columnIndexEnd-1; i>= columnIndexStart; i--) {
					result.append(arr[rowIndexEnd][i] + " ");
				}
			}
			
			//read a column (no columsn to read if only 1 row is exist
			if (rowIndexStart != rowIndexEnd && columnIndexStart != columnIndexEnd) {
				for (int i=rowIndexEnd-1; i> rowIndexStart; i--) {
					result.append(arr[i][columnIndexStart] + " ");
				}
			}
			
			rowIndexStart++;
			columnIndexStart++;
			rowIndexEnd--;
			columnIndexEnd--;
		}
		System.out.println(result.toString());
	}
}
