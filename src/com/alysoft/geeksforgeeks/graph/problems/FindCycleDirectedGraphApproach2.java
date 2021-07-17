/*******************************************************************************************************************************
FindCycleDirectedGraphApproach2.java



Author : ymohammad
Date   : Jul 17, 2021

Last modified by : ymohammad
Last modified on : Jul 17, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
* In this algorithm, we will use a khan's algorithm approach to find if there is any cycle in a directed graph.
*/
public class FindCycleDirectedGraphApproach2 {
    
    public static boolean isCycleExist(List<List<Integer>> graph, int[] degreeArray) {
	int counter = 0;
	Queue<Integer> queue = new LinkedList<Integer>();
	//Add all the degree zero elements to the queue.
	for (int node = 0; node<graph.size(); node++) {
	    int deg = degreeArray[node];
	    if (deg == 0) {
		queue.add(node);
	    }
	}
	while (queue.size() > 0) {
	    int node = queue.poll();
	    for (int x : graph.get(node)) {
		degreeArray[x]--;
		if (degreeArray[x] == 0) {
		    queue.add(x);
		}
	    }
	    counter++;
	}
	if (counter != graph.size()) {
	    return true;
	}
	return false;
    }
    
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(4);
	
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 2, 0);
	
	int[] degreeArray = GraphUtils.getPowerArray(graph);
	System.out.println("Cycle Exist:" + isCycleExist(graph, degreeArray));
	System.out.println("\n");
	
	graph = GraphUtils.createGraph(4);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 0, 2);
	
	degreeArray = GraphUtils.getPowerArray(graph);
	System.out.println("Cycle Exist:" + isCycleExist(graph, degreeArray));
	System.out.println("\n");
	
	graph = GraphUtils.createGraph(5);
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 1, 2);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 1);
	GraphUtils.addDirectedEdge(graph, 4, 1);
	degreeArray = GraphUtils.getPowerArray(graph);
	System.out.println("Cycle Exist:" + isCycleExist(graph, degreeArray));
	System.out.println("\n");
    }
}
