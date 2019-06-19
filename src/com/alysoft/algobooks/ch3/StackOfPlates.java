package com.alysoft.algobooks.ch3;

import java.util.Stack;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).

FOLLOW UP
Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
 * @author ymohammad
 *
 */
public class StackOfPlates
{
	static class SetOfStacks {
		private Stack<Stack<Integer>> setOfStacks;
		private int stackCapacity = 0;
		private Stack<Integer> currentStack = null;
		public SetOfStacks(int stackCapacity) {
			this.stackCapacity = stackCapacity;
			this.currentStack = new Stack<Integer>();
		}
		
		public void push(int item) {
			if (this.currentStack.size() == this.stackCapacity) {
				this.setOfStacks.push(this.currentStack);
				this.currentStack = new Stack<Integer>();
			}
			this.currentStack.push(item);
		}
		
		public int pop() {
			if (this.currentStack.isEmpty()) {
				if (this.setOfStacks.isEmpty()) throw new RuntimeException("Stack is empty");
				
				this.currentStack = this.setOfStacks.pop();
			}
			return this.currentStack.pop();
		}
		
		public int peek() {
			if (this.currentStack.isEmpty()) {
				if (this.setOfStacks.isEmpty()) throw new RuntimeException("Stack is empty");
				
				this.currentStack = this.setOfStacks.pop();
			}
			return this.currentStack.peek();
		}
		
		public int popAt(int index) {
			if (this.currentStack.isEmpty()) {
				if (this.setOfStacks.isEmpty()) throw new RuntimeException("Stack is empty");
				
				this.currentStack = this.setOfStacks.pop();
			}
			return this.currentStack.pop();
		}
	}
}
