public class State {
	private State parent;
	private int[][] matrix;
	private int x, y;
	private int cost;
	private int step;
	
	public State(int[][] matrix, int x, int y, int newX, int newY, int step, State parent) {
		this.parent = parent;
		this.matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			this.matrix[i] = matrix[i].clone();
		}
		this.matrix[x][y]       = this.matrix[x][y] + this.matrix[newX][newY];
		this.matrix[newX][newY] = this.matrix[x][y] - this.matrix[newX][newY];
		this.matrix[x][y]       = this.matrix[x][y] - this.matrix[newX][newY];
		
		this.cost = Integer.MAX_VALUE;
		this.step = step;
		this.x = newX;
		this.y = newY;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCost() {
		return cost;
	}
	public int getStep() {
		return step;
	}
	public State getParent() {
		return parent;
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}