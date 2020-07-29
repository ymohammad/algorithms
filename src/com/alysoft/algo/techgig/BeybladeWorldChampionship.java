/*******************************************************************************************************************************
BeybladeWorldChampionship.java

Copyright © 2020, TextCloud.AI Corporation. All rights reserved.
The Programs (which include both the software and documentation) contain proprietary information of TextCloud.AI Corporation;
they are provided under a license agreement containing restrictions on use and disclosure and are also protected by
copyright, patent and other intellectual and industrial property law. Reverse engineering, disassembly or de-compilation of
the programs is prohibited.
Program Documentation is licensed for use solely to support the deployment of the Programs and not for any other
purpose.
The information contained in this document is subject to change without notice. If you find any problems in the
documentation, please report them to us in writing. TextCloud.AI Corporation does not warrant that this document is error free.
Except as may be expressly permitted in your license agreement for these Programs, no part of these Programs may be
reproduced or transmitted in any form or by any means, electronic or mechanical, for any purpose, without the express
written permission of TextCloud.AI Corporation.

Author : ymohammad
Date   : Apr 30, 2020

Last modified by : ymohammad
Last modified on : Apr 30, 2020

*******************************************************************************************************************************/

package com.alysoft.algo.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Class BeybladeWorldChampionship
 * 
 * Beyblade World Championship (100 Marks) Tyson is all prepared for the
 * Beyblade World Championship. The tournament is team-based and each team can
 * have N members. A player can fight against a single player only. Team
 * G-Revolution is all excited and pumped up as they have practised a lot.
 * Kenny, the mind of team G-Revolution, has created a database where he has the
 * data about the power of other teams’ members and his own team members. The
 * tournament is going to start in some time and Kenny moves to the cafeteria to
 * have a snack before the competition.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * The team G-Revolution is to fight in some time and they are tensed up as
 * someone has kidnapped Kenny from the cafeteria. They have made a police
 * complaint and the police are searching for Kenny. Luckily, they have found
 * his device with all the data. The problem is, the data is present randomly
 * and not in the order they have to fight the opponent. Team G-Revolution wants
 * to win at any cost and for that, they need the order in which they have to
 * fight optimally to win the maximum number of battles.
 * 
 * 
 * 
 * A player can win only when his/her beyblade power is strictly greater than
 * the opponents beyblade power.
 * 
 * 
 * 
 * Example:
 * 
 * Consider the team size is 3, N = 3
 * 
 * 
 * The 3 players of both the teams are shown with their beyblade powers.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Team G-Revolution is presented in the order: Tyson, Max, Ray
 * 
 * Team All Starz is presented in the order: Michael, Eddy, Steve
 * 
 * 
 * 
 * With the given arrangement, Team G-Revolution would be able to win only 1
 * fight. Team G-Revolution should be shuffled in an optimal manner as below:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * The maximum number of fights Team G-Revolution can win is 2 when they are
 * arranged optimally or fight in an optimal order.
 * 
 * 
 * 
 * Team G-Revolution needs help with the device. Tyson has heard about your
 * skills and called you up to help them shuffle their positions in an order
 * such that they would be able to win the maximum number of fights. Can you
 * help Tyson and Team G-Revolution?
 * 
 * 
 * 
 * Input Format The first line of input consists of the number of test cases, T
 * 
 * The first line of each test case consists of the number of members each team
 * can have, N.
 * 
 * The second line of each test case consists of N space-separated integers
 * representing the power of beyblades of Team G-Revolution members.
 * 
 * 
 * The third line of each test case consists of N space-separated integers
 * representing the power of beyblades of opponent team members.
 * 
 * 
 * 
 * Constraints 1<= T <=100000 1<= N <=100000
 * 
 * 0<= Power of Beyblade <= LLONG_MAX
 * 
 * 
 * 
 * Output Format For each test case, print the maximum number of fights Team
 * G-Revolution can win if they go to fight in an optimal manner.
 * 
 * Sample TestCase 1 Input 1 10 3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6 Output 7
 */
public class BeybladeWorldChampionship
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t > 0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			long[] ourTeamStrengths = new long[n];
			long[] opponentTeamStrengths = new long[n];

			String line = br.readLine();
			String[] arrayValues = line.trim().split(" ");

			for (int i = 0; i < n; i++)
			{
				ourTeamStrengths[i] = Long.parseLong(arrayValues[i].trim());
			}

			line = br.readLine();
			arrayValues = line.trim().split(" ");

			for (int i = 0; i < n; i++)
			{
				opponentTeamStrengths[i] = Long.parseLong(arrayValues[i].trim());
			}

			int noOfWins = getBattleStatus(ourTeamStrengths, opponentTeamStrengths, n);
			System.out.println(noOfWins);
			t--;
		}
	}

	public static int getBattleStatus(long[] ourTeamStrengths, long[] opponentTeamStrengths, int n)
	{
		int count = 0;
		int playerIndex = 0;
		HashSet<Long> foundPlaces = new HashSet<Long>();
		Arrays.sort(ourTeamStrengths);

		while (playerIndex < n)
		{
			long oppStg = opponentTeamStrengths[playerIndex];
			boolean isFound = searchOptimalOpponent(oppStg, ourTeamStrengths, foundPlaces);
			if (isFound)
			{
				count++;
			}
			playerIndex++;
		}
		return count;
	}

	private static boolean searchOptimalOpponent(long oppStg, long[] arr, HashSet<Long> foundPlaces)
	{
		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high) / 2;
		while (mid >= low && mid <= high)
		{
			if (arr[mid] < oppStg && arr[mid + 1] > oppStg)
			{
				if (!foundPlaces.contains(arr[mid + 1]))
				{
					foundPlaces.add(arr[mid + 1]);
					return true;
				}
				low = mid + 1;
			} 
			else if (arr[mid] > oppStg && arr[mid - 1] < oppStg)
			{
				if (!foundPlaces.contains(arr[mid]))
				{
					foundPlaces.add(arr[mid]);
					return true;
				}
				low = mid + 1;
			} 
			else if (arr[mid] < oppStg)
			{

			}
			mid = (low + high) / 2;
		}
		return false;
	}
}
