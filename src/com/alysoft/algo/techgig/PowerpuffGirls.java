/*******************************************************************************************************************************
PowerpuffGirls.java

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

/**
 * Class PowerpuffGirls
 * 
 * The Powerpuff Girls (100 Marks)
Professor Utonium is restless because of the increasing crime in the world. The number of villains and their activities has increased to a great extent. The current trio of Powerpuff Girls is not well to fight the evils of the whole world. Professor has decided to create the maximum number of Powerpuff Girls with the ingredients he has.



There are N ingredients required in a certain quantity to create a Powerpuff Girl. Professor has all the N ingredients in his laboratory and knows the quantity of each available ingredient. He also knows the quantity of a particular ingredient required to create a Powerpuff Girl. Professor is busy with the preparations and wants to start asap.



The villains, on the other hand, want to destroy the laboratory and stop Professor Utonium from creating more Powerpuff girls. Mojo Jojo is coming prepared with ammunition and Him is leading other villains like Princess, Amoeba Boys, Sedusa, Gangreen Gang etc.







Professor does not have much time as villains will reach the laboratory soon. He is starting the process but does not know the number of Powerpuff Girls which will be created. He needs your help in determining the maximum number of Powerpuff Girls which will be created with the current quantity of ingredients. 



Example:

Professor Utonium requires 3 ingredients to make Powerpuff Girls. The 3 ingredients are present in the laboratory in the given quantity:







To make a Powerpuff Girl, Professor Utonium requires:

3 units of Ingredient A

6 units of Ingredient B

10 units of Ingredient C



The maximum number of Powerpuff Girls which can be created are 3 as after 3, Professor will run out of Ingredient C.





Image Source: Google



Can you determine the maximum number?



Input Format
The first line of input consists of the number of ingredients, N

The second line of input consists of the N space-separated integers representing the quantity of each ingredient required to create a Powerpuff Girl.


The third line of input consists of the N space-separated integers representing the quantity of each ingredient present in the laboratory.



Constraints
1<= N <=10000000 (1e7)

0<= Quantity_of_ingredient <= LLONG_MAX 



Output Format
Print the required output in a separate line.

Sample TestCase 1
Input
4
2 5 6 3 
20 40 90 50 
Output
8
 */
public class PowerpuffGirls
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String line = br.readLine();
		String[] arrayValues = line.trim().split(" ");
		long[] reqQty = new long[n];
		int i = 0;
		for (String s : arrayValues)
		{
			if (s != null && s.trim().length() > 0)
			{
				reqQty[i] = Long.parseLong(s.trim());
				i++;
			}
		}

		line = br.readLine();
		arrayValues = line.trim().split(" ");
		long[] availQty = new long[n];
		i = 0;
		for (String s : arrayValues)
		{
			if (s != null && s.trim().length() > 0)
			{
				availQty[i] = Long.parseLong(s.trim());
				i++;
			}
		}

		printNumberOfPG(n, reqQty, availQty);
	}

	private static void printNumberOfPG(int n, long[] reqQty, long[] availQty)
	{
		long minVal = Long.MAX_VALUE;
		for (int i = 0; i<n; i++) {
			long div = availQty[i]/reqQty[i];
			if (div<minVal) {
				minVal = div;
			}
		}
		System.out.print(minVal);
	}
}
