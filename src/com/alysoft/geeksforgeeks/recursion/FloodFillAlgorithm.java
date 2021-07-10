package com.alysoft.geeksforgeeks.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to 
 * replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

                     {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };

                        x=4, y=4, color=3 

                     {{1, 1, 1, 1, 1, 1, 1, 1},
                     {1, 1, 1, 1, 1, 1, 0, 0},
                     {1, 0, 0, 1, 1, 0, 1, 1}, 
                     {1, 3, 3, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 0, 1, 0},
                     {1, 1, 1, 3, 3, 3, 3, 0},
                     {1, 1, 1, 1, 1, 3, 1, 1},
                     {1, 1, 1, 1, 1, 3, 3, 1}, };


Note: Use zero based indexing.


Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow. The first line of each test case contains Two integers N and M denoting the size of the matrix. 
Then in the next line are N*M space separated values of the matrix. Then in the next line are three values x, y and K.

Output:
For each test case print the space separated values of the new matrix.

Constraints:
1<=T<=100
1<=M[][]<=100

Example:
Input:
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4 
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9

Output:
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4
 * 
 * @author ymohammad
 *
 */
public class FloodFillAlgorithm
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
        	String[] arrayValues = line.trim().split(" ");
        	int n = Integer.parseInt(arrayValues[0].trim());
            int m = Integer.parseInt(arrayValues[1].trim());
            
            int[][] arr = new int[n][m];
            line = br.readLine();;
        	arrayValues = line.trim().split(" ");
        	int h=0;
            for (int a = 0; a<n; a++) {
            	for (int j = 0; j<m; j++) {
            		arr[a][j] = Integer.parseInt(arrayValues[h]);
            		h++;
            	}
            }
				
            line = br.readLine();;
        	arrayValues = line.trim().split(" ");
        	
			int x = Integer.parseInt(arrayValues[0]);
			int y = Integer.parseInt(arrayValues[1]);
			int k = Integer.parseInt(arrayValues[2]);
			
			int pixelValue = arr[x][y];
			replacePixel(arr, n, m, x, y, k, pixelValue);
			printArr(arr, n, m);
            t--;
        }
	}

	private static void printArr(int[][] arr, int n, int m)
	{
		StringBuffer buff = new StringBuffer();
		for (int a = 0; a<n; a++) {
        	for (int j = 0; j<m; j++) {
        		buff.append(arr[a][j] + " ");
        	}
        }
		System.out.println(buff.toString().trim());
	}

	private static void replacePixel(int[][] arr, int n, int m, int x, int y, int k, int oldVal) {
		if (x < 0 || x > n-1 || y < 0 || y > m-1) {
			return;
		}
		int pixelValue = arr[x][y];
		if (pixelValue == oldVal) 
		{
			//replace value
			arr[x][y] = k;
			//System.out.println("Replacing ....");
			//printArr(arr, n, m);
			
			
			//left
			replacePixel(arr, n, m, x, y-1, k, oldVal);
			//top
			replacePixel(arr, n, m, x-1, y, k, oldVal);
			//right
			replacePixel(arr, n, m, x, y+1, k, oldVal);
			//bottom
			replacePixel(arr, n, m, x+1, y, k, oldVal);
			
		} else {
			//System.out.println("Different value :" + pixelValue + " >> oldVal :" + oldVal);
		}
	}
}
