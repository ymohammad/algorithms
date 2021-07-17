/*******************************************************************************************************************************
ShortestPathBetweenNodes.java

Find the shortest path between nodes. Adjacency list and the current vertex will be given. Need to find
the shortest distance from the current vertex to all other vertex.

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

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
* Class ShortestPathBetweenNodes
*/
public class ShortestPathBetweenNodes {
    
    /**
     * BFS is the algorithm which travers level by level. Shortest path (less number of edges) can be found
     * when do traverse using BFS. 
     */
    
    public static int[] getShortestDistanceFromNode(List<List<Integer>> graph, int node, boolean[] visited) {
	int[] distance = new int[graph.size()];
	for (int x: distance) {
	    distance[x] = Integer.MAX_VALUE;
	}
	
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(node);
	distance[node] = 0;
	visited[node] = true;
	
	while (queue.size() > 0) {
	    Integer currNode = queue.poll();
	    for (Integer adj: graph.get(currNode)) {
		if (visited[adj] == false) {
		    queue.add(adj);
		    distance[adj] = distance[currNode] + 1;
		    visited[adj] = true;
		}
	    }
	}
	return distance;
    }
    
    
    public static void main(String[] args) {
	List<List<Integer>> graph = new ArrayList<List<Integer>>();
	
	GraphUtils.addEdge(graph, 0, 1);
	GraphUtils.addEdge(graph, 0, 2);
	GraphUtils.addEdge(graph, 1, 3);
	GraphUtils.addEdge(graph, 1, 2);
	GraphUtils.addEdge(graph, 2, 3);
	
	boolean[] visited = new boolean[graph.size()];
	int[] shortestDistanceFromNode = getShortestDistanceFromNode(graph, 0, visited);
	for (int x: shortestDistanceFromNode) {
	    System.out.print(x + " ");
	}
	
	
	graph = new ArrayList<List<Integer>>(6);
	
	GraphUtils.addEdge(graph, 0, 1);
	GraphUtils.addEdge(graph, 0, 2);
	GraphUtils.addEdge(graph, 1, 3);
	GraphUtils.addEdge(graph, 2, 3);
	GraphUtils.addEdge(graph, 2, 4);
	GraphUtils.addEdge(graph, 3, 5);
	GraphUtils.addEdge(graph, 4, 5);
	GraphUtils.addEdge(graph, 0, 4);
	
	System.out.println("\nShortestPathBetweenNodes.main() Graph Nodes Count :" + graph.size());
	visited = new boolean[graph.size()];
	shortestDistanceFromNode = getShortestDistanceFromNode(graph, 0, visited);
	for (int x: shortestDistanceFromNode) {
	    System.out.print(x + " ");
	}
    }
}
