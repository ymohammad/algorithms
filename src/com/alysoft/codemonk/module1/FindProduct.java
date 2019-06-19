package com.alysoft.codemonk.module1;

import java.util.Scanner;

public class FindProduct
{

	public static void main(String[] args ) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long answer = 1L;
        for (int i = 0; i< n; i++) {
        	answer = (long) ((answer * s.nextInt()) % (Math.pow(10, 9) + 7));
        }
        System.out.println(answer);
	}
}
