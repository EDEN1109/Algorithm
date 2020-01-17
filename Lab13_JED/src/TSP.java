import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TSP {
	private int[][] W;
	private ArrayList<Integer> path = new ArrayList<Integer> ();
	private int n;
	private int scount; // solution count
	private ArrayList<Integer> shortestPath = new ArrayList<Integer> ();
	private int[] Optimalpath;
	private int shortestDistance = Integer.MAX_VALUE; 
	private int nodeCount=0;
	
	public TSP(int[][] G) {
		scount = 0;
		W = G;
		n = G.length;
		Optimalpath = new int[n+1];
	}
	public void backtrackingTSP() {
		// back tracking
		path.add(0);
		hamiltonianC(0);
		System.out.print("No of Solution : " + scount);
		
		//printShortestPath(shortestPath);
		System.out.println();
		System.out.println("Shortest Distance " + shortestDistance);
		System.out.println("No of Nodes " + nodeCount);
	}
	public void BnBTSP() {
		ArrayList<Integer> cities = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			cities.add(i);
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		int initB = initbound();
		Node v = new Node(new ArrayList<>(), 0, initB, 0);
		queue.add(v);
		nodeCount++;
		
		while(!queue.isEmpty()) {
			v = queue.remove();
			if(v.getBound() < shortestDistance) {
				Node u = new Node();
				u.setLevel(v.getLevel()+1);
				for(int i=1;i<n;i++) {
					path = v.getPath();
					if(!path.contains(i)) {
						u.setPath(v.getPath());
						path = u.getPath();
						path.add(i);
						u.setPath(path);
						if(u.getLevel()==n-2) {
							// put index of only vertex not in u.path
							for(int j=1;j<cities.size();j++) {
								if(!u.getPath().contains(j)) {
									ArrayList<Integer> tmp = new ArrayList<>();
									tmp = u.getPath();
									tmp.add(j);
									u.setPath(tmp);
								}
							}
							path=u.getPath();
							path.add(0);
							u.setPath(path);
							if(u.computeLength(W) < shortestDistance) {
								shortestDistance = u.computeLength(W);
								shortestPath = u.getPath();
							}
						}else {
							u.setBound(computeBound(u,cities));
							if(u.getBound() < shortestDistance) {
								queue.add(u);
								nodeCount++;
							}
						}
					}
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public void hamiltonianC(int i) {
		int length = 0;
		if(promissing(i)) {
			if(i==n-1) {
				scount++;
				if(path.size()>i+1) { path.set(i+1, 0); }
				else { path.add(0); }
				
				length = computeLength(path);
				if(length < shortestDistance) {
					shortestDistance = length;
					shortestPath = (ArrayList<Integer>) path.clone();
				}
				System.out.print("Solution #" + scount + " = {");
				for(int a=0;a<=i+1;a++) {
					System.out.print(" " + path.get(a));
				}
				System.out.println("}  Length =  " + computeLength(path));
			}else {
				for(int j=1;j<n;j++) {
					if(path.size()>i+1) { path.set(i+1, j); }
					else { path.add(j); }
					nodeCount++;
					hamiltonianC(i+1);
				}
			}
		}
	}
	private int initbound() {
		int min;
		int bound=0;
		for(int i=0;i<n;i++) {
			min=Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(W[i][j] != 0) {
					if(min > W[i][j]) {
						min = W[i][j];
					}
				}
			}
			bound = bound + min;
		}
		return bound;
	}
	private int computeBound(Node u, ArrayList<Integer> cities) {
		int bound = 0;
		ArrayList<Integer> path = u.getPath();
		for(int i=0;i<path.size()-1;i++) {
			bound = bound + W[path.get(i)][path.get(i+1)];
		}
		int last = path.get(path.size()-1);
		List<Integer> subPath1 = path.subList(1, path.size());
		List<Integer> subPath2 = path.subList(0, path.size()-1);
		int min;
		for(int i=0;i<cities.size();i++) {
			min=Integer.MAX_VALUE;
			if(!path.contains(cities.get(i))) {
				for(int j=0;j<cities.size();j++) {
					if(i != j && !subPath1.contains(cities.get(j))) {
						if(min > W[i][j]) {
							min = W[i][j];
						}
					}
				}
			}
			if(min != Integer.MAX_VALUE) {
				bound = bound + min;
			}
		}
		min=Integer.MAX_VALUE;
		for(int i=0;i<cities.size();i++) {
			if(cities.get(i) != last && !subPath2.contains(i) && min > W[last][i]) {
				min = W[last][i];
			}
		}
		bound = bound + min;
		return bound;
	}
	public boolean promissing(int i) {
		if(i==0) return true;
		if(i==n-1 && W[path.get(i)][path.get(0)] == 0) return false; // first condition
		if(i>0 && W[path.get(i-1)][path.get(i)] == 0) return false; // second
		
		int j=0;
		while(j<i && path.get(j) != path.get(i)) { // third
			j++;
		}
		return (j==i);
	}
	
	public int computeLength(ArrayList<Integer> path2) {
		int distance=0;
		for(int i=0;i<path2.size()-1;i++) {
			distance = distance + W[path2.get(i)][path2.get(i+1)];
		}
		return distance;
	}

	public int getShortestDistance() {
		return shortestDistance;
	}
	
	public ArrayList<Integer> getShortestPath() {
		return shortestPath;
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	public void printShortestPath() {
		System.out.print("shortest path : {");
		int distance = 0;
		for(int i=0;i<shortestPath.size()-1;i++) {
			System.out.print(shortestPath.get(i) + " ");
			distance = distance + W[shortestPath.get(i)][shortestPath.get(i+1)];
		}
		System.out.println("}  length = " + distance);
	}
}