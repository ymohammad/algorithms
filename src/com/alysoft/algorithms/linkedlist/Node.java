package com.alysoft.algorithms.linkedlist;

public class Node {
	 Node next;
	 int data;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(int d) {
		 data=d;
	        next=null;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public int getData() {
		return data;
	}
	public int getSize() {
		return 1 + (next != null ? next.getSize() : 0);
	}
	@Override
	public String toString() {
		return "[" + this.data + "]->" + this.next;
	}
}
