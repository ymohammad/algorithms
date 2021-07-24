package com.alysoft.completedsa.math;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers
{
	
	public static void main(String[] args)
	{
		
		printAllJumpingNumbers(10);
		printAllJumpingNumbers(50);
		printAllJumpingNumbers(1000000000);
		
		/*
		efficientApproach(10);
		efficientApproach(50);
		efficientApproach(1018467);
		*/
	}
	public static void efficientApproach(int n) {
		LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("0 ");
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            if (temp > n) continue;
            System.out.print(temp + " ");
            int leftMost = temp % 10;
            if (leftMost > 0) queue.add(temp * 10 + (leftMost - 1));
            if (leftMost < 9) queue.add(temp * 10 + (leftMost + 1));
        }
        System.out.println();
	}
	public static void printAllJumpingNumbers(int x) {
		StringBuilder sb = new StringBuilder("0 ");
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }
		
		while (!queue.isEmpty()) {
			int first = queue.remove();
			if (first > x) continue;
			
			sb.append(first + " ");
			int leftMost = first%10;
			
			if (leftMost > 0) {
				queue.add(first * 10 + (leftMost - 1));
			}
			if (leftMost < 9) {
				queue.add(first * 10 + (leftMost) + 1);
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean isJumpingNumber(int n) {
		if (n <= 10) return true;
		
		int prev = n%10;
		int curr = 0;
		n = n/10;
		while (n > 0) {
			curr = n%10;
			if (Math.abs(prev-curr) != 1) {
				return false;
			}
			n = n/10;
			prev = curr;
		}
		return true;
	}
}
