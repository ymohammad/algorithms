package com.alysoft.datastructure.linklist;

public class DoubleNode<T>
{
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;
	
	
	public DoubleNode()
	{
		super();
		
	}
	public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous)
	{
		super();
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	public T getData()
	{
		return this.data;
	}
	public void setData(T data)
	{
		this.data = data;
	}
	public DoubleNode<T> getNext()
	{
		return this.next;
	}
	public void setNext(DoubleNode<T> next)
	{
		this.next = next;
	}
	public DoubleNode<T> getPrevious()
	{
		return this.previous;
	}
	public void setPrevious(DoubleNode<T> previous)
	{
		this.previous = previous;
	}
	@Override
	public String toString()
	{
		return "[" + this.data + "]";
	}
	
	
}
