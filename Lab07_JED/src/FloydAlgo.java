
public class FloydAlgo {
	private int n;
	private Double[][] D;
	private Integer[][] P;

	public FloydAlgo(Double[][] adjMat) {
		n = adjMat.length;
		D = adjMat.clone();
		P = new Integer[n][n];

		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j < n ; j++) {
				P[i][j] = 0;
			}
		}//end for

		System.out.println("\n Matrix D0 ");
		printD();
		runFloyds();
		System.out.println("\n Matrix Dn ");
		printD();
		System.out.println("\n Matrix P ");
		printP();
	}
	
	public void printPath( int q, int r ) {
		System.out.print("V_" + q + "--> " );
		path(q,r);
		System.out.print("V_" + r  );
	}

	public void path( int q, int r) {
		if(P[q][r] != 0) {
			path( q, P[q][r]);
			System.out.print("V_" + P[q][r] + "--> " );
			path(P[q][r] , r);
		}
		
	}
	
	public void runFloyds() {

		for(int k=0 ; k < n ; k++) {
			for(int i=0 ; i < n ; i++) {
				for(int j=0 ; j < n ; j++) {

					if( D[i][k] != null && D[k][j] != null ) { //??????
						//D[i][k] != null && D[i][k] != null¶ó°í ÇÏ¼Ì´Âµ¥ ³» ³úÇÇ¼È·Î ¹Ù²Þ
						if( D[i][k] == null || D[i][j] > D[i][k] + D[k][j] ) {
							D[i][j] = D[i][k] + D[k][j];
							P[i][j] = k;
						}
						
					}//end if

				}
			}
		}//end for


	}

	public void printD() {

		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j < n ; j++) {
				System.out.print(D[i][j] + "\t");
			}
			System.out.println();
		}//end for

	}

	public void printP() {

		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j < n ; j++) {
				System.out.print(P[i][j] + "\t");
			}
			System.out.println();
		}//end for

	}

}
