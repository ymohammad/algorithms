package com.alysoft.algo.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * Given an array arr[] of N integers in which elements may be repeating several times. Also, a positive number K is given and the 
 * task is to find sum of total frequencies of K most occurring elements

Note: The value of K is guaranteed to be less than or equal to the number of distinct elements in arr.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains the size of array N, and next line 
contains N positive integers. The last line contains K.

Output:
For each testcase, print the sum of total frequencies of K most occurring elements in the given array.

Constraints:
1 <= T <= 100
1 <= K <= N
1 <= N <= 107
1 <= arr[i] <= 106

Example:
Input:
2
8
3 1 4 4 5 2 6 1
2
8
3 3 3 4 1 1 6 1
2

Output:
4
6

Explanation:
Testcase 1: Since, 4 and 1 are 2 most occurring elements in the array with their frequencies as 2, 2. So total frequency is 2 + 2 = 4.

Testcase 2: Since, 3 and 1 are most occurring elements in the array with frequencies 3, 3 respectively. So, total frequency is 6.
 * @author ymohammad
 *
 */
public class KMostOccurringElements
{

	public static void main(String[] args)
	{
		int k = 5;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i<k; i++) {
            pq.add(1);
        }
        System.out.println(pq);
	}
	void kMostOccuring(int arr[], int n, int k){
        // your code here
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : arr) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x)+1);
            } else {
                map.put(x, 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i<k; i++) {
            pq.add(1);
        }
        Set<Integer> keys = map.keySet();
        for (int x : keys) {
            int freq = map.get(x);
            if (pq.peek() <= freq) {
                pq.poll();
                pq.add(freq);
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.print(sum);
    }
	
	//Editorials
	static class Pair {
	    int freq;
	    int num;
	    Pair(int x, int y){
	        this.num = x;
	        this.freq = y;
	    }
	}

	static class PairComparitor implements Comparator<Pair> {
	    public int compare(Pair p1, Pair p2) { 
	        // if frequencies of two elements are same 
			// then the larger number should come first 
	        if(p1.freq == p2.freq){
	            if(p1.num > p2.num)return -1;
	            if(p1.num < p2.num)return 1;
	            return 0;
	        }
	        		
			// insert elements in the priority queue on the basis of 
			// decreasing order of frequencies	 
	        if(p1.freq > p2.freq)return -1;
	        if(p1.freq < p2.freq)return 1;
	        return 0;
	    }
	}

    void kMostOccuringE(int arr[], int n, int k){
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new PairComparitor());
        
        // unordered_map 'um' implemented as frequency hash table  
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++) {
            if (mp.containsKey(arr[i]))mp.put(arr[i], mp.get(arr[i]) + 1); 
            else mp.put(arr[i] , 1);
        }
        for(Map.Entry m:mp.entrySet()){
            q.add(new Pair((int)m.getKey(), (int)m.getValue()));
        }
        int res=0;
        for(int i=0; i<k; i++){
            //System.out.print(q.peek().num + " " + q.peek().freq +  "\n");
            res+=q.poll().freq;
        }
        System.out.println(res);
    }
	    
}
