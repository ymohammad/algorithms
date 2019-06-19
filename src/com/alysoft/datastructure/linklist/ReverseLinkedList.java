package com.alysoft.datastructure.linklist;

public class ReverseLinkedList {
	public static SingleNode<Integer> revHead = null;
	public static void reverseLinkedListRecursive(SingleNode<Integer> previous, SingleNode<Integer> current) {
		if (current == null) {
			revHead = previous;
			return;
		}
		
		reverseLinkedListRecursive(current, current.getNext());
		current.setNext(previous);
	}
	public static SingleNode<Integer> reverseLinkedListIterative(SingleNode<Integer> current) {
		if (current == null || current.getNext() == null) return current;
		
		SingleNode<Integer> previous = null;
		SingleNode<Integer> nextNode = null;
		
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(previous);
			previous = current;
			current = nextNode;
		}
		return previous;
	}
	
	public static void printNode(SingleNode<Integer> head) {
		while (head != null) {
			System.out.print(head.toString() + "-->");
			head = head.getNext();
		}
		System.out.print(head);
	}
	public static void main(String[] args) {
		SingleNode<Integer> head = new SingleNode<Integer>(1, new SingleNode<Integer>(2, 
				new SingleNode<Integer>(3, new SingleNode<Integer>(4, new SingleNode<Integer>(5, null)))));
		//head = reverseLinkedListIterative(head);
		printNode(reverseLinkedListIterative(head));
		
		System.out.println("\n\nRecursive call...");
		head = new SingleNode<Integer>(1, new SingleNode<Integer>(2, 
				new SingleNode<Integer>(3, new SingleNode<Integer>(4, new SingleNode<Integer>(5, null)))));
		//head = reverseLinkedListIterative(head);
		reverseLinkedListRecursive(null, head);
		printNode(revHead);
		
	}
}
