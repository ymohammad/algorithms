package com.alysoft.algobooks.ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrderComplete
{
	public static Project[] orderedProject(Graph gh) {
		ArrayList<Project> nodes = gh.getNodes();
		Project[] buildProject = new Project[nodes.size()];
		int offSet = addNonDependentProjects(buildProject, nodes, 0);
		int counter = 0;
		while (offSet < buildProject.length) {
			Project projectNode = buildProject[counter];
			
			//It is cyclick and we can't remove any element.
			if (projectNode == null) return null;
			
			for (Project node : projectNode.getChildrens()) {
				node.decrementDependencies();
			}
			offSet = addNonDependentProjects(buildProject, projectNode.getChildrens(), offSet);
			counter++;
		}
		
		return buildProject;
	}
	public static int addNonDependentProjects(Project[] buildProject, ArrayList<Project> nodes, int offSet) {
		for (Project node : nodes) {
			if (node.getNoOfDependency() == 0) {
				buildProject[offSet] = node;
				offSet++;
			}
		}
		return offSet;
	}
	public static void main(String[] args)
	{
		String[] names = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {{"f", "c"}, {"f", "b"}, {"f", "a"}, {"c", "a"}, {"b", "a"}, {"b", "e"}, {"a", "e"}, {"d", "g"}};
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
	static class Graph {
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
		private ArrayList<Project> childrens = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private int noOfDependencies = 0;
		
		public Project(String name) {
			this.name = name;
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
	}
}
