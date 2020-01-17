import java.util.LinkedList;
import java.util.Queue;

public class OBST {
	private int n;
	private double[][] A;
	private int[][] R;
	private double[] P;
	private Node root;

	public void setroot(Node root) {
		this.root = root;
	}

	public Node getroot() {
		return this.root;
	}

	public OBST(int n, double P[]) {
		this.n = n;
		A = new double[n+1][n];
		R = new int[n+1][n];
		this.P = P;
	}

	public double minAverageTime() {

		A[0][0] = 0;
		A[n][n-1]=0;
		R[n][n-1]=0;

		for ( int i=1 ;  i < n+1 ;  i++)  {
			A[i][i-1] = 0;
			R[i][i-1] = 0;

			if(i < n) {
				A[i][i] = P[i-1];
				R[i][i] = i;
			}

		}
		int count = 0;
		for(int diagonal=1 ; diagonal < n-1 ; diagonal++ ) {
			for(int i=1 ; i < n - diagonal ; i++ ) {

				int j = i + diagonal;


				double calB = Double.MAX_VALUE;
				for (int k = i; k <= j ; k++) { //k = root·Î ÁöÁ¤
					count++;
					double p = 0;

					if(k==i) {
						R[i][j] = k;
					}
					for(int m = i-1 ; m < j ; m++) {
						p += P[m];
					}
					double calA = A[i][k-1] + A[k + 1][j] + p;
					if ( calA < calB ) {
						A[i][j] = calA;
						R[i][j] = k;
					}
					calB = calA;

				}//end for

			}
			System.out.println();
		}//end for

		return A[1][n-1];
	}

	public Node makeTree(int i, int j, int[] Key) {
		int k = R[i][j];
		Node key;

		if(k==0) {	return null;	}
		else {
			key = new Node();

			key.setKey(Key[k]);
			key.setLeft(makeTree(i, k-1, Key));
			key.setRight(makeTree(k+1, j, Key));

			return key;
		}
	}

	public void printTree() {

		if (root == null) { 	return; 	} 

		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(root); 

		Node curr = new Node();
		curr = null;

		while (!queue.isEmpty()) { 
			int size = queue.size(); 

			while (size != 0) { 
				curr = queue.peek();
				queue.poll();

				System.out.print(curr.getKey() + " "); 

				if (curr.getLeft() != null) { 
					queue.add(curr.getLeft()); 
				} 

				if (curr.getRight() != null) { 
					queue.add(curr.getRight()); 
				} 
				size--; 
			}

			System.out.println(); 

		} 


	}

	public void printArray() {

		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < n ; j++) {
				System.out.print(R[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

	}
}
