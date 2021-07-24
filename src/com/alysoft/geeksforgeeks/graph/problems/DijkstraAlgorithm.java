/*******************************************************************************************************************************
DijkstraAlgorithm.java

Author : ymohammad
Date   : Jul 24, 2021

Last modified by : ymohammad
Last modified on : Jul 24, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.List;
import java.util.PriorityQueue;

import com.alysoft.geeksforgeeks.graph.Edge;
import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
 * Class DijkstraAlgorithm Finding the Shortest Path.
 */
public class DijkstraAlgorithm {

    public static void findPath(List<List<Edge>> graph, int source, int dest, boolean[] visited) {
	PriorityQueue<Pair> pQueue = new PriorityQueue<>();
	pQueue.add(new Pair(source, source+"", 0));
	
	while (pQueue.size() > 0) {
	    Pair pair = pQueue.poll();
	    if (visited[pair.node]) {
		continue;
	    }
	    if (pair.node == dest) {
		System.out.println("Shortest Path " + source + "-->" + dest + " " + pair);
		break;
	    }
	    visited[pair.node] = true;
	    for (Edge e : graph.get(pair.node)) {
		if (visited[e.getnNode()] == false) {
		    pQueue.add(new Pair(e.getnNode(), pair.psf + e.getnNode(), pair.wsf + e.getWeight()));
		}
	    }
	}
    }
    private static void checkSPath(List<List<Edge>> graph, int source, int dest) {
	boolean[] visited = new boolean[graph.size()];
	findPath(graph, source, dest, visited);
    }
    
    public static void main(String[] args) {
	List<List<Edge>> graph = GraphUtils.createWtGraph(9);
	GraphUtils.addDirectedWtEdge(graph, 0, 1, 4);
	GraphUtils.addDirectedWtEdge(graph, 1, 2, 8);
	GraphUtils.addDirectedWtEdge(graph, 2, 3, 7);
	GraphUtils.addDirectedWtEdge(graph, 3, 7, 9);
	GraphUtils.addDirectedWtEdge(graph, 0, 4, 8);
	GraphUtils.addDirectedWtEdge(graph, 4, 5, 1);
	GraphUtils.addDirectedWtEdge(graph, 4, 8, 7);
	GraphUtils.addDirectedWtEdge(graph, 8, 2, 2);
	GraphUtils.addDirectedWtEdge(graph, 8, 5, 6);
	GraphUtils.addDirectedWtEdge(graph, 5, 6, 2);
	GraphUtils.addDirectedWtEdge(graph, 6, 2, 4);
	GraphUtils.addDirectedWtEdge(graph, 6, 3, 14);
	GraphUtils.addDirectedWtEdge(graph, 6, 7, 10);
	
	checkSPath(graph, 0, 7);
	checkSPath(graph, 0, 2);
	checkSPath(graph, 0, 3);
	checkSPath(graph, 0, 8);
	checkSPath(graph, 0, 5);
    }
    
    static class Pair implements Comparable<Pair> {
	int node;
	String psf;
	int wsf;

	public Pair(int node, String psf, int wsf) {
	    this.node = node;
	    this.psf = psf;
	    this.wsf = wsf;
	}

	@Override
	public int compareTo(Pair o) {
	    return this.wsf-o.wsf;
	}

	@Override
	public String toString() {
	    return "Pair [node=" + this.node + ", psf=" + this.psf + ", wsf=" + this.wsf + "]";
	}
    }
}
