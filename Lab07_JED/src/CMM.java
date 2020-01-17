
public class CMM {
	public int minMult(int n, int d[], int P[][]) 
	{
		int M[][] = new int[n][n]; // Set M size n*n
		int calM;
		// dia is starting at 1.
		for (int dia = 1; dia < n; dia++) { 
			for (int i = 0; i < n - dia; i++) { 
				int j = i + dia;
				M[i][j] = Integer.MAX_VALUE; // Set M[i][j] value to Max, Because we have to find minimum value
				for (int k = i; k <= j - 1; k++) { 
					// calM is Multiplications Value
					calM = M[i][k] + M[k + 1][j] + d[i] * d[k+1] * d[j+1]; 
					if (calM < M[i][j]) { // If calM is small then M[i][j]
						M[i][j] = calM; // Change M[i][j] to calM
						P[i][j] = k; // Store value of k to P[i][j];
					}
				} 
			} 
		}
		printArray(M); // print Array M
		return M[0][n - 1]; // return last number value of first low of M
	}
	public String order(int i, int j, int P[][]) {
		if(i==j)
			return "A"+i+" "; // return value of i with A
		else {
			int k = P[i][j]; // k is P[i][j]
			return "("+order(i,k,P)+" "+order(k+1,j,P)+")"; // Recursive order
		}
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