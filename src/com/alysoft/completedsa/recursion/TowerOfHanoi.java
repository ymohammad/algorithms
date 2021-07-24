package com.alysoft.completedsa.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * The tower of Hanoi is a famous puzzle where we have three rods and N disks. The objective of the puzzle is to move the entire stack to another rod. 
 * You are given the number of discs N. Initially, these discs are in the rod 1. You need to print all the steps of discs movement 
 * so that all the discs reach the 3rd rod. Also, you need to find the total moves.
Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered N. 
Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc. 
Refer the provided link to get a better clarity about the puzzle.

Input:
The first line of input is T denoting the number of testcases. T testcases follow. Each testcase contains a single line of input containing N.

Output:
For each testcase, print the steps and the total steps taken. Please see the example output to see the steps format.

Constraints:
1 <= T <= 16
1 <= N <= 16

Example:
Input:
2
2
3
Output:
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
3
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3
7
 * @author ymohammad
 *
 */
public class TowerOfHanoi
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            printTowerOfHanoiSteps(n);
            t--;
        }
	}

	private static void printTowerOfHanoiSteps(int n)
	{
		Stack<Integer> rod1 = new Stack<Integer>();
		int temp = n;
		while (temp > 0) {
			rod1.push(temp);
			temp--;
		}
		Stack<Integer> rod2 = new Stack<Integer>();
		Stack<Integer> rod3 = new Stack<Integer>();
		StringBuffer buff = new StringBuffer();
		while (rod3.size()<n) {
			
			if (!isEven(n)) {
				moveAtoC(rod1, rod2, rod3, buff, n);
				moveAtoB(rod1, rod2, rod3, buff, n);
			} else {
				moveAtoB(rod1, rod2, rod3, buff, n);
				moveAtoC(rod1, rod2, rod3, buff, n);
			}
			moveBtoC(rod1, rod2, rod3, buff, n);
		}
		buff.append((int)(Math.pow(2, n))-1);
		System.out.println(buff.toString());
	}
	
	private static void moveBtoC(Stack<Integer> rod1, Stack<Integer> rod2, Stack<Integer> rod3, StringBuffer buff, int n)
	{
		if (rod3.isEmpty() && rod2.isEmpty()) return;
		
		if (rod3.size() == n) return;
		
		if (rod3.isEmpty() || (!rod2.isEmpty() && rod3.peek() > rod2.peek())) {
			buff.append("move disk " + rod2.peek() + " from rod 2 to rod 3\n");
			rod3.push(rod2.pop());
		} else {
			buff.append("move disk " + rod3.peek() + " from rod 3 to rod 2\n");
			rod2.push(rod3.pop());
		}
	}

	private static void moveAtoB(Stack<Integer> rod1, Stack<Integer> rod2, Stack<Integer> rod3, StringBuffer buff, int n)
	{
		if (rod1.isEmpty() && rod2.isEmpty()) return;
		
		if (rod2.isEmpty() || (!rod1.isEmpty() && rod2.peek() > rod1.peek())) {
			buff.append("move disk " + rod1.peek() + " from rod 1 to rod 2\n");
			rod2.push(rod1.pop());
		} else {
			buff.append("move disk " + rod2.peek() + " from rod 2 to rod 1\n");
			rod1.push(rod2.pop());
		}
	}

	private static void moveAtoC(Stack<Integer> rod1, Stack<Integer> rod2, Stack<Integer> rod3, StringBuffer buff, int n)
	{
		if (rod1.isEmpty() && rod3.isEmpty()) return;
		if (rod3.size() == n) return;
		
		if (rod3.isEmpty() || (!rod1.isEmpty() && rod3.peek() > rod1.peek())) {
			buff.append("move disk " + rod1.peek() + " from rod 1 to rod 3\n");
			rod3.push(rod1.pop());
		} else {
			buff.append("move disk " + rod3.peek() + " from rod 3 to rod 1\n");
			rod1.push(rod3.pop());
		}
	}

	private static boolean isEven(int n)
	{
		return n%2==0;
	}
}
