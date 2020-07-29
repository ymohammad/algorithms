package com.alysoft.algo.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input Format:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. 
The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated 
integers A1, A2, ..., AN denoting the elements of the array.

Output Format:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Your Task:
This is a function problem. You only need to complete the function sortByFreq that takes arr, and n as parameters and prints the sorted elements. 
Endline is provided by the driver code.

Constraints:
1 ≤ T ≤ 70
30 ≤ N ≤ 130
1 ≤ Ai ≤ 60 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. 
So 4 4 comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.

Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. 
So we print smaller element first.
The output is 9 9 9 2 5.
 * @author ymohammad
 *
 */
public class SortingElementsByFrequency
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			    sortByFreq(arr, size);
			    System.out.println();
			n--;
		}
	}
	static void sortByFreq(int arr[], int n)
    {
        // add your code here
        int[] hash = new int[61];
        for (int x : arr) {
            hash[x]++;
        }
        HashMap<Integer, ArrayList<Integer>> valueHash = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0; i<hash.length; i++) {
            int x = hash[i];
            if (x != 0) {
                if (valueHash.containsKey(x)) {
                    valueHash.get(x).add(i);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    valueHash.put(x, list);
                }
            }
        }
        Set<Integer> keys = valueHash.keySet();
        List<Integer> list = new ArrayList<Integer>(keys); 
        Collections.sort(list, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				if (o1 > o2) return -1;
				
				return 1;
			}
		});
        StringBuffer buff = new StringBuffer();
        for (int x : list) {
        	ArrayList<Integer> numList = valueHash.get(x);
        	Collections.sort(numList);
        	for (int num : numList) {
        		int y =  x;
        		while (y > 0) {
        			buff.append(num + " ");
        			y--;
        		}
        	}
        }
        System.out.print(buff);
    }
}
