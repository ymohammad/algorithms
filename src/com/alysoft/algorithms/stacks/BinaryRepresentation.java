package com.alysoft.algorithms.stacks;

import java.util.Stack;

public class BinaryRepresentation {
	
	public static void main(String[] args) {
		printBinary(17);
	}
	
	public static void printBinary(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while (n>0) {
			stack.push(n%2);
			n = n/2;
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
