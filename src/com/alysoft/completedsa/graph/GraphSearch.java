/*******************************************************************************************************************************
GraphSearch.java

Author : ymohammad
Date   : Jul 9, 2021

Last modified by : ymohammad
Last modified on : Jul 9, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Class GraphSearch
*/
public class GraphSearch {
    
    public Node depthFirstSearch(Graph graph, Node nodeToSearch) {
	if (graph == null || nodeToSearch == null) return null;
	
	List<Node> graphNodes = graph.getGraphNodes();
	for (Node eachNode: graphNodes) {
	    Node nodeFound = doDFSearch(eachNode, nodeToSearch);
	    if (nodeFound != null) return nodeFound;
	}
	return null;
    }

    private Node doDFSearch(Node currNode, Node nodeToSearch) {
	if (currNode.isVisited()) return null;
	
	currNode.setVisited(true);
	if (currNode.getName().equals(nodeToSearch.getName())) {
	    return currNode;
	}
	List<Node> childrens = currNode.getChildrens();
	for (Node eachChild: childrens) {
	    Node nodeFound = doDFSearch(eachChild, nodeToSearch);
	    if (nodeFound != null) return nodeFound;
	}
	return null;
    }
    
    public Node breadthFirstSearch(Graph graph, Node nodeToSearch) {
	if (graph == null || nodeToSearch == null) return null;
	
	List<Node> graphNodes = graph.getGraphNodes();
	for (Node eachNode: graphNodes) {
	    Node nodeFound = doBFSearch(eachNode, nodeToSearch);
	    if (nodeFound != null) return nodeFound;
	}
	return null;
    }

    private Node doBFSearch(Node currNode, Node nodeToSearch) {
	if (currNode.isVisited()) return null;
	
	Queue<Node> queueNodes = new LinkedList<Node>();
	queueNodes.add(currNode);
	
	while (queueNodes.size() > 0) {
	    Node eachNode = queueNodes.poll();
	    if (!eachNode.isVisited()) {
		eachNode.setVisited(true);
		if (eachNode.getName().equals(nodeToSearch.getName())) {
		    return eachNode;
		}
		List<Node> childrens = eachNode.getChildrens();
		for (Node eachChild : childrens) {
		    queueNodes.add(eachChild);
		}
	    }
	}
	return null;
    }
}
