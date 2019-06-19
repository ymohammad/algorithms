package com.alysoft.geeksofgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a matrix of size N X N, where N is odd. The task is to find the maximum sum out of all the triangles formed in the matrix as shown below:
Matrix:
1 2 3
4 5 6
7 8 9

Upper Triangle:
1 2 3
   5

Left Triangle:
1
4 5
7

Lower Triangle:
   5
7 8 9

Right Triangle:
   3
5 6
   9

Sum of all triangles up, left , low and right are as 11, 17, 29, 23 respectively. Maximum of all these is 29.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= Mat[i][j] <= 106

Example:
Input:
1
3
1 1 1
1 1 1
1 1 1

Output:
4

Explanation:
Testcase 1: Sum of all triangles are 4, 4, 4, 4 respectively. Maximum of all the sum is 4.
 * @author ymohammad
 *
 */
public class AddTheTriangles
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
            
            int x = printMaxSumTriangle(arr, n);
            System.out.println(x);
            t--;
        }
	}
	
	private static int printMaxSumTriangle(int[][] arr, int n)
	{
		int maxSum = Integer.MIN_VALUE;
		if (n == 1) return arr[0][0];
		
		int matCenter = (n-1)/2;
		
		//left triangle
		int colStart = 0;
		int colEnd = matCenter;
		int rowStart = 0;
		int rowEnd = n-1;
		int leftTriangleSum = 0;
		while (colStart <= colEnd) {
			for (int i = rowStart; i<=rowEnd; i++) {
				leftTriangleSum += arr[i][colStart]; 
			}
			colStart++;
			rowStart++;
			rowEnd--;
		}
		if (maxSum < leftTriangleSum) maxSum = leftTriangleSum;
		
		//Right Triangle
		colStart = n-1;
		colEnd = matCenter;
		rowStart = 0;
		rowEnd = n-1;
		int rightTriangleSum = 0;
		while (colStart >= colEnd) {
			for (int i = rowStart; i<=rowEnd; i++) {
				rightTriangleSum += arr[i][colStart]; 
			}
			colStart--;
			rowStart++;
			rowEnd--;
		}
		if (maxSum < rightTriangleSum) maxSum = rightTriangleSum;
		
		//Top Triangle
		colStart = 0;
		colEnd = n-1;
		rowStart = 0;
		rowEnd = matCenter;
		int topTriangleSum = 0;
		while (rowStart <= rowEnd) {
			for (int i = colStart; i<=colEnd; i++) {
				topTriangleSum += arr[rowStart][i]; 
			}
			colStart++;
			colEnd--;
			rowStart++;
		}
		if (maxSum < topTriangleSum) maxSum = topTriangleSum;
		
		//Bottom Triangle
		colStart = 0;
		colEnd = n-1;
		rowStart = n-1;
		rowEnd = matCenter;
		int bottomTriangleSum = 0;
		while (rowStart >= rowEnd) {
			for (int i = colStart; i<=colEnd; i++) {
				bottomTriangleSum += arr[rowStart][i]; 
			}
			colStart++;
			colEnd--;
			rowStart--;
		}
		if (maxSum < bottomTriangleSum) maxSum = bottomTriangleSum;
		
		return maxSum;
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
