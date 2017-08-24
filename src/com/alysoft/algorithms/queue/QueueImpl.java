package com.alysoft.algorithms.queue;


/*
 * Implementing Queue using circular Array.
 */
public class QueueImpl {
	private int[] queueArr = null;
	private int queueCapacity = 0;
	private int rear = 0;
	private int front = 0;
	
	public QueueImpl(int queueCapacity) {
		this.queueCapacity = queueCapacity;
		this.queueArr = new int[queueCapacity];
	}
	
	public int remove() {
		if (rear == front) {
			System.out.println("Queue is empty.");
			return -1;
		} else {
			front = (front+1)%queueCapacity;
			int frontValue = queueArr[front];
			return frontValue;
		}
	}
	
	public boolean add(int item) {
		if (front == ((rear+1)%queueCapacity)) {
			System.out.println("Queue is Overflow.");
			return false;
		} else {
			rear = (rear+1)%queueCapacity;
			queueArr[rear] = item;
			return true;
		}
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public int size() {
		int size = 0;
		int tempFront = front;
		while (tempFront != rear) {
			size++;
			tempFront = (tempFront+1)%queueCapacity;
		}
		return size;
	}
	
	
	//Test the Queue API Methods.
	public static void main(String[] args) {
		QueueImpl queueImpl = new QueueImpl(4);
		System.out.println("Size of Queue after init :" + queueImpl.size()); // 0
		System.out.println("Queue is empty after init :" + queueImpl.isEmpty()); // true
		
		System.out.println("Adding 10 :" + queueImpl.add(10)); // true
		System.out.println("Adding 20 :" + queueImpl.add(20)); // true
		System.out.println("Adding 30 :" + queueImpl.add(30)); // true
		System.out.println("Adding 40 :" + queueImpl.add(40)); // false -- overflow
		
		System.out.println("Queue is empty after full insertion :" + queueImpl.isEmpty()); // false
		System.out.println("Size of Queue after full insertion :" + queueImpl.size()); // 3
		
		System.out.println("Remove from Queue EXPECTED-10:" + queueImpl.remove()); // 10
		
		System.out.println("Size of Queue after removing 1 element :" + queueImpl.size()); // 2
		
		System.out.println("Adding 40 :" + queueImpl.add(40)); // true
		
		System.out.println("Remove from Queue EXPECTED-20:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED-30:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED-40:" + queueImpl.remove());
		System.out.println("Remove from Queue EXPECTED -1:" + queueImpl.remove());//underflow condition.
		
		System.out.println("Size of Queue after complete removal :" + queueImpl.size()); // 0
		System.out.println("Queue is empty after complete removal :" + queueImpl.isEmpty()); // true
	}
}
