package com.alysoft.algorithms.linkedlist;

public class SingleLinkedList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public void insertFirst(int data) {
		Node newNode = new Node (data, null);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			Node temp = head.getNext();
			newNode.setNext(temp);
			head.setNext(newNode);
		}
		size++;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node (data, null);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
		}
		size++;
	}
	
	public Node delete(int data) {
		Node result = null;
		if (head == null) {
			System.out.println("LinkedList is Empty.");
			return null;
		} else {
			Node tempNode = head;
			while (tempNode.getNext() != null) {
				if (tempNode.getData() == data) {
					//to-do
					size--;
				} else {
					tempNode = tempNode.getNext();
				}
			}
		}
		
		return result;
	}
}
