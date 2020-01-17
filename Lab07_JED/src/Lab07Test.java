import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class Lab07Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. RCC
		/*
		RCC rcc = new RCC();
		int[][] C = {
				{0, 1, 0},
				{0, 0, 1},
				{0, 0, 0}
		};
		int nn = C.length;
		int m = C[0].length;
		rcc.robotCoinCollection(nn, m, C);
		
		//2. Floyds
		testFloydalgo();
		
		//3. CMM
		CMM cmm = new CMM();
		Random rand =  new Random();
		int n = 4; // size of CMM col and row
		int[] d = new int[n+1]; // d Array for CMM
		int[][] P = new int[n][n]; // P Array for CMM
		
		System.out.print("d : ");
		for(int i=0; i<n+1; i++) {
			d[i] = rand.nextInt(10)+1;
			System.out.print(d[i]+", ");
		}
		System.out.println();
		System.out.println("Print CMM Array");
		System.out.println(cmm.minMult(4, d, P));
		System.out.println("Print P Array");
		cmm.printArray(P);
		System.out.println(cmm.order(0,3,P));
		*/
		//4. OBST
		int nnn=5;
		double[] PP = new double[nnn];
		
		PP[0] = 0.1;
		PP[1] = 0.4;
		PP[2] = 0.2;
		PP[3] = 0.3;
		
		OBST obst = new OBST( nnn, PP );
		System.out.print( "minAverageTime = " + obst.minAverageTime() + "\n\n" );
		
		int[] Key = new int[nnn];
		
		Key[0] = 2;
		Key[1] = 4;
		Key[2] = 6;
		Key[3] = 8;
		
		obst.printArray();
		obst.printTree();
	}
	public static void testFloydalgo() {
		WeightedGraph wg = new WeightedGraph(false);
		
		wg.addVertex(new Vertex<Integer>(0));
		wg.addVertex(new Vertex<Integer>(1));
		wg.addVertex(new Vertex<Integer>(2));
		wg.addVertex(new Vertex<Integer>(3));
		wg.addVertex(new Vertex<Integer>(4));
		wg.addVertex(new Vertex<Integer>(5));
		wg.addVertex(new Vertex<Integer>(6));
		
		List<Vertex<Integer>> list = new LinkedList<>();
		list.addAll(wg.getVertices());
		
		wg.addEdge(list.get(0), list.get(1), 2.0);
		wg.addEdge(list.get(2), list.get(0), 4.0);
		wg.addEdge(list.get(0), list.get(3), 1.0);
		wg.addEdge(list.get(1), list.get(3), 3.0);
		wg.addEdge(list.get(1), list.get(4), 10.0);
		wg.addEdge(list.get(3), list.get(2), 2.0);
		wg.addEdge(list.get(2), list.get(5), 5.0);
		wg.addEdge(list.get(3), list.get(4), 2.0);
		wg.addEdge(list.get(3), list.get(6), 4.0);
		wg.addEdge(list.get(3), list.get(5), 8.0);
		wg.addEdge(list.get(4), list.get(6), 6.0);
		wg.addEdge(list.get(6), list.get(5), 1.0);
		
		wg.printGraph();
		
		Double[][] adjM = wg.getAdjMat();
		FloydAlgo fa = new FloydAlgo(adjM);
		fa.printPath(2, 6);
	}
	
	public static void testGrapgh() {
		WeightedGraph wg = new WeightedGraph(false);
		
		wg.addVertex(new Vertex<Integer>(0));
		wg.addVertex(new Vertex<Integer>(1));
		wg.addVertex(new Vertex<Integer>(2));
		wg.addVertex(new Vertex<Integer>(3));
		wg.addVertex(new Vertex<Integer>(4));
		wg.addVertex(new Vertex<Integer>(5));
		wg.addVertex(new Vertex<Integer>(6));
		
		List<Vertex<Integer>> list = new LinkedList<>();
		list.addAll(wg.getVertices());
		
		wg.addEdge(list.get(0), list.get(1), 2.0);
		wg.addEdge(list.get(2), list.get(0), 4.0);
		wg.addEdge(list.get(0), list.get(3), 1.0);
		wg.addEdge(list.get(1), list.get(3), 3.0);
		wg.addEdge(list.get(1), list.get(4), 10.0);
		wg.addEdge(list.get(3), list.get(2), 2.0);
		wg.addEdge(list.get(2), list.get(5), 5.0);
		wg.addEdge(list.get(3), list.get(4), 2.0);
		wg.addEdge(list.get(3), list.get(6), 4.0);
		wg.addEdge(list.get(3), list.get(5), 8.0);
		wg.addEdge(list.get(4), list.get(6), 6.0);
		wg.addEdge(list.get(6), list.get(5), 1.0);
		
		wg.printGraph();
	}

}
