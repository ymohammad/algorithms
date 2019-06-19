package com.alysoft.algo.interviewbit;

public class MaxSumContiguousSubarray
{

	public static void main(String[] args)
	{
		int[] A = {-2};
		MaxSumContiguousSubarray obj = new MaxSumContiguousSubarray();
		System.out.println("Max Value :" + obj.maxSubArray(A));
	}
	public int maxSubArray(final int[] A) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i<A.length; i++) {
            if (sum + A[i] > 0) {
                sum += A[i];
                maxVal = Math.max(maxVal, sum);
            } else {
            	maxVal = Math.max(maxVal, A[i]);
                sum = 0;
            }
            //maxVal = Math.max(maxVal, sum);
        }
        return maxVal;
    }
	public int maxSubArray1(final int[] A) {
		int maxVal = Integer.MIN_VALUE;
		
		for (int i = 0; i<A.length; i++) {
			int currentTotal = A[i];
			maxVal = Math.max(maxVal, currentTotal);
			for (int j = i+1; j<A.length; j++) {
				currentTotal += A[j];
				maxVal = Math.max(maxVal, currentTotal);
			}
		}
		return maxVal;
    }
}
