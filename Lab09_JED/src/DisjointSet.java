
public class DisjointSet {
	int[] a;
	int[] sz;
	
	public DisjointSet(int size){
		a= new int[size + 1];
		sz = new int [size + 1];
		
		for (int i = 0; i< a.length; i++){
			a[i] = i;
			sz[i] = i;
		}
	}
	public void union(int i, int j){
		int ip = find(i);
		int jp = find(j);
		
		if(sz[ip] < sz[jp]){
			a[ip] = jp;
			sz[jp] += sz[ip];
			
		}
		else {
			sz[ip] += sz[jp];
			a[jp] = a[ip];
		}
	}
	
	public int find(int i){
		
		while(a[i] != i){
			a[i] = a[a[i]];
			i = a[i];
		}
		return i;
	}
	
}
