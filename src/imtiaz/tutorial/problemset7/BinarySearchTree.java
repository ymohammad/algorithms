package imtiaz.tutorial.problemset7;

public class BinarySearchTree {
	public static int kthLowest = 1;
	public static int kthLargest = 3;
	public static void main(String[] args) {
		 /* Let us create following BST
		        50
		     /     \
		    30      70
		   /  \    /  \
		 20   40  60   80 
		 				\
		 				85
		 */
		BinaryNode root = new BinaryNode(50);
		root.left = new BinaryNode(30);
		root.right = new BinaryNode(70);
		
		root.left.left = new BinaryNode(20);
		root.left.right = new BinaryNode(40);
		
		root.right.left = new BinaryNode(60);
		root.right.right = new BinaryNode(80);
		root.right.right.right = new BinaryNode(85);
		
		System.out.println("Is BST :" + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("INORDER TRAVERSER");
		inOrderTraverser(root);
		
		System.out.println("\n" + kthLowest + " Lowest Element is");
		kthLowestElement(root, new BinaryNode(0));
		
		System.out.println("\n\nREVERSE INORDER TRAVERSER");
		reverseInOrderTraverser(root);
		
		System.out.println("\n\nkth Largest Element");
		kthLargestElement(root, new BinaryNode(0));
		
		

	}
	public static void findLowestCommonAncestor(BinaryNode root, int x, int y) {
		
	}
	public static boolean isMirror(BinaryNode tree1, BinaryNode tree2) {
		if (tree1 == null && tree2 == null) return true;
		
		if (tree1== null || tree2 == null) return false;
		
		return (tree1.data == tree2.data && isMirror(tree1.left, tree2.right));
	}
	public static void kthLargestElement(BinaryNode root, BinaryNode counterNode) {
		if (root == null || counterNode.data > kthLargest) return;
		
		kthLargestElement(root.right, counterNode);
		
		counterNode.data = counterNode.data+1;
		if (counterNode.data == kthLargest) 
			System.out.print(root.data + " ");
		
		kthLargestElement(root.left, counterNode);
	}
	public static void reverseInOrderTraverser(BinaryNode root) {
		if (root == null) return;
		
		reverseInOrderTraverser(root.right); 
		System.out.print(root.data + " ");
		reverseInOrderTraverser(root.left);
	}
	public static void kthLowestElement(BinaryNode root, BinaryNode counterNode) {
		if (root == null || counterNode.data > kthLowest) return;
		
		kthLowestElement(root.left, counterNode);
		counterNode.data = counterNode.data+1;
		if (counterNode.data == kthLowest) 
			System.out.print(root.data + " ");
		
		kthLowestElement(root.right, counterNode);
	}
	public static void inOrderTraverser(BinaryNode root) {
		if (root == null) return;
		
		inOrderTraverser(root.left); 
		System.out.print(root.data + " ");
		inOrderTraverser(root.right);
	}
	public static boolean isBST(BinaryNode rootNode, int lb, int up) {
		if (rootNode == null) return true;
		
		if (lb > rootNode.data || rootNode.data > up) return false;
		
		return isBST(rootNode.left, lb, rootNode.data) && isBST(rootNode.right, rootNode.data, up);
	}
}
