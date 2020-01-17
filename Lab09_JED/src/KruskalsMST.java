import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalsMST {
	private Graph graph;
	private DisjointSet ds;
	
	public KruskalsMST(Graph graph){
		this.graph = graph;
		this.ds = new DisjointSet(graph.size());
	}
	
	public List<Edge> getMST() {
		List<Edge> list = new ArrayList<>();
		PriorityQueue<Edge> q = new PriorityQueue<>(graph.getEdges());
		
		while(!q.isEmpty()){
			Edge minEdge = q.remove(); //remove
			if (ds.find(minEdge.getFrom())!= ds.find(minEdge.getTo())){
				ds.union(minEdge.getFrom(),minEdge.getTo()); //make
				list.add(minEdge);
			}
		}
		
		return list;
	}
	
	public void printSolution(List<Edge> list){
		System.out.println("Minimum Spanning Tree");
		double minlen = 0;
		for (int i=0; i<list.size();i++){
			minlen += list.get(i).getWeight();
			System.out.println(list.get(i).toString());
		}
		System.out.println("Length of the Minimum Spanning Tree = : " + minlen);
	}
}
