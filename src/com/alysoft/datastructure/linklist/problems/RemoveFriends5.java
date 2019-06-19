import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class RemoveFriend5
{
	public static void Pseudo(int k, int popularity[])
	{
		Deque<Integer> dqu = new LinkedList();
		dqu.add(popularity[0]);
		for (int i = 1; i < popularity.length; i++)
		{
			if (dqu.peekLast() < popularity[i] && k > 0)
			{
				while (dqu.size() > 0 && dqu.peekLast() < popularity[i] && k > 0)
				{
					dqu.removeLast();
					k--;
				}
			}
			dqu.add(popularity[i]);
		}
		while (dqu.size() > 0)
			System.out.print(dqu.removeFirst() + " ");
		System.out.println();

	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++)
		{
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int arr[] = new int[n];
			for (int j = 0; j < n; j++)
				arr[j] = Integer.parseInt(input[j]);
			Pseudo(k, arr);
		}
		// System.out.println(output);

	}
}