package com.alysoft.algo.arrays;

/**
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between 
 * those days your profit is maximum.

Input: 
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, 
followed by an array of stock prices of N days. 

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

User Task:
The task is to complete the function stockBuySell() which finds the days of buying and selling stock and print them. The newline is 
automatically added by the driver code.

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
 * @author ymohammad
 *
 */
public class StockBuyAndSell
{
	public static void main(String[] args)
	{
		//int[] price = {100, 180, 260, 310, 40, 535, 695};
		//int[] price = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
		int[] price = {52, 10, 2, 1};
		stockBuySell(price, price.length);
	}
	static void stockBuySell(int price[], int n) 
	{
        int i = 0;
        StringBuffer buff = new StringBuffer();
        while (i<n-1) {
        	
        	//Find the local minima to do buy.
        	while (i<(n-1) && price[i]>=price[i+1]) {
        		i++;
        	}
        	if (buff.length() == 0 && i == (n-1)) {
        		buff.append("No Profit");
        		break;
        	}
        	buff.append("(" + i + " ");
        	i++;
        	//Find the local maxima to do sell.
        	while (i<n && price[i]>price[i-1]) {
        		i++;
        	}
        	buff.append((i-1) + ") ");
        }
        System.out.println(buff.toString());
    }
}
