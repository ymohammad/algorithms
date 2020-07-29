package com.alysoft.algo.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * You are given an array of N+2 integer elements. All elements of the array are in range 1 to N. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow Each test case consists of two lines. First line of each test case contains an integer N denoting the range of numbers to be inserted in array of size N+2. Second line of each test case contains the N+2 space separated integers denoting the array elements.

Output: 
Print the two elements occuring twice in the array. Order of the two elements must be preserved as in the original list, i.e., print the element which arrives first(2nd time).

User Task:
The task is to complete the function repeatedElements() which finds the two repeated element in the array.

Constraints: 
1 ≤ T ≤ 30
1 ≤ N ≤ 105

Example:
Input:
1
4
1 2 1 3 4 3

Output:
1 3

Explanation:
Testcase 1: In the given array, 1 and 3 are repeated two times.
 * @author ymohammad
 *
 */
public class Repeated
{
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            twoRepeated3(arr, n);
    		
    		
	    }
	 }
	//1 2 1 3 4 3
	static void twoRepeated(int arr[], int n){
		for (int i = 0; i<arr.length; i++) {
			int x = arr[i];
			int y = arr[Math.abs(x)];
			if (y > 0) {
				arr[Math.abs(x)] = -1 * y;
			} else {
				System.out.print(Math.abs(x) + " ");
			}
		}
	}
	static void twoRepeated3(int arr[], int n){
        
        StringBuffer data = new StringBuffer();
        for (int i = 0; i<arr.length; i++) {
            int x = Math.abs(arr[i]);
            int d = arr[x-1];
            if (d<0) {
                data.append(x + " ");
                //arr[i] = arr[i]*-1;
            } else {
                arr[x-1] = d*-1;
            }
        }
        System.out.print(data.toString());
    }
	static void twoRepeated2(int arr[], int n){
		int[] copyOf = Arrays.copyOf(arr, arr.length);
         Arrays.sort(arr);
         
        int i = 1;
        int[] val = new int[2];
        int j = 0;
        while (i < arr.length) {
            if (arr[i-1] == arr[i]) {
                val[j] = arr[i-1];
                j++;
            }
            i++;
        }
        int a = val[0];
        int b = val[1];
        System.out.println(">>> a :" + a + " >>>> b:" + b);
        for (int x: copyOf) {
            System.out.println(">>> x :" + x);
            if (x == a) {
                System.out.print(x + " ");
                a = -1;
            } else if (x == b) {
                System.out.print(x + " ");
                b = -1;
            }
            if (a == -1 && b == -1) {
                break;
            }
        }
        System.out.println();
    }
}
