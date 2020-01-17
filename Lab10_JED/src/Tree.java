public class Tree implements Comparable<Tree> {

	private Node root;

	public Tree() {}

	public Tree(char symbol, int frequency) {
		root= new Node(symbol,frequency);
	}

	public Tree(Tree t1, Tree t2) {
		this.root = new Node();
		root.setLeft(t1.getRoot());
		root.setRight(t2.getRoot());
		root.setFrequency(t1.getRoot().getFrequency()+t2.getRoot().getFrequency());
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int compareTo(Tree t) {
		return root.getFrequency()-t.getRoot().getFrequency();
	}




}