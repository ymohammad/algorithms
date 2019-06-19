package com.alysoft.datastructure.linklist;

public class SinglyLinkedList<T>
{
	private SingleNode<T> head;
	private int length = 0;
	
	public SinglyLinkedList() {
		this.head = null;
		this.length = 0;
	}
	
	public SinglyLinkedList(T headData) {
		this.head = new SingleNode<T>(headData, null);
		this.length++;
	}
	//Method 1 - Inserting a node at the begining of the List.
	public synchronized SingleNode<T> insertAtBegining(T data) {
		if (head == null) {
			head = new SingleNode<T>(data, null);
			length++;
			return head;
		}
		
		SingleNode<T> newNode = new SingleNode<T>(data, head);
		head = newNode;
		length++;
		return newNode;
	}
	
	//Method 2 - Inserting a node at the end of the list.
	public synchronized SingleNode<T> insertAtEnd(T data) {
		
		if (head == null) {
			head = new SingleNode<T>(data, null);
			length++;
			return head;
		}
		
		SingleNode<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		SingleNode<T> singleNode = new SingleNode<T>(data, null);
		temp.setNext(singleNode);
		length++;
		return singleNode;
	}
	
	//Method 3 - Inserting a node at certain position.
	public synchronized SingleNode<T> insert(int position, T data) {
		if (head == null) {
			head = new SingleNode<T>(data, null);
			length++;
			return head;
		}
		
		//Fixing position
		if (position < 0) position = 0;
		if (position > length) position = length;
		
		if (position == 0) return insertAtBegining(data);
		if (position == length) return insertAtEnd(data);
		
		SingleNode<T> temp = head;
		for (int i = 2; i<position; i++) {
			temp = temp.getNext();
		}
		SingleNode<T> next = temp.getNext();
		SingleNode<T> newNode = new SingleNode<T>(data, next);
		temp.setNext(newNode);
		length++;
		return newNode;
	}
	
	//Method 4 - Delete at the begining of the position.
	public synchronized SingleNode<T> deleteAtBegining() {
		if (head == null) return head;
		
		SingleNode<T> temp = head;
		head = temp.getNext();
		temp.setNext(null);
		length--;
		return temp;
	}
	
	//Method 5- Delete at the end of the list.
	public synchronized SingleNode<T> deleteAtEnd() {
		if (head == null) return head;
		
		SingleNode<T> temp = head;
		SingleNode<T> prevNode = null;
		while (temp.getNext() != null) {
			prevNode = temp;
			temp = temp.getNext();
		}
		prevNode.setNext(null);
		length--;
		return temp;
	}
	
	public synchronized SingleNode<T> delete(SingleNode<T> node) {
		if (head == null) return head;
		
		if (head == node) return deleteAtBegining();
		
		SingleNode<T> temp = head;
		SingleNode<T> prevNode = null;
		while (temp != null) {
			if (temp == node) {
				prevNode.setNext(temp.getNext());
				temp.setNext(null);
				length--;
				return temp;
			}
			prevNode = temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	//Method 6- Delete at the given position
	public synchronized SingleNode<T> delete(int position) {
		if (head == null) return head;
		
		if (position < 0) position = 0;
		if (position > length) position = length;
		
		if (position == 0) return deleteAtBegining();
		if (position == length) return deleteAtEnd();
		
		SingleNode<T> temp = head;
		for (int i = 2; i<position; i++) {
			temp = temp.getNext();
		}
		SingleNode<T> next = temp.getNext();
		temp.setNext(next.getNext());
		length--;
		next.setNext(null);
		return next;
	}
	
	public synchronized void clearList() {
		this.head = null;
		this.length = 0;
	}
	
	public int size() {
		return length;
	}

	
	@Override
	public String toString()
	{
		if (head == null) return "Size : " + this.length + " - []";
		SingleNode<T> temp = head;
		StringBuilder str = new StringBuilder("Size : " + this.length + " - ");
		while (temp != null) {
			str.append(temp + "-->");
			temp = temp.getNext();
		}
		str.append(temp);
		return str.toString();
	}
	public SingleNode<T> getHead()
	{
		return this.head;
	}
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer>(1);
		sLL.insertAtEnd(2);
		sLL.insertAtEnd(3);
		sLL.insertAtEnd(4);
		sLL.insertAtEnd(5);
		sLL.insertAtEnd(6);
		sLL.insertAtEnd(7);
		sLL.insertAtEnd(8);
		sLL.insertAtEnd(9);
		sLL.insertAtEnd(10);
		
		System.out.println("Complete List:" + sLL);
		
		sLL.insertAtBegining(0);
		
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Delete Begining :" + sLL.deleteAtBegining());
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Delete Ending :" + sLL.deleteAtEnd());
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Insert at position 10 :" + sLL.insert(10, 10));
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Insert at position 22 :" + sLL.insert(22, 22));
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Insert at position -85 :" + sLL.insert(-85, -85));
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Delete Begining :" + sLL.deleteAtBegining());
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Delete Ending :" + sLL.deleteAtEnd());
		System.out.println("Complete List:" + sLL + "\n\n");
		
		
		System.out.println("Insert at position 3 :" + sLL.insert(3, 13));
		System.out.println("Complete List:" + sLL + "\n\n");
		
		System.out.println("Delete at Position 3 :" + sLL.delete(3));
		System.out.println("Complete List:" + sLL + "\n\n");
		
	}



}
