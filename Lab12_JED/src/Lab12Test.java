public class Lab12Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startMaze();
		System.out.println();
		startPuzzle();
	}
	public static void startMaze() {
		char[][] map = {
				{ '1', '1', '1', '1', '1', '1'},
				{ 'e', '0', '1', '0', '0', '1'},
				{ '1', '0', '0', '0', '1', '1'},
				{ '1', '0', '1', '0', '1', '1'},
				{ '1', '0', '1', '0', '0', 'x'},
				{ '1', '1', '1', '1', '1', '1'}
		};
		Maze maze = new Maze(map, map.length);

		// Branch and Bound Algorithm for Maze Problem
		maze.BnBMaze();

		System.out.println();
		maze.resetMap();

		// Backtracking Algorithm for Maze Problem
		maze.BacktrackingMaze();
	}
	public static void startPuzzle() {
		// For 8-Puzzle Problem
		int[][] problem = {
				{ 1, 2, 3},
				{ 5, 6, 0},
				{ 7, 8, 4}
		};

		int[][] solution = {
				{ 1, 2, 3},
				{ 4, 5, 6},
				{ 7, 8, 0}
		};

		EightPuzzle puzzle = new EightPuzzle(problem, solution);
		if(puzzle.isSolvable()) {
			// Branch and Bound Algorithm for 8-puzzle Problem
			puzzle.solvePuzzle();
		}
		else { System.out.println("The instance is not solvable"); }
	}
}