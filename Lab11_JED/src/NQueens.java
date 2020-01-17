
public class NQueens {
	private int[] col;
	private int n;
	private int ns; // 정답의 수
	private int npn;

	public NQueens(int n) { // Queen의 개수 설정
		npn=0;
		ns=0;
		this.n = n;
		col = new int[n];
		placeQueen();
		System.out.println("Number of Solution : " + ns + ", Number of Promising Nodes : " + npn);

	}

	public void placeQueen() {
		for(int i=0;i<n;i++) {
			col[0] = i;
			queens(0);
		}
	}

	private void queens(int i) {
		int j;
		if(promising(i)) {
			npn++;
			if(i==(n-1)) {
				ns++;
				System.out.print(ns);
				for(int s=0;s<n;s++) {
					System.out.print(" Q" + s + "(" + s + ", " + col[s] + ")");
				}
				System.out.println();
			}
			else {
				for(j=0;j<n;j++) {
					col[i+1] = j;
					queens(i+1);
				}
			}
		}
	}

	private boolean promising(int i) {
		boolean swh = true;
		for(int k=0;k<i;k++) {
			if((col[i]==col[k]) || ((Math.abs(col[i]-col[k])) == (Math.abs(i-k)))){ // 같은 열이거나 대각선 위치
				swh = false;
			}
		}
		return swh;
	}
}
