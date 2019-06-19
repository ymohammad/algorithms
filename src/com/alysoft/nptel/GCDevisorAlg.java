package com.alysoft.nptel;

import java.util.ArrayList;
import java.util.List;

public class GCDevisorAlg {
	public static int getGCDOneStep(int x, int y) {
		int i = Math.min(x,  y);
		while (i>1) {
			if (x%i == 0 && y%i == 0) {
				return i;
			} else {
				i = i-1;
			}
		}
		return i;
	}
	public static int getGCDOneLoop(int x, int y) {
		int commonFactor = 1;
		for (int a=2; a<=Math.min(x, y); a++) {
			if (x%a == 0 && y%a == 0) {
				commonFactor = a;
			}
		}
		return commonFactor;
	}
	public static int getGCD(int x, int y) {
		int lowest = x;
		int highest = y;
		if (x > y) {
			lowest = y;
			highest = x;
		}
		ArrayList<Integer> factors = getFactors(lowest);
		//System.out.println("Factors of " + lowest + " > " + factors);
		int commonDevisor = factors.get(0);
		for (int a : factors) {
			if (highest%a == 0) commonDevisor = a;
		}
		return commonDevisor;
	}
	private static ArrayList<Integer> getFactors(int i) {
		ArrayList<Integer> returnArr = new ArrayList<Integer>();
		for (int x=1; x <= i; x++) {
			if (i%x == 0) returnArr.add(x);
		}
		return returnArr;
	}
	public static void main(String[] args) {
		System.out.println("GCD of 4,8 		:" + getGCD(4, 8));
		System.out.println("GCD of 7,63 	:" + getGCD(7, 63));
		System.out.println("GCD of 14,63 	:" + getGCD(14, 63));
	}

}
