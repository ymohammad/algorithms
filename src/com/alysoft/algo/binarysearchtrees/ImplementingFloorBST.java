package com.alysoft.algo.binarysearchtrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.alysoft.algo.trees.Node;

/**
 * Given an array arr[] of N positive integers to be inserted into BST and a positive integer X. The task is to find floor of X in the BST.
Floor(X) is an element that is either equal to X or immediately smaller to X.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements to be inserted in BST, next line contains N elements.

Output:
For each testcase, print the greatest smaller element of X.

Your task:
You don't need to worry about the insert function, just complete the function floor() which should return floor of X.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
4
6
7 8 3 4 1 9
3

Output:
4
3

Explanation:
Testcase 1: We find 4 in the BST to floor of 4 is 4.
Testcase 2: We find 3 in the BST to floor of 3 is 3.
 * @author ymohammad
 *
 */
public class ImplementingFloorBST
{

	static Node insertInBST(Node root, int key) { 
        if (root == null) return new Node(key); 
	    if (key < root.data) root.left = insertInBST(root.left, key); 
	    else root.right = insertInBST(root.right, key); 
	    return root; 
    }
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    Node root = null;
		    inputLine = br.readLine().trim().split(" ");
		    root = insertInBST(root, Integer.parseInt(inputLine[0]));
		    for(int i=1; i<n; i++){
		        insertInBST(root, Integer.parseInt(inputLine[i]));
		    }
		    int k = Integer.parseInt(br.readLine().trim());
		    System.out.println(floor(root, k));
		}
	}

    //Editorial..
    int floor2(Node root, int key) { 
        
        // base case
        if (root == null)
            return Integer.MAX_VALUE;
        
        // check if data is equal to key
        if (root.data == key) return root.data; 
        
        // recurse left if data is greater than key
        if (root.data > key) return floor(root.left, key); 
        
        // else recurse for right
        int floorValue = floor(root.right, key); 
	    
	    // if floorValue is less than or equal to key
	    // then return this value
	    if(floorValue <= key) return floorValue;
	    
	    // else return the data of root itself
	    else return root.data; 
    } 
    static int floor(Node root, int key) { 
        
        if (root == null) return Integer.MAX_VALUE;
        
        if (root.left == null && root.right == null) return root.data;
        
        if (root.data == key) return root.data;
        
        //if (root.left != null && root.left.data <= key) return
        
        int leftMin = floor(root.left, key);
        int rightMin = floor(root.right, key);
        
        leftMin = (leftMin > key) ? Integer.MIN_VALUE : leftMin;
        rightMin = (rightMin > key) ? Integer.MIN_VALUE : rightMin;
        int rootData = (root.data > key) ? Integer.MIN_VALUE : root.data;
        
        int min = Math.max(leftMin, rightMin);
        min = Math.max(min, rootData);
        return min;
    
    } 
    public static Node getLowestElement(Node root, int key) {
        while (root.left != null || root.right != null) {
            if (root.data <= key) {
                if (root.right != null && root.right.data <= key) {
                    root = root.right;
                } else if (root.left != null && root.left.data <= key) {
                    root = root.left;
                } else {
                    break;
                }
            } else if (root.left != null) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
