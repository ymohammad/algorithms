package com.alysoft.contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Chef is a network engineer at CodeChef. Currently, he has to design a network that connects N computers (numbered 1 through N).

The network should consist of these N computers and exactly M cables. Usually, a cable needs to connect two different computers, 
but Chef is okay with connecting computers to themselves too. Therefore, let's describe a cable by the pair of computers (u,v) it 
connects, where 1≤u≤v≤N. However, for each valid pair of computers (u,v), there must be at most one cable that directly connects this 
pair of computers.

Let's define the data consumption factor of a computer as the number of computers which are directly connected to it. In particular, 
if a computer v is directly connected to itself (by a cable (v,v)), it is only counted as connected to itself once. The data consumption 
factor of the whole network is the maximum of data consumption factors of all computers.

In the resulting network, each computer needs to be connected (directly or indirectly) to all other computers, so that they could 
communicate with each other.

Determine whether it is possible to design such a network. If it is possible, find the minimum possible data consumption factor of 
the resulting network.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers N and M.
Output
For each test case, print a single line containing one integer ― the minimum data consumption factor or −1 if Chef cannot design a required network.

Constraints
1≤T≤5⋅105
1≤N≤106
0≤M≤1015
Subtasks
Subtask #1 (10 points):

1≤N≤10
0≤M≤103
Subtask #2 (10 points): 1≤T≤102
Subtask #3 (10 points): 1≤T≤103
Subtask #4 (70 points): original constraints

Example Input
3
2 3
5 6
3 3
Example Output
2
2
2
Explanation
Example case 1: The optimal configuration (and the only configuration) of computers is to connect computers 1 and 2, connect computer 1 
to itself and computer 2 to itself. Then, the consumption factor of each computer is 2 because it is directly connected to itself and the 
other computer.

Example case 3: Here, the cables can connect pairs of computers (1,2), (1,3) and (2,3). The consumption factor of each computer is 2. 
There is a configuration with consumption factor 1, where each computer is connected to itself, but all the computers are not connected, 
so this network configuration is invalid.
 * @author ymohammad
 *
 */
public class ChefDesignedNetwork
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine = br.readLine();
		while (eachLine == null) {
			eachLine = br.readLine();
		}
		int t = Integer.parseInt(eachLine.trim());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	eachLine = br.readLine();
        	String[] splArr = eachLine.split(" ");
        	int N = Integer.parseInt(splArr[0].trim());
        	int M = Integer.parseInt(splArr[1].trim());
        	
        	int finalValue = getMinumuNetworkDataConsumption(N, M);
        	System.out.println(finalValue);
            t--;
        }
	}

	private static int getMinumuNetworkDataConsumption(int n, int m)
	{
		if (m<= n-2) return -1;
		
		int noOfEdge = m;
		Graph gh = new Graph(n);
		//add all possible direct connections.. a to b, b to c, c to d..
		//direct nodes join
		for (int node = 0; node<n-1; node++) {
			if (noOfEdge == 0) return -1;
			
			int u = node;
			int v = node+1;
			if (gh.isValidConnection(u, v)) {
				gh.addEdge(u, v);
				noOfEdge--;
			} else {
				return -1;
			}
		}
		
		if (noOfEdge == 0) return gh.getGraphRank();
		
		//Self join lowest rank nodes..1 and n
		noOfEdge = addEdgeUtil(gh, 0, 0, noOfEdge);
		if (noOfEdge == 0) return gh.getGraphRank();
		
		noOfEdge = addEdgeUtil(gh, n-1, n-1, noOfEdge);
		if (noOfEdge == 0) return gh.getGraphRank();
				
		//Joins the edge between last node to first node.
		noOfEdge = addEdgeUtil(gh, n-1, 0, noOfEdge);
		if (noOfEdge == 0) return gh.getGraphRank();
				
		//self join
		int eachNode=0;
		while (noOfEdge >0 && eachNode<n) {
			noOfEdge = addEdgeUtil(gh, eachNode, eachNode, noOfEdge);
			eachNode++;
		}
		
		if (noOfEdge == 0) return gh.getGraphRank();
		
		return connectOptimizeConnection(gh, n, noOfEdge, 2);
	}
	
	private static int connectOptimizeConnection(Graph gh, int n, int noOfEdge, int nextConnectorPos)
	{
		if (noOfEdge == 0) return gh.getGraphRank();
		
		if (nextConnectorPos >= n) return -1;
		
		for (int node = 0; node<n-nextConnectorPos; node++) {
			if (noOfEdge == 0) return gh.getGraphRank();
			
			int u = node;
			int v = node+nextConnectorPos;
			
			noOfEdge = addEdgeUtil(gh, u, v, noOfEdge);
		}
		return connectOptimizeConnection(gh, n, noOfEdge, nextConnectorPos+1);
	}

	public static int addEdgeUtil(Graph gh, int u, int v, int edgeCount) {
		if (gh.isValidConnection(u, v)) {
			gh.addEdge(u, v);
			edgeCount--;
		}
		return edgeCount;
	}
	static class Graph {
		int V;
		int[] rank;
		int maxRank = -1;
		ArrayList<ArrayList<Integer>> list;
		
		public Graph(int v) {
			this.V = v;
			this.list = new ArrayList<ArrayList<Integer>>();
			this.rank = new int[this.V];
			for (int i = 0; i<this.V; i++) {
				this.list.add(new ArrayList<Integer>());
			}
		}
		public boolean isValidConnection(int u, int v) {
			ArrayList<Integer> adjList = this.list.get(u);
			if (adjList.size() == 0) return true;
			
			for (int x : adjList) {
				if (x == v) return false;
			}
			return true;
		}
		public void addEdge(int u, int v) {
			
			this.list.get(u).add(v);
			this.rank[u]++;
			this.maxRank = Math.max(this.maxRank, this.rank[u]);
			
			if (u == v) return;
			
			this.list.get(v).add(u);
			this.rank[v]++;
			this.maxRank = Math.max(this.maxRank, this.rank[v]);
		}
		
		public int getGraphRank() {
			return this.maxRank;
		}
	}
}
