/*******************************************************************************************************************************
GraphUtils.java

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

package com.alysoft.completedsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
* Class GraphUtils
*/
public class GraphUtils {
    
    public static List<List<Edge>> createWtGraph(int vertexCount) {
	List<List<Edge>> graph = new ArrayList<List<Edge>>(vertexCount);
	for (int i = 0; i< vertexCount; i++) {
	    graph.add(new ArrayList<Edge>());
	}
	return graph;
    }
    public static List<List<Integer>> createGraph(int nodesCount) {
	List<List<Integer>> graph = new ArrayList<List<Integer>>(nodesCount);
	for (int i = 0; i< nodesCount; i++) {
	    graph.add(new ArrayList<Integer>());
	}
	return graph;
    }
    
    public static ArrayList<Edge>[] createWtGraphArr(int nodesCount) {
	ArrayList<Edge>[] graph = new ArrayList[nodesCount];
	for (int i = 0; i< nodesCount; i++) {
	    graph[i] = new ArrayList<Edge>();
	}
	return graph;
    }
    public static void addDirectedWtEdge(List<List<Edge>> graph, int src, int dest, int wt) {
	addEdge(graph, src, dest, wt, false);
    }
    public static void addDirectedWtEdge(List<List<Edge>> graph, int src, int dest) {
	addUnDirectedWtEdge(graph, src, dest, 1);
    }
    public static void addUnDirectedWtEdge(List<List<Edge>> graph, int src, int dest, int wt) {
	addEdge(graph, src, dest, wt, true);
    }
    public static void addUnDirectedWtEdge(List<List<Edge>> graph, int src, int dest) {
	addUnDirectedWtEdge(graph, src, dest, 1);
    }
    
    public static void addEdge(List<List<Integer>> graph, int node1, int node2) {
	List<Integer> node1List = graph.get(node1);
	node1List.add(node2);
	List<Integer> node2List = graph.get(node2);
	node2List.add(node1);
    }
    
    public static void addDirectedEdge(List<List<Integer>> graph, int node1, int node2) {
	List<Integer> adjList = graph.get(node1);
	adjList.add(node2);
    }
    public static int[] getPowerArray(List<List<Integer>> graph) {
	int[] powerArr = new int[graph.size()];
	for (int x = 0; x < graph.size(); x++) {
	    List<Integer> adjList = graph.get(x);
	    for (int u : adjList) {
		powerArr[u] = powerArr[u] + 1;
	    }
	}
	return powerArr;
    }
    
    private static void addEdge(List<List<Edge>> graph, int src, int dest, int wt, boolean isUndirected) {
	List<Edge> srcAdjList = graph.get(src);
	srcAdjList.add(new Edge(dest, wt));
	if (isUndirected) {
	    List<Edge> desAdjList = graph.get(dest);
	    desAdjList.add(new Edge(src, wt));
	}
    }
    public static void addUDWtEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {
	graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }
    
}
