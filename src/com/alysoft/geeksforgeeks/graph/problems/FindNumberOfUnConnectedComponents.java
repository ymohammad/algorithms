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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
* Class FindNumberOfUnConnectedComponents
*/
public class FindNumberOfUnConnectedComponents {
    
    public static void graphBFSComponentsCount(List<List<Integer>> graph, int vertex, boolean[] visited) {
	
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(vertex);
	visited[vertex] = true;
	
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
    }
   
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(9);
	
	GraphUtils.addEdge(graph, 0, 1);
	GraphUtils.addEdge(graph, 0, 2);
	GraphUtils.addEdge(graph, 1, 0);
	GraphUtils.addEdge(graph, 1, 2);
	GraphUtils.addEdge(graph, 2, 1);
	GraphUtils.addEdge(graph, 2, 0);
	
	GraphUtils.addEdge(graph, 3, 4);
	
	GraphUtils.addEdge(graph, 5, 6);
	GraphUtils.addEdge(graph, 5, 7);
	GraphUtils.addEdge(graph, 7, 5);
	GraphUtils.addEdge(graph, 7, 8);
	
	boolean[] visited = new boolean[graph.size()];
	int compCount = 0;
	for (int i = 0; i<graph.size(); i++) {
	    if (visited[i] == false) {
		compCount++;
		graphBFSComponentsCount(graph, i, visited);
	    }
	}
	System.out.println("\nComponent Counts:" + compCount);
    }
}
