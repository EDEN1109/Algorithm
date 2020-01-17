
public class Edge implements Comparable<Edge>{
	private Double weight;
	private Integer from;
	private Integer to;
	
	public Edge(Integer from, Integer to, Double weight) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Edge (" + from + "---->" + to + ") " + "weight=" + weight ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = weight != null ? weight.hashCode() : 0;
		result = prime * result + ((from != null) ? from.hashCode() : 0);
		result = prime * result + ((to != null) ? to.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Edge o) {
		return (int) (this.weight - o.weight);
	}
	
	
	
}
