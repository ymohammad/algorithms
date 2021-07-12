/*******************************************************************************************************************************
DisconnectedGraphTraversal.java

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
* Class DisconnectedGraphTraversal
*/
public class DisconnectedGraphTraversal {

    public static void graphBFS(List<List<Integer>> graph, int vertex, boolean[] visited) {
	if (visited[vertex]) return;
	
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(vertex);
	//Vertex is discovered and added to the queue.
	visited[vertex] = true;

	while (queue.size() > 0) {
	    Integer node = queue.poll();
	    System.out.print(node + " ");
	    List<Integer> list = graph.get(node);
	    for (Integer x : list) {
		if (visited[node] == false) {
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
	addEdge(graph, 2, 3);
	
	addEdge(graph, 4, 5);
	addEdge(graph, 4, 6);
	addEdge(graph, 5, 4);
	addEdge(graph, 5, 6);
	addEdge(graph, 6, 4);
	addEdge(graph, 6, 5);
	
	printGraph(graph);
	boolean[] visited = new boolean[graph.size()];
	for (int i = 0; i<graph.size(); i++) {
	    graphBFS(graph, i, visited);
	}
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
