package com.alysoft.algobooks.ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrderDFS
{
	public static Project[] orderedProject(Graph gh) {
		ArrayList<Project> nodes = gh.getNodes();
		Project[] buildOrderNodes = new Project[nodes.size()];
		Integer arrayIndex = new Integer(buildOrderNodes.length-1);
		for (Project node : nodes) {
			if (node.getStatus() == Graph.BLANK) {
				Integer newIndex = performDFS(node, buildOrderNodes, arrayIndex);
				if (newIndex == null) return null;
				arrayIndex = newIndex;
			}
		}
		return buildOrderNodes;
	}
	public static Integer performDFS(Project node, Project[] orderedNodes, Integer offSet) {
		if (node == null || offSet == null) return null;
		
		if (node.getStatus() == Graph.PARTIAL) {
			return null;
		}
		
		if (node.getStatus() == Graph.COMPLETED) {
			return offSet;
		}
		
		ArrayList<Project> childrens = node.getChildrens();
		if (childrens == null || childrens.size() == 0) {
			node.setStatus(Graph.COMPLETED);
			orderedNodes[offSet] = node;
			offSet--;
		} else {
			node.setStatus(Graph.PARTIAL);
			for (Project eachNode : childrens) {
				offSet = performDFS(eachNode, orderedNodes, offSet);
				if (offSet == null) return offSet;
			}
			node.setStatus(Graph.COMPLETED);
			orderedNodes[offSet] = node;
			offSet--;
		}
		return offSet;
	}
	public static void main(String[] args)
	{
		String[] names = {"a", "b", "c", "d", "e", "f", "g", "h"};
		String[][] dependencies = {{"f", "c"}, {"f", "b"}, {"f", "a"}, {"c", "a"}, {"b", "a"}, {"b", "e"}, {"b", "h"}, {"a", "e"}, {"d", "g"}};
		Graph gh = new Graph();
		gh.buildGraph(names, dependencies);
		Project[] orderedProject = orderedProject(gh);
		System.out.println("Ordered Project :" + orderedProject);
		for (Project node: orderedProject) {
			System.out.print(node.getName() + "-->");
		}
		
		//Cyclick Graph
		String[] names1 = {"a", "b", "c", "d"};
		String[][] dependencies1 = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"d", "b"}};
		gh = new Graph();
		gh.buildGraph(names1, dependencies1);
		orderedProject = orderedProject(gh);
		System.out.println("\nOrdered Project :" + orderedProject);
		if (orderedProject != null) {
			for (Project node: orderedProject) {
				System.out.print(node.getName() + "-->");
			}
		}
	}

	//Graph related classes
	static class Graph {
		public static final String BLANK = "BLANK";
		public static final String COMPLETED = "COMPLETED";
		public static final String PARTIAL = "PARTIAL";
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> nodesMap = new HashMap<String, Project>();
		
		public void buildGraph(String[] names, String[][] dependencies) {
			for(String name : names) {
				this.createNGetNode(name);
			}
			
			for(String[] depends : dependencies) {
				this.addEdge(depends[0], depends[1]);
			}
		}
		public void addEdge(String first, String second) {
			Project firstNode = createNGetNode(first);
			Project secondNode = createNGetNode(second);
			firstNode.addNeighbour(secondNode);
		}
		public Project createNGetNode(String name) {
			if (!nodesMap.containsKey(name)) {
				Project node = new Project(name);
				nodesMap.put(node.getName(), node);
				nodes.add(node);
			}
			return nodesMap.get(name);
		}
		public ArrayList<Project> getNodes()
		{
			return this.nodes;
		}
	}
	static class Project {
		
		private String name;
		private String status;
		private ArrayList<Project> childrens = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private int noOfDependencies = 0;
		
		public Project(String name) {
			this.name = name;
			this.status = Graph.BLANK;
		}
		
		public void addNeighbour(Project node) {
			if (!map.containsKey(node.getName())) {
				childrens.add(node);
				map.put(name, node);
				node.incrementDependencies();
			}
		}
		public int getNoOfDependency() {
			return this.noOfDependencies;
		}
		public void incrementDependencies() {
			this.noOfDependencies++;
		}
		public void decrementDependencies() {
			this.noOfDependencies--;
		}
		
		public String getName() {
			return this.name;
		}
		public ArrayList<Project> getChildrens() {
			return this.childrens;
		}

		public String getStatus()
		{
			return this.status;
		}

		public void setStatus(String status)
		{
			this.status = status;
		}		
	}
}
