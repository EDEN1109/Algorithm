import java.util.Random;

public class Lab11Test {

	public static void main(String[] args) {
		//n Queen Problem
		testQueens();
		
		//Sum of Subset Problem
		testSS();
		
		//Graph Coloring Problem
		testGC();
	}
	
	public static void testQueens() {
		NQueens nq = new NQueens(4);
	}
	
	public static void testSS() {
		int[] weights;
		final int W=25;
		int n=10;
		weights = new int[n];
		int[] weights2 = {5, 10, 12, 13, 15, 18};
		Random rm = new Random();
		for(int i=0;i<n;i++) {
			weights[i] = 1+rm.nextInt(10);
		}
		SumSubset ss = new SumSubset(weights2, W);
	}
	
	public static void testGC() {
		int N = 5;
		int[][] G = new int[N][N];
		G = new int[][] {
			{1,1,1,0,1},
			{1,1,0,1,1},
			{1,0,1,1,0},
			{0,1,1,1,1},
			{1,0,0,1,1}
		};
		for(int[] row : G) {
			for(int j=0;j<N;j++) {
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		GraphColoring p = new GraphColoring();
		p.solution(G);
		
	}

}
