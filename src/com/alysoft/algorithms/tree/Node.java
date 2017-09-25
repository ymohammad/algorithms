package com.alysoft.algorithms.tree;

public class Node {
    char data;
    Node left;
    Node right;
    
    public Node() {
    	
    }
    public Node(char value) {
    	this.data = value;
    }
	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right
				+ "]";
	}
}
