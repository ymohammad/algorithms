package com.alysoft.algorithms.graphs;

public class DepthFirstSearch
{
	public void search(Node<Integer> root) {
		if (root == null) return;
		visitNode(root);
		for (int i=0; i<root.getAdjacentList().size(); i++) {
			Node<Integer> node = root.getAdjacentList().get(i);
			if (!node.isVisited()) {
				search(node);
			}
		}
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
		
		Graph<Integer> graph = new Graph<Integer>();
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		graph.addNode(node5);
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.search(node0);
	}

}
