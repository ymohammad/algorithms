package com.alysoft.algorithms.graphs;

import java.util.LinkedList;

public class Graph<E>
{
	private LinkedList<Node<E>> graphNodes;
	
	public Graph() {
		this.graphNodes = new LinkedList<Node<E>>();
	}

	public LinkedList<Node<E>> getGraphNodes()
	{
		return this.graphNodes;
	}

	public void addNode(Node<E> node) {
		this.graphNodes.add(node);
	}
}
