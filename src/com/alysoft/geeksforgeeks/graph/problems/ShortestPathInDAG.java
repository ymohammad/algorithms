/*******************************************************************************************************************************
ShortestPathInDAG.java


Author : ymohammad
Date   : Jul 17, 2021

Last modified by : ymohammad
Last modified on : Jul 17, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
* Class ShortestPathInDAG
* 
* It can be solved using topological sorting. As we have directed acyclic graph.
*/
public class ShortestPathInDAG {

    public static void performTopologicalSort(List<List<Integer>> graph, int source, boolean[] visited, Stack<Integer> stack) {
	visited[source] = true;
	for (int x : graph.get(source)) {
	    if (visited[x] == false) {
		performTopologicalSort(graph, x, visited, stack);
	    }
	}
	stack.push(source);
    }
    public static long[] getShortestPath(List<List<Integer>> graph, int[][] weights, int sourceVertex) {
	long[] distance = new long[graph.size()];
	Arrays.fill(distance, Integer.MAX_VALUE);
	distance[sourceVertex] = 0;
	
	Stack<Integer> stack = new Stack<Integer>();
	boolean[] visited = new boolean[graph.size()];
	
	for (int node = 0; node < graph.size(); node++) {
	    if (visited[node] == false) {
		performTopologicalSort(graph, node, visited, stack);
	    }
	}
	while (stack.size() > 0) {
	    int u = stack.pop();
	    for(int v : graph.get(u)) {
		if (distance[v] > distance[u] + weights[u][v]) {
		    distance[v] = distance[u] + weights[u][v];
		}
	    }
	}
	return distance;
    }
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(6);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 0, 4);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 4, 2);
	GraphUtils.addDirectedEdge(graph, 4, 5);
	GraphUtils.addDirectedEdge(graph, 5, 3);
	
	int[][] weights = new int[6][6];
	weights[0][1] = 2;
	weights[1][2] = 3;
	weights[2][3] = 6;
	weights[0][4] = 1;
	weights[4][2] = 2;
	weights[4][5] = 4;
	weights[5][3] = 1;
	
	System.out.println(Arrays.toString(getShortestPath(graph, weights, 0)));
	System.out.println();
	
	System.out.println(Arrays.toString(getShortestPath(graph, weights, 1)));
	System.out.println();
	
	System.out.println(Arrays.toString(getShortestPath(graph, weights, 4)));
	System.out.println();
    }
}
