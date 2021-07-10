/*******************************************************************************************************************************
Graph.java


Author : ymohammad
Date   : Jul 9, 2021

Last modified by : ymohammad
Last modified on : Jul 9, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.List;

/**
* Class Graph
*/
public class Graph {
    private List<Node> graphNodes;
    
    public Graph() {
	this.graphNodes = new ArrayList<Node>();
    }

    public List<Node> getGraphNodes() {
        return this.graphNodes;
    }

    public void addNode(Node node) {
	this.graphNodes.add(node);
    }
}
