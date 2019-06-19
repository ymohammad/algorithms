package com.alysoft.algo.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Haku has been newly hired by Chef to clean tables at his restaurant. So whenever a customer wants a table, Haku must clean it.

But Haku happens to be a lazy boy. So in the morning, when the restaurant is opened, all the tables are dirty from night before.

The customer don't leave the table unless they are politely requested to do so. And customers can order meal later again. So if they were already having a table, they can be served on the same table [Haku doesn't have to clean :)]. But if they don't have a table then they must be given some table [Haku must clean :(]

The restaurant has N tables. When a customer requires a table, he/she can occupy any unoccupied table. However if all tables are occupied, then Haku is free to ask politely any customer to leave his/her table. And the freed table can be given to the waiting customer.

Now Chef has the psychic ability to tell the order of customer meal requests for the entire day. Given this list, help Haku find the minimum number of times he has to clean the tables.

Input
First line contains integer T, number of test cases. First line of each test case contains 2 integers N, number of tables and M, 
number of customer orders. Followed by M integers on next line, which is the order in which customers ask for meal. Customers are 
referenced by integer C.

Output
For each test case output the minimum number of times Haku must clean the table(s).

Constraints
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ M ≤ 400
1 ≤ C ≤ 400
Example
Input:
4
2 4
1 2 3 4
3 2
4 1
3 6
1 2 1 3 4 1
3 5
1 2 1 3 4

Output:
4
2
4
4
Explanation
Example case 1. In the starting all tables i.e. 2 tables are unoccupied. When customer 1 asks for table,
 he can be given any of the 2 tables. Haku has to clean either of the table. Next customer 2 can occupy the other free table. 
 Haku must clean second time. When customer 3 comes Haku can ask either customer 1 or 2 to leave. Suppose he asks customer 1 to leave. 
 Then he has to clean table for the third time. When customer 4 comes, Haku can ask customer 2 or 3 to leave. In either case Haku 
 will have to clean the table for the fourth time. Phew!!

Example case 4. Suppose the tables are listed as [-, -, -]. A possible optimal order of allocating 
tables can be [1, -, -] -> [1, 2, -] -> [1, 2, -] -> [1, 2, 3] -> [4, 2, 3]. So Haku will have to clean table for order no. 1, 2, 4 and 5. 
That is 4 times.
 * @author ymohammad
 *
 */
public class CleaningTables
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            // Input the size of the array
	            String line = br.readLine();
	            String[] split = line.split(" ");
	            int n = Integer.parseInt(split[0]);
	            int m = Integer.parseInt(split[1]);
	            int[] customers = new int[m];
	            
	            line = br.readLine();
	            split = line.split(" ");
	            int i = 0;
	            while (i < m) {
	            	customers[i] = Integer.parseInt(split[i]);
	            	i++;
	            }
	            int tablesCleaned = findWithoutHashing(customers, n);
	            //int tablesCleaned = getMinimumClearning(customers, n, m);
	            System.out.println(tablesCleaned);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}
	public static int findWithoutHashing(int[] arr, int capacity) {
		ArrayList<Integer> s=new ArrayList<>(capacity); 
        int count=0; 
        int page_faults=0; 
        for(int i:arr) 
        { 
            // Insert it into set if not present 
            // already which represents page fault 
            if(!s.contains(i)) 
            { 
	            // Check if the set can hold equal pages 
	            if(s.size()==capacity) 
	            { 
	                s.remove(0); 
	                s.add(capacity-1,i); 
	            } 
	            else
	                s.add(count,i); 
	                // Increment page faults 
	                page_faults++; 
	                ++count; 
            } 
            else
            { 
                // Remove the indexes page 
                s.remove((Object)i); 
                // insert the current page 
                s.add(s.size(),i);          
            } 
          
        } 
        return page_faults; 
    }
	private static int getMinimumClearning(int[] customers, int noOfTables, int noOfCustomers)
	{
		if (noOfCustomers <= noOfTables) return noOfCustomers;
		
		int noOfTablesCleaned = 0;
		Queue<Integer> customerOrderQueue = new LinkedList<Integer>();
		HashMap<Integer, Integer> tableMap = new HashMap<Integer, Integer>();
		
		for (int c : customers) {
			customerOrderQueue.add(c);
		}
		int tableInd = 1;
		while (tableInd<=noOfTables) {
			int nextCustomer = customerOrderQueue.poll();
			if (!tableMap.containsValue(nextCustomer)) {
				tableMap.put(tableInd, nextCustomer);
				noOfTablesCleaned++;
				tableInd++;
			}
		}
		
		while (!customerOrderQueue.isEmpty()) {
			int nextCustomer = customerOrderQueue.poll();
			if (!tableMap.containsValue(nextCustomer)) {
				int tableNumber = getTableNumberCanByEmpty(tableMap, customerOrderQueue);
				tableMap.put(tableNumber, nextCustomer);
				noOfTablesCleaned++;
			}
		}
		
		return noOfTablesCleaned;
	}

	private static int getTableNumberCanByEmpty(HashMap<Integer, Integer> tableMap, Queue<Integer> customerOrderQueue)
	{
		int farthestCustomer = 0;
		int farthestCustomerIndex = 0;
		int farthestSittingCustomerTable = 0;
		
		HashSet<Integer> customerCheckedMap = new HashSet<Integer>();
		Iterator<Integer> iterator = tableMap.keySet().iterator();
		while (iterator.hasNext()) {
			int tableNumber = iterator.next();
			int customerSitting = tableMap.get(tableNumber);
			
			if (!customerOrderQueue.contains(customerSitting)) {
				return tableNumber;
			} else {
				int index = 0;
				Iterator<Integer> custIterator = customerOrderQueue.iterator();
				while (custIterator.hasNext()) {
					Integer next = custIterator.next();
					if (customerCheckedMap.contains(next)) {
						index++;
						continue;
					}
					if (customerSitting == next) {
						customerCheckedMap.add(next);
						if (farthestCustomerIndex <= index) {
							farthestCustomerIndex = index;
							farthestCustomer = next;
							farthestSittingCustomerTable = tableNumber;
							break;
						}
					}
					index++;
				}
			}
		}
		
		return farthestSittingCustomerTable;
	}
	
	//
	public static void main1(String args[])
	{
		int n, m, i, j, k, mn, flag = 0, pgfault = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of pages");
		n = sc.nextInt();
		System.out.println("enter page nos");
		int a[] = new int[n];
		for (i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("Enter no of frames");
		m = sc.nextInt();
		int frm[] = new int[m];
		int whn[] = new int[m];
		for (i = 0; i < m; i++)
		{
			frm[i] = a[i];
			whn[i] = 0;
		}
		for (; i < n; i++)
		{
			for (j = 0; j < m; j++)
			{
				if (frm[j] == a[i])
				{
					flag = 1;
					break;
				} else
					flag = 0;
			}
			if (flag == 0)
			{
				for (j = 0; j < m; j++)
				{
					for (k = i + 1; k < n; k++)
					{
						if (frm[j] == a[k])
							whn[j] = k;
						else
							whn[j] = 0;
					}
				}
				mn = ltr(whn, m);
				frm[mn] = a[i];
				pgfault++;
			}
		}
		pgfault = pgfault + m;
		System.out.println("Optimal algorithm");
		System.out.println("page fault is:" + pgfault);
		System.out.println("page hits are:" + (n - pgfault));
	}

	static int ltr(int whn[], int m)
	{
		int i, mn = 0;
		for (i = 1; i < m; i++)
			if ((whn[i] > whn[i - 1]) && (whn[i] != 0))
				mn = i;
		return mn;
	}
}
