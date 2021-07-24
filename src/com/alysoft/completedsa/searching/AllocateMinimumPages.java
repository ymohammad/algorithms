package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given N number of books. Every ith book has Pi number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. 
In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, 
the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of 
those in all the other permutations, and print this minimum value. 

Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding).

Input:

The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
Each case begins with a single positive integer N denoting the number of books.
The second line contains N space separated positive integers denoting the pages of each book.
And the third line contains another integer M, denoting the number of students.


Output:
For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.

Example:
Input:
1
4
12 34 67 90
2

Output:
113

Explaination: Allocation can be done in following ways:
{12} and {34, 67, 90}     Maximum Pages = 191
{12, 34} and {67, 90}     Maximum Pages = 157
{12, 34, 67} and {90}        Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.

 * @author ymohammad
 *
 */
public class AllocateMinimumPages
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
            long totalPages = 0L;
            int start = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        totalPages += a[i];
			        start = Math.max(start, a[i]);
			        i++;
			    }
			}
			int studentsCount = Integer.parseInt(br.readLine().trim());	
			long x = getMinimumPagesPermutation(a, n, totalPages, studentsCount, start);
			
			System.out.println(x);
            t--;
        }
	}

	private static long getMinimumPagesPermutation(int[] a, int n, long totalPages, int studentsCount, long start)
	{
		if (n < studentsCount) {
			return -1;
		}
		long end = totalPages;
		long foundValue = 0;
		while (start < end) {
			long mid = (start+end)/2;
			if (isMaxSetPossible(a, mid, studentsCount)) {
				end = mid-1;
				//if (foundValue > mid) 
				{
					foundValue = mid;
				}
			} else {
				start = mid+1;
			}
		}
		if (start == end && isMaxSetPossible(a, start, studentsCount)) {
			//if (foundValue > start) 
			{
				foundValue = start;
			}
		}
		return foundValue;
	}

	private static boolean isMaxSetPossible(int[] a, long mid, int studentsCount)
	{
		int sum = 0;
		int localCount = 0;
		for (int x: a) {
			if (sum+x > mid) {
				sum = x;
				localCount++;
				
			} else {
			    sum += x;
			}
			if (localCount == studentsCount) {
				return false;
			}
		}

		return true;
	}
}
