package com.alysoft.algo.matrix;

public class SnakeOrder
{
	public static void main(String[] args)
	{
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7},
				{8, 9, 10, 11}
		};
		printSnakeOrder(arr);
	}
	public static void printSnakeOrder(int[][] arr) {
		for (int i = 0; i<arr.length; i++)
		{
			int j, n;
			boolean increment = true;
			if (i%2 == 0)
			{
				j = 0;
				n = arr[i].length-1;
			} else
			{
				j = arr[i].length-1;
				n = 0;
				increment = false;
			}
			while ((increment && j<=n) || (!increment && j>=n)) {
				System.out.print(arr[i][j] + " ");
				if (increment) {
					j++;
				} else {
					j--;
				}
			}
		}
	}
}
