package com.alysoft.algobooks.ch4;

import java.util.LinkedList;
import java.util.Queue;

import com.alysoft.algorithms.graphs.BreadthFirstSearch;
import com.alysoft.algorithms.graphs.Graph;
import com.alysoft.algorithms.graphs.Node;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
 * @author ymohammad
 *
 */
public class RouteBetweenNodes
{
	public boolean isRouteExist(Node<Integer> source, Node<Integer> dest) {
		if (source == null || dest == null) return false;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(source);
		
		while (!queue.isEmpty()) {
			Node<Integer> eachNode = queue.poll();
			
			if (eachNode.getData() == dest.getData()) {
				visitNode(eachNode);
				return true;
			}
			if (!eachNode.isVisited()) {
				eachNode.setVisited(true);
				for(Node<Integer> adjNode: eachNode.getAdjacentList()) {
					queue.add(adjNode);
				}
			}
			
		}
		return false;
	}
	
	public void visitNode(Node<Integer> node) {
		System.out.print(node.getData() + " ");
		node.setVisited(true);
	}
	public static void main(String[] args)
	{
		Node<Integer> node0 = new Node<Integer>(0);
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		node0.addEdge(node1);
		node0.addEdge(node4);
		node0.addEdge(node5);
		
		node1.addEdge(node4);
		node1.addEdge(node3);
		
		node2.addEdge(node1);
		
		node3.addEdge(node4);
		node3.addEdge(node2);
		
		RouteBetweenNodes route = new RouteBetweenNodes();
		System.out.println("Route between 0, 3 :" + route.isRouteExist(node1, node5));
		//System.out.println("Route between 0, 3 :" + route.isRouteExist(node0, node3));
	}

}
