package com.alysoft.algorithms.stacks;

public class StackLinkedListImpl {
	
	private Node topElement;
	private int size;
	
	public StackLinkedListImpl() {
		this.topElement = null;
		this.size = 0;
	}
	
	public void push(int item) {
		Node nodeItem = new Node(item, topElement);
		topElement = nodeItem;
	}
	
	public int pop() {
		if (size == 0) {
			throw new RuntimeException("Stack is empty.");
		}
		int item = this.topElement.getItem();
		Node nextTopElement = this.topElement.getLinkNode();
		this.topElement = nextTopElement;
		size++;
		return item;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	//Node class for Linked List implementation.
	class Node {
		
		private int item;
		private Node nextNodeElement;
		
		Node(int item, Node nextElement) {
			this.item = item;
			this.nextNodeElement = nextElement;
		}
		
		public Node getLinkNode() {
			return this.nextNodeElement;
		}
		
		public void setLinkNode(Node node) {
			this.nextNodeElement = node;
		}
		
		public int getItem() {
			return this.item;
		}
		
		public void setItem(int item) {
			this.item = item;
		}
	}
}
