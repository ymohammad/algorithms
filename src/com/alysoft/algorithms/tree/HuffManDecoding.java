package com.alysoft.algorithms.tree;

public class HuffManDecoding {
	
	public static void main(String[] args) {
		/*
         		 {$,5}
		      0 /     \ 1
		     {$,2}   {A,3}
		    0/   \1
		{B,1}  {C,1}  
		
		S="1001011"
	  */
	 HuffManDecoding huffDecodeTree = new HuffManDecoding();
	 Node root = new Node('$');
	 root.left = new Node('$');
	 root.right = new Node('A');
	 root.left.left = new Node('B');
	 root.left.right = new Node('C');
	 
	 String encodedString = "1001011";
	 System.out.println("Decoded String :" + huffDecodeTree.getDecodeString(encodedString, root));
	 System.out.println("Decoded String of Decode method:");
	 huffDecodeTree.decode(encodedString, root);
	 
	}
	public Node generateEncodedHuffmanTree() {
		
		return null;
	}
	public String getDecodeString(String encodedString, Node rootNode) {
		if (rootNode == null || encodedString == null || encodedString.trim().length() == 0)
			return null;
		
		StringBuffer decodedStringBuff = new StringBuffer();
		String[] encodedCodeArr = encodedString.split("");
		int currentArrInd = 0;
		while (true) {
			if (currentArrInd > encodedCodeArr.length-1)
				break;
			
			Node tempNode = rootNode;
			while (tempNode != null) {
				String charCode = encodedCodeArr[currentArrInd];
				if (charCode.equals("0")) {
					tempNode = tempNode.left;
					if (isLeafNode(tempNode)) {
						decodedStringBuff.append(tempNode.data);
						tempNode = null;//reset the pointer now.
					}
				} else {
					tempNode = tempNode.right;
					if (isLeafNode(tempNode)) {
						decodedStringBuff.append(tempNode.data);
						tempNode = null;//reset the pointer now.
					}
				}
				currentArrInd++;
			}
		}
		return decodedStringBuff.toString();
	}

	private static boolean isLeafNode(Node leftNode) {
		if (leftNode == null) return true;
		return leftNode.right == null && leftNode.left == null;
	}
	
	void decode(String encodedString, Node rootNode)
    {
        if (rootNode == null || encodedString == null || encodedString.trim().length() == 0)
			return;
		
		StringBuffer decodedStringBuff = new StringBuffer();
		int codeLength = encodedString.length();
		Node tempNode = rootNode;
		for (int ind = 0; ind<codeLength; ind++) {
			tempNode = encodedString.charAt(ind) == '1'? tempNode.right : tempNode.left;
			if (tempNode.right == null && tempNode.left == null) {
				decodedStringBuff.append(tempNode.data);
				tempNode = rootNode;
			}
		}
		System.out.println(decodedStringBuff.toString());
    }
}
