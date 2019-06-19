package com.alysoft.algorithms.stacks;

import java.util.Stack;

/**
 * Here we need to make getMin in O(1).
 * push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * @author ymohammad
 *
 */


public class MinStack
{
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
    
    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek()) {
        	minStack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
    	int temp = stack.pop();
        if(temp == minStack.peek()) {
        	minStack.pop();
        }
    }
    
    public int top(){
        return stack.peek();
    } 
    
    public int getMin() {
        return minStack.peek();
    }
}
