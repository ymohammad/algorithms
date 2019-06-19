package com.alysoft.algorithms.hackerrank.arrays;

import java.util.Hashtable;
import java.util.Scanner;

public class SparseArrays {
	private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N = Integer.parseInt(scan.nextLine().trim());

        //String[] stringsItems = scan.nextLine().split(" ");
        Hashtable<String, Integer> stringsTable = new Hashtable<>();
        for (int stringsItr = 0; stringsItr < N; stringsItr++) {
            String stringsItem = scan.nextLine();
            if (stringsTable.containsKey(stringsItem)) {
                stringsTable.put(stringsItem, stringsTable.get(stringsItem) + 1);
            } else {
                stringsTable.put(stringsItem, 1);
            }
        }

        int Q = Integer.parseInt(scan.nextLine().trim());

        //String[] queries = new String[Q];

        String[] queriesItems = new String[Q];

        for (int queriesItr = 0; queriesItr < Q; queriesItr++) {
            String queriesItem = scan.nextLine();
            queriesItems[queriesItr] = queriesItem;
        }
        for (String queryItem: queriesItems) {
        	if (stringsTable.containsKey(queryItem)) {
                System.out.println(stringsTable.get(queryItem));
            }
        }
    }
}
