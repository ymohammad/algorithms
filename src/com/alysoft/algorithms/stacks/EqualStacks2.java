package com.alysoft.algorithms.stacks;

import java.util.Scanner;

public class EqualStacks2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		
		int tempValueHolder = -1;
		int targetHeight = 0;
		int[] noOfCylenders = {n1, n2, n3};
		int[] topIndex = {0, 0, 0};
		int[] cylnTotalHeight = {0, 0, 0};
		int[][] stacksArray = {new int[n1], new int[n2], new int[n3]};
		
		for (int inx = 0; inx < 3; inx++) {
			for (int iny = 0; iny < noOfCylenders[inx]; iny++) {
				tempValueHolder = in.nextInt();
				stacksArray[inx][iny] = tempValueHolder;
				cylnTotalHeight[inx] = cylnTotalHeight[inx] + tempValueHolder;
			}
		}
		
		targetHeight = Math.min(Math.min(cylnTotalHeight[0], cylnTotalHeight[1]), cylnTotalHeight[2]);
		
		while (cylnTotalHeight[0] != cylnTotalHeight[1] || cylnTotalHeight[1] != cylnTotalHeight[2]) {
			for (int inz = 0; inz < 3; inz++) {
				if (cylnTotalHeight[inz] > targetHeight) {
					cylnTotalHeight[inz] -= stacksArray[inz][topIndex[inz]++];
					targetHeight = Math.min(targetHeight, cylnTotalHeight[inz]);
				}
			}
		}
		
		System.out.println(targetHeight); 
	}
}
