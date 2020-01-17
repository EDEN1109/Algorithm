public class RCC {
	public int[][] robotCoinCollection(int n, int m, int C[][]) {
		int[][] F = new int[n][m]; // Array F, size equal with C
		F[0][0] = C[0][0];
		for(int j=1; j<m; j++) {
			F[0][j] = F[0][j-1] + C[0][j];
		}
		for(int i=1; i<n; i++) {
			F[i][0] = F[i][0] + C[i][0]; // F[i][0] is F[i][0] + C[i][0]
			for(int j=1; j<m; j++) {
				if(F[i-1][j]+C[i][j]>F[i][j-1]+C[i][j])
					F[i][j] = F[i-1][j]+C[i][j];
				else
					F[i][j] = F[i][j-1]+C[i][j];
			}
		}
		printArray(F);
		return F; // return F
	}
	public void printArray(int A[][]) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
}