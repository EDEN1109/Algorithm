import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph {
	
	private boolean Undirected = false;
	
	private Set<Edge> edges = new HashSet<>();
	private Map< Vertex<Integer>, Set<Edge> > map = new HashMap<>();
	
	public WeightedGraph(boolean Undirected) {
		this.Undirected = Undirected;
	}
	
	public void addVertex( Vertex<Integer> v ) {
		map.put(v, new HashSet<>() );
	}
	
	public void addEdge( Vertex<Integer> v1,  Vertex<Integer> v2, Double w ) {
		if( !map.containsKey(v1) ) return ;
		if( !map.containsKey(v2) ) return ;
		
		Edge e = new Edge(v1, v2, w);
		map.get(v1).add(e);
		edges.add(e);
		
		if( Undirected ) {
			Edge e2 = new Edge(v2, v1, w);
			map.get(v2).add(e2);
			edges.add(e2);
		}
		
	}
	
	public Set< Vertex<Integer> > getVertices(){
		return new HashSet<>(map.keySet());
	}
	
	public Set< Edge > getEdges() { return edges; }
	public Set< Edge > getEdges(Vertex<Integer> v) { return map.get(v); }
	
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
			adjMat[e.getFrom().getValue()][e.getTo().getValue()] = w;
		}
		
		return adjMat;
	}
	
	public void printGraph() {
		
		System.out.println("Graph contains the following edges : ");
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(this.getEdges());
		
		while( !q.isEmpty() ) {
			Edge e = q.poll();
			System.out.println(e);
		}
		
	}
	
	
	
}
