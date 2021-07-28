/*******************************************************************************************************************************
RoadsAndLibrary.java


Determine the minimum cost to provide library access to all citizens of HackerLand. 
There are  cities numbered from  to . Currently there are no libraries and the cities are not connected. 
Bidirectional roads may be built between any city pair listed in . A citizen has access to a library if:

Their city contains a library.
They can travel by road from their city to a city containing a library.
Example

The following figure is a sample map of HackerLand where the dotted lines denote possible roads:

image




The cost of building any road is , and the cost to build a library in any city is . 
Build  roads at a cost of  and  libraries for a cost of . One of the available roads in the cycle  is not necessary.

There are  queries, where each query consists of a map of HackerLand and value of  and . 
For each query, find the minimum cost to make libraries accessible to all the citizens.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
* Class RoadsAndLibrary
*/
public class RoadsAndLibrary {
    public static void main(String[] args) throws IOException {
	test();
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int c_lib = Integer.parseInt(firstMultipleInput[2]);

            int c_road = Integer.parseInt(firstMultipleInput[3]);

            List<List<Integer>> cities = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] citiesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> citiesRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowTempItems[j]);
                    citiesRowItems.add(citiesItem);
                }

                cities.add(citiesRowItems);
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
            System.out.println(result);
        }

        bufferedReader.close();*/
    }
    
    public static void test() {
	Scanner scan = new Scanner(System.in);
	int q = scan.nextInt();
	for (int iq=0; iq<q; iq++) {
	    HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int libraryCost = scan.nextInt();
		int roadCost = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			cityMap.put(i, list);
		}
		System.out.println("Before:" + cityMap);
		for (int a1 = 0; a1 < m; a1++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			//System.out.println("X :" + x);
			//System.out.println("y :" + y);
			ArrayList<Integer> list1 = cityMap.get(x);
			ArrayList<Integer> list2 = cityMap.get(y);
			//System.out.println("Index :" + a1);
			System.out.println("List 1:" + list1);
			System.out.println("List 2:" + list2);
			if (list1 != list2) {
				list1.addAll(list2);
				list2.forEach(i -> cityMap.put(i, list1));
			}
		}
		System.out.println("After:" + cityMap);
		if (libraryCost < roadCost)
			System.out.println((long) n * libraryCost);
		else {
			long cost = 0;
			for (ArrayList<Integer> list : cityMap.values()) {
				int size = list.size();
				if (size > 0) {
					cost += libraryCost;
					cost += (size - 1) * roadCost;
					list.removeIf(i -> true);
				}
			}
			System.out.println(cost);
		}
	}
	scan.close();
    }
    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int noOfCities, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
	if (c_road >= c_lib) {
	    return (long)(noOfCities * c_lib);
	}
	
        List<List<Integer>> graph = createGraph(noOfCities);
        HashSet<Integer> vertices = new HashSet<Integer>();
        addEdges(graph, cities, vertices);
        boolean[] visited = new boolean[noOfCities+1];
        long totalCost = 0L;
        //for (Integer vertex: vertices) {
        for (int vertex = 1; vertex <= noOfCities; vertex++) {
            if (visited[vertex] == false) {
                long noOfNodes = exploreGraph(graph, visited, vertex);
                long multiplier = noOfNodes-1; //(noOfNodes == 1) ? noOfNodes : noOfNodes-1;
                totalCost = totalCost + (multiplier*c_road) + c_lib;
            }
        }
        long costForAllCitiesLib = (noOfCities * c_lib);
        if (totalCost > costForAllCitiesLib) {
            return costForAllCitiesLib;
        }
        return totalCost;
    }
    public static long exploreGraph(List<List<Integer>> graph, boolean[] visited, int src) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        long result = 0;
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
    public static void addEdges(List<List<Integer>> graph, List<List<Integer>> edges, HashSet<Integer> vertices) {
        for (List<Integer> edgeList: edges) {
            graph.get(edgeList.get(0)).add(edgeList.get(1));
            graph.get(edgeList.get(1)).add(edgeList.get(0));
            vertices.add(edgeList.get(0));
            vertices.add(edgeList.get(1));
        }
    }
    public static List<List<Integer>> createGraph(int nodesCount) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(nodesCount + 1);
        for (int i = 0; i<= nodesCount; i++) {
            graph.add(new ArrayList<Integer>());
        }
        return graph;
    }
}
