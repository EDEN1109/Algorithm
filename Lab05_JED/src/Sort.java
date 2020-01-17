
public class Sort {
	private Ranks rank = new Ranks();

	public void quickSort(int low, int high, int S[]) {
		int pivotpoint;
		if(high > low) {
			pivotpoint = rank.Partition(low, high, S);
			quickSort(low, pivotpoint-1, S);
			quickSort(pivotpoint+1, high, S);
		}
	}
	
	/******Start ERROR Code*******/
	public void mergeSort(int n, int S[]) {
		if(n>1) {
			int h = n/2;
			int m = n-h;
			int[] U = new int[h];
			int[] V = new int[n-h];
			for(int i=0; i<h; i++) {
				U[i] = S[i];
				V[i] = S[h+i];
			}
			mergeSort(h, U);
			mergeSort(m, V);
			merge(h, m, U, V, S);
		}
	}
	public int[] merge(int h, int m, int U[], int V[], int S[]) {
		int i=1;
		int j=1;
		int k=1;

		while(i < h && j < m) {
			if(U[i] < V[j]) {
				S[k] = U[i];
				i++;
			}
			else {
				S[k] = V[i];
				j++;
			}
			k++;
		}

		if(i>=h) {
			while(j<m) {
				S[k] = V[j];
				j++;
				k++;
			}
		}
		else {
			while(j<h) {
				S[k] = U[i];
				i++;
				k++;
			}
		}
		return S;
	}
	/******END ERROR Code*******/
	
	public void printArray(int S[]) {
		for(int i=0; i<S.length; i++) {
			System.out.print(S[i]+", ");
		}
		System.out.println();
	}
}
