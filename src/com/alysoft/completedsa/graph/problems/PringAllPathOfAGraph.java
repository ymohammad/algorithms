/*******************************************************************************************************************************
PringAllPathOfAGraph.java

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
Date   : Jul 18, 2021

Last modified by : ymohammad
Last modified on : Jul 18, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.alysoft.completedsa.graph.Edge;
import com.alysoft.completedsa.graph.GraphUtils;

/**
* Class PringAllPathOfAGraph
*/
public class PringAllPathOfAGraph {
    
    public static void printAllPaths(List<List<Edge>> graph, int src, int dest, 
	    boolean[] visited, String path) {
	if (src == dest) {
	    System.out.println(path + "" + src);
	    return;
	}
	visited[src] = true;
	List<Edge> adjList = graph.get(src);
	for (Edge edge : adjList) {
	    if (visited[edge.getnNode()] == false) {
		printAllPaths(graph, edge.getnNode(), dest, visited, path + "" + src);
	    }
	}
	visited[src] = false;
    }
    
    public static void invokeMain(List<List<Edge>> graph, int src, int dest) {
	boolean[] visited = new boolean[graph.size()];
	printAllPaths(graph, src, dest, visited, "");
    }
    
    public static void main(String[] args) {
	List<List<Edge>> graph = GraphUtils.createWtGraph(6);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 3, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 4, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 5, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 4, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 5, 1);
	
	for (int i = 0; i<graph.size(); i++) {
	    List<Edge> adjList = graph.get(i);
	    Collections.sort(adjList);
	}
	
	invokeMain(graph, 0, 5);
	System.out.println();
	
	invokeMain(graph, 1, 5);
	System.out.println();
	
	
	graph = GraphUtils.createWtGraph(7);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 5);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 4);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 5);
	GraphUtils.addUnDirectedWtEdge(graph, 4, 6);
	GraphUtils.addUnDirectedWtEdge(graph, 5, 6);
	
	invokeMain(graph, 0, 6);
	System.out.println();
    }
}
