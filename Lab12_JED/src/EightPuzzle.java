import java.util.PriorityQueue;

public class EightPuzzle {
	public int[][] initialState;
	public int[][] finalState;
	public static final int[][] DIR = {{0,1} ,{1,0}, {0,-1}, {-1,0}};
	public int len;

	public EightPuzzle(int[][] initialState, int[][] finalState) {
		this.initialState = initialState;
		this.finalState = finalState;
		len = initialState.length;
	}

	public void solvePuzzle() {
		int x = 0;
		int y = 0;

		for(int i=0;i<len;i++) {
			for(int j=0; j<len; j++) {
				if(initialState[i][j]==0) {
					x=i;
					y=j;
				}
			}
		}

		PriorityQueue<State> pq = new PriorityQueue<State>(1000, (a, b) -> (a.getCost() + a.getStep()) - (b.getCost() + b.getStep()));
		State root = new State(initialState, x, y, x, y, 0, null);
		root.setCost(calculateCost(initialState));
		pq.add(root);

		System.out.println("Branch and Bound Algorithm for 8-Puzzle Problem");

		while (!pq.isEmpty()) {
			State curr = pq.poll();
			if (curr.getCost() == 0) {
				printPath(curr);
				System.out.println("Solved!!");
				System.out.println("Total steps = " + curr.getStep());
				return;
			}

			for (int[] dir: DIR) {
				int newX = curr.getX() + dir[0];
				int newY = curr.getY() + dir[1];
				if(isSafe(newX, newY)) {
					State child = new State(curr.getMatrix(), curr.getX(), curr.getY(), newX, newY, curr.getStep() + 1, curr);
					child.setCost(calculateCost(child.getMatrix()));
					pq.add(child);
				}
			}
		}
	}
	public int calculateCost(int[][] curr) {
		int count = 0;
		int n = curr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (curr[i][j] != 0 && curr[i][j] != finalState[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	public boolean isSafe(int x, int y) {
		return (x >= 0 && x < len && y >= 0 && y < len);
	}
	public void printPath(State root) {
		if (root == null) {
			return;
		}
		printPath(root.getParent());
		System.out.println("("+root.getX()+", "+root.getY()+")");
		printMatrix(root.getMatrix());
		System.out.println();
	}
	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public boolean isSolvable() {
		int inversionCount = 0;
		int[] arr = flatten2D(initialState);
		for(int i=0; i<0; i++) {
			for(int j= i+1; j<9;j++) {
				if(arr[j] != 0 && arr[i] != 0 && arr[i]> arr[j]) {
					inversionCount++;
				}
			}
		}
		return inversionCount % 2 == 0;
	}
	public int[] flatten2D (int[][] input) {
		int[] res = new int[9];
		int k =0;
		for(int i =0; i< 3; i++) {
			for(int j =0; j<3;j++) {
				res[k++] = input[i][j];
			}
		}
		return res;
	}
}