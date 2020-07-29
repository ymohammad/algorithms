package com.alysoft.algo.heap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A binary heap is a Binary Tree with following properties:
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). 
This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. 
The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

Given some queries and your task is to implement the three methods insertKey,  deleteKey,  and extractMin on a Binary Min Heap and call 
them as per the query given below:
1) 1  x  (a query of this type means to insert an element in the min heap with value x )
2) 2  x  (a query of this type means to remove an element at position x from the min heap)
3) 3  (a query like this removes the min element from the min heap and prints it ).

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test 
case contains an integer Q denoting the number of queries. The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1  if the heap is empty else the min element of the heap.

Your Task:
You are required to complete the 3 methods insertKey() which takes one argument the value to be inserted , deleteKey() which takes 
one argument the position from where element is to be deleted and extractMin() which returns the minimum element in the heap.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
2
7
1 4 1 2 3 1 6 2 0 3 3
5
1 8 1 9 2 1 3 3

Output:
2 6 - 1
8 -1
 

Explanation:
Testcase 1:
In the first test case for query 
1 4      the heap will have  {4}  
1 2      the heap will be {2 4}
3         removes min element from heap ie 2 and prints it now heap is {4} 
1 6      inserts 6 to heap now heap is {4 6}
2 0      delete element at position 0 of heap now heap is {6}
3         remove min element from heap ie 6 and prints it  now the heap is empty {}
3         since heap is empty thus no min element exist so -1 is printed .
 * @author ymohammad
 *
 */
public class BinaryMinHeap
{
	/**
	 * Expected to implement following operations.
	 * 1. Get Minimum element - getMin
	 * 2. Extract the minimum (remove the root element) - extractMin
	 * 3. Insert an element into the minHeap- insert()
	 * 4. Decrease key - decrease the element value at the given index -  decreaseKey()
	 * 5. Delete an element at the given index - delete()
	 * 6. Search an element - find()
	 * 7. BuildHeap - Build the heap for the given array of elements. buildHeap().
	 */
	
	private int capacity;
	private int size;
	private int[] minHeapArr = null;
	
	public BinaryMinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.minHeapArr = new int[this.capacity];
	}
	public BinaryMinHeap() {
		this(100); 
	}
	
	public int getMin() {
		if (size == 0) throw new EmptyHeapException("getMin is failed. Heap is empty.");
		
		return minHeapArr[0];
	}
	
	public int extractMin() {
		if (size == 0) throw new EmptyHeapException("extractMin is failed. Heap is empty.");
		
		int minValue = getMin();
		swapElements(0, size-1);
		this.minHeapArr[size-1] = 0;
		size--;
		heapify(0);
		return minValue;
	}
	public void insert(int data) {
		if (size == this.capacity)
			throw new HeapInvalidOperation("Insertion is not valid as capacity is full..");
		
		this.minHeapArr[this.size] = data;
		this.size++;
		int atIndex = this.size-1;
		int parent = -1;
		while (atIndex > 0) {
			parent = getParent(atIndex);
			if (getIndexValue(parent)>getIndexValue(atIndex)) {
				swapElements(parent, atIndex);
			} else {
				break;
			}
			atIndex = parent;
		}
	}
	
	public void decreaseKey(int atIndex, int minData) {
		if (atIndex > this.size-1) {
			throw new HeapInvalidOperation("Invalid Index to get value." + atIndex + " vs heap size " + this.size);
		}
		this.minHeapArr[atIndex] = minData;
		this.swapElements(atIndex, 0);
		this.heapify(0);
	}
	
	public void delete(int atIndex) {
		if (atIndex > this.size-1) {
			System.out.println("Out of heap range..");
			return;
		}
		this.minHeapArr[atIndex] = -1* Integer.MIN_VALUE;
		int parent = -1;
		while (atIndex > 0) {
			parent = getParent(atIndex);
			swapElements(parent, atIndex);
			atIndex = parent;
		}
		this.extractMin();
	}
	
	public static BinaryMinHeap buildHeap(int[] arr) {
		if (arr == null) return new BinaryMinHeap();
		
		int arrSize = arr.length;
		BinaryMinHeap heap = new BinaryMinHeap(arrSize + 10);
		for (int i = 0; i<arrSize; i++) {
			heap.insert(arr[i]);
		}
		return heap;
	}
	private void heapify(int atIndex)
	{
		if (atIndex >this.size || atIndex < 0) return;
		
		int leftIndex = leftChild(atIndex);
		int rightIndex = rightChild(atIndex);
		int smallest = atIndex;
		
		if (rightIndex<this.size && this.minHeapArr[rightIndex] < this.minHeapArr[smallest]) {
			smallest = rightIndex;
		} else if(leftIndex<this.size && this.minHeapArr[leftIndex]<this.minHeapArr[atIndex]){
			smallest = leftIndex;
		}
		if (smallest != atIndex) {
			swapElements(smallest, atIndex);
			heapify(smallest);
		}
	}
	private int getParent(int atIndex) {
		if (atIndex == 0) return atIndex;
		if (atIndex > this.size) return -1;
		
		return (atIndex-1)/2;
	}
	private int rightChild(int atIndex)
	{
		if (atIndex > this.size) return -1;
		
		int rightChildIndex = 2*atIndex + 2;
		/*if (rightChildIndex > this.size-1) {
			throw new HeapInvalidOperation("Invalid Index to get right child." + rightChildIndex + " vs heap size " + this.size);
		}*/
		return rightChildIndex;
	}
	private int leftChild(int atIndex)
	{
		if (atIndex > this.size) return -1;
		
		int leftChildIndex = 2*atIndex + 1;
		/*if (leftChildIndex > this.size-1) {
			throw new HeapInvalidOperation("Invalid Index to get left child." + leftChildIndex + " vs heap size " + this.size);
		}*/
		return leftChildIndex;
	}
	private void swapElements(int fromInd, int toIndex)
	{
		int temp = this.minHeapArr[fromInd];
		this.minHeapArr[fromInd] = this.minHeapArr[toIndex];
		this.minHeapArr[toIndex] = temp;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		q.add(null);
		while (!q.isEmpty()) {
			Integer index = q.poll();
			if (index != null) {
				int indexValue = getIndexValue(index);
				if (indexValue == -1) continue;
				
				buff.append(getIndexValue(index) + " ");
				if (this.leftChild(index.intValue()) != -1) {
					q.add(this.leftChild(index.intValue()));
				}
				
				if (this.rightChild(index.intValue()) != -1) {
					q.add(this.rightChild(index.intValue()));
				}
			} else {
				buff.append("\n");
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
		return buff.toString();
	}
	private int getIndexValue(Integer atIndex)
	{
		if (atIndex > this.size) return -1;
		
		return this.minHeapArr[atIndex];
	}
	static class EmptyHeapException extends RuntimeException
	{
		public EmptyHeapException(String message) {
			super(message);
		}
	}
	static class HeapInvalidOperation extends RuntimeException
	{
		public HeapInvalidOperation(String message) {
			super(message);
		}
	}
}
