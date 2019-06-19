package com.alysoft.algorithms.hackerrank.code30;

import java.util.ArrayList;
import java.util.Scanner;

public class BitWiseAnd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> finalList = new ArrayList<Integer>();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            finalList.add(getGreaterBitwise(n, k));
        }
	}

	private static int getGreaterBitwise(int n, int k) {
		int globalMax = Integer.MIN_VALUE;
		for (int x=1; x<=n; x++) {
			for(int y=x+1; y<=n; y++) {
				int temp = x & y;
				System.out.println("x :" + x + " & y:" + y + ">>" +temp);
				if (temp < k && temp > globalMax) {
					globalMax = temp;
				}
			}
		}
		return globalMax;
	}

}
