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
			Node temp = head;
			newNode.setNext(temp);
			head = newNode;
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
			Node prevNode = null;
			while (tempNode != null) {
				if (tempNode.getData() == data) {
					prevNode.setNext(tempNode.getNext());
					size--;
				} else {
					prevNode = tempNode;
					tempNode = tempNode.getNext();
				}
			}
		}
		
		return result;
	}
	public int getFirst() {
		if (head == null) {
			System.out.println("LinkedList is Empty.");
			return -1;
		} else {
			return head.getData();
		}
	}
	@Override
	public String toString() {
		StringBuffer outputBuff = new StringBuffer();
		Node tempNode = head;
		int index = 0;
		while (tempNode != null) {
			outputBuff.append("[" + index + "=" + tempNode.getData() + "]");
			tempNode = tempNode.getNext();
			index++;
		}
		
		return "SingleLinkedList [head=" + head + ", tail=" + tail + ", size="
				+ size + "]\nElements" + outputBuff.toString();
	}
	
	public static void main(String[] args) {
		SingleLinkedList sLinkedList = new SingleLinkedList();
		sLinkedList.insertFirst(5);
		sLinkedList.insertFirst(9);
		sLinkedList.insertFirst(2);
		sLinkedList.insertFirst(9);
		
		System.out.println("Get First Expected 9 :" + sLinkedList.getFirst());
		System.out.println("Linked List Output :" + sLinkedList);
	}
}
