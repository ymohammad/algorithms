package com.alysoft.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * I have a Array A of N elements . I have to perform Q query in it. At every query i choose an index I(0-based) and does the following

for j = I+1 to N:
  if A[j]<A[i]:
      A[j]=0
Note : the queries are not independent of each other.

INPUT:
First line contains N(no of elements in the array ) and Q (no.of query)
Second line contains N space seperated intergers
Q space seperated integers denoting chosen index in each query

5 2 
4 3 4 3 2
3 2

Output:
4 3 4 0 0
Explanation:
Array after 1st query : {4,3,4,3,0}
Array after 2nd query : {4,3,4,0,0}
 * @author ymohammad
 *
 */
public class DeletionProblemAWS
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine = br.readLine();
		String[] strArr = null;
		while (eachLine == null) {
			eachLine = br.readLine();
		}
		strArr = eachLine.split(" ");
		int N = Integer.parseInt(strArr[0].trim());
		int Q = Integer.parseInt(strArr[1].trim());
		int[] arr = new int[N];
		
		eachLine = br.readLine();
		strArr = eachLine.split(" ");
		for (int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(strArr[i].trim());
		}
		
		int[] queries = new int[Q];
		eachLine = br.readLine();
		strArr = eachLine.split(" ");
		for (int i = 0; i<Q; i++) {
			queries[i] = Integer.parseInt(strArr[i].trim());
		}
		
		printFinalArray(arr, queries, N, Q);
	}

	private static void printFinalArray(int[] arr, int[] queries, int n, int q)
	{
		int[] qTrack = new int[n];
		for (int i = 0; i<q; i++) {
			int qVal = queries[i];
			qTrack[qVal] = 1;
		}
		
		int max = 0;
		for (int i = 0; i<n; i++) {
			if (qTrack[i] == 1) {
				max = Math.max(max, arr[i]);
			}
			if (arr[i]<max) {
				arr[i] = 0;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
