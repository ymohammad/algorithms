/*******************************************************************************************************************************
FindNumberOfUnConnectedComponents.java

This program to find the number of components in a graph. A component is a verteces connect in a bunch. But this component is not 
connect with other component in a graph.

Author : ymohammad
Date   : Jul 11, 2021

Last modified by : ymohammad
Last modified on : Jul 11, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Class FindNumberOfUnConnectedComponents
*/
public class FindNumberOfUnConnectedComponents {
    
    public static int graphBFSComponentsCount(List<List<Integer>> graph, int vertex, boolean[] visited) {
	
	int count = 0;
	if (visited[vertex]) return count;
	
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(vertex);
	visited[vertex] = true;
	count++;
	while (queue.size() > 0) {
	    Integer d = queue.poll();
	    System.out.print(d + ", ");
	    for (Integer x : graph.get(d)) {
		if (visited[x] == false) {
		    queue.add(x);
		    visited[x] = true;
		}
	    }
	}
	return count;
    }
    
    public static void addEdge(List<List<Integer>> graph, int source, int node) {
	List<Integer> list0 = null;
	if (source < graph.size()) {
	    list0 = graph.get(source);
	    if (!list0.contains(node)) {
		list0.add(node);
		graph.set(source, list0);
	    }
	} else {
	    list0 = new ArrayList<Integer>();
	    list0.add(node);
	    graph.add(source, list0);
	}
	
	
	if (node < graph.size()) {
	    list0 = graph.get(node);
	    if (!list0.contains(source) ) {
		list0.add(source);
		graph.set(node, list0);
	    }
	} else {
	    list0 = new ArrayList<Integer>();
	    list0.add(source);
	    graph.add(node, list0);
	}
    }
    public static void main(String[] args) {
	List<List<Integer>> graph = new ArrayList<List<Integer>>();
	
	addEdge(graph, 0, 1);
	addEdge(graph, 0, 2);
	addEdge(graph, 1, 0);
	addEdge(graph, 1, 2);
	addEdge(graph, 2, 1);
	addEdge(graph, 2, 0);
	
	addEdge(graph, 3, 4);
	
	addEdge(graph, 5, 6);
	addEdge(graph, 5, 7);
	addEdge(graph, 7, 5);
	addEdge(graph, 7, 8);
	
	boolean[] visited = new boolean[graph.size()];
	int compCount = 0;
	for (int i = 0; i<graph.size(); i++) {
	    compCount = compCount + graphBFSComponentsCount(graph, i, visited);
	}
	System.out.println("\nComponent Counts:" + compCount);
    }
}
