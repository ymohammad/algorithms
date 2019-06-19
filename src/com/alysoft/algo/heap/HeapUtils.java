package com.alysoft.algo.heap;

public class HeapUtils
{
	public static void main(String[] args) {
		int[] arr = {5, 6, 8, 12, 9, 14, 3};
		Heap heapObj = buildHeap(arr);
		System.out.println(heapObj);
		System.out.println("Adding 19 -> " + heapObj.insert(19));
		System.out.println(heapObj);
		System.out.println("Deleting max 19 -> " + heapObj.deleteMax());
		System.out.println(heapObj);
		System.out.println("Sort the heap -> " + heapObj.insert(19));
		heapObj.heapSort();
		System.out.println(heapObj);
		System.out.println("Heapify again...");
		heapObj.heapifySorted();
		System.out.println(heapObj);
		Integer val1 = Integer.valueOf("1100", 2);
		Integer val2 = Integer.valueOf("1010", 2);
		System.out.println("Val1 :" + val1 + " >> val2:" + val2);
		System.out.println("Product :" + (val1*val2));
	}
	public static Heap buildHeap(int[] array) {
		if (array == null) return null;
		
		Heap heap = new Heap(array.length);
		heap.insertArray(array);
		return heap;
	}
	
}
