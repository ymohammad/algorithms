package com.alysoft.geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given N students with marks obtained by them in an exam. The task is to count the students with same name and marks.

Input: First line of input contains number of testcases T. For each testcase, first line of input contains N, number of students. 
Next N lines contains students name and his marks.

Output: For each testcase, print students name, marks and count of same student with same name and marks, all seperated by space. 
The output is sorted in lexigraphically sorted order of names and if two names are same then those are sorted in decreasing order of marks.

INPUT
1
7
anit 100
anit 50
anit 50
mohan 20
ankit 30
mohan 20
abram 25

anit 100 2
anit 50 1
anit 50 2

Example:
Input:
1
5
john 50
ankit 100
ankit 100
john 60
ankit 30

Output:
ankit 100 2
ankit 30 1
john 60 1
john 50 1

 * @author ymohammad
 *
 */
public class CountStudents
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            Student[] studentArr = new Student[n];
            HashMap<String, Integer> hash = new HashMap<String, Integer>();
            for (int j = 0; j<n; j++) {
            	String line = br.readLine();
                String[] arrayValues = line.trim().split(" ");
                int marks = Integer.parseInt(arrayValues[1]);
                studentArr[j] = new Student(arrayValues[0], marks);
                String key = arrayValues[0]+marks;
                if (hash.containsKey(key)) {
                	hash.put(key, hash.get(key)+1);
                } else {
                	hash.put(key, 1);
                }
            }
            
			printStudenCount(studentArr, hash, n);
            t--;
        }
	}
	
	private static void printStudenCount(Student[] studentArr, HashMap<String, Integer> hash, int n)
	{
		Arrays.sort(studentArr, new Comparator<Student>()
		{
			@Override
			public int compare(Student o1, Student o2)
			{
				if (o1.name.equals(o2.name)) {
					return o1.marks<=o2.marks ? 1 : -1;
				}
				return o1.name.compareTo(o2.name);
			}
		});
		StringBuffer buff = new StringBuffer();
		
		for (Student st : studentArr) {
			String key = st.name+st.marks;
			if (hash.containsKey(key)) {
				buff.append(st.name + " " + st.marks + " " + hash.get(key) + "\n");
				hash.remove(key);
			}
			
		}
		System.out.println(buff);
	}

	static class Student {
		public String name;
		public int marks;
		public Student(String name, int marks) {
			this.name = name;
			this.marks = marks;
		}
		@Override
		public boolean equals(Object obj)
		{
			Student st = (Student)obj;
			return this.name.equals(st.name) && this.marks == st.marks;
		}
		@Override
		public int hashCode()
		{
			return this.name.hashCode();
		}
		@Override
		public String toString()
		{
			return this.name + " -> " + this.marks;
		}
	}
}


