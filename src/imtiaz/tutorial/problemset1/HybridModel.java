package imtiaz.tutorial.problemset1;


public class HybridModel {
	
	public static void main(String[] args) {
		
		/**
		 * 						7
		 * 					6		3
		 * 				12		  2		5
		 */
		BinaryNode rootNode = new BinaryNode(7);
		
		BinaryNode left = new BinaryNode(6);
		left.setLeft(new BinaryNode(12));
		
		rootNode.setLeft(left);
		
		BinaryNode right = new BinaryNode(3);
		right.setRight(new BinaryNode(5));
		right.setLeft(new BinaryNode(2));
		
		rootNode.setRight(right);
		
		int sum = getLeftLeafNodeSum(rootNode, false);
		System.out.println(sum);
	}
	
	
	
	private static int getLeftLeafNodeSum(BinaryNode node, boolean isLeftNode) {
		
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			if (isLeftNode) {
				return node.data;
			} else {
				return 0;
			}
		}
		
		int leftNodeSum = getLeftLeafNodeSum(node.getLeft(), true);
		int rightNodeSum = getLeftLeafNodeSum(node.getRight(), false);
		
		return leftNodeSum+rightNodeSum;
	}



	//Tree
	static class BinaryNode {
		private int data;
		private BinaryNode left;
		private BinaryNode right;
		
		public BinaryNode(int item) {
			this.data = item;
			this.left = this.right = null;
		}
		public BinaryNode(int item, BinaryNode left, BinaryNode right) {
			this.data = item;
			this.left = left;
			this.right = right;
		}
		public int getData() {
			return data;
		}

		public void setData(char data) {
			this.data = data;
		}

		public BinaryNode getLeft() {
			return left;
		}

		public void setLeft(BinaryNode left) {
			this.left = left;
		}

		public BinaryNode getRight() {
			return right;
		}

		public void setRight(BinaryNode right) {
			this.right = right;
		}
	}
}
