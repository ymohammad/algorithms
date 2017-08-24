package com.alysoft.algorithms.stacks;

public class StackImpl {
	
	private int stackSize = 0;
	private int[] stackItemsArray = null;
	private int top = -1;
	
	public StackImpl(int stackSize) {
		this.stackSize = stackSize;
		this.stackItemsArray = new int[this.stackSize];
	}
	
	public void push(int item) {
		if (top == this.stackSize-1) {
			throw new RuntimeException("Stack Overflow Error.");
		}
		this.top++;
		this.stackItemsArray[top] = item;
	}
	
	public int pop() {
		if (top == -1) {
			throw new RuntimeException("Stack is empty.");
		}
		int returnValue = this.stackItemsArray[this.top--];
		return returnValue;
	}
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public static void main(String[] args) {
		StackImpl stack = new StackImpl(6);
		stack.push(5);
		stack.push(1);
		stack.push(4);
		stack.push(2);
		stack.push(7);
		stack.push(9);
		System.out.println("Pop value :" + stack.pop());
		System.out.println("Pop value :" + stack.pop());
		System.out.println("Pop value :" + stack.pop());
		System.out.println("Pop value :" + stack.pop());
		System.out.println("Pop value :" + stack.pop());
		System.out.println("Pop value :" + stack.pop());
		
		System.out.println("Pop value :" + stack.pop());
	}
}
