package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two matrices mat1 and mat2 of size N x N of  elements. Given a value x. 
 * The problem is to count all pairs from both matrices whose sum is equal to x.

INPUT: The first line consists of an integer T i.e. the number of test cases. 
The first line of each test case contains Two Integer N , x  denoting the size of the square Matrix. 
Next 2*N lines contain N integers separated by space.


OUTPUT: For each test case Print the count.

Constraints:
1<=T<=50
1 <= N <= 50
0 <= X <= 2000
1<= A[i][j] , B[i][j] <= 1000

Example:

Input:

1

3 21

1 5 6
8 10 11
15 16 18

2 4 7
9 10 12
13 16 20

Output:

4

Explanation: The pairs are : (1 , 20 ) , (5 , 16 ) , (8 ,13 ) ,( 11 , 10 )
 * @author ymohammad
 *
 */
public class CountPairsSumMatrices
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
            int[] localVariable = new int[2];
            int k=0;
            for (int e = 0; e<arrayValues.length; e++) {
                if (arrayValues[e] != null && arrayValues[e].trim().length()>0) {
                    localVariable[k] = Integer.parseInt(arrayValues[e]);
                    k++;
                }
            }
            int n = localVariable[0];
            int x = localVariable[1];
            int[][] arr1 = new int[n][n];
            int[][] arr2 = new int[n][n];
            
            k = 0;
            line=null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
            arrayValues = line.trim().split(" ");
            for (int i = 0; i<n; i++) {
            	for (int j = 0; j<n; j++) {
            		while (arrayValues[k] == null || arrayValues[k].trim().length() == 0) {
            			k++;
            		}
            		arr1[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            	k = 0;
                line=null;
                if (i != n-1) {
	            	while (line == null || line.trim().length()==0) {
	            		line = br.readLine();
	                }
	                arrayValues = line.trim().split(" ");
                }
            }
            k = 0;
            line=null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
            arrayValues = line.trim().split(" ");
            for (int i = 0; i<n; i++) {
            	for (int j = 0; j<n; j++) {
            		while (arrayValues[k] == null || arrayValues[k].trim().length() == 0) {
            			k++;
            		}
            		arr2[i][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            	k = 0;
                line=null;
                if (i != n-1) {
	            	while (line == null || line.trim().length()==0) {
	            		line = br.readLine();
	                }
	                arrayValues = line.trim().split(" ");
                }
            }
            
			int result = findSumCount(arr1, arr2, n, x);
			System.out.println(result);
            t--;
        }
	}

	private static int findSumCount(int[][] arr1, int[][] arr2, int n, int x)
	{
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				int a = arr1[i][j];
				for (int k=0; k<n; k++) {
					for (int l=0; l<n; l++) {
						int b = arr2[k][l];
						if ((a+b) == x) count++;
					}
				}
			}
		}
		return count;
	}
}
