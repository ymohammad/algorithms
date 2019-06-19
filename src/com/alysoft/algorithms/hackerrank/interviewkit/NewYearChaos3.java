package com.alysoft.algorithms.hackerrank.interviewkit;

import java.util.Scanner;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! 
 * There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. 
 * Initial positions increment by  1 from 1 at the front of the line to n at the back.
 * 
 * Any person in the queue can bribe the person directly in front of them to swap positions. 
 * If two people swap positions, they still wear the same sticker denoting their original places in line. 
 * One person can bribe at most two others. For example, if n=8 and Person 5 bribes Person 4, 
 * the queue will look like this: 1, 2, 3, 5, 4, 6, 7, 8
 * 
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place 
 * to get the queue into its current state!
 * 
 * Function Description
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum 
 * number of bribes necessary, or 'Too chaotic' if the line configuration is not possible.
 * 
 * Constraints:
 * 1 < t < 10 (max 10 test cases)
 * 1 <= n <= 10^5
 * @author ymohammad
 */
public class NewYearChaos3
{
	/**
	 * How to solve it in Bruteforce way?
	 * -> Here q[i] = i+1 if no bribe given otherwise, q[i]=y where y = i+1-x 
	 * -> here if x>2 then 'Too chaotic' otherwise, just keep adding x to the result variable.
	 * -> 
	 * -> Here we also need to consider the cases when we find bribe then two indexes value should not be
	 * 	  consider for the next evaluation.
	 * -> Also when changing the target value, make sure that is having a proper value. Otherwise, ignore it. Ex: 2, 5, ... Here we 
	 * can't change [1] because it is not having the value 1 as expected.
	 * 
	 * It takes O(n) time complexity and O(1) as space complexity.
	 * 
	 * How to solve it in O(1) or O(logn)?
	 * 	
	 * 2 1 5 3 4
	 * 0 1 2 3 4
	 * 
	 * Input:
2
8
5 1 2 3 7 8 6 4
8
1 2 5 3 7 8 6 4

1
8
1 2 5 3 4 7 8 6

1
8
1 2 5 3 7 8 6 4
	 */
    static void minimumBribes2(int[] q) {
    	int noOfBribes = 0;
    	for (int i=0; i<q.length; i++) {
    		System.out.println("Index :" + i + " q[" + i + "] :" + q[i] + " Number of bribes " + noOfBribes);
    		if (q[i] != i+1 && q[i] != -1) {
    			int x = Math.abs(i+1-q[i]);
    			System.out.println("Current member bribe " + x);
    			if (x > 2) {
    				System.out.println("Too chaotic");
    				return;
    			}
    			//If number of moves are 2 then it bribe to two people.
    			//we need to invalid those two people because their sin of bribing already included in this 2 bribes.
    			//i+1 is the expected value but we have i+1+2
    			//[i+1] 
    			/*
    			if (x == 2) {
    				//We also need to make sure that the target guy also not bribed its position.
    				if (q[i+x] == i+x)
    					q[i+x] = -1;
    				if (q[i+x-1] == (i+x-1))
    					q[i+x-1] = -1; //If two bribes then we should ignore two future values.
    			} else if (q[i+x] == i+x){
    				q[i+x] = -1;
    			}
    			
    			noOfBribes = noOfBribes + x;
    			*/
    			
    		}
    	}
    	System.out.println(noOfBribes);
    }
    
    /*
     * 
     Brute Force Approach: Run two loops, and for every integer , we find the number of 's such that , where  and . 
	Time complexity: O(n^2), but we can do better.

	Optimised (Linear Time) Approach: We start from the end of the array . If  is not equal to , where , 
	then we know that the last element must have bribed and moved towards the left since it cannot move to 
	the right being the last element. Also, we know that it will be present either in position  or . 
	This is because if it is in the position left to , he must have bribed more than 2 people. 
	In that case, we just print Too chaotic and terminate our program. Else if  is equal to  
	just swap the two elements and increment the counter by . Else shift  to ,  to  and put  equal to  
	and increment the counter by . Repeat the process until we reach the start of the array.

	Note: For the answer to be a valid count, our condition that if  is not equal to , it will be present either in position  
	or  holds for all the elements because at every step we reorganize the array and make  equal to  for . So, if we are at index ,
	 we are sure that  is equal to  for .

	Time complexity: O(n)
     */
    static void minimumBribes(int[] q) { 
    	int n = q.length;
    	int noOfBribes = 0;
    	for (int i = n-1; i>=0; i--) {
    		if (q[i] != i+1) {
    			if (i-2 >= 0 && q[i-2] == i+1) {
    				swap(q, i-2, i-1);
    				noOfBribes++;
    				swap(q, i-1, i);
    				noOfBribes++;
    			} else if (i-1 >= 0 && q[i-1] == i+1) {
    				swap(q, i-1, i);
    				noOfBribes++;
    			} else {
    				System.out.println("Too chaotic");
    				return;
    			}
    		}
    	}
    	System.out.println(noOfBribes);
    }
    private static void swap(int[] arr, int fromInd, int toInd) {
    	int temp = arr[fromInd];
    	arr[fromInd] = arr[toInd];
    	arr[toInd] = temp;
    }
    
    static void minimumBribesBruteForce(int[] q) {
        int noOfBribes = 0;
        byte[] bribesArr = new byte[100000];
        for (int i=0; i<q.length; i++) {
            if (q[i] != i+1) {
                int x = Math.abs(i+1-q[i]);
                if (x > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
            }
            for (int j=i+1; j<q.length; j++) {
                
                if (q[i]>q[j]) {
                    bribesArr[q[i]]++;
                    if ( bribesArr[q[i]] > 2) {
                        System.out.println("Too chaotic");
                        return;
                    }
                    int temp = q[i];
                    q[i] = q[j];
                    q[j] = temp; 
                    noOfBribes++;
                }
            }
        }
        System.out.println(noOfBribes);

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }
        scanner.close();
    }
}
