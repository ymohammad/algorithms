/*******************************************************************************************************************************
TopologicalSort.java

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
Date   : Jul 17, 2021

Last modified by : ymohammad
Last modified on : Jul 17, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alysoft.completedsa.graph.GraphUtils;


/**
* Class TopologicalSort
*/
public class TopologicalSort {
    
    public static void printTopologicaSort(List<List<Integer>> graph, int[] powerArr) {
	Queue<Integer> queue = new LinkedList<Integer>();
	//Add all zero power (degree) nodes to the Queue.
	for (int ind = 0; ind < powerArr.length; ind++) {
	    int x = powerArr[ind];
	    if (x == 0) {
		queue.add(ind);
	    }
	}
	System.out.println("Queue:" + queue);
	while(queue.size() > 0) {
	    Integer currNode = queue.poll();
	    System.out.print(currNode + " ");
	    
	    List<Integer> adjList = graph.get(currNode);
	    for (int u : adjList) {
		//Decrease its power.
		powerArr[u]--;
		if (powerArr[u] == 0) {
		    queue.add(u);
		}
	    }
	}
    }
    
    public static void main(String[] args) {
	System.out.println("Topological Sort.");
	List<List<Integer>> graph = GraphUtils.createGraph(3);
	
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 0, 2);
	
	int[] powerArr = GraphUtils.getPowerArray(graph);
	System.out.println("Power Array:" + Arrays.toString(powerArr));
	printTopologicaSort(graph, powerArr);
	
	
	System.out.println("\n");
	graph = GraphUtils.createGraph(5);
	
	GraphUtils.addDirectedEdge(graph, 0, 2);
	GraphUtils.addDirectedEdge(graph, 0, 3);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 1, 4);
	
	powerArr = GraphUtils.getPowerArray(graph);
	System.out.println("Power Array:" + Arrays.toString(powerArr));
	printTopologicaSort(graph, powerArr);
	
	System.out.println("\n");
	graph = GraphUtils.createGraph(6);
	
	GraphUtils.addDirectedEdge(graph, 0, 1);
	GraphUtils.addDirectedEdge(graph, 0, 2);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 3, 4);
	GraphUtils.addDirectedEdge(graph, 3, 5);
	
	powerArr = GraphUtils.getPowerArray(graph);
	System.out.println("Power Array:" + Arrays.toString(powerArr));
	printTopologicaSort(graph, powerArr);
	
	System.out.println("\n");
	graph = GraphUtils.createGraph(5);
	
	GraphUtils.addDirectedEdge(graph, 0, 2);
	GraphUtils.addDirectedEdge(graph, 0, 3);
	GraphUtils.addDirectedEdge(graph, 2, 3);
	GraphUtils.addDirectedEdge(graph, 1, 3);
	GraphUtils.addDirectedEdge(graph, 1, 4);
	
	powerArr = GraphUtils.getPowerArray(graph);
	System.out.println("Power Array:" + Arrays.toString(powerArr));
	printTopologicaSort(graph, powerArr);
    }
}
