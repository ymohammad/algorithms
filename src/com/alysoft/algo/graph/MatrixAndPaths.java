package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.alysoft.algo.graph.BasicImplementation.Graph;

/**
 * Matrix and Paths (100 Marks)
In a square matrix M containing 0 and 1, the task is to find the lowest cost path from (0,0) to any given cell (x,y). 
You may move in only four directions i.e. up, down, left and right. 
A path can exist through a cell if and only if it has a value of 1. The cell with value 0 cannot allow a path to go through it. 
The cost of the path is the number of total cells traversed in the path.
If we cannot reach the desired cell, then output -1.


Input Format
The first line contains N and M, denoting the number of rows and columns respectively.
Each of the next N lines consists of m integers values (0/1).
The next line contains two integers x and y denoting the destination cell.


Constraints
0 <= n,m < 1000
0 <= x,y < 1000


Output Format
Output the minimum cost of the path.


Sample TestCase 1
Input
4 4
1 1 1 1
1 0 1 1
0 1 1 1
0 1 1 1
2 1
Output
5
 * @author ymohammad
 *
 */
public class MatrixAndPaths
{
	public static void main(String[] args) throws Exception {
		String[] strArr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();    
        strArr = line.split(" ");
        int rows = Integer.parseInt(strArr[0].trim());
        int columns = Integer.parseInt(strArr[1].trim());
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i<rows; i++) {
        	line = br.readLine();    
            strArr = line.split(" ");
            for (int j = 0; j<columns; j++) {
            	matrix[i][j] = Integer.parseInt(strArr[j].trim());
            }
        }
        line = br.readLine();    
        strArr = line.split(" ");
        int x = Integer.parseInt(strArr[0].trim());
        int y = Integer.parseInt(strArr[1].trim());
        
        boolean[][] visited = new boolean[rows][columns];
        int shortestPath = getShortestPath(matrix, visited, rows, columns, x, y, 0, 0, 0, -1, -1);
        if (shortestPath == Integer.MAX_VALUE) {
        	shortestPath = -1;
        }
        System.out.print(shortestPath);
	}
/*
 * 
4 4
1 1 1 1
1 0 1 1
0 1 1 1
0 1 1 1
2 1
 */
	public static int getShortestPath(int[][] matrix, boolean[][] visited, int rows, int columns, int x, int y, int xStart, int yStart, 
			int currentCount, int parentX, int parentY)
	{
		//System.out.println("xStart :" + xStart + " >> yStart :" + yStart + " currentCount :" + currentCount);
		if (x == xStart && y == yStart) return currentCount;
		
		if (xStart < 0 || yStart < 0) return Integer.MAX_VALUE;
		
		if (xStart >= rows || yStart >= columns) return Integer.MAX_VALUE;
		
		if (matrix[xStart][yStart] == 0) return Integer.MAX_VALUE;
		
		if (xStart == parentX && yStart == parentY) return Integer.MAX_VALUE;
		//Already visited..
		if (visited[xStart][yStart]) return Integer.MAX_VALUE;
		
		visited[xStart][yStart] = true;
		//upDirection
		int upValue = getShortestPath(matrix, visited, rows, columns, x, y, xStart-1, yStart, currentCount+1, xStart, yStart);
		int leftValue = getShortestPath(matrix, visited, rows, columns, x, y, xStart, yStart-1, currentCount+1, xStart, yStart);
		int downValue = getShortestPath(matrix, visited, rows, columns, x, y, xStart+1, yStart, currentCount+1, xStart, yStart);
		int rightValue = getShortestPath(matrix, visited, rows, columns, x, y, xStart, yStart+1, currentCount+1, xStart, yStart);
		
		int minValue = Math.min(upValue, rightValue);
		minValue = Math.min(minValue, leftValue);
		minValue = Math.min(minValue, downValue);
		return minValue;
	}
}
