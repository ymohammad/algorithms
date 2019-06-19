package com.alysoft.algo.binarysearch;

public class SquareRoot
{

	public static void main(String[] args)
	{
		System.out.println("SquareRoot.main() 4:" + floorSqrt(4));
		System.out.println("SquareRoot.main() 16:" + floorSqrt(16));
		System.out.println("SquareRoot.main() 18:" + floorSqrt(18));
		System.out.println("SquareRoot.main() 5:" + floorSqrt(5));
	}
	public static long floorSqrt(long x) {
		long start = 1L;
		long end = x;
		
		while (start <= end) {
			long mid = (start+end)/2;
			long prod = mid*mid;
			if (prod == x ) {
				return mid;
			} else if (prod<x) {
				if ((mid < end && ((mid+1)*(mid+1))>=x)) {
					return mid;
				}
				start = mid+1;
			} else {
				if ((mid > start && ((mid-1)*(mid-1))<=x)) {
					return mid-1;
				}
				end = mid-1;
			}
		}
		return -1;
	}
	
	long floorSqrt2(long x)
	 {
		if(x == 0 || x == 1)
			return x;
			
		long start = 1, end = x, ans = 0;
		while(start <= end)
		{
			long mid = (start + end)/2;

			if(mid*mid == x)
				return mid;
				
			if(mid*mid < x)
			{
				start = mid+1;
				ans = mid;
			}
			else
				end = mid - 1;
				
		}
		return ans;
	 }
}
