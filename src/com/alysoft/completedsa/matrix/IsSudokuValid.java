package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to check if the 
 * configuration has a solution or not. 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case in a new line print 1 if the sudoku configuration is valid else print 0.

Constraints:
1<=T<=10
0<=mat[]<=9

Example:
Input:
2
3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0
3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2 9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1 5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0 7 

Output:
1
0
 * @author ymohammad
 *
 */
public class IsSudokuValid
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
        	int n = 9;
            String[] arrayValues = line.trim().split(" ");
            int[][] sudokuArr = new int[n][n];
            int k=0;
            for (int i = 0; i<n; i++) {
            	for (int j = 0; j<n; j++) {
            		while (arrayValues[k] == null || arrayValues[k].trim().length() == 0) {
            			k++;
            		}
            		sudokuArr[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
			int result = isSudokuValid(sudokuArr, n);
			System.out.println(result);
            t--;
        }
	}

	public static int isSudokuValid(int[][] sudokuArr, int n)
	{
		boolean[] rowHashArray = new boolean[10];
		boolean[] colmHashArray = new boolean[10];
		int diagonalIndex = 0;
		while (diagonalIndex < n) {
			
			//get row..
			for (int i=0; i<n; i++) {
				int x = sudokuArr[i][diagonalIndex];
				if (x != 0) {
					if (rowHashArray[x]) return 0;
					
					rowHashArray[x] = true;
				}
			}
			//get column..
			for (int i=0; i<n; i++) {
				int x = sudokuArr[diagonalIndex][i];
				if (x != 0) {
					if (colmHashArray[x]) return 0;
					
					colmHashArray[x] = true;
				}
			}
			Arrays.fill(rowHashArray, false);
			Arrays.fill(colmHashArray, false);
			
			//Check 3x3 blocks
			if (diagonalIndex == 0 || diagonalIndex == 3 || diagonalIndex == 6) {
				int rowEndInd = diagonalIndex+3;
				
			}
			Arrays.fill(rowHashArray, false);
			Arrays.fill(colmHashArray, false);
			diagonalIndex++;
		}
		return 1;
	}
}
