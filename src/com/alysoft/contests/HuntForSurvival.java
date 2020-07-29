package com.alysoft.contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Many Tribes have been residing in Jungle for a long time now. They have been hunting in the Jungle for their survival. 
 * The continuous increasing size of the tribes has resulted in more hunting for food. This has reached to a level where there is no 
 * animal to hunt in the Jungle now. The tribes have been hungry for a month. 

The oldest member of all the tribes, Vango, called up a meeting of all tribes and suggested a method which will provide them 
food and keep them alive. Vango knows that there is another Jungle which is far from their place.

He suggests that tribes together sent their best two hunters in the other Jungle to hunt and get them food. After hearing him, 
respective tribes have chosen their best hunters. The total has come to N. All the N hunters have been arranged in a line and assigned a 
Unique Identification Number (ID). The first hunter in line is assigned 0, the second hunter assigned 1 and so on till the end of the line.

Vango sees the line and notices that it includes K pair of hunters in which both the hunters are from the same tribe. He does not want 
both the hunters of the same tribe to go to the other Jungle and wants to know the number of pairs that can be made in a way that two 
hunters selected does not belong to the same tribe and can be sent to the other Jungle. 

Vango needs your help with this. Can you help Vango?

Note: There can be more than one pair of the same tribe.

Input Format
The first line of input consists of two space-separated integers, N and K
Next K lines each consists of the IDs of hunters of pairs of same tribes.

Constraints
1<= N <=100000
1<= K <=10000

Output Format
Print the required output in a separate line.

Sample TestCase 1
Input
5 2
1 3
0 4
Output
8
Explanation

Hunter with ID 1 and 3 belong to the same tribe.
Hunter with ID 0 and 4 belong to the same tribe.


Vango wants to know the number of pairs of hunters belonging to different tribes he can choose from.

There are 8 such pairs which can be made following Vango’s wish.

 * @author ymohammad
 *
 */
public class HuntForSurvival
{
	public static void main(char[] arr) {
		
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine = br.readLine();
		while (eachLine == null) {
			eachLine = br.readLine();
		}
		String[] arrs = eachLine.split(" ");
		int N = Integer.parseInt(arrs[0]);
		int K = Integer.parseInt(arrs[1]);
		
		HashSet<Pair> pairSet = new HashSet<Pair>();
		for (int i=0; i<K; i++) {
			eachLine = br.readLine();
			arrs = eachLine.split(" ");
			Integer a = new Integer(arrs[0].trim());
			Integer b = new Integer(arrs[1].trim());
			pairSet.add(new Pair(a, b));
		}

		int x = getCount(N, pairSet);
		System.out.println(x);
	}
	
	private static int getCount(int n, HashSet<Pair> pairSet)
	{
		int r = 0;
		HashSet<Pair> uniqueSet = new HashSet<Pair>();
		for (int i = 0; i<n-1; i++) {
			for (int j = i+1; j<n; j++) {
				Pair p = new Pair(i, j);
				if (!pairSet.contains(p)) {
					uniqueSet.add(p);
				}
			}
		}
		return uniqueSet.size();
	}

	static class Pair {
		Integer x;
		Integer y;
		public Pair(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			Pair pair = (Pair) obj;
			if (pair == null) return false;
			if (this.x == null || this.y == null) return false;
			if (pair.x == null || pair.y == null) return false;
			
			if (this.x.intValue() == pair.x.intValue() && this.y.intValue() == pair.y.intValue()) {
				return true;
			} else if (this.x.intValue() == pair.y.intValue() && this.y.intValue() == pair.x.intValue()) {
				return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			return this.x.hashCode()+this.y.hashCode();
		}
	}
}
