
public class Vertex<T> {
	private T value;
	
	public Vertex(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "V_" + value ;
	}
	
	
}
