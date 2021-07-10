/*******************************************************************************************************************************
GraphClient.java



Author : ymohammad
Date   : Jul 9, 2021

Last modified by : ymohammad
Last modified on : Jul 9, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph;

/**
 * Class GraphClient
 */
public class GraphClient {
    public static void main(String[] args) {
	GraphSearch search = new GraphSearch();

	Graph localGraph = prepareTestingGraph();
	System.out.println("Not Exist :" + search.depthFirstSearch(localGraph, new Node("10")));
	resetGraph(localGraph);
	System.out.println("Node - 0 Exist :" + search.depthFirstSearch(localGraph, new Node("0")));
	resetGraph(localGraph);
	
	System.out.println("Node - 5 Exist :" + search.depthFirstSearch(localGraph, new Node("5")));
	resetGraph(localGraph);
	
	System.out.println("Node - 3 Exist :" + search.depthFirstSearch(localGraph, new Node("3")));
	resetGraph(localGraph);
	
	System.out.println("breadthFirstSearch Not Exist :" + search.breadthFirstSearch(localGraph, new Node("10")));
	resetGraph(localGraph);
	System.out.println("breadthFirstSearch Node - 0 Exist :" + search.breadthFirstSearch(localGraph, new Node("0")));
	resetGraph(localGraph);
	
	System.out.println("breadthFirstSearch Node - 5 Exist :" + search.breadthFirstSearch(localGraph, new Node("5")));
	resetGraph(localGraph);
	
	System.out.println("breadthFirstSearch Node - 3 Exist :" + search.breadthFirstSearch(localGraph, new Node("3")));
	resetGraph(localGraph);
    }
    public static void resetGraph(Graph graph) {
	for (Node node: graph.getGraphNodes()) {
	    node.setVisited(false);
	}
    }
    private static Graph prepareTestingGraph() {

	Graph graph = new Graph();

	Node node0 = new Node("0");
	Node node1 = new Node("1");
	Node node2 = new Node("2");
	Node node3 = new Node("3");
	Node node4 = new Node("4");
	Node node5 = new Node("5");

	node0.addVertex(node1);
	node0.addVertex(node4);
	node0.addVertex(node5);

	node1.addVertex(node4);
	node1.addVertex(node3);

	node2.addVertex(node1);

	node3.addVertex(node2);
	node3.addVertex(node4);

	graph.addNode(node0);
	graph.addNode(node1);
	graph.addNode(node2);
	graph.addNode(node3);
	graph.addNode(node4);
	graph.addNode(node5);

	return graph;
    }
}
