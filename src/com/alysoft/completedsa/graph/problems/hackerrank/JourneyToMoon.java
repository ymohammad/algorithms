/*******************************************************************************************************************************
JourneyToMoon.java

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
Date   : Jul 26, 2021

Last modified by : ymohammad
Last modified on : Jul 26, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* Class JourneyToMoon
*/
public class JourneyToMoon {
    
    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon1(int n, List<List<Integer>> astronaut) {
	// Write your code here
	HashMap<Integer, ArrayList<Integer>> graph = createGraph(n);
	for(List<Integer> edge: astronaut) {
	    graph.get(edge.get(0)).add(edge.get(1));
	    graph.get(edge.get(1)).add(edge.get(0));
	}
	boolean[] visited = new boolean[n+1];
	ArrayList<Integer> compoentsList = new ArrayList<Integer>();
	for (int eachNode: graph.keySet()) {
	    if (visited[eachNode] == false) {
		int noOfNodes = exploreGraph(graph, visited, eachNode);
		compoentsList.add(noOfNodes);
	    }
	}
	
	int noOfAstronutesPair = 0;
	for (int i = 0; i<compoentsList.size(); i++) {
	    for (int j = i+1; j<compoentsList.size(); j++) {
		noOfAstronutesPair = noOfAstronutesPair + (compoentsList.get(i) * compoentsList.get(j));
	    }
	}
	return noOfAstronutesPair;
    }
    public static int exploreGraph(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int src) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        int result = 0;
        while (queue.size() > 0) {
            Integer rem = queue.poll();
            if (visited[rem] == true) continue;
            
            visited[rem] = true;
            result++;
            for (int node: graph.get(rem)) {
                if (visited[node] == false) {
                    queue.add(node);
                }
            }
        }
        return result;
    }
    
    public static HashMap<Integer, ArrayList<Integer>> createGraph(int nodesCount) {
	HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
	for (int vertex = 0; vertex < nodesCount; vertex++) {
		ArrayList<Integer> adjList = new ArrayList<Integer>();
		graph.put(vertex, adjList);
	}
        return graph;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            String[] astronautRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> astronautRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowTempItems[j]);
                astronautRowItems.add(astronautItem);
            }

            astronaut.add(astronautRowItems);
        }

        int result = journeyToMoon(n, astronaut);
        System.out.println(result);
        /*Collection<ArrayList<Integer>> values = getComponentsList(n, astronaut).values();
        HashSet<ArrayList<Integer>> keys = new HashSet<>(values);
	System.out.println(keys);*/
        bufferedReader.close();
    }
    /*
     * 100000 2
1 2
3 4

4999949998

Answer = (axb) + (a+b)xc + (a+b+c)xd ..........................(3)
     */
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
	// Write your code here
	Collection<ArrayList<Integer>> values = getComponentsList(n, astronaut).values();
        HashSet<ArrayList<Integer>> keys = new HashSet<>(values);
        ArrayList<Integer> compoentsList = new ArrayList<Integer>();
	for (ArrayList<Integer> comp : keys) {
	    compoentsList.add(comp.size());
	}
	int[] sumArr = new int[compoentsList.size()];
	sumArr[0] = compoentsList.get(0);
	for (int i = 1; i<compoentsList.size(); i++) {
	    sumArr[i] = sumArr[i-1] + compoentsList.get(i);
	}
	int noOfAstronutesPair = compoentsList.get(0) * compoentsList.get(1);
	for (int i = 2; i<compoentsList.size(); i++) {
	    /*for (int j = i+1; j<compoentsList.size(); j++) {
		noOfAstronutesPair = noOfAstronutesPair + (compoentsList.get(i) * compoentsList.get(j));
	    }*/
	    noOfAstronutesPair = noOfAstronutesPair + (sumArr[i-1] * compoentsList.get(i));
	}
	return noOfAstronutesPair;
    }
    public static HashMap<Integer, ArrayList<Integer>> getComponentsList(int noOfNodes, List<List<Integer>> edgesList) {
	HashMap<Integer, ArrayList<Integer>> compMap = new HashMap<>();
	for (int vertex = 0; vertex < noOfNodes; vertex++) {
		ArrayList<Integer> adjList = new ArrayList<Integer>();
		adjList.add(vertex);
		compMap.put(vertex, adjList);
	}
	for(List<Integer> edge: edgesList) {
	    int x = edge.get(0);
		int y = edge.get(1);
		ArrayList<Integer> list1 = compMap.get(x);
		ArrayList<Integer> list2 = compMap.get(y);
		//System.out.println("Index :" + a1);
		//System.out.println("List 1:" + list1);
		//System.out.println("List 2:" + list2);
		if (list1 != list2) {
			list1.addAll(list2);
			for (Integer eachItem: list2) {
			    compMap.put(eachItem, list1);
			}
			//list2.forEach(i -> compMap.put(i, list1));
		}
	}
	
	
	return compMap;
    }
}
