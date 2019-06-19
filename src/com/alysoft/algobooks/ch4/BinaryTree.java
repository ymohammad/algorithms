package com.alysoft.algobooks.ch4;
/**
 * Random Node: You are implementing a binary tree class from scratch which, in addition to
insert, find, and delete, has a method getRandomNode() which returns a random node
from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
for getRandomNode, and explain how you would implement the rest of the methods.
 * @author ymohammad
 *
 */
public class BinaryTree
{
	private int[] binaryTreeArray = null;
	private int currentInsertIndex = 0;
	public BinaryTree(int capacity) {
		binaryTreeArray = new int[capacity];
	}
	public void insert(int data) {
		binaryTreeArray[currentInsertIndex] = data;
		currentInsertIndex++; 
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
