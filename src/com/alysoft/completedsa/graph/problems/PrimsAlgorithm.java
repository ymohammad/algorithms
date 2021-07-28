/*******************************************************************************************************************************
PrimsAlgorithm.java


Author : ymohammad
Date   : Jul 24, 2021

Last modified by : ymohammad
Last modified on : Jul 24, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.List;
import java.util.PriorityQueue;

import com.alysoft.completedsa.graph.Edge;
import com.alysoft.completedsa.graph.GraphUtils;

/**
* Class PrimsAlgorithm
*/
public class PrimsAlgorithm {
    
    public static void printMST(List<List<Edge>> graph, int srcVertex, boolean[] visited) {
	PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>();
	pQueue.add(new Pair(srcVertex, 0, -1));
	
	while (pQueue.size() > 0) {
	    Pair rem = pQueue.poll();
	    if (visited[rem.vertex] == true) continue;
	    
	    visited[rem.vertex] = true;
	    if (rem.acquiringVertex != -1)
		System.out.println(rem.vertex + " via " + rem.acquiringVertex + " @ " + rem.weight);
	    
	    for (Edge e: graph.get(rem.vertex)) {
		if (visited[e.getnNode()] == false) {
		    pQueue.add(new Pair(e.getnNode(), e.getWeight(), rem.vertex));
		}
	    }
	}
    }
    public static void checkMST(List<List<Edge>> graph, int srcVertex) {
	boolean[] visited = new boolean[graph.size()];
	printMST(graph, srcVertex, visited);
    }
    public static void main(String[] args) {
	List<List<Edge>> graph = GraphUtils.createWtGraph(9);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1, 4);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2, 8);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 3, 7);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 7, 9);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 4, 8);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 5, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 8, 7);
	GraphUtils.addUnDirectedWtEdge(graph, 8, 2, 2);
	GraphUtils.addUnDirectedWtEdge(graph, 8, 5, 6);
	GraphUtils.addUnDirectedWtEdge(graph, 5, 6, 2);
	GraphUtils.addUnDirectedWtEdge(graph, 6, 2, 4);
	GraphUtils.addUnDirectedWtEdge(graph, 6, 3, 14);
	GraphUtils.addUnDirectedWtEdge(graph, 6, 7, 10);
	
	checkMST(graph, 0);
	
	System.out.println("\n*****************");
	graph = GraphUtils.createWtGraph(7);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1, 10);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2, 10);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 3, 10);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 3, 5);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 4, 12);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 5, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 5, 6, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 6, 8);
	
	checkMST(graph, 0);
    }
    static class Pair implements Comparable<Pair> {
	int vertex;
	int weight;
	int acquiringVertex;
	
	public Pair(int v, int w, int acquiringVertex) {
	    this.vertex = v;
	    this.weight = w;
	    this.acquiringVertex = acquiringVertex;
	}
	@Override
	public int compareTo(Pair o) {
	    return this.weight - o.weight;
	}
	@Override
	public String toString() {
	    return "Pair [vertex=" + this.vertex + ", weight=" + this.weight + ", acquiringVertex=" + this.acquiringVertex + "]";
	}
    }
}
