package imtiaz.tutorial.problemset7;

public class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;
    
	BinaryNode() {
    	
    }
	BinaryNode(int value) {
    	this.data = value;
    }
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
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
	
    @Override
    public String toString() {
    	return "[Data = " + data + "]";
    }
}
