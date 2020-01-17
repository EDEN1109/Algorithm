
public class Lab01 {
	public void ExchangeSort(int n, int S[]) {
		int temp;
		for(int i=0; i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(S[j]<S[i]) {
					temp = S[j];
					S[j] = S[i];
					S[i] = temp;
				}
			}
		}
	}
	
	public int SEQSearch(int n, int S[], int x) {
		int location = 0;
		while(location<n && S[location]!=x) {
			location++;
		}
		if(location>=n)
			location = 0;
		return location;
	}
	
	public int Location1(int n, int S[], int x, int low, int high) {
		int mid;
		
		if(low>high)
			return 0;
		else {
			mid = (low+high)/2;
			if(x==S[mid])
				return mid;
			else {
				if(x>S[mid])
					return Location1(n,S,x,mid+1,high);
				else
					return Location1(n,S,x,low,mid-1);
			}
		}
	}
	
	public int Power2(int n) {
		if(n==0)
			return 1;
		else
			return 2*Power2(n-1);
	}
	
	public int Power(int n) {
		int pow = 1;
		for(int i = n; i>0; i--)
			pow *= 2;
		return pow;
	}
	
	public int FIB(int n) {
		if(n>1)
			return FIB(n-2)+FIB(n-1);
		else
			return n;
	}
	
	public int FIB2(int n) {
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i<=n; i++)
			f[i] = f[i-2]+f[i-1];
	
		return f[n];
	}
	
	public int[][] MultiplyMatrices(int a[][], int b[][]) {
		int[][] c = new int[a.length][a.length];
		
		for(int i = 0; i <a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				c[i][j]=0;
				for(int k = 0; k <a.length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return c;
	}
	
	public void PrintMatrix(int a[][]) {
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a.length; j++)
				System.out.print(a[i][j]+ "\t");
			System.out.println();
		}
		System.out.println();
	}
	
	public int SumArray(int arr[]) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public void PrintArray(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+", ");
		System.out.println();
	}
}
