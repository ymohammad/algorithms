package com.alysoft.algorithms.graphs;

import java.util.LinkedList;

public class Node<E> {
	private E data;
	private boolean visited = false;
	private int noOfIncomingEdges = 0;
	private LinkedList<Node<E>> adjacentList;
	
	public Node() {
		this.adjacentList = new LinkedList<Node<E>>();
	}
	public Node(E data) {
		this();
		this.data = data;
	}
	public Node(E data, LinkedList<Node<E>> adjacentList) {
		this.data = data;
		this.adjacentList = adjacentList;
	}

	public E getData()
	{
		return this.data;
	}

	public void setData(E data)
	{
		this.data = data;
	}
	
	public void addEdge(Node<E> edge) {
		if (edge != null) {
			this.adjacentList = this.adjacentList != null ? this.adjacentList : new LinkedList<Node<E>>();
			this.adjacentList.add(edge);
		}
	}

	public LinkedList<Node<E>> getAdjacentList()
	{
		return this.adjacentList;
	}

	public boolean isVisited()
	{
		return this.visited;
	}
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	public int getNoOfIncomingEdges()
	{
		return this.noOfIncomingEdges;
	}
	public void setNoOfIncomingEdges(int noOfIncomingEdges)
	{
		this.noOfIncomingEdges = noOfIncomingEdges;
	}
}
