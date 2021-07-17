/*******************************************************************************************************************************
TopologicalSortDFS.java

Author : ymohammad
Date   : Jul 17, 2021

Last modified by : ymohammad
Last modified on : Jul 17, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.List;
import java.util.Stack;

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
* Class TopologicalSortDFS
*/
public class TopologicalSortDFS {
    
    public static void printTopologicalSort(List<List<Integer>> graph, 
	    boolean[] visited, int vertex, Stack<Integer> stack) {
	visited[vertex] = true;
	for (int x : graph.get(vertex)) {
	    if (visited[x] == false) {
		printTopologicalSort(graph, visited, x, stack);
	    }
	}
	stack.push(vertex);
    }
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(5);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 2, 4);
	Stack<Integer> stack = new Stack<Integer>();
	boolean[] visited = new boolean[graph.size()];
	for(int i = 0; i< graph.size(); i++) {
	    if (visited[i] == false) {
		printTopologicalSort(graph, visited, i, stack);
	    }
	}
	while (stack.size() > 0) {
	    int x = stack.pop();
	    System.out.print(x + " ");
	}
    }
}
