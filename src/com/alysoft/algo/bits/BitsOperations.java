package com.alysoft.algo.bits;

public class BitsOperations
{

	public static void main (String[]  args) {
		System.out.println("isNumberEven - 12 :" + isNumberEven(12));
		System.out.println("isNumberEven - 1 :" + isNumberEven(1));
		System.out.println("isNumberEven - 2 :" + isNumberEven(2));
		System.out.println("Bitwise And 5, 3 :" + bitwiseAnd(5, 3));
		System.out.println("Bitwise And 2, 6 :" + bitwiseAnd(2, 6));
		System.out.println("Bitwise And 2, 5 :" + bitwiseAnd(2, 5));
		System.out.println("Left Shift 2, 1 :" + leftShift(2, 1));
		System.out.println("Left Shift 2, 2 :" + leftShift(2, 2));
		System.out.println("Left Shift 2, 3 :" + leftShift(2, 3));
		System.out.println();
		System.out.println("Right Shift 1, 1 :" + rightShift(1, 1));//0
		System.out.println("Right Shift 2, 1 :" + rightShift(2, 1));//1
		System.out.println("Right Shift 8, 3 :" + rightShift(8, 3));//1
		
		System.out.println();
		System.out.println("SetBits At nth postion 5, 3 :" + setBitAtNthPostion(5, 3));//13
		System.out.println("SetBits At nth postion 0, 1 :" + setBitAtNthPostion(0, 1));
		System.out.println("SetBits At nth postion 0, 0 :" + setBitAtNthPostion(0, 0));
		
		System.out.println();
		System.out.println("clearBitAtPositionN At nth postion 5, 2 :" + clearBitAtPositionN(5, 2));//1
		System.out.println("clearBitAtPositionN At nth postion 8, 3 :" + clearBitAtPositionN(8, 3));//0
		System.out.println("clearBitAtPositionN At nth postion 1, 0 :" + clearBitAtPositionN(1, 0));//0
		
		System.out.println();
		System.out.println("toggleBitAtNthPosition At nth postion 5, 1 :" + toggleBitAtNthPosition(5, 1));//7
		System.out.println("toggleBitAtNthPosition At nth postion 5, 3 :" + toggleBitAtNthPosition(5, 3));//13
		System.out.println("toggleBitAtNthPosition At nth postion 1, 0 :" + toggleBitAtNthPosition(1, 0));//0
		
		System.out.println();
		System.out.println("isBitSetAtNthPosition At nth postion 1, 0 :" + isBitSetAtNthPosition(1, 0));// true
		System.out.println("isBitSetAtNthPosition At nth postion 5, 1 :" + isBitSetAtNthPosition(5, 1));//false
		System.out.println("isBitSetAtNthPosition At nth postion 2, 1 :" + isBitSetAtNthPosition(2, 1));//true
		
		System.out.println();
		System.out.println("divideBy2 At nth postion 6 	:" + divideBy2(6));// true
		System.out.println("divideBy2 At nth postion 14 :" + divideBy2(14));//false
		System.out.println("divideBy2 At nth postion 5 	:" + divideBy2(5));//true
		System.out.println("divideBy4 At nth postion 16 :" + divideBy4(16));//true
		
		System.out.println();
		System.out.println("log2 16 :" + log2(16));// true
		System.out.println("log2 14 :" + log2(14));//false
		System.out.println("log2 5 	:" + log2(5));//true
		System.out.println("log2 1 	:" + log2(1));//true
		
		System.out.println();
		System.out.println("isPowerOf2 16 :" + isPowerOf2(16));// true
		System.out.println("isPowerOf2 14 :" + isPowerOf2(14));//false
		
		System.out.println();
		int[] arr = {9, 12, 2, 11, 2, 2, 10, 9, 12, 10, 9, 11, 2};
		System.out.println("odd occuring elements :" + findOddOccuringElement(arr, arr.length));// true
		
		System.out.println();
		System.out.println("Check bits :" + checkKthBit(4, 2));
	}
	/**
	 * Given a number N, the task is to check whether the given number is a power of 2 or not.
	 * @param x
	 * @return
	 */
	public static boolean isPowerOf2(int x) {
		int d = x&(x-1);
		if ( d == 0) {
			return true;
		}
		return false;
	}
	public static int log2(int x) {
		int res = 0;
		while (x > 1) {
			x = x>>1;
			System.out.println(">> after division x:" + x);
			res++;
		}
		return res;
	}
	public static int divideBy4(int num ) {
		int x = num>>2;
		return x;
	}
	public static int divideBy2(int num) {
		int x = num>>1;
		return x;
	}
	public static boolean isBitSetAtNthPosition(int num, int n) {
		int leftShift = leftShift(1, n);
		int x = num&leftShift;
		//System.out.println(">> x:" + x);
		return x!=0;
	}
	public static int toggleBitAtNthPosition(int num, int n) {
		int leftShift = leftShift(1, n);
		return num^leftShift;
	}
	public static int clearBitAtPositionN(int num, int n) {
		int onesValueAtN = leftShift(1, n);
		onesValueAtN = ~onesValueAtN;
		return num&onesValueAtN;
	}
	public static int setBitAtNthPostion(int num, int n) {
		//First left shift the number to nth position.
		int x = leftShift(1, n);
		return num|x;
	}
	public static int rightShift(int a, int k) {
		return a>>k;
	}
	public static int leftShift(int a, int k) {
		int b = a<<k;
		return b;
	}
	public static int bitwiseAnd(int a, int b) {
		return a&b;
	}
	public static boolean isNumberEven(int x) {
		//System.out.println(">>> complement " + (~x));
		//System.out.println(">>> bitwise and :" + (x&1));
		if ((x&1) == 1) {
			return false;
		} else {
			return true;
		}
	}
	public static int findOddOccuringElement(int arr[], int n)
	{
	    int x = arr[0];
	    for (int i = 1; i < n; i++)
	        x = x ^ arr[i];
	    return x;
	}
	
	public static boolean checkKthBit(int n, int k){
        
        int x = 1<<k;
        System.out.println("BitsOperations.checkKthBit() x :" + x);
        System.out.println("BitsOperations.checkKthBit() n&x :" + (n&x));
        if ((n&x) > 0) {
            return true;
        }
        return false;
    }
}
