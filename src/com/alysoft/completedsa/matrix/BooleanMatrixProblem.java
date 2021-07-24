package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is r and c, r is the number of rows and c is the number of columns.
The second line of each test case contains all the elements of the matrix in a single line separated by a single space.

Output:
Print the modified array.

Constraints:
1 <= T <= 102
1 <= r, c <= 103
0 <= A[i][j] <= 1

Example:
Input:
3
2 2
1 0 
0 0
2 3
0 0 0 
0 0 1
4 3
1 0 0
1 0 0
1 0 0
0 0 0

Output:
1 1
1 0
0 0 1 
1 1 1
1 1 1
1 1 1
1 0 0

Explanation:
Testcase1: Since only rist element of matrix has 1 (at index 1,1) as value, so first row and first column are modified to 1.
 * @author ymohammad
 *
 */
public class BooleanMatrixProblem
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
        	String[] arrayValues = line.trim().split(" ");
        	int n = Integer.parseInt(arrayValues[0].trim());
            int m = Integer.parseInt(arrayValues[1].trim());
            
            int[][] booleanArr = new int[n][m];
            
            for (int a = 0; a<n; a++) {
            	line = br.readLine();;
            	arrayValues = line.trim().split(" ");
            	int k=0;
            	for (int j = 0; j<m; j++) {
            		booleanArr[a][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
            
            printBooleanMatrixEnhanced(booleanArr, n, m);
            t--;
        }
	}

	private static void printBooleanMatrixEnhanced(int[][] booleanArr, int rows, int columns)
	{
		int[] tmpRowArr = new int[rows];
		int[] tmpColmArr = new int[columns];
		
		for (int i = 0; i<rows; i++) {
			int j = 0;
        	while ( j<columns) {
        		if (booleanArr[i][j] == 1) {
        			tmpRowArr[i] = 1;
        			tmpColmArr[j] = 1;
        		}
        		j++;
        	}
        }
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				if (tmpRowArr[i] == 1 || tmpColmArr[j] == 1) {
					buff.append("1 ");
				} else {
					buff.append(booleanArr[i][j] + " ");
				}
			}
			buff.append("\n");
		}
		System.out.println(buff.toString());
	}
	
	private static void printBooleanMatrix(int[][] booleanArr, int rows, int columns)
	{
		for (int i = 0; i<rows; i++) {
			int j = 0;
        	while ( j<columns) {
        		if (booleanArr[i][j] == 1) {
        			fillRow(booleanArr, i, columns );
        			fillColumn(booleanArr, j, rows);
        		}
        		j++;
        	}
        }
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				if (booleanArr[i][j] == -1) {
					buff.append("1 ");
				} else {
					buff.append(booleanArr[i][j] + " ");
				}
			}
			buff.append("\n");
		}
		System.out.println(buff.toString());
	}

	private static void fillColumn(int[][] booleanArr, int columnInd, int rows)
	{
		for (int i=0; i<rows; i++) {
			if (booleanArr[i][columnInd] == 0) {
				booleanArr[i][columnInd] = -1;
			}
		}
	}

	private static void fillRow(int[][] booleanArr, int rowInd, int colmns)
	{
		for (int i=0; i<colmns; i++) {
			if (booleanArr[rowInd][i] == 0) {
				booleanArr[rowInd][i] = -1;
			}
		}
	}
}
