/*******************************************************************************************************************************
RouteBetweenTwoNodes.java

Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes. 

Author : ymohammad
Date   : Jul 10, 2021

Last modified by : ymohammad
Last modified on : Jul 10, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.alysoft.completedsa.graph.Node;

/**
* Class RouteBetweenTwoNodes
*/
public class RouteBetweenTwoNodes {
    
    public boolean isARouteBetweenTwoNodes(Node firstNode, Node secondNode) {
	if (firstNode == null || secondNode == null) return false;
	
	Queue<Node> firstQueue = new LinkedList<Node>();
	firstQueue.add(firstNode);
	
	Queue<Node> secondQueue = new LinkedList<Node>();
	secondQueue.add(secondNode);
	
	while (firstQueue.size() > 0 && secondQueue.size() > 0) {
	    Node leftNode = firstQueue.poll();
	    Node rightNode = secondQueue.poll();
	    
	    if (leftNode.getName().equals(rightNode.getName())) {
		return true;
	    }
	    leftNode.setVisited(true);
	    rightNode.setVisited(true);
	    
	    for (Node leftNodeChild : leftNode.getChildrens()) {
		if (!leftNodeChild.isVisited()) {
		    firstQueue.add(leftNodeChild);
		}
	    }
	    
	    for (Node rightNodeChild : rightNode.getChildrens()) {
		if (!rightNodeChild.isVisited()) {
		    secondQueue.add(rightNodeChild);
		}
	    }
	}
	return false;
    }
}
