import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class PrimsMST {
	private Graph graph;

	public PrimsMST(Graph graph) {
		this.graph = graph;
	}

	public List<Edge> getMST() {
		List<Edge> list = new ArrayList<>();
		Set<Integer> F = new HashSet<>();

		Integer start = getRandomVertex();
		F.add(start);

		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.addAll(graph.getEdges(start));
		
		while (!q.isEmpty()) {
			Edge minEdge = q.remove();
			Integer vertex = minEdge.getTo();
			
			if(F.contains(vertex)) {
				continue;
			}
			
			q.addAll(graph.getEdges(vertex));
			list.add(minEdge);
			F.add(vertex);
		}

		return list;
	}

	private Integer getRandomVertex() {
		Random rand = new Random();
		int start;
		
		if(graph.getVertices().size() > 0) {
			start = rand.nextInt(graph.getVertices().size());
			System.out.println("starting node: " +start);
			return start;
		}
		return null;
	}
	
	public void printSolution(List<Edge> list) {
		System.out.println("Minimum Spanning Tree");
		double minlen = 0.0;
		
		for(int i =0 ; i < list.size() ; i++) {
			minlen += list.get(i).getWeight();
			System.out.println(list.get(i).toString());
		}
		System.out.println("Length of the Minimum Spaaining Tree = : " + minlen);
	}
	
	
}
