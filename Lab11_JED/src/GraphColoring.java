
public class GraphColoring {
	private boolean isSafe(int[][] G, int E, int[] colored, int v_id, int color){
		for(int i=0;i<E;i++) {
			if(G[v_id][i] == 1 && colored[i]==color) return false; 
		}
		return true;
	}
	private boolean gColoring(int[][] G, int E, int colors, int[] colored, int v_id) {
		if(v_id == E) return true;
		for(int color=1;color<=colors;color++) {
			if(isSafe(G, E, colored, v_id, color)) {
				colored[v_id] = color;
				if(gColoring(G, E, colors, colored, v_id+1)) return true;
				else {
					colored[v_id] = 0;
				}
			}
		}
		return false;
	}
	
	public void solution(int[][] G) {
		int E = G.length;
		int[] colored = new int[E];
		int colors = E;
		if(gColoring(G, E, colors, colored, 0)) {
			System.out.println("Colored result : ");
			for(int color: colored) {
				System.out.print(color+ " ");
			}
			System.out.println();
		}
		else {
			System.out.println("No Solution");
		}
	}
}
