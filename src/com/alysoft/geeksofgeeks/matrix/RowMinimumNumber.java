package com.alysoft.geeksofgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Determine the row index with minimum number of ones. The given 2D matrix has only zeroes and ones and also the matrix is sorted row wise. 
 * If two or more rows have same number of 1's than print the row with smallest index.

Input:
The first line of input contains an integer T denoting the number of test cases. 
The first line of each test case consists of two integer n and m. The next line consists of n*m spaced integers. 

Output:
Print the index of the row with minimum number of 1's. If there is 0 number of '1' in the matrix then, print '-1'.

Constraints: 
1 <= T <= 103
1 <= n, m <= 100

Example:
Input:
2
3 3
0 0 0 0 0 0 0 0 0
4 4
0 0 0 1 0 1 1 1 0 0 1 1 0 0 1 1

Output:
-1
0

Explanation:
Testcase 2: The matrix formed for the given input will be as such
0 0 0 1
0 1 1 1
0 0 1 1
0 0 1 1
First row is having minimum number of 1 i.e. answer is 0.
 * @author ymohammad
 *
 */
public class RowMinimumNumber
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
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
            
            int minRowIndex = -1;
            int minOnes = Integer.MAX_VALUE;
            for (int i = 0; i<n; i++) {
            	int count = 0;
            	for (int j=0; j<n; j++) {
            		while (arrayValues[k] == null || arrayValues[k].trim().length() == 0) {
            			k++;
            		}
            		arr[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            		if (arr[i][j] == 1) count++;
            	}
            	if (count != 0 && count < minOnes) {
            		minOnes = count;
            		minRowIndex = i;
            	}
            }
			
            System.out.println(minRowIndex);
            t--;
        }
	}
}
