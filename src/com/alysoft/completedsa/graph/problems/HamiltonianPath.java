/*******************************************************************************************************************************
HamiltonianPath.java

Author : ymohammad
Date   : Jul 19, 2021

Last modified by : ymohammad
Last modified on : Jul 19, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.HashSet;
import java.util.List;

import com.alysoft.completedsa.graph.Edge;
import com.alysoft.completedsa.graph.GraphUtils;

/**
* Class HamiltonianPath
* 
*/
public class HamiltonianPath {

    public static void printPath(List<List<Edge>> graph, int src, 
	    HashSet<Integer> visited, int oSrc, String psf) {
	
	if (visited.size() == graph.size()-1) {
	    System.out.print(psf);
	    
	    boolean isCyclePath = false;
	    for (Edge e : graph.get(src)) {
		if (e.getnNode() == oSrc) {
		    isCyclePath = true;
		    break;
		}
	    }
	    if(isCyclePath) {
		System.out.println("*");
	    } else {
		System.out.println(".");
	    }
	    return;
	}
	visited.add(src);
	for (Edge e : graph.get(src)) {
	    int nNode = e.getnNode();
	    if (!visited.contains(nNode)) {
		printPath(graph, nNode, visited, oSrc, psf + "" + nNode);
	    }
	}
	visited.remove(src);
    }
    public static void main(String[] args) {
	List<List<Edge>> graph = GraphUtils.createWtGraph(4);
	GraphUtils.addUnDirectedWtEdge(graph, 0, 1);
	GraphUtils.addUnDirectedWtEdge(graph, 1, 2);
	GraphUtils.addUnDirectedWtEdge(graph, 2, 3);
	GraphUtils.addUnDirectedWtEdge(graph, 3, 1);
	
	HashSet<Integer> visited = new HashSet<Integer>();
	printPath(graph, 0, visited, 0, "0");
	
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
	
	visited = new HashSet<Integer>();
	printPath(graph, 0, visited, 0, "0");
    }
}
