import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maze {
	private char[][] map;
	private final int MAZE_SIZE;
	private final int[][] DIR = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	private final Location2D entry;
	
	public Maze(char[][] map, int size) {
		this.map = map;
		MAZE_SIZE = size;
		entry = setStart();
	}
	
	public void BnBMaze() {
		int nn = 0;
		Queue<Location2D> q = new LinkedList<Location2D>();
		q.add(entry);
		
		System.out.println("Branch and Bound Algorithm for Maze Problem");
		
		while(!q.isEmpty()) {
			Location2D here = q.remove();
			int row = here.getRow();
			int col = here.getCol();
			System.out.println("("+row+", "+col+")");
			printMap();
			
			if(map[row][col]=='x') {
				System.out.println("Solved!!\nNumber of Nodes = "+nn);
				return;
			}
			else {
				nn++;
				map[row][col] = '*';
				
				for(int[] dir : DIR) {
					if(isValid(row+dir[0], col+dir[1]))
						q.add(new Location2D(row+dir[0], col+dir[1]));
				}
			}
			
		}
		System.out.println("Not Solved...");
	}
	public void BacktrackingMaze() {
		int nn = 0;
		Stack<Location2D> s = new Stack<Location2D>();
		s.add(entry);
		
		System.out.println("Backtracking Algorithm for Maze Problem");
		
		while(!s.isEmpty()) {
			Location2D here = s.pop();
			int row = here.getRow();
			int col = here.getCol();
			System.out.println("("+row+", "+col+")");
			printMap();
			
			if(map[row][col]=='x') {
				System.out.println("Solved!!\nNumber of Nodes = "+nn);
				return;
			}
			else {
				nn++;
				map[row][col] = '*';
				
				for(int[] dir : DIR) {
					if(isValid(row+dir[0], col+dir[1]))
						s.add(new Location2D(row+dir[0], col+dir[1]));
				}
			}
			
		}
		System.out.println("Not Solved...");
	}
	public void resetMap() {
		for(int i=0; i<MAZE_SIZE; i++)
			for(int j=0; j<MAZE_SIZE; j++)
				if(map[i][j]=='*')
					map[i][j]='0';
		map[entry.getRow()][entry.getCol()] = 'e';
	}
	private void printMap() {
		for(int i=0; i<MAZE_SIZE; i++) {
			for(int j=0; j<MAZE_SIZE; j++)
				System.out.print(map[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	}
	private Location2D setStart() {
		Location2D result = null;
		for(int i=0; i<MAZE_SIZE; i++)
			for(int j=0; j<MAZE_SIZE; j++)
				if(map[i][j]=='e') {
					result = new Location2D(i,j);
				}
		return result;
	}
	private boolean isValid(int row, int col) {
		if(row<0 || col<0 || row>=MAZE_SIZE || col>=MAZE_SIZE) {
			return false;
		}
		else { return map[row][col]=='0' ||  map[row][col]=='x'; }
	}
}