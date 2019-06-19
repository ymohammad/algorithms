package com.alysoft.datastructure.linklist.problems;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveFriends3
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++)
		{
			int n = s.nextInt(), rem = s.nextInt();
			LinkedList<Integer> l = new LinkedList<>();

			for (int j = 0; j < n; j++)
				l.add(s.nextInt());

			for (int j = 0; j < rem; j++)
			{
				boolean flag = false;
				for (int k = 0; k < n; k++)
				{
					if (k + 1 < l.size() && l.get(k) < l.get(k + 1))
					{
						l.remove(k);
						flag = true;
						break;
					}
				}

				if (!flag)
					l.removeLast();

			}
			for (int j : l)
				System.out.print(j + " ");
			System.out.println("");

		}
	}
}
