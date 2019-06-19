package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array  we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

 * @author ymohammad
 *
 */
public class MinimumSwap4
{
    /**
     * Here as all elements are consicutive, we no highest number by the length of the array.
     * First element is always 1.
     * 
     * bruteforce will be to start searching from min and keep swapping and repeat for next consicutive element.
     * @param arr
     * @return
     */
	//[7, 1, 3, 2, 4, 5, 6]
	// 0, 1, 2, 3, 4, 5, 6
	
	//[6, 1, 3, 2, 4, 5, 7]
	//[5, 1, 3, 2, 4, 6, 7]
	static int minimumSwaps(int[] arr) {
		int minSwapsCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (i+1 < arr[i]) {
				swap(arr, i, Math.min(arr.length - 1, arr[i] - 1));
				minSwapsCount++;
				i--;
			}
		}
		return minSwapsCount;
	}
    static int minimumSwaps2(int[] arr) {
    	int currentMin = 1;
    	int currentInd = arr.length-1;
    	int minSwapsCount = 0;
    	while (currentMin != arr.length) {
    		for (int i = 0; i<arr.length; i++) {
    			if (arr[currentInd] == currentMin) {
    				/**/
    				if (i == currentInd) {
    					//It is already sorted..
    					currentInd--;
    					currentMin++;
    					break;
    				}
    				swap(arr, i, currentInd);
    				minSwapsCount++;
    				currentInd--;
					currentMin++;
    			}
    		}
    	}
    	return minSwapsCount;
    }
    private static void swap(int[] arr, int fromInd, int toInd) {
    	int temp = arr[fromInd];
    	arr[fromInd] = arr[toInd];
    	arr[toInd] = temp;
    }
    static int minimumSwaps1(int[] arr) {
        int currentMin = 1;
        int currentInd = 0;
        int minSwapsCount = 0;
        while (currentMin != arr.length) {
            for (int i = currentInd; i<arr.length; i++) {
                if (arr[i] == currentMin) {
                    if (i == currentInd) {
                        //It is already sorted..
                        currentInd++;
                        currentMin++;
                        break;
                    }
                    swap(arr, i, currentInd);
                    minSwapsCount++;
                    currentInd++;
                    currentMin++;
                }
            }
        }
        return minSwapsCount;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("Got n :" + n);
        int[] arr = new int[n];

        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("D:/minSwap.txt")));
        String eachLine = "";
        StringBuffer totalContent = new StringBuffer();
        while (eachLine!= null) {
        	eachLine = bf.readLine();
        	if (eachLine != null)
        	totalContent.append(eachLine);
        }
        String[] arrItems = totalContent.toString().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        System.out.println("Calling swaps..");
        long currentTIme = System.currentTimeMillis();
        int res = minimumSwaps1(arr);
        System.out.println(res);
        System.out.println("Total TIme Take :" + (System.currentTimeMillis()-currentTIme));
        scanner.close();
    }
}
