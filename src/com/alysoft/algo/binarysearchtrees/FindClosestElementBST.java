package com.alysoft.algo.binarysearchtrees;

import com.alysoft.algo.trees.Node;

/**
 * 
 * Given a BST with N nodes and a target node K. The task is to find an integer having minimum absolute difference with given 
 * target value K and return this difference.

Input Format:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists 
of three lines. First line of each test case contains an integer N denoting the number of nodes in the BST . Second line of each test case 
consists of 'N' space separated integers denoting the elements of the BST. These elements are inserted into BST in the given order.
The last line of each test case contains an integer k as specified in problem statement.

Output Format:
The output for each test case will be the minimum absolute difference of a node with given target value K.

Your Task:
This is a function problem. You don't have to take any input. Just complete the function maxDiff() that takes node and K as parameter and 
returns the minimum difference.

Constraints:
1 <= T <= 100
1 <= N <= 200

Example:
Input:
2
9
9 4 3 6 5 7 17 22 20
18
9
9 4 3 6 5 7 17 22 20
4   

Output:
1
0

Explanation:

Testcase1:
K=18. The node that has value nearest to K is 17 so it's difference with k is the answer.
Testcase2:
K=4. The node that has value nearest to K is 4 so it's difference with k is the answer.
 * @author ymohammad
 *
 */
public class FindClosestElementBST
{

	public static void main(String[] args)
	{
		
	}
	/**
	 * 1. create a vector or list to keep nodes in increasing order by traversing tree inorder way.
	 * 2. While traversing list compute absolute difference of k with elements of list. The difference would be as such, 
	 * 		at first it will go on decreasing after which difference increases you have to return the last difference which was in 
	 * 		decreasing order.
	 * @param root
	 * @param k
	 * @return
	 */
	public static int maxDiff1(Node root, int k)
    {
		return k;
        /*int floor = findFloor(root, k);
        int ceil = findCeil(root, k);
        
        int minFloor = Math.abs(k-floor);
        int minCeil = Math.abs(k-ceil);
        return Math.min(minFloor, minCeil);*/
    }
	
	//Editorial....
	// Function to find node with minimum absolute
    // difference with given K
    // min_diff   -. minimum difference till now
    // min_diff_key  -. node having minimum absolute
    //                   difference with K
    static int min_diff, min_diff_key; 
    static void maxDiffUtil(Node  ptr, int k)
    { 
        if (ptr == null) 
            return ; 
       
        // If k itself is present 
        if (ptr.data == k) 
        { 
            min_diff_key = k; 
            return; 
        } 
       
        // update min_diff and min_diff_key by checking 
        // current node value 
        if (min_diff > Math.abs(ptr.data - k)) 
        { 
            min_diff = Math.abs(ptr.data - k); 
            min_diff_key = ptr.data; 
        } 
       
        // if k is less than ptr.data then move in 
        // left subtree else in right subtree 
        if (k < ptr.data) 
            maxDiffUtil(ptr.left, k); 
        else
            maxDiffUtil(ptr.right, k); 
    } 
       
    // Wrapper over maxDiffUtil() 
    static int maxDiff(Node  root, int k) 
    { 
        // Initialize minimum difference 
        min_diff = Integer.MAX_VALUE; min_diff_key = -1; 
       
        // Find value of min_diff_key (Closest data 
        // in tree with k) 
        maxDiffUtil(root, k); 
       
        return Math.abs(min_diff_key-k);
    } 
}
