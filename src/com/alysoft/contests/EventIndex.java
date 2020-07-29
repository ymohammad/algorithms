package com.alysoft.contests;

/**
 * I have a list of numbers in an ArrayList. I am trying to remove odd indexed numbers from the list. 
 * We need to perform this operation in a loop till it remains only 1 element in the list. 

Example: 
List -> {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}
List after removing odd-indexed elements after 
Iteration 1 : {2, 4, 1, 3, 5}
Iteration 2 : {4, 3}
Iteration 3 : {3} 

Brute Force method is working but is there any other way? The number of elements in the list could be huge until 10^18.


 * 
 * 
 * Solution:
 * It is pretty easy actually: given a list of elements, the returned index is the power of two nearest but less than the size of the list.

1 -> 1
2 -> 2
3 -> 2
4 -> 4
5 -> 4
6 -> 4
7 -> 4
8 -> 8
...
You can do this easily with a bit mask:
 * 
 * @author ymohammad
 *
 *
 */
public class EventIndex
{

	public static int getIndex(int a){
	    for (int i = 31; i >= 0; i--) {
	        if (((a >> i) & 1) == 1)
	            return i;
	    }

	    return 0;
	}

	public static void main(String []args){
	    int a = 1;
	    int indexVal = getIndex(a);
	    double index = Math.pow(2, indexVal);
	    System.out.println(index);  
	}
}
