import java.util.List;

public class Lab09Test {

	public static void main(String[] args) {
		
		//Lab09 1
		testDijsktra();
		
		//Lab09 2
		testKruskalMST();
		
		//Lab09 3
		testPrimsMST();
		
	}

	public static void testGrapgh() {
		Graph wdg = new Graph(false);

		wdg.addVertex(0);
		wdg.addVertex(1);
		wdg.addVertex(2);
		wdg.addVertex(3);
		wdg.addVertex(4);
		wdg.addVertex(5);
		wdg.addVertex(6);

		wdg.addEdge(0, 1, 2.0);
		wdg.addEdge(2, 0, 4.0);
		wdg.addEdge(0, 3, 1.0);
		wdg.addEdge(1, 3, 3.0);
		wdg.addEdge(1, 4, 10.0);
		wdg.addEdge(3, 2, 2.0);
		wdg.addEdge(2, 5, 5.0);
		wdg.addEdge(3, 4, 2.0);
		wdg.addEdge(3, 6, 4.0);
		wdg.addEdge(3, 5, 8.0);
		wdg.addEdge(4, 6, 6.0);
		wdg.addEdge(6, 5, 1.0);

		wdg.printGraph();
	}
	
	public static void testDijsktra() {
		Graph wdg = new Graph(false);

		wdg.addVertex(0);
		wdg.addVertex(1);
		wdg.addVertex(2);
		wdg.addVertex(3);
		wdg.addVertex(4);
		wdg.addVertex(5);
		wdg.addVertex(6);

		wdg.addEdge(0, 1, 2.0);
		wdg.addEdge(2, 0, 4.0);
		wdg.addEdge(0, 3, 1.0);
		wdg.addEdge(1, 3, 3.0);
		wdg.addEdge(1, 4, 10.0);
		wdg.addEdge(1, 3, 5.0);
		wdg.addEdge(3, 2, 2.0);
		wdg.addEdge(2, 5, 5.0);
		wdg.addEdge(3, 4, 2.0);
		wdg.addEdge(3, 6, 4.0);
		wdg.addEdge(3, 5, 8.0);
		wdg.addEdge(4, 6, 6.0);
		wdg.addEdge(6, 5, 1.0);
		
		Dijsktra dj = new Dijsktra(wdg);
		dj.shortestPath(0);
		
	}
	
	public static void testKruskalMST(){
		Graph wdg = new Graph(true); 

		wdg.addVertex(0);
		wdg.addVertex(1);
		wdg.addVertex(2);
		wdg.addVertex(3);
		wdg.addVertex(4);
		wdg.addVertex(5);
		wdg.addVertex(6); 

		wdg.addEdge(0, 1, 2.0);
		wdg.addEdge(0, 2, 4.0);
		wdg.addEdge(0, 3, 1.0);
		wdg.addEdge(1, 3, 3.0);
		wdg.addEdge(1, 4, 10.0);
		wdg.addEdge(2, 3, 2.0);
		wdg.addEdge(2, 5, 5.0);
		wdg.addEdge(3, 4, 7.0);
		wdg.addEdge(3, 6, 4.0);
		wdg.addEdge(3, 5, 8.0);
		wdg.addEdge(4, 6, 6.0);
		wdg.addEdge(5, 6, 1.0);

		KruskalsMST kk = new KruskalsMST(wdg);
		List<Edge> list = kk.getMST();
		kk.printSolution(list);
	}
	
	public static void testPrimsMST() {
		Graph wdg = new Graph(false);

		wdg.addVertex(0);
		wdg.addVertex(1);
		wdg.addVertex(2);
		wdg.addVertex(3);
		wdg.addVertex(4);
		wdg.addVertex(5);
		wdg.addVertex(6);

		wdg.addEdge(0, 1, 2.0);
		wdg.addEdge(0, 2, 4.0);
		wdg.addEdge(0, 3, 1.0);
		wdg.addEdge(1, 3, 3.0);
		wdg.addEdge(1, 4, 10.0);
		wdg.addEdge(2, 3, 2.0);
		wdg.addEdge(2, 5, 5.0);
		wdg.addEdge(3, 4, 7.0);
		wdg.addEdge(3, 6, 4.0);
		wdg.addEdge(3, 5, 8.0);
		wdg.addEdge(4, 6, 6.0);
		wdg.addEdge(5, 6, 1.0);
		
		PrimsMST pmst = new PrimsMST(wdg);
		List<Edge> list2 = pmst.getMST();
		pmst.printSolution(list2);
	}

}
