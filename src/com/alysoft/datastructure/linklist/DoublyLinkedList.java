package com.alysoft.datastructure.linklist;

public class DoublyLinkedList<T>
{
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int length = 0;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	private DoubleNode<T> createHead(T data) {
		head = new DoubleNode<T>(data, null, null);
		length++;
		tail = head;
		return head;
	}
	//Method 1 - Insert begining.
	public synchronized DoubleNode<T> insertBegining(T data) {
		if (head == null) {
			return createHead(data);
		}
		
		DoubleNode<T> newNode = new DoubleNode<T>(data, head, null);
		head.setPrevious(newNode);
		head = newNode;
		length++;
		return newNode;
	}
	
	//Method 2 - Insert at the end.
	public synchronized DoubleNode<T> insertEnd(T data) {
		if (head == null) {
			return createHead(data);
		}
		
		DoubleNode<T> newNode = new DoubleNode<T>(data, null, tail);
		tail.setNext(newNode);
		length++;
		tail = newNode;
		return newNode;
	}
	
	//Method 3 - Insert at the end.
	public synchronized DoubleNode<T> insert(T data, int position) {
		if (head == null) {
			return createHead(data);
		}
		
		//Fix positions
		position = position < 0 ? 0 : position;
		position = position > length ? length : position;
		
		if (position == 0) return insertBegining(data);
		
		if (position == length) return insertEnd(data);
		
		DoubleNode<T> temp = head;
		for (int i=2; i<position; i++) {
			temp = temp.getNext();
		}
		DoubleNode<T> newNode = new DoubleNode<T>(data, temp.getNext(), temp);
		temp.getNext().setPrevious(newNode);
		temp.setNext(newNode);
		length++;
		return newNode;
	}
	
	
	//Method 4 - Delete at Begining
	public synchronized DoubleNode<T> deleteBegining() {
		if (head == null) return head;
		
		DoubleNode<T> temp = head;
		head = temp.getNext();
		head.setPrevious(null);
		temp.setNext(null);
		length--;
		return temp;
	}
	
	public synchronized DoubleNode<T> deleteEnd() {
		if (head == null) return head;
		
		DoubleNode<T> temp = tail;
		tail = temp.getPrevious();
		tail.setNext(null);
		temp.setPrevious(null);
		length--;
		return temp;
	}
	
	public synchronized DoubleNode<T> delete(int position) {
		if (head == null) return head;
		
		//Fix positions
		position = position < 0 ? 0 : position;
		position = position > length ? length : position;
		
		if (position == 0) return deleteBegining();
		
		if (position == length) return deleteEnd();
		
		DoubleNode<T> temp = head;
		
		for (int i = 2; i<position; i++) {
			temp = temp.getNext();
		}
		DoubleNode<T> nodeToDelete = temp.getNext();
		temp.setNext(nodeToDelete.getNext());
		nodeToDelete.getNext().setPrevious(temp);
		nodeToDelete.setNext(null);
		nodeToDelete.setPrevious(null);
		return temp;
	}
	
	public int size() {
		return length;
	}
	@Override
	public String toString()
	{
		if (head == null) return "";
		
		StringBuilder sb = new StringBuilder("Size : " + this.length + "\n");
		DoubleNode<T> temp = this.head;
		while (temp != null) {
			sb.append(temp.getPrevious() + "<--" + temp + "-->" + temp.getNext() + "\n");
			temp = temp.getNext();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.insertEnd(1);
		dll.insertEnd(2);
		dll.insertEnd(3);
		dll.insertEnd(4);
		dll.insertEnd(5);
		System.out.println("Complete List:" + dll);
		
		dll.insertBegining(0);
		System.out.println("Complete List:" + dll + "\n\n");
		
		dll.deleteBegining();
		System.out.println("Complete List:" + dll + "\n\n");
		
		dll.insert(13, 3);
		System.out.println("Complete List:" + dll + "\n\n");
		
		dll.delete(3);
		System.out.println("Complete List:" + dll + "\n\n");
		
		dll.deleteEnd();
		System.out.println("Complete List:" + dll + "\n\n");
		
	}
}
