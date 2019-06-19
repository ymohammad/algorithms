package com.alysoft.algorithms.tree;

public class BinaryNode<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private BinaryNode<T> parent;
	
	public BinaryNode(T item) {
		this.data = item;
		this.left = this.right = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString()
	{
		return "[data=" + this.data + "] -> left=" + this.left + ", right=" + this.right + "]";
	}

	public BinaryNode<T> getParent()
	{
		return this.parent;
	}

	public void setParent(BinaryNode<T> parent)
	{
		this.parent = parent;
	}
}
