package com.alysoft.algorithms.tree;

public class BinaryNode {
	private char data;
	private BinaryNode left;
	private BinaryNode right;
	
	public BinaryNode(char item) {
		this.data = item;
		this.left = this.right = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}
}
