package com.alysoft.hackerearth.compete;

import java.util.*;

/**
 *  A question paper contains  questions. The marks assigned to each correct answer is . 
 *  For each incorrect answer, you will lose  marks. Find the number of different marks that can be obtained in the examination.

	Note: An unattempted question is awarded  marks.
	
	Input format
	
	First line: T denoting the number of test cases
	Each of the next  lines: Three space-separated integers N, a , and b
	
	Output format
	Print the answer to each test case in a different line. (The number of different marks that one can score in an examination).
	
	Explanation
	For test case 1, you will get 0 for not attempting any question, 4 for the correct answer, and -3 for the wrong answer
	
	For test case 2, you will get -2, -1, 0, 1, 2

 * @author ymohammad
 *
 */
public class QuestionPaper
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i<t; i++) {
			long n = s.nextLong();
			int a = s.nextInt();
			int b = s.nextInt();
			
			findQuestions(n, a, b);
		}
	}
	
	public static void findQuestions(long n, int a, int b)
	{
		if (n == 1)
		{
			System.out.println(-b + " " + 0 + " " + a);
		}

		int [] marksArr = new int[] {-b, 0, a};
		
		for (int j = 0; j <= marksArr.length; j++)
		{
			for (int i = 1; i <= n; i++)
			{
				/*temp = num[i];
				num[i] = num[i + 1];
				num[i + 1] = temp;
				print(num, n);*/
			}
		}

	}

}
