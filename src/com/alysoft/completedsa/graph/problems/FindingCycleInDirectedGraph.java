/*******************************************************************************************************************************
FindingCycleInDirectedGraph.java

Author : ymohammad
Date   : Jul 17, 2021

Last modified by : ymohammad
Last modified on : Jul 17, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.Arrays;
import java.util.List;

import com.alysoft.completedsa.graph.GraphUtils;

/**
* Detecting a cycle in a directed graph. It is not same as the undirected graph. Here we need
* to store the recursion stack and verify if the node exist in the stack. If yes then there is a cycle.
* We call it as a back edge.
*/
public class FindingCycleInDirectedGraph {
    
    public static boolean isCycleExist(List<List<Integer>> graph, Integer source, 
	    boolean[] visited, boolean[] recuStack) {
	visited[source] = true;
	recuStack[source] = true;
	//System.out.println("Visited :" + source + " >> VArray:" + Arrays.toString(visited) + " >>RecuStack:" + Arrays.toString(recuStack));
	for (Integer node : graph.get(source)) {
	    //System.out.println("Checking Node:" + node);
	    if (visited[node] == false) {
		if (isCycleExist(graph, node, visited, recuStack) == true) {
		    return true;
		}
	    } else if (recuStack[node]) {
		return true;
	    }
	}
	recuStack[source] = false;
	return false;
    }
    public static void checkCycleInGraph(List<List<Integer>> graph) {
	boolean[] visited = new boolean[graph.size()];
	boolean[] recuStack = new boolean[graph.size()];
	
	boolean cycleExist = false;
	for (int x = 0; x < graph.size(); x++) {
	    if (visited[x] == false) {
		cycleExist = isCycleExist(graph, x, visited, recuStack);
	    }
	}
	System.out.println("Cycle Exist :" + cycleExist);
    }
    
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(4);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 1);
	
	checkCycleInGraph(graph);
	
	System.out.println("\n\n");
	graph = GraphUtils.createGraph(4);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 2, 1);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	
	checkCycleInGraph(graph);
	
	System.out.println("\n\n");
	graph = GraphUtils.createGraph(6);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 4, 5);
	GraphUtils.addDirectedEdge(graph, 5, 3);
	GraphUtils.addDirectedEdge(graph, 5, 2);
	
	checkCycleInGraph(graph);
	
	System.out.println("\n\n");
	graph = GraphUtils.createGraph(6);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 2, 1);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 4, 5);
	GraphUtils.addDirectedEdge(graph, 5, 3);
	
	checkCycleInGraph(graph);
    }
}
