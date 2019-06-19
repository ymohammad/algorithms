package com.alysoft.algorithms.heap;

public class MinHeapOnArray {

	int[] minHeapArr = null;
	int size = -1;
	
	public MinHeapOnArray(int size) {
		this.minHeapArr = new int[size];
		this.size = size;
	}
	public MinHeapOnArray(int[] arr) {
		this.minHeapArr = arr;
		this.size = arr.length;
	}
	
	//dataArray = [25, 12, 10] => [10, 12, 25]
	public void heapifyMinHeap(int rootIndex) {
		int l = this.getLeft(rootIndex);
		int r = this.getRight(rootIndex);
		//System.out.println("L :" + l + " >> R:" + r);
		int smallest = rootIndex;
		if (l<this.size && this.minHeapArr[l] < this.minHeapArr[smallest]) smallest = l;
		
		if (r < this.size && this.minHeapArr[r] < this.minHeapArr[smallest]) smallest = r;
		
		if (rootIndex != smallest) {
			this.swapElement(rootIndex, smallest);
			heapifyMinHeap(smallest);
		}
	}
	
	public void swapElement(int p, int l) {
		int temp = this.minHeapArr[p];
		this.minHeapArr[p] = this.minHeapArr[l];
		this.minHeapArr[l] = temp;
	}
	
	public int getParent(int pos) {
		int parentNodeIndex = (pos-1)/2;
		return parentNodeIndex;
	}
	
	public int getLeft(int pos) {

		int leftNode = 2*pos+1;
		return leftNode;
	}
	
	public int getRight(int pos) {

		int rightNode = 2*pos+2;
		return rightNode;
	}

	public void print()
    {
        for (int i = 0; i < size / 2; i++ )
        {
            System.out.print(" PARENT : " + this.minHeapArr[i]);
            if ((2*i+1)<size) System.out.print(" LEFT CHILD : " + this.minHeapArr[2*i + 1]); 
            if ((2*i+2)<size) System.out.print(" RIGHT CHILD :" + this.minHeapArr[2*i  + 2]);
            System.out.println();
        } 
    }
	
	public static void main(String[] args) {
		System.out.println("{25, 12, 10, 65}");
		int[] dataArray = {25, 12, 10, 65}; // => [10, 12, 25, 65]
		MinHeapOnArray obj = new MinHeapOnArray(dataArray);
		obj.heapifyMinHeap(0);
		obj.print();
		
		System.out.println("\n\n {25, 14, 13, 16, 10, 8, 12}");
		int[] dataArray1 = {25, 14, 13, 16, 10, 8, 12}; // => [10, 12, 25, 65]
		obj = new MinHeapOnArray(dataArray1);
		obj.heapifyMinHeap(0);
		obj.print();
	}
}
