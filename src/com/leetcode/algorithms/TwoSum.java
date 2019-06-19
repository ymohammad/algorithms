package com.leetcode.algorithms;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		System.out.println(twoSum(nums, target));
	}
    public static int[] twoSum(int[] nums, int target) {
        int[] returnArray = null;
        for(int x=0; x<nums.length; x++) {
            for(int y=x+1; y<nums.length; y++) {
                if (target == nums[x] + nums[y]) {
                	returnArray = new int[2];
                    returnArray[0] = x;
                    returnArray[1] = y;
                    break;
                }
            }
            if (returnArray != null && returnArray.length > 0) {
                break;
            }
        }
        return returnArray;
    }
   
}
