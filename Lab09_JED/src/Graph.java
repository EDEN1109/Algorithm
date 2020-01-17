import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	
	private Set<Edge> edges = new HashSet<>();
	private boolean Undirected = false;
	private Map<Integer, Set<Edge>> map = new HashMap<>();
	
	public Graph(boolean Undirected) {
		this.Undirected = Undirected;
	}
	
	public void addVertex(Integer v) {
		map.put(v, new HashSet<>());
	}
	
	public void addEdge(Integer v1, Integer v2, Double weight) {
		if(!map.containsKey(v1)) return;
		if(!map.containsKey(v2)) return;
		
		Edge edge = new Edge(v1, v2, weight);
		
		map.get(v1).add(edge);
		edges.add(edge);
		
		if(Undirected) {
			Edge edge2 = new Edge(v2, v1, weight);
			map.get(v2).add(edge2);
			edges.add(edge2);
		}
	}
	
	public Set<Integer> getVertices(){
		return new HashSet<>(map.keySet());
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Set<Edge> getEdges(Integer v) {
		return map.get(v);
	}
	
	public int size() {
		return map.size();
	}
	
	public Double[][] getAdjMat(){
		int n = map.keySet().size();
		
		Double[][] adjMat = new Double[n][n];
		
		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j < n ; j++) {
				
				if( i == j ) {	adjMat[i][j] = 0.0;	}
				else {	adjMat[i][j] = Double.POSITIVE_INFINITY;	}
				
			}
		}//for end
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(this.getEdges());
		
		while( !q.isEmpty() ) {
			Edge e = q.poll();
			Double w = e.getWeight();
			adjMat[e.getFrom()][e.getTo()] = w;
		}
		
		return adjMat;
	}
	
	public void printGraph() {
		
		System.out.println("Graph contains the following edges : ");
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(this.getEdges());
		
		while( !q.isEmpty() ) {
			Edge e = q.remove();
			System.out.println(e);
		}
		
	}
	
}
