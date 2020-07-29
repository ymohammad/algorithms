package com.alysoft.algo.trees;

/**
 * Given a binary tree containing N+1 with N edges nodes and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to a value X.

 Example: For the tree given below:            

              5
            /    \
        -10     3
        /    \    /  \
      9     8  -4 7

Subtree with sum 7:
             -10
            /      \
          9        8

and one node 7.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of edges in the tree. 
Next line contains information as X Y L or X Y R which means Y is on the left of X or Y is on the right of X respectively. Last line contains sum.

Output:
For each test case count the number of subtrees with given sum.

Your Task:
The task is to complete the function countSubtreesWithSumX() which check if there exists a subtree with sum x.

Constraints:
1 <= T <= 103
1 <= N <= 103
-103 <= Node Value <= 103

Example:
Input:
2
6
5 -10 L 5 3 R -10 9 L -10 8 R 3 -4 L 3 7 R
7
2
1 2 L 1 3 R
5

Output:
2
0

Explanation:
Testcase 1: Subtrees with sum 7 are [9, 8, -10] and [7].
 * @author ymohammad
 *
 */
public class CountNumberOfSubTreesSum
{

	int countSubtreesWithSumX(Node root, int x)
    {
        int[] countArr = {0, 0};
    	getSubTreeCount(root, x, countArr);
    	return countArr[0];
    }
    public int getSubTreeCount (Node root, int sum, int[] countArr)
    {
        
        
        if (root == null) return 0;
        
        int leftSum = getSubTreeCount(root.left, sum, countArr);
        int rightSum = getSubTreeCount(root.right, sum, countArr);
        
        //if (root.left == null || root.right == null) return;
        
        int currSum = root.data + leftSum + rightSum;
       // currSum += (root.left != null ? root.left.data : 0);
       // currSum += (root.right != null ? root.right.data : 0);
        
        if (currSum == sum) {
            countArr[0]++;
            //return 0;
        } 
        return currSum;
    }

}
