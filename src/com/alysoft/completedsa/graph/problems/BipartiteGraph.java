/*******************************************************************************************************************************
BipartiteGraph.java

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
Date   : Jul 23, 2021

Last modified by : ymohammad
Last modified on : Jul 23, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alysoft.completedsa.graph.Edge;
import com.alysoft.completedsa.graph.GraphUtils;
import com.alysoft.completedsa.graph.Pair;

/**
* Class BipartiteGraph
*/
public class BipartiteGraph {
    public static boolean isBipartiteGraph(List<List<Edge>> graph, int vertex, 
	    int[] visited, int level) {
	
	Queue<Pair> queue = new LinkedList<Pair>();
	queue.add(new Pair(vertex, vertex+"", level));
	
	while (queue.size() > 0) {
	    Pair p = queue.poll();
	    if (visited[p.node] != -1) {
		//earlier visited, verify if visited same level.
		if (visited[p.node] != p.level) {
		    return false;
		}
	    } else {
		visited[p.node] = p.level;
	    }
	    for (Edge e: graph.get(p.node)) {
		if (visited[e.getnNode()] == -1) {
		    queue.add(new Pair(e.getnNode(), p.psf + e.getnNode(), p.level + 1));
		}
	    }
	}
	return true;
    }
    private static void checkGraph(List<List<Edge>> graph) {
	int[]  visited = new int[graph.size()];
	Arrays.fill(visited, -1);
	
	for (int i = 0; i<graph.size(); i++) {
	    if (visited[i] == -1) {
		boolean isB = isBipartiteGraph(graph, i, visited, 0);
		if (!isB) {
		    System.out.println(false);
		    return;
		}
	    }
	}
	System.out.println(true);
    }
    public static void main(String[] args) {
	List<List<Edge>> graph = GraphUtils.createWtGraph(4);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 1);
	
	checkGraph(graph);
    }
    
}
