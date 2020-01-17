
public class Lab05 {
	public boolean isDistinct(int A[], int n) {
		int i,j;
		boolean isDis;
		isDis = true;
		
		for(i=0; i<n-1; i++) {
			for(j=i+1; j<n; j++) {
				if(A[i]==A[j]) {
					isDis = false;
				}
			}
		}
		return isDis;
	}
	
	public int Exponentiation(int a, int n) {
		if(n==1)
			return a;
		if(n%2 != 0)
			return Exponentiation(a,n/2)*Exponentiation(a,n/2)*a;
		return Exponentiation(a,n/2)*Exponentiation(a,n/2);
	}
	
	public void printArray(int S[]) {
		for(int i=0; i<S.length; i++) {
			System.out.print(S[i]+", ");
		}
		System.out.println();
	}
}
