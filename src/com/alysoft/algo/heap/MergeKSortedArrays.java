package com.alysoft.algo.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * Given K sorted arrays arranged in form of a matrix. The task is to merge them. You need to complete mergeKArrays() function 
 * which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. 
 * The function should return a pointer to the merged sorted arrays.

Input:
The first line of input contains the number of test cases, then T test cases follows. Each test case will contain an integer N denoting the 
number of sorted arrays. Then in the next line contains all the elements of the array separated by space.

Output:
The output will be the sorted merged array.

User Task:
The task is to complete the function mergeKArrays() which takes two arguments, and returns pointer to the modified array.

Constraints:
1 <= T <= 50
1 <= N <= 103
1 <= K <= 10

Example:
Input:
1
3
1 2 3 4 5 6 7 8 9 

Output:
1 2 3 4 5 6 7 8 9

Explanation:
Testcase 1:
Above test case has 3 sorted arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],

             [4, 5, 6],

             [7, 8, 9]]
The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
 
 * @author ymohammad
 *
 */
public class MergeKSortedArrays
{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			
			ArrayList<Integer> arr= mergeKArrays(a, n);
			printArray(arr,n*n);
		}
	}
	public static void printArray(ArrayList<Integer> arr, int size){
		for(int i = 0; i < size ; i++)
			System.out.print(arr.get(i)+" ");
		System.out.println();
	}
	public static ArrayList<Integer> mergeKArrays2(int[][] arrays,int k) 
    {
       ArrayList<Integer> sortedList = new ArrayList<Integer>();
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
       
       for (int i=0; i<k; i++) {
           pq.add(arrays[i][0]);
       }
       int colIndex=1;
       int rowIndex = 0;
       while (!pq.isEmpty()) {
           
           if (rowIndex < k && colIndex<arrays[rowIndex].length) {
              pq.add(arrays[rowIndex][colIndex]);
              sortedList.add(pq.poll());
               if (rowIndex == k-1) {
                   //reaches end..
                   rowIndex = 0;
                   colIndex++;
                   continue;
               } 
           } else {
        	   sortedList.add(pq.poll());
           }
           
           rowIndex++;
       }
       return sortedList;
    }
	
	//
	public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
       ArrayList<Integer> sortedList = new ArrayList<Integer>();
       MergeBean[] heapArr = new MergeBean[k];
       int totalSize = 0;
       for (int i = 0; i<k; i++) {
    	   MergeBean bean = new MergeBean(arrays[i][0], i, 1);
    	   heapArr[i] = bean;
    	   totalSize += arrays[i].length;
       }
       MergeHeap heap = new MergeHeap(heapArr);
       
       for (int i = 0; i<totalSize; i++) {
    	   MergeBean root = heap.getMin();
    	   sortedList.add(root.data);
    	   
    	   if (root.nextElmIndex < arrays[root.elmIndex].length) {
    		   root.data = arrays[root.elmIndex][root.nextElmIndex];
    		   root.nextElmIndex++;
    	   } else {
    		   root.data = Integer.MAX_VALUE;
    	   }
    	   heap.replaceMin(root);
       }
       
       return sortedList;
    }
	static class MergeHeap {
		MergeBean[] heapArr;
		int heapSize = 0;
		int heapCapacity = 0;
		public MergeHeap(MergeBean[] arr) {
			this.heapArr = arr;
			this.heapSize = arr.length;
			int lastNonLeave = (this.heapSize-2)/2;
			for (int i = lastNonLeave; i>=0; i--) {
				this.heapify(i);
			}
		}
		public MergeBean getMin() {
			if (this.heapSize == 0) return null;
			
			MergeBean bean = heapArr[0];
			return bean;
		}
		public void replaceMin(MergeBean obj) {
			heapArr[0] = obj;
			heapify(0);
		}
		private void heapify(int index)
		{
			int left = 2*index + 1;
			int right = 2*index + 2;
			int smallest = index;
			
			if (left < this.heapSize && heapArr[left].data<heapArr[smallest].data) {
				smallest = left;
			}
			if (right < this.heapSize && heapArr[right].data<heapArr[smallest].data) {
				smallest = right;
			}
			if (smallest != index) {
				MergeBean temp = heapArr[smallest];
				heapArr[smallest] = heapArr[index];
				heapArr[index] = temp;
				this.heapify(smallest);
			}
		}
	}
	//Static class..
	static class MergeBean {
		int elmIndex;
		int nextElmIndex;
		int data;
		public MergeBean(int data, int elmIndex, int nextElmIndex) {
			this.elmIndex = elmIndex;
			this.data = data;
			this.nextElmIndex = nextElmIndex;
		}
	}
}
