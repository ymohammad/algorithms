package com.alysoft.algo.heap;

class MinHeap{
    int[] harr; 
    int capacity;
    int heap_size;
    MinHeap(int cap) {   heap_size = 0;  capacity = cap; harr = new int[cap]; }
    int parent(int i) { return (i-1)/2; }
    int left(int i) { return (2*i + 1); }
    int right(int i) { return (2*i + 2); }
      
    // You need to write code for below three functions
    int extractMin()
    {
        if (heap_size == 0) return -1;
        int minValue = getMin();
		swapElements(0, heap_size-1);
		heap_size--;
		MinHeapify(0);
		return minValue;
    }
 
    void insertKey(int k)
    {
        if (heap_size == this.capacity) return;
        
       this.harr[this.heap_size] = k;
		this.heap_size++;
		this.swapElements(this.heap_size-1, 0);
		this.MinHeapify(0);
    }
    void deleteKey(int i)
    {
        if (i > this.heap_size-1) {
			return;
		}
		
        this.swapElements(i, 0);
	    this.extractMin();
    }
    private void swapElements(int fromInd, int toIndex)
	{
		int temp = this.harr[fromInd];
		this.harr[fromInd] = this.harr[toIndex];
		this.harr[toIndex] = temp;
	}
    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i])
        {
            int temp = harr[i] ;
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }
    public int getMin() {
		//if (size == 0) throw new EmptyHeapException("getMin is failed. Heap is empty.");
		
		return harr[0];
	}
    /* You may call below MinHeapify function in 
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
           smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
           smallest = r;
        if (smallest != i)
        {
           int temp = harr[i] ;
           harr[i] = harr[smallest];
           harr[smallest] = temp;
           MinHeapify(smallest);
        }
    }
}
