package com.alysoft.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack
{

	public static void main(String[] args)
	{
		int[] profits = {10, 5, 15, 7, 6, 18, 3};
		int[] weight = {2, 3, 5, 7, 1, 4, 1};
		int knapSackSize = 15;
		
		findMaxProfit(weight, profits, knapSackSize);
		
	}

	public static void findMaxProfit(int[] objectsWeight, int[] profit, int knapSackSize) {
		int noOfObjects = objectsWeight.length;
		
		if (noOfObjects == 0) return;
		
		KnapsackObj[] profitPerWeaight = new KnapsackObj[noOfObjects];
		for (int objInd = 0; objInd<noOfObjects; objInd++) {
			double unitPrice = (double)profit[objInd]/(double)objectsWeight[objInd];
			profitPerWeaight[objInd] = new KnapsackObj(objectsWeight[objInd], profit[objInd], objInd, unitPrice);
		}
		
		//Sort array..
		Arrays.sort(profitPerWeaight, new Comparator<KnapsackObj>() {
			@Override
			public int compare(KnapsackObj o1, KnapsackObj o2) {
				if (o1.unitPrice > o2.unitPrice) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		//printArray(profitPerWeaight);
		double maxProfit = 0;
		int remainKnapsack = knapSackSize;
		
		for (KnapsackObj eachObj : profitPerWeaight) {
			if (remainKnapsack > 0) {
				if (eachObj.objWeight < remainKnapsack) {
					remainKnapsack = remainKnapsack - eachObj.objWeight;
					maxProfit += eachObj.profit;
				} else {
					maxProfit += (eachObj.unitPrice * remainKnapsack);
					remainKnapsack = 0;
				}
			} else {
				break;
			}
		}
		System.out.println("Max Profit :" + maxProfit);
	}
	
	private static void printArray(KnapsackObj[] profitPerWeaight)
	{
		for (KnapsackObj eachObj : profitPerWeaight) {
			System.out.println(eachObj);
		}
	}

	static class KnapsackObj {
		private int objWeight;
		private int profit;
		private int objIndex;
		private double unitPrice;
		
		public KnapsackObj(int objWeight, int profit, int objIndex, double unitPrice) {
			this.objWeight = objWeight;
			this.profit = profit;
			this.objIndex = objIndex;
			this.unitPrice = unitPrice;
		}

		@Override
		public String toString()
		{
			return "KnapsackObj [objWeight=" + this.objWeight + ", profit=" + this.profit + ", objIndex=" + this.objIndex + ", unitPrice=" + this.unitPrice + "]";
		}
		
		
	}
}
