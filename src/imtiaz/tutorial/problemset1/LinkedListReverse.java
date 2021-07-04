package imtiaz.tutorial.problemset1;

public class LinkedListReverse {
	
	public static void main(String[] args) {
		Node parentNode = new Node("A", new Node("B", new Node("C", null)));
		Node solutionNode = null;
		reverseLinkedList(parentNode, solutionNode);
	}


	
	private static void reverseLinkedList(Node parentNode, Node solutionNode) {
		
	}



	private static class Node {
		String data;
		Node next;
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
