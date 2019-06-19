package com.alysoft.algorithms.hackerrank.interviewkit;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum
{
	// Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minValue = 0L;
        long maxValue = 0L;
        
        Arrays.sort(arr, 0, arr.length);

        for (int x = 0; x<4; x++) {
            minValue += arr[x];
        }
        for (int x = 4; x>0; x--) {
            maxValue += arr[x];
        }

        System.out.println(minValue + " " + maxValue);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

}
