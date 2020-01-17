import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

	private String text;
	private int[] frequencies;
	private Tree htree;
	private String[] codes;
	
	public Huffman(String t) {
		this.text=t;
		getFrequencies();
		htree=buildHuffmanTree();
		Node root=htree.getRoot();
		levelRoder(root);
		this.codes=new String[256];
		buildCode(codes,root," ");
		printCodes();
		
		
	}
	
	private void buildCode(String[] st,Node node, String s) {
		if(node.isLeaf()) 
			st[(int)node.getSymbol()]=s;
		else {
			buildCode(st,node.getLeft(),s+"0");
			buildCode(st,node.getRight(),s+"1");
		}
	}
	
	private void printCodes() {
		
		System.out.println();
		System.out.println(" ASCII	" + "	Char	"+"	Frequency   "+"   Code   ");
		for(int i=0;i<codes.length;i++)
			if(frequencies[i]!= 0)
				System.out.println(i + "		"+(char)i+"		"+frequencies[i]+"		"+codes[i]);
	}
	
	private void levelRoder(Node root) {
		if(root == null)
			return;
		
		Queue<Node> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node curr= q.poll();
			if(curr.getLeft()!= null)
				q.add(curr.getLeft());
			if(curr.getRight()!= null)
				q.add(curr.getRight());
			if(Character.isLetter(curr.getSymbol()))
				System.out.print(curr.toString()+" ");
				
		}
	}
	
	private Tree buildHuffmanTree() {
		Tree t = new Tree();
		PriorityQueue<Tree> PQ = new PriorityQueue<Tree>();
		
		for(int i=0;i<frequencies.length;i++) {
			
			if(frequencies[i]>0)
				PQ.add(new Tree((char)i,frequencies[i]));
		}
		
		while(PQ.size()>1) {
			Tree t1=PQ.remove();
			Tree t2=PQ.remove();
			PQ.add(new Tree(t1,t2));
		}
		
		t = PQ.remove();
		
		return t;
	}
	
	private void getFrequencies() {
		frequencies = new int[256];
		for(int i=0;i<text.length();i++) 
			frequencies[(int)text.charAt(i)]++;
			
	}
}