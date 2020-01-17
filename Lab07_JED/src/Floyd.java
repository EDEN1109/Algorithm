

public class Floyd {
	
	public int [][] P;
	public int n;
	
	public Floyd(int n) {
		this.P = new int [n][n];
	}
	
	public void Floyds(int[][] W) {
		
		int [][] D = new int [n][n];
	
		for (int i = 0 ; i < n ; i++ ) {
			for (int j = 0 ; j < n ; j++ ) {
				P[i][j] = 0;
			}
		}

		D = W;

		for (int k = 0 ; k < n ; k++ ) {
			for (int i = 0 ; i < n ; i++ ) {
				for(int j = 0 ; j < n ; j++ ) {

					if (D[i][j] > D[i][k] + D[k][j] ) {
						D[i][j]= D[i][k] + D[k][j];
						P[i][j] = k ;
					}
					
				}
			}
		}//end for
		
		PrintMatrix(D);
		
	}
	
	public void path(int q, int r) {
		
		if( P[q][r] != 0 ) {
			path( q, P[q][r] );
			System.out.print(P[q][r]);
			path( P[q][r] , r );
		}
		
	}
	
	public void PrintMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}
}
