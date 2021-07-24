/*******************************************************************************************************************************
Node.java

Author : ymohammad
Date   : Jul 9, 2021

Last modified by : ymohammad
Last modified on : Jul 9, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
* Class Node
*/
public class Node {
    private String name;
    private boolean visited;
    private List<Node> childrens;
    
    public Node(String name) {
	this();
	this.name = name;
    }
    public Node() {
	this.childrens = new ArrayList<Node>();
    }
    public List<Node> getChildrens() {
	return this.childrens;
    }
    public void addVertex(Node edgeNode) {
	this.childrens.add(edgeNode);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isVisited() {
        return this.visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    @Override
    public String toString() {
	return "Node [name=" + this.name + ", visited=" + this.visited + "]";
    }
}
