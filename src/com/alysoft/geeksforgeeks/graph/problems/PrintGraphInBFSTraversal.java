/*******************************************************************************************************************************
PrintGraphInBFSTraversal.java



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
* Class PrintGraphInBFSTraversal
*/
public class PrintGraphInBFSTraversal {
    
    public static void graphBFS(List<List<Integer>> graph, int source) {
	boolean[] visited = new boolean[graph.size()];
	
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(source);
	
	while (queue.size() > 0) {
	    Integer node = queue.poll();
	    if (visited[node] == false) {
		System.out.print(node + " ");
		visited[node] = true;
		List<Integer> list = graph.get(node);
		for (Integer x : list) {
		    queue.add(x);
		}
	    }
	}
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
	addEdge(graph, 1, 3);
	addEdge(graph, 1, 2);
	addEdge(graph, 2, 0);
	addEdge(graph, 2, 1);
	addEdge(graph, 2, 3);
	addEdge(graph, 2, 4);
	addEdge(graph, 3, 1);
	addEdge(graph, 3, 2);
	addEdge(graph, 3, 4);
	addEdge(graph, 4, 3);
	addEdge(graph, 4, 2);
	printGraph(graph);
	graphBFS(graph, 0);
    }
    private static void printGraph(List<List<Integer>> graph) {
	for(int i = 0; i< graph.size(); i++) {
	    System.out.println("For Node :" + i);
	    List<Integer> list = graph.get(i);
	    for (int x : list) {
		System.out.print("" + x + ",");
	    }
	    System.out.println("");
	}
    }
}
