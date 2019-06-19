package com.alysoft.datastructure.linklist;

public class SingleNode<T>
{
	private T data;
	private T extraValue;
	private SingleNode<T> next;
	
	public SingleNode() {
		super();
	}
	
	public SingleNode(T data, SingleNode<T> next)
	{
		super();
		this.data = data;
		this.next = next;
	}
	
	public T getData()
	{
		return this.data;
	}
	public void setData(T data)
	{
		this.data = data;
	}
	public SingleNode<T> getNext()
	{
		return this.next;
	}
	public void setNext(SingleNode<T> next)
	{
		this.next = next;
	}

	@Override
	public String toString()
	{
		return "[" + this.data + "]";
	}
	
	public static void printLinkedList(SingleNode head) {
		while (head != null) {
			System.out.print(head.toString() + "-->");
			head = head.getNext();
		}
		System.out.print(head + "\n\n");
	}

	public T getExtraValue()
	{
		return this.extraValue;
	}

	public void setExtraValue(T extraValue)
	{
		this.extraValue = extraValue;
	}
}
