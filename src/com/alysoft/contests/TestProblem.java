package com.alysoft.contests;

import java.util.ArrayList;

public class TestProblem
{

	static int  finalCount=0;
	public static void main(String[] args) {
		System.out.println(cadbury(6, 5, 3, 4));
	}
	public static int cadbury(int input1, int input2, int input3, int input4) {
		int total = 0;
		if (input2 >= input1 && input4 >= input3 && input1 > 0 && input2 > 0
				&& input3 > 0 && input4 > 0) {
			for (int row = input1; row <= input2; row++) {
				for (int column = input3; column <= input4; column++) {
					int remainingRow = row, remainingColumn = column;
					System.out.println(row + "x" + column);
					while (true) {
						if (remainingRow == 0 && remainingColumn == 0) {
							break;
						}
						if (remainingRow > remainingColumn) {
							remainingRow = remainingRow - remainingColumn;
							total = total + 1;
						}
						if (remainingRow < remainingColumn) {
							remainingColumn = remainingColumn - remainingRow;
							total = total + 1;
						}
						if (remainingRow == remainingColumn) {
							remainingRow = 0;
							remainingColumn = 0;
							total = total + 1;
						}
					}
				}
			}
		}
		return total;
	}
}
