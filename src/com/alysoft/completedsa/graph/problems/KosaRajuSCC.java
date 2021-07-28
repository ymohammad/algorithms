/*******************************************************************************************************************************
KosaRajuSCC.java

Author : ymohammad
Date   : Jul 24, 2021

Last modified by : ymohammad
Last modified on : Jul 24, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.alysoft.completedsa.graph.GraphUtils;

/**
* Class KosaRajuSCC
* 
* This algorithm is to find the strongly connected component.
*/
public class KosaRajuSCC {
    
    public static void topoLogicalDFS(List<List<Integer>> graph, int vertex, 
	    boolean[] visited, Stack<Integer> stack) {
	visited[vertex] = true;
	for (Integer e: graph.get(vertex)) {
	    if (visited[e] == false) {
		topoLogicalDFS(graph, e, visited, stack);
	    }
	}
	stack.add(vertex);
    }
    
    public static List<List<Integer>> transposeGraph(List<List<Integer>> graph) {
	List<List<Integer>> tGraph = GraphUtils.createGraph(graph.size());
	for (int i = 0; i<graph.size(); i++) {
	    for (Integer e: graph.get(i)) {
		GraphUtils.addDirectedEdge(tGraph, e, i);
	    }
	}
	return tGraph;
    }
    public static void doDFS(List<List<Integer>> graph, int vertex, boolean[] visited) {
	visited[vertex] = true;
	System.out.print(vertex + " ");
	for (Integer e: graph.get(vertex)) {
	    if (visited[e] == false) {
		doDFS(graph, e, visited);
	    }
	}
	
    }
    
    public static void findStronglyConnectedComponents(List<List<Integer>> graph) {
	boolean[] visited = new boolean[graph.size()];
	Stack<Integer> sortedOrder = new Stack<Integer>();
	
	//Step 1 - Topological sort.
	for (int node = 0; node < graph.size(); node++) {
	    if (visited[node] == false) {
		topoLogicalDFS(graph, node, visited, sortedOrder);
	    }
	}
	//Step 2 - Reverse the edges.
	List<List<Integer>> transposeGraph = transposeGraph(graph);
	
	//Step 3 - Do normal DFS
	int noOfComponents = 0;
	Arrays.fill(visited, false);
	while (sortedOrder.size() > 0) {
	    int node = sortedOrder.pop();
	    if (visited[node] == false) {
		doDFS(transposeGraph, node, visited);
		System.out.println();
		noOfComponents++;
	    }
	}
	System.out.println("Number of Strongly Connect Components:" + noOfComponents + "\n\n");
    }
    
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(5);
	GraphUtils.addDirectedEdge(graph, 0, 2);
	GraphUtils.addDirectedEdge(graph, 2, 1);
	GraphUtils.addDirectedEdge(graph, 1, 0);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 4, 3);
	
	findStronglyConnectedComponents(graph);
	
	graph = GraphUtils.createGraph(6);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 1);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 4, 5);
	GraphUtils.addDirectedEdge(graph, 5, 4);
	
	findStronglyConnectedComponents(graph);
	
	graph = GraphUtils.createGraph(5);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 0);
	GraphUtils.addDirectedEdge(graph, 3, 1);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	
	findStronglyConnectedComponents(graph);
	
	graph = GraphUtils.createGraph(4);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 3, 0);
	
	findStronglyConnectedComponents(graph);
    }
}
