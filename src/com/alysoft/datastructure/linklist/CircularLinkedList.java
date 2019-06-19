package com.alysoft.datastructure.linklist;

public class CircularLinkedList<T>
{
	private SingleNode<T> tail = null;
	private int length = 0;
	
	public CircularLinkedList() {
		this.tail = null;
		this.length = 0;
	}
	
	//Method 1: Insert at Start
	public void add(T data) {
		this.addToHead(data);
	}
	
	//Method 2: insert at the start.
	public void addToHead(T data) {
		if (tail == null) {
			tail = new SingleNode<T>(data, null);
			tail.setNext(tail);
		} else {
			SingleNode<T> head = tail.getNext();
			SingleNode<T> newNode = new SingleNode<T>(data, head);
			tail.setNext(newNode);
		}
		this.length++;
	}
	
	//Method 3: Add to tail
	public void addToTail(T data) {
		this.addToHead(data);
		this.tail = tail.getNext();
	}
	
	//Method 4: pop method implementation
	public T pop() {
		if (tail == null) return null;
		
		SingleNode<T> head = tail.getNext();
		this.tail.setNext(head.getNext());
		head.setNext(null);
		this.length--;
		return head.getData();
	}
	
	//Method 5: Delete data
	public T delete(T data) {
		if (tail == null) return null;
		
		if (tail.getData().equals(data) && this.length == 1) {
			T returnData = tail.getData();
			tail = null;
			this.length--;
			return returnData;
		}
		SingleNode<T> previous = tail;
		SingleNode<T> finger = tail.getNext();
		while (finger != tail && !finger.getData().equals(data)) {
			previous = finger;
			finger = finger.getNext();
		}
		
		if (finger.getData().equals(data)) {
			if (finger == tail)
				tail = previous;
			
			previous.setNext(finger.getNext());
			finger.setNext(null);
			this.length--;
			return finger.getData();
		}
		return null;
	}

	@Override
	public String toString()
	{
		if (tail == null) return "[]";
		
		if (tail.getNext() == null) return this.tail.toString();
		
		SingleNode<T> head = tail.getNext();
		StringBuffer buff = new StringBuffer();
		while (head != tail) {
			buff.append(head + "-->");
			head = head.getNext();
		}
		buff.append(tail.toString() + "--------->" + tail.getNext().toString());
		return "CircularLinkedList Size :" + this.length + " - " + buff.toString();
	}
	
	public static void main(String[] str) {
		CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
		cll.add(5);
		cll.add(4);
		cll.add(3);
		cll.add(2);
		cll.add(1);
		
		System.out.println("Complete List:" + cll + "\n\n");
		
		cll.addToTail(6);
		System.out.println("Complete List:" + cll + "\n\n");
		
		cll.addToHead(0);
		System.out.println("Complete List:" + cll + "\n\n");
		
		System.out.println("Pop :" + cll.pop());
		System.out.println("Complete List:" + cll + "\n\n");
		
		System.out.println("Delete 3 :" + cll.delete(3));
		System.out.println("Complete List:" + cll + "\n\n");
	}
}
