package com.alysoft.algorithms.queue;

import com.alysoft.algorithms.stacks.StackImpl;

public class QueueTwoStacksImpl {
	private StackImpl firstStack = null;
	private StackImpl secondStack = null;
	private int qCapacity = 0;
	
	public QueueTwoStacksImpl (int qCapacity) {
		this.qCapacity = qCapacity;
		this.firstStack = new StackImpl(qCapacity);
		this.secondStack = new StackImpl(qCapacity);
	}
	
	public boolean add(int item) {
		boolean result = false;
		try {
			this.firstStack.push(item);
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}
	
	public int remove() {
		if (!this.secondStack.isEmpty()) {
			return this.secondStack.pop();
		} else  {
			while (!this.firstStack.isEmpty()) {
				this.secondStack.push(this.firstStack.pop());
			}
		}
		return this.secondStack.pop();
	}
	
	public int size() {
		return this.secondStack.size() + this.firstStack.size();
	}
	
	public boolean isEmpty() {
		return this.firstStack.isEmpty() && this.secondStack.isEmpty();
	}
	
	//Test the Queue API Methods.
	public static void main(String[] args) {
		QueueTwoStacksImpl queueImpl = new QueueTwoStacksImpl(4);
		System.out.println("Size of Queue after init :" + queueImpl.size()); // 0
		System.out.println("Queue is empty after init :" + queueImpl.isEmpty()); // true
		
		System.out.println("Adding 10 :" + queueImpl.add(10)); // true
		System.out.println("Adding 20 :" + queueImpl.add(20)); // true
		System.out.println("Adding 30 :" + queueImpl.add(30)); // true
		System.out.println("Adding 40 :" + queueImpl.add(40)); // true 
		System.out.println("Adding 50 :" + queueImpl.add(50)); // false-- overflow
		
		System.out.println("Queue is empty after full insertion :" + queueImpl.isEmpty()); // false
		System.out.println("Size of Queue after full insertion :" + queueImpl.size()); // 3
		
		System.out.println("Remove from Queue EXPECTED-10:" + queueImpl.remove()); // 10
		
		System.out.println("Size of Queue after removing 1 element :" + queueImpl.size()); // 2
		
		System.out.println("Adding 50 :" + queueImpl.add(50)); // true
		
		System.out.println("Remove from Queue EXPECTED-20:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED-30:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED-40:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED-50:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED -1:" + queueImpl.remove());//underflow condition.
		
		System.out.println("Size of Queue after complete removal :" + queueImpl.size()); // 0
		System.out.println("Queue is empty after complete removal :" + queueImpl.isEmpty()); // true
	}
}
