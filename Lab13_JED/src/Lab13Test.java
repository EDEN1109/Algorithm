import java.util.Random;

public class Lab13Test {
	public static void main(String[] args) {
		testBackTrackingTSP();
		testBnBTSP();
	}
	
	public static void testBackTrackingTSP() {
		int[][] W = getW(6);
		PrintW(W);
		TSP hc = new TSP(W);
		hc.backtrackingTSP();
		System.out.println("Length of shortest path : " + hc.getShortestDistance());
		hc.printShortestPath();
	}
	public static void testBnBTSP() {
		int[][] W = getW(6);
		TSP bbtsp = new TSP(W);
		PrintW(W);
		bbtsp.BnBTSP();
		bbtsp.printShortestPath();
		System.out.println("Number of nodes inserted into PQ = " + bbtsp.getNodeCount());
	}
	public static int[][] getW(int N){
		Random r = new Random();
		int value;
		int[][] W = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				value = r.nextInt(10)+1;
				W[i][j] = value;
				if(i==j) {
					W[i][j] = 0;
				}
			}
		}
		return W;
	}
	
	public static void PrintW(int[][] W) {
		for(int i=0;i<W.length;i++) {
			for(int j=0;j<W.length;j++) {
				if(j==0) {
					System.out.println();
				}
				System.out.print(W[i][j] + "\t");
			}
		}
		System.out.println();
	}
}