package com.alysoft.algobooks.ch8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.
 * @author ymohammad
 *
 */
public class RobotInGrid
{
	public static void main(String[] args) {
		System.out.println("No. of possible paths 3x3:" + getNoOfPaths(3, 3));
		System.out.println("No. of possible paths 5x5:" + getNoOfPaths(5, 5));
		
		int n = 3;
		boolean[][] maze = new boolean[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(maze[i], true);
		}
		maze[1][2] = false;
		maze[2][1] = false;
		System.out.println("Path :" + getPath(maze));
	}
	static int getNoOfPaths(int r, int c) {
		int[][] grid = new int[r][c];
		
		for (int i = 1; i<r; i++) {
			grid[i][0] = 1;
		}
		
		for (int j = 1; j<c; j++) {
			grid[0][j] = 1;
		}
		for (int i = 1; i<r; i++) {
			for (int j = 1; j<c; j++) {
				grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}
		return grid[r-1][c-1];
	}
	
	static ArrayList<Point>getPath(boolean[][] maze) {
		ArrayList<Point> path = new ArrayList<>();
		if (getPath(maze, maze.length-1, maze[0].length-1, path)) {
			return path;
		}
		return null;
	}
	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path)
	{
		if (row < 0 || col<0 || !maze[row][col]) {
			return false;
		}
		boolean isOrigin = row==0 && col==0;
		if (isOrigin || getPath(maze, row-1, col, path) || getPath(maze, row, col-1, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		return false;
	}
	static class Point {
		int row = 0;
		int col = 0;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString()
		{
			return "(" + this.row + ", " + this.col + ")";
		}
	}
}
