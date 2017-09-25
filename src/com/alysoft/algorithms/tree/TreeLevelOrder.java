package com.alysoft.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeLevelOrder {

	public void levelOrder(BinaryNode rootNode) {
		if (rootNode == null)
			return;
		
		LinkedHashMap<Integer, ArrayList<BinaryNode>> mapObj = new LinkedHashMap<Integer, ArrayList<BinaryNode>>();
		loopEachLevel(mapObj, rootNode, 0);
		
		for (int eachInd = 0; eachInd < mapObj.size(); eachInd++) {
			ArrayList<BinaryNode> listObj = mapObj.get(eachInd);
			for (BinaryNode nodeObj : listObj) {
				System.out.print(nodeObj.getData() + " ");
			}
		}
	}
	public void loopEachLevel(Map<Integer, ArrayList<BinaryNode>> nodesListMap, 
			BinaryNode rootNode, int levelNo) {
		
		if (rootNode == null)
			return;
		
		ArrayList<BinaryNode> listOfNodes = null;
		if (nodesListMap.get(levelNo) == null) {
			listOfNodes = new ArrayList<BinaryNode>();
		} else {
			listOfNodes = nodesListMap.get(levelNo);
		}
		listOfNodes.add(rootNode);
		nodesListMap.put(levelNo, listOfNodes);
		
		levelNo = levelNo+1;
		loopEachLevel(nodesListMap, rootNode.getLeft(), levelNo);
		loopEachLevel(nodesListMap, rootNode.getRight(), levelNo);
	}
	public static void main(String[] args) {
		TreeLevelOrder obj = new TreeLevelOrder();
		/* creating a binary tree and entering 
        the nodes */
       
		//Case 1 -- BAC - INORDER
		System.out.println("\n\n********* Case 1 **************");
		BinaryTree tree = new BinaryTree();
		tree.setRoot(new BinaryNode('A'));
       tree.getRoot().setLeft(new BinaryNode('B'));
       tree.getRoot().setRight(new BinaryNode('C'));
       
       System.out.println("\n******** RECURSIVE - LevelOrder **********");
       obj.levelOrder(tree.getRoot());
       
       
       //Case 2 --  - INORDER
       System.out.println("\n\n********* Case 2 **************");
     	BinaryTree tree2 = new BinaryTree();
     	tree2.setRoot(new BinaryNode('A'));
     	tree2.getRoot().setLeft(new BinaryNode('B'));
     	tree2.getRoot().setRight(new BinaryNode('C'));
     	tree2.getRoot().getLeft().setLeft(new BinaryNode('D'));
     	tree2.getRoot().getLeft().setRight(new BinaryNode('E'));
       
     	System.out.println("\n******** RECURSIVE - LevelOrder **********");
        obj.levelOrder(tree2.getRoot());
        
        System.out.println("\n\n********* Case 3 **************");
     	BinaryTree tree3 = new BinaryTree();
     	tree3.setRoot(new BinaryNode('A'));
     	tree3.getRoot().setLeft(new BinaryNode('B'));
     	tree3.getRoot().setRight(new BinaryNode('C'));
     	
     	tree3.getRoot().getLeft().setLeft(new BinaryNode('D'));
     	tree3.getRoot().getLeft().setRight(new BinaryNode('E'));
     	tree3.getRoot().getRight().setLeft(new BinaryNode('F'));
     	tree3.getRoot().getRight().setRight(new BinaryNode('G'));
       
     	System.out.println("\n******** RECURSIVE - LevelOrder **********");
        obj.levelOrder(tree3.getRoot());
        
        System.out.println("\n\n********* Case 4 **************");
        /*
        1
        \
         2
          \
           5
          /  \
         3    6
          \
           4  
           */
     	BinaryTree tree4 = new BinaryTree();
     	tree4.setRoot(new BinaryNode('1'));
     	tree4.getRoot().setRight(new BinaryNode('2'));
     	
     	tree4.getRoot().getRight().setRight(new BinaryNode('5'));
     	
     	tree4.getRoot().getRight().getRight().setLeft(new BinaryNode('3'));
     	tree4.getRoot().getRight().getRight().setRight(new BinaryNode('6'));
     	
     	tree4.getRoot().getRight().getRight().getLeft().setRight(new BinaryNode('4'));
       
     	System.out.println("\n******** RECURSIVE - LevelOrder **********");
        obj.levelOrder(tree4.getRoot());
	}

}
