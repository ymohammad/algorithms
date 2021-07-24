/*******************************************************************************************************************************
FindNumberOfIslands.java


Author : ymohammad
Date   : Jul 19, 2021

Last modified by : ymohammad
Last modified on : Jul 19, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

/**
* Class FindNumberOfIslands
*/
public class FindNumberOfIslands {

    public static void printNumberOfIslands(int[][] arr) {
	int islandCount = 0;
	boolean[][] visited = new boolean[arr.length][arr[0].length];
	
	for (int i = 0; i<arr.length; i++) {
	    for (int j = 0; j< arr[0].length; j++) {
		if (visited[i][j] == false && arr[i][j] == 0) {
		    exploreIsland(arr, i, j, visited);
		    islandCount++;
		}
	    }
	}
	System.out.println(islandCount);
    }
    private static void exploreIsland(int[][] arr, int row, int column, boolean[][] visited) {
	
	if (row < 0 || column < 0 || row >= arr.length || column >= arr[0].length || 
		visited[row][column] == true || arr[row][column] == 1) {
	    return;
	}
	
	visited[row][column] = true;
	exploreIsland(arr, row+1, column, visited);
	exploreIsland(arr, row, column+1, visited);
	exploreIsland(arr, row-1, column, visited);
	exploreIsland(arr, row, column-1, visited);
	
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
}
