
public class Edge implements Comparable<Edge> {
	
	private Vertex<Integer> from;
	private Vertex<Integer> to;
	private Double weight;
	
	
	public Vertex<Integer> getFrom() {
		return from;
	}
	
	public void setFrom(Vertex<Integer> from) {
		this.from = from;
	}
	
	public Vertex<Integer> getTo() {
		return to;
	}
	
	public void setTo(Vertex<Integer> to) {
		this.to = to;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge: " + from + "---->" + to + " weight=" + weight ;
	}

	public Edge(Vertex<Integer> from, Vertex<Integer> to, Double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	
	@Override
	public int compareTo(Edge o) {
		return (int) (this.weight - o.weight );
	}

	
	
	
}
