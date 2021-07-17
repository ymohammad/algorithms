/*******************************************************************************************************************************
FindingCycleInUnDirectGraph.java

Copyright © 2021, Power Integrations Corporation. All rights reserved.
The Programs (which include both the software and documentation) contain proprietary information of Power Integrations Corporation;
they are provided under a license agreement containing restrictions on use and disclosure and are also protected by
copyright, patent and other intellectual and industrial property law. Reverse engineering, disassembly or de-compilation of
the programs is prohibited.
Program Documentation is licensed for use solely to support the deployment of the Programs and not for any other
purpose.
The information contained in this document is subject to change without notice. If you find any problems in the
documentation, please report them to us in writing. Power Integrations Corporation does not warrant that this document is error free.
Except as may be expressly permitted in your license agreement for these Programs, no part of these Programs may be
reproduced or transmitted in any form or by any means, electronic or mechanical, for any purpose, without the express
written permission of Power Integrations Corporation.

Author : ymohammad
Date   : Jul 12, 2021

Last modified by : ymohammad
Last modified on : Jul 12, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alysoft.geeksforgeeks.graph.GraphUtils;

/**
 * Class FindingCycleInUnDirectGraph
 */
public class FindingCycleInUnDirectGraph {

    public static boolean isCycleExistInGraphBFS(List<List<Integer>> adjList, Integer vertex, boolean[] visitedNodes,
	    Integer[] parent) {
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(vertex);
	visitedNodes[vertex] = true;
	parent[vertex] = vertex;
	
	while (queue.size() > 0) {
	    Integer curr = queue.poll();
	    for (Integer n : adjList.get(curr)) {
		
		if (visitedNodes[n] == false) {
		    queue.add(n);
		    visitedNodes[n] = true;
		    parent[n] = curr;
		} else if (n.intValue() != parent[curr].intValue()) {
		    return true;
		}
	    }
	}
	return false;
    }
    /**
     * Finding using the DFS algorithm.
     * 
     * @param adjList
     * @param visitedNodes
     * @param parent
     * @return
     */
    public static boolean isCycleExistInGraphDFS(List<List<Integer>> adjList, Integer vertex, boolean[] visitedNodes,
	    Integer parent) {

	visitedNodes[vertex] = true;
	for (Integer v : adjList.get(vertex)) {

	    if (visitedNodes[v] == false) {
		if (isCycleExistInGraphDFS(adjList, v, visitedNodes, vertex)) {
		    return true;
		}
	    } else if (v.intValue() != parent.intValue()) {
		return true;
	    }
	}
	return false;
    }
    public static void checkCycle(List<List<Integer>> graph) {
	boolean isCycle = false;
	boolean[] visited = new boolean[graph.size()];
	for (int x = 0; x < graph.size(); x++) {
	    if (visited[x] == true) continue;
	    isCycle = isCycleExistInGraphDFS(graph, x, visited, -1);
	    if (isCycle) {
		System.out.println("Cycle Exist in the graph: " + isCycle);
		break;
	    }
	}
	if (!isCycle) {
	    System.out.println("NO CYCLE IN THE GRAPH.");
	}
    }
    public static void checkCycleBFS(List<List<Integer>> graph) {
	boolean isCycle = false;
	boolean[] visited = new boolean[graph.size()];
	Integer[] parent = new Integer[graph.size()];
	for (int x = 0; x < graph.size(); x++) {
	    if (visited[x] == true) continue;
	    isCycle = isCycleExistInGraphBFS(graph, x, visited, parent);
	    if (isCycle) {
		System.out.println("Cycle Exist in the graph: " + isCycle);
		break;
	    }
	}
	if (!isCycle) {
	    System.out.println("NO CYCLE IN THE GRAPH.");
	}
    }
    public static void main(String[] args) {
	List<List<Integer>> graph = GraphUtils.createGraph(4);

	GraphUtils.addEdge(graph, 0, 1);
	GraphUtils.addEdge(graph, 0, 2);
	GraphUtils.addEdge(graph, 1, 3);
	GraphUtils.addEdge(graph, 1, 2);
	GraphUtils.addEdge(graph, 2, 3);
	checkCycle(graph);
	System.out.println("Calling using BFS");
	checkCycleBFS(graph);
	
	graph = GraphUtils.createGraph(7);
	GraphUtils.addEdge(graph, 0, 1);
	GraphUtils.addEdge(graph, 1, 2);
	//GraphUtils.addEdge(graph, 1, 3);
	//GraphUtils.addEdge(graph, 2, 3);
	GraphUtils.addEdge(graph, 3, 6);
	GraphUtils.addEdge(graph, 2, 4);
	GraphUtils.addEdge(graph, 4, 5);
	System.out.println(graph);
	checkCycle(graph);
	
	System.out.println("Calling using BFS");
	checkCycleBFS(graph);
    }
}
