package com.alysoft.algo.sorting;

public class MergeSort
{
	public static void main(String[] args) {
		long[] arr = {5, 9, 10, 1, 3, 4};
		System.out.println(inversionCount(arr, arr.length));
	}
	static long inversionCount(long arr[], long n)
    {
        long temp[] = new long[(int)n]; 
        return _mergeSort(arr, temp, 0, n - 1); 
    }
    
    static long _mergeSort(long arr[], long temp[], 
        long left, long right)
    {
        long mid, inv_count = 0; 
        if (right > left) { 
            /* Divide the array into two parts
            and call _mergeSortAndCountInv() 
           for each of the parts */
            mid = (right + left) / 2; 
  
            /* Inversion count will be sum of inversions 
            in left-part, right-part 
          and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid); 
            inv_count += _mergeSort(arr, temp, mid + 1, right); 
  
            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right); 
        } 
        return inv_count; 
    }
    
    /* This method merges two sorted arrays and 
        returns inversion count in 
       the arrays.*/
    static long merge(long arr[], long temp[], long left,
    long mid, long right) 
    { 
        long i, j, k; 
        long inv_count = 0; 
  
        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) { 
            if (arr[(int)i] <= arr[(int)j]) { 
                temp[(int)k++] = arr[(int)i++]; 
            } 
            else { 
                temp[(int)k++] = arr[(int)j++]; 
  
                // add the inversions that cross between 
                // the first half and second half
                inv_count = inv_count + (mid - i); 
            } 
        } 
  
        /* Copy the remaining elements of left subarray 
       (if there are any) to temp*/
        while (i <= mid - 1) 
            temp[(int)k++] = arr[(int)i++]; 
  
        /* Copy the remaining elements of right subarray 
       (if there are any) to temp*/
        while (j <= right) 
            temp[(int)k++] = arr[(int)j++]; 
  
        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++) 
            arr[(int)i] = temp[(int)i]; 
  
        return inv_count; 
    }
}
