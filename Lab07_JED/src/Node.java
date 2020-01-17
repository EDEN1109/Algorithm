
public class Node {
	private double key;
	private Node left;
	private Node right;
	public Node() {
		this.key = 0;
		this.left = null;
		this.right = null;
	}
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	public double getKey() {
		return key;
	}
	public void setKey(double key) {
		this.key = key;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
