
public class Ranks {
	public int Partition(int low, int high, int S[]) {
		int i, j, pivotpoint;
		int pivotitem;
		pivotitem = S[low];
		j = low;

		for(i = low+1; i<high; i++) {
			if(S[i]<pivotitem) {
				j = j+1;
				swap(S, i, j);
			}
		}
		pivotpoint = j;
		swap(S, low, pivotpoint);
		return pivotpoint;
	}

	private void swap(int S[], int i, int j) {
		int temp;

		temp = S[i];
		S[i] = S[j];
		S[j] = temp;
	}

	public int RankSelection(int low, int high, int sRank, int S[]) {
		int pivotpoint;
		if(high==low)
			return S[low];
		else {
			pivotpoint = Partition(low, high, S);
			if(sRank==pivotpoint)
				return S[pivotpoint];
			else {
				if(sRank<pivotpoint)
					RankSelection(low, pivotpoint-1, sRank, S);
				else
					RankSelection(pivotpoint+1, high, sRank, S);	
			}
		}
		return S[sRank];
	}
	
	public void printArray(int S[]) {
		for(int i=0; i<S.length; i++) {
			System.out.print(S[i]+", ");
		}
		System.out.println();
	}
}
