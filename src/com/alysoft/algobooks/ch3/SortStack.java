package com.alysoft.algobooks.ch3;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 * @author ymohammad
 *
 */
public class SortStack
{
	/**
	 * While adding we can do it easily the sorted array. But how to write a method which does it.
	 * @param unSortedStack
	 * @return
	 */
	public static Stack<Integer> getSortedStack(Stack<Integer> unSortedStack) {
		SortStack stack = new SortStack();
		
		while(!unSortedStack.isEmpty()) {
			stack.push(unSortedStack.pop());
		}
		return stack.getSortedStack();
	}
	private Stack<Integer> primaryStack = new Stack<Integer>();
	private Stack<Integer> secondaryStack = new Stack<Integer>();
	
	public boolean push(Integer item) {
		while (!primaryStack.isEmpty() && item > primaryStack.peek()) {
			this.secondaryStack.push(primaryStack.pop());
		}
		this.primaryStack.push(item);
		
		while(!secondaryStack.isEmpty()) {
			this.primaryStack.push(secondaryStack.pop());
		}
		return true;
	}
	
	public int pop() {
		return this.primaryStack.pop();
	}
	public Stack<Integer> getSortedStack() {
		return this.primaryStack;
	}
	@Override
	public String toString()
	{
		return "SortStack [primaryStack=" + this.primaryStack + ", secondaryStack=" + this.secondaryStack + "]";
	}
	public static void main(String[] args)
	{
		SortStack stack = new SortStack();
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(4);
		stack.push(6);
		
		System.out.println(stack);
	}

	

}
