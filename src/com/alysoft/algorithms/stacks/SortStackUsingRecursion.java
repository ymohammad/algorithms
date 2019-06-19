package com.alysoft.algorithms.stacks;

import java.util.Stack;

public class SortStackUsingRecursion
{
	 public static void main(String args[]) 
	    { 
	        Stack<Integer> input = new Stack<Integer>(); 
	        input.add(34); 
	        input.add(3); 
	        input.add(31); 
	        input.add(98); 
	        input.add(92); 
	        input.add(23); 
	        Stack<Integer> sortedStack = new Stack<Integer>();
	        // This is the temporary stack 
	        stackSort(input, sortedStack, input.pop()); 
	        System.out.println("Sorted numbers are:"); 
	      
	        while (!sortedStack.empty()) 
	        { 
	            System.out.print(sortedStack.pop()+" "); 
	        }  
	    } 
	public static void stackSort(Stack<Integer> input, Stack<Integer> sortedStack, int temp) {
		if (!input.isEmpty() || temp != -1) {
			if (sortedStack.isEmpty() || temp < sortedStack.peek()) {
				sortedStack.push(temp);
				temp = input.isEmpty() ? -1 : input.pop();
			} else {
				input.push(sortedStack.pop());
			} 
			stackSort(input, sortedStack, temp);
		}
	}
}
