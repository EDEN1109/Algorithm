public class Node implements Comparable<Node>{

	private char symbol;
	private int frequency;
	private Node left;
	private Node right;
	
	public Node() {}
	
	public Node(char symbol, int frequency) {
		this.symbol = symbol;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	
	public boolean isLeaf() {
		if(left==null && right == null)
			return true;
		else
			return false;
	}
	
	
	
	@Override
	public String toString() {
		return "Node (" + symbol + "," + frequency + ")";
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
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
	
	public int compareTo(Node n) {
		
		return this.getFrequency()-n.getFrequency();
	}
	
	
}