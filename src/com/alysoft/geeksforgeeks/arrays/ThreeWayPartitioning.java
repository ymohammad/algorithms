package com.alysoft.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array A and a range [lowVal, highVal]. The task is to complete the function  threeWayPartition 
 * which partition the array around the range such that array is divided in three parts.
	1) All elements smaller than lowVal come first.
	2) All elements in range lowVal to highVal come next.
	3) All elements greater than highVal appear in the end.
	The individual elements of three sets can appear in any order. You are required to return the modified arranged array.
	
	Input:
	The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
	Each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array (A[]).
	
	Output:
	For each test case the output will be 1 if the array is properly arranged else it would be 0.
 * @author ymohammad
 *
 */
public class ThreeWayPartitioning
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		int N=sc.nextInt();
		ArrayList<Integer> A=new ArrayList<>();
		int[] hash=new int[1000001];
		Arrays.fill(hash,0);
		for(int i=0;i<N;i++){
		A.add(i,sc.nextInt());
		hash[A.get(i)]++;
		}
		int n=sc.nextInt();
		int m=sc.nextInt();
		ArrayList<Integer> B=new ArrayList<>();
		for(int i=0;i<A.size();i++)
		{
			B.add(i,A.get(i));
		}
        int k1=0,k2=0,k3=0;
        int kk1=0;int kk2=0;int kk3=0;
        for(int i=0;i<B.size();i++)
        {
        	if(B.get(i)>m)
        	{
        		k3++;
        	}else if(B.get(i)<=m && B.get(i)>=n)
        	{
        		k2++;
        	}else if(B.get(i)<m)
        	k1++;
        }
		ArrayList<Integer> Res = threeWayPartition(A,n,m);
      	for(int i=0;i<k1;i++)
      	{
      		if(Res.get(i)<m)
      		kk1++;
      	}
      	for(int i=k1;i<k1+k2;i++)
      	{
      		
      		if(Res.get(i)<=m && Res.get(i)>=n)
      		kk2++;
      		
      	}
      	for(int i=k1+k2;i<k1+k2+k3;i++)
      	{
      		if(Res.get(i)>m)
      		kk3++;
      	}
      	boolean ok = false;
      	if(k1==kk1 && k2 ==kk2 && k3 == kk3)
      	ok = true;
	
	for(int i=0;i<Res.size();i++)
      		hash[Res.get(i)]--;
      	
      	for(int i=0;i<Res.size();i++)
      	if(hash[Res.get(i)]!=0)
      	ok=false;
      	
	if(ok)
		System.out.println(1);
		else
		System.out.println(0);
		}
	}

	private static ArrayList<Integer> threeWayPartition(ArrayList<Integer> a, int low, int high)
	{
		int start = 0;
		int end = a.size()-1;
		
		int i = 0;
		while (i<=end) {
			if (a.get(i)<low) {
				swapValues(a, i, start);
				start++;
			} else if (a.get(i)>high) {
				swapValues(a, i, end);
				end--;
			} else {
				i++;
			}
		}
		//System.out.println(a);
		return a;
	}
	public static void swapValues(ArrayList<Integer> a, int from, int to) {
		int temp = a.get(from);
		a.set(from, a.get(to));
		a.set(to, temp);
	}

}
