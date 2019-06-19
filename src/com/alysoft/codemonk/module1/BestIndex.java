package com.alysoft.codemonk.module1;

import java.util.Scanner;

public class BestIndex
{

	public static long getBestIndexSum(int[] nums, int n) {
		long totalArraySum = 0L;
		for (int a = 0; a<n; a++) {
			totalArraySum += nums[a];
        }
		long maxSum = Long.MIN_VALUE;
		int k=1000;
		for (int i=0; i<n; i++) {
			int leftIndex = i;
			long indexSum = 0L;

			 while((k*(k+1))/2>n-leftIndex){
	            k--;
	         }
	         int size=(k*(k+1))/2;
	         int rightIndex=leftIndex+size-1;
	         
	         if (leftIndex == 0 && rightIndex == (n-1)) indexSum = totalArraySum;
	         else {
	        	 for (int a = 0; a<leftIndex; a++) {
		        	 indexSum += nums[a];
		         }
	        	 indexSum = totalArraySum - indexSum;
	        	 long rightSideSum = 0L;
	        	 for (int a = rightIndex+1; a<n; a++) {
	        		 rightSideSum += nums[a];
		         }
	        	 indexSum = indexSum - rightSideSum;
	         }
	        

	         if (maxSum < indexSum) {
				maxSum = indexSum;
			}
		}
		return maxSum;
	}
	
	public static void findRightIndex(int n) {
		int k=1000;
        for(int leftindex=0;leftindex<n;leftindex++){
           
        	//System.out.println("Before starting loop :" + (k*(k+1))/2);
            while((k*(k+1))/2>n-leftindex){
                k--;
            }
            //System.out.println("Value of K:" + k);
            int size=(k*(k+1))/2;
            //System.out.println("Value of Size:" + size);
            int rightIndex=leftindex+size-1;
            //System.out.println("Left Index :" + leftindex + " --> Right Index:" + rightIndex);
        }
	}
	static int specialIndex(int i ,int n)
    {
        int j=1;
        int pos=i+j;
        while(pos-1<n)
        {
            i=pos;
            j++;
            pos=i+j;
        }
        return i;
    }
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i<n; i++) {
			//System.out.println("Index :" + i + " End index:" + specialIndex(i, n));
		}
		//findRightIndex(n);
		
		int[] num = new int[n];
		for (int i = 0; i<n; i++) {
			num[i] = s.nextInt();
		}
		
		if (n <3) {
			System.out.println(0);
		} else {
			System.out.println(getBestIndexSum(num, n));
		}
	}
}
