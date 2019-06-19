package com.alysoft.algo.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Neighbours and New Year Party (100 Marks)
In the XYZ society, the neighbours hate each other for their attitude. Various activities are organized in the society for Welcoming the New Year. 
The tickets were provided to each house with an integer written on it. Some got tickets with positive integers and some got tickets with 
negative integers. In the evening, people had to carry their tickets to the club house where the eligible ones will get the exciting gifts. 
The eligibility of winning the gift depends on the maximum sum which can be formed from the tickets numbers keeping in mind that neighbours 
hate each other. Since the neighbours hate each other, the two cannot be together in the list of maximum sum. 

The President of the society, Mr. Singh, is a wise men and know that neighbours in society don't like each other. 
Also, he don't wish to become bad in front of people. So, he came up with an idea to design a program which will provide the list 
of integers forming maximum sum and thus all the members of the list will be given the gifts. The only problem with this idea is that
 he don't know programming so he is asking you to provide the correct list of integers. The people may be annoying but are smart and will 
 fight if the list provided by you doesn't form the maximum sum.


Note: The integer written on ticket of individuals may or may not be unique. In case, when there are two list with equal maximum sum, 
the list with first greater element would be considered. For better understanding, look at the explanation of Test case 4 in Sample Test Case. 
The tickets with integer 0 are not considered for winning the gifts.


Input Format
The first line of input consist of number of test cases, T.

The first line of each test case consist of the number of houses (tickets distributed) in society, N.

The second line of each test case consist of N space separated tickets with integer written on them.




Constraints
1<= T <=10

1<= N <=10000

-1000<= Integer_on_Ticket <=1000



Output Format
For each test case, print the ticket numbers in a single line forming the maximum sum in the format similar to Sample Test Case.

Sample TestCase 1
Input
5
5
-1 7 8 -5 4 
4
3 2 1 -1 
4 
11 12 -2 -1 
4
4 5 4 3 
4
5 10 4 -1
Output
48
13
12
44
10
Explanation
Test Case 1: Maximum sum which can be formed is 12. Element considered 8, 4. Note that Output is printed from the reverse side 
of the array which is TRUE for all the test cases without the space. So, the output is 48.
Test Case 2: Maximum sum which can be formed is 4. Element considered 3, 1. Output = 13.
Test Case 3: Maximum sum which can be formed is 12 as by taking any other element value of maximum sum decreases.
Test Case 4: Maximum sum which can be formed is 8 by taking 3, 5 or 4, 4. But the output is 4, 4 as 3 is smaller than 4.
Test Case 5: Maximum sum which can be formed is 10.
 * @author ymohammad
 *
 */
public class NeighboursAndNewYearParty
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        while (t > 0)
        {
        	int n = Integer.parseInt(br.readLine().trim());
        	int[] neighboursArray = new int[n];
            
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            for (int i = 0; i<n; i++) {
            	neighboursArray[i] = Integer.parseInt(arrayValues[i].trim());
            }
            
            String maxSumOutput = getMaxSum(neighboursArray, n);
			System.out.println(maxSumOutput);
            t--;
        }
	}
	static class MaxSumPath {
		private int sum;
		private StringBuffer path = null;
		
		public MaxSumPath() {
			path = new StringBuffer();
		}
		public MaxSumPath(int sum, int path) {
			this();
			this.sum = sum;
			this.path.append(path);
		}
		public MaxSumPath(int sum, String path) {
			this();
			this.sum = sum;
			this.path.append(path);
		}
		
		public String getPath()
		{
			return this.path.toString();
		}
		public void setPath(String path)
		{
			this.path.append(path);
		}
		public void setPath(int path)
		{
			this.path = new StringBuffer();
			this.path.append(path);
		}
		public void appendPath(int path)
		{
			this.path.append(path);
		}
		public int getSum()
		{
			return this.sum;
		}
		public void setSum(int sum)
		{
			this.sum = sum;
		}
		@Override
		public String toString()
		{
			return "MaxSumPath [sum=" + this.sum + ", path=" + this.path + "]";
		}
		
	}

	private static String getMaxSum(int[] neighboursArray, int n)
	{
		MaxSumPath prev = new MaxSumPath(neighboursArray[n-1], neighboursArray[n-1]);
		MaxSumPath prevTwo = new MaxSumPath(); 
		MaxSumPath currentMax; 
        int i; 
  
        for (i = n-2; i >=0; i--) 
        { 
            /* current max excluding i */
        	
            currentMax = getMax(prevTwo, prev); 
            prev = getPreviousMax(neighboursArray[i], prevTwo);
            prevTwo = currentMax; 
        } 
        String maxSumPath = getReturnPath(prev, prevTwo);
        return maxSumPath; 
	}
	private static String getReturnPath(MaxSumPath val1, MaxSumPath val2)
	{
		if (val1.getSum() > val2.getSum()) {
			return val1.getPath();
		} else if (val1.getSum() < val2.getSum()) {
			return val2.getPath();
		} else {
			int val1FirstChar = Character.getNumericValue(val1.getPath().charAt(0));
			int val2FirstChar = Character.getNumericValue(val2.getPath().charAt(0));
			if (val1FirstChar < val2FirstChar) {
				return val2.getPath();
			} else {
				return val1.getPath();
			}
		}
	}
	private static MaxSumPath getPreviousMax(int currentValue, MaxSumPath prevTwo)
	{
		if (currentValue > (prevTwo.getSum() + currentValue)) {
			prevTwo = new MaxSumPath(currentValue, currentValue);
		} else {
			prevTwo = new MaxSumPath(prevTwo.getSum() + currentValue, prevTwo.getPath() + currentValue);
		}
		return prevTwo;
	}
	private static MaxSumPath getMax(MaxSumPath prevTwo, MaxSumPath prev)
	{
		return (prev.getSum() > prevTwo.getSum()) ? prev : prevTwo;
	}
	private static String getMaxSumOld(int[] neighboursArray, int n)
	{
		int loopStartInd = n-1;
		int maxSum = 0;
		String currentMaxElements = null;
		
		while (loopStartInd >=0) {
			int localSum = 0;
			StringBuffer localElms = new StringBuffer();
			int i = loopStartInd;
			while (i >= 0) {
				if (neighboursArray[i] < 0) {
					i--;
				} else {
					localSum += neighboursArray[i];
					localElms.append(neighboursArray[i]);
					i = i-2;
				}
			}
			if (localSum > maxSum) {
				maxSum = localSum;
				currentMaxElements = localElms.toString();
			} else if (localSum == maxSum) {
				if (currentMaxElements != null) {
					int maxElmChar = Character.getNumericValue(currentMaxElements.charAt(0));
					int currentElmChar = Character.getNumericValue(localElms.charAt(0));
					if (maxElmChar < currentElmChar) {
						maxSum = localSum;
						currentMaxElements = localElms.toString();
					}
				} else {
					maxSum = localSum;
					currentMaxElements = localElms.toString();
				}
			}
			loopStartInd--;
		}
		return currentMaxElements;
	}
}
