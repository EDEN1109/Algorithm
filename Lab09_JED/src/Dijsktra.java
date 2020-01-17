import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Dijsktra {
	
	private Map<Integer, Double> dv;
	private Map<Integer, Integer> pv;
	private Map<Integer, Boolean> known;
	private Graph graph;
	
	public Dijsktra(Graph graph) {
		this.graph = graph;
		dv = new HashMap<>();
		pv = new HashMap<>();
		known = new HashMap<>();
	}
	
	public void shortestPath(Integer source) {
		Set<Integer> openSet = new TreeSet<>();
		
		//initial configration
		for(Integer vertex : graph.getVertices()) {
			pv.put(vertex, 0);
			known.put(vertex, Boolean.FALSE);
			
			if(source.equals(vertex)) {
				dv.put(source, 0.0);
			}
			else {
				dv.put(vertex, Double.POSITIVE_INFINITY);
			}
			
			openSet.add(vertex);
		}
		
		known.put(source, Boolean.TRUE);
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(graph.getEdges(source));
		
		double edgeDistance = -1;
		double newDistance = -1;
		
		while(!openSet.isEmpty()) {
			Edge minEdge = q.remove(); //get min weight edge
			Integer vertex = minEdge.getTo();
			openSet.remove(vertex);
			known.put(vertex, Boolean.TRUE);
			
			for(Edge edge : graph.getEdges(vertex)) {
				edgeDistance = edge.getWeight();
				newDistance = dv.get(vertex) + edgeDistance;
				
				if(dv.get(edge.getTo()) > newDistance ) {
					dv.put(edge.getTo(), newDistance);
					pv.put(edge.getTo(), vertex + 1);
				}
				q.addAll(graph.getEdges(vertex));
			}
			openSet.remove(vertex);
			printSolution();
			System.out.println( );
		}
		printSolution();
		System.out.println( );
	}
	
	public void printSolution() {
		System.out.println("Configuration for Dijsktra algorithm");
		System.out.println("Vertex # " + "	Known	" + " Distance from source(dv)	" + "Parent Vertex(pv)");
		
		for(int i=0 ; i < dv.size() ; i++) {
			System.out.println( i + 1 +
					"	        " + known.get(i).toString()
					+ "          " + dv.get(i).toString()
					+ "                        " + pv.get(i).toString());
			
			
		}
	}
	
}


