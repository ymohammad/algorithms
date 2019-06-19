package com.alysoft.algo.bits;

/**
 * Find the two non-repeating elements in an array of repeating elements.
 * 
 * Let x and y be the non-repeating elements we are looking for and arr[] be the input array. First, calculate the XOR of all the array elements.

     xor = arr[0]^arr[1]^arr[2].....arr[n-1]
All the bits that are set in xor will be set in one non-repeating element (x or y) and not in others. So if we take any set bit of xor and divide the elements of the array in two sets – one set of elements with same bit set and another set with same bit not set. By doing so, we will get x in one set and y in another set. Now if we do XOR of all the elements in the first set, we will get the first non-repeating element, and by doing same in other sets we will get the second non-repeating element.

Let us see an example.
   arr[] = {2, 4, 7, 9, 2, 4}
1) Get the XOR of all the elements.
     xor = 2^4^7^9^2^4 = 14 (1110)
2) Get a number which has only one set bit of the xor.   
   Since we can easily get the rightmost set bit, let us use it.
     set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
   Now set_bit_no will have only set as rightmost set bit of xor.
3) Now divide the elements in two sets and do xor of         
   elements in each set and we get the non-repeating 
   elements 7 and 9. Please see the implementation for this step.
 * @author ymohammad
 *
 */
public class FindNonRepeatingElement
{
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 7, 9, 2, 4};
		print2NonRepeatingNum(arr, arr.length);
	}
	
	public static void print2NonRepeatingNum(int[] arr, int n) {
		int xOr = arr[0];
		for (int i = 1; i<n; i++) {
			xOr = xOr^arr[i];
		}
		int x = 0;
		int y = 0;
		//Get first set bit from right.
		int setBit = xOr&(~(xOr-1));
		
		//Loop and print the number which is a different. Number which has same set bit is differnt.
		for (int i = 0; i<n; i++) {
			if ((arr[i]&setBit)>0) {
				x = x^arr[i];
			} else if ((arr[i]&setBit) == 0) {
				y = y^arr[i];
			}
		}
		System.out.println(x + " >>> " + y);
	}
}
