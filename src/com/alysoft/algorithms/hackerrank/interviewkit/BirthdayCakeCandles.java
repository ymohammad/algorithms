package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.IOException;
import java.util.Scanner;

public class BirthdayCakeCandles
{
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {

        int[] candleHeight = new int[(int)Math.pow(10, 7)];
        int maxHeightCandle = 0;
        for (int eachVal : ar) {
            candleHeight[eachVal] = candleHeight[eachVal] + 1;
            maxHeightCandle = maxHeightCandle < eachVal ? eachVal : maxHeightCandle;
        }
        double sqrt = Math.sqrt((short)12);
        return candleHeight[maxHeightCandle];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);
        System.out.println(result);
        scanner.close();
    }
}
