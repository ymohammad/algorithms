package com.alysoft.algobooks.ch4;

import java.util.LinkedList;

import com.alysoft.algorithms.graphs.Graph;
import com.alysoft.algorithms.graphs.Node;

public class BuildOrder
{
	public static void printBuildOrder(Graph<Character> g) {
		LinkedList<Node<Character>> graphNodes = g.getGraphNodes();
		Node<Character> first = graphNodes.getFirst();
		for(Node<Character> eachCharNode : first.getAdjacentList()) {
			
		}
		
	}
	public static void main(String[] args)
	{
		Graph<Character> gh = new Graph<Character>();
		Node<Character> a = new Node<Character>('a');
		Node<Character> b = new Node<Character>('b');
		Node<Character> c = new Node<Character>('c');
		Node<Character> d = new Node<Character>('d');
		Node<Character> e = new Node<Character>('e');
		Node<Character> f = new Node<Character>('f');
		Node<Character> g = new Node<Character>('g');
		
		a.addEdge(e);
		b.addEdge(e);
		e.setNoOfIncomingEdges(2);
		
		b.addEdge(a);
		f.addEdge(a);
		c.addEdge(a);
		a.setNoOfIncomingEdges(3);
		
		f.addEdge(c);
		c.setNoOfIncomingEdges(1);
		
		f.addEdge(b);
		b.setNoOfIncomingEdges(1);
		
		d.addEdge(g);
		g.setNoOfIncomingEdges(1);
		
		gh.addNode(a);
		gh.addNode(b);
		gh.addNode(c);
		gh.addNode(d);
		gh.addNode(e);
		gh.addNode(f);
		gh.addNode(g);
	}

}
