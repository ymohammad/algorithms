package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Chef likes to write poetry. Today, he has decided to write a X pages long poetry, but unfortunately his notebook has 
 * only Y pages left in it. Thus he decided to buy a new CHEFMATE notebook and went to the stationary shop. Shopkeeper showed 
 * him some N notebooks, where the number of pages and price of the ith one are Pi pages and Ci rubles respectively. 
 * Chef has spent some money preparing for Ksen's birthday, and then he has only K rubles left for now.

Chef wants to buy a single notebook such that the price of the notebook should not exceed his budget and he is able to complete his poetry.

Help Chef accomplishing this task. You just need to tell him whether he can buy such a notebook or not. 
Note that Chef can use all of the Y pages in the current notebook, and Chef can buy only one notebook because 
Chef doesn't want to use many notebooks.


 * Input
	The first line of input contains an integer T, denoting the number of test cases. Then T test cases are follow.
	The first line of each test case contains four space-separated integers X, Y, K and N, described in the statement. 
	The ith line of the next N lines contains two space-separated integers Pi and Ci, denoting the number of pages and price 
	of the ith notebook respectively.

	Output
	For each test case, Print "LuckyChef" if Chef can select such a notebook, otherwise print "UnluckyChef" (quotes for clarity).
	
	Sample
	Input
	3
	3 1 2 2
	3 4
	2 2    
	3 1 2 2
	2 3
	2 3    
	3 1 2 2
	1 1
	1 2
	
	Output
	LuckyChef
	UnluckyChef
	UnluckyChef
 * 
 * @author ymohammad
 *
 */
public class ChefAndNotebooks
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine);
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	String str = br.readLine();
	        	String[] lineSplit = str.split(" ");
	        	int X = Integer.parseInt(lineSplit[0].trim());
	        	int Y = Integer.parseInt(lineSplit[1].trim());
	        	int K = Integer.parseInt(lineSplit[2].trim());
	        	int N = Integer.parseInt(lineSplit[3].trim());
	        	
	        	int[] pagesArr = new int[N];
	        	int[] costArr = new int[N];
	        	for (int i = 0; i<N; i++) {
	        		String pagesNCostStr = br.readLine().trim();
	        		String[] split = pagesNCostStr.split(" ");
	        		int pages = Integer.parseInt(split[0].trim());
	        		int cost = Integer.parseInt(split[1].trim());
	        		pagesArr[i] = pages;
	        		costArr[i] = cost;
	        	}
	        	
	        	findNPrint(X, Y, K, N, pagesArr, costArr);
	            t--;
	        }
	        break;
		}
	}

	private static void findNPrint(int poetryPagesLen, int availPagesNb, int availMoney, int n, int[] pagesArr, int[] costArr)
	{
    	int reqPages = poetryPagesLen-availPagesNb;
    	
    	for (int i = 0; i<n; i++) {
    		if (costArr[i]<= availMoney && reqPages <= pagesArr[i]) {
    			System.out.println("LuckyChef");
    			return;
    		}
    	}
    	System.out.println("UnluckyChef");
	}
}
