
public class Lab04 {
	
	// 1.1 Solution1 : Brute Force Solution
	public int SUM1 (int S[]) {
		int sum;
		int max = 0;
		
		for(int i=0; i<S.length; i++) {
			for(int j=i; j<S.length; j++) {
				sum = 0;
				for(int k=i; k<=j; k++) {
					sum+=S[k];
				}
				if(sum>max)
					max = sum;
			}
		}
		
		return max;
	}
	
	// 1.2 Solution2 : Brute Force Solution
	public int SUM2 (int S[]) {
		int sum;
		int max = 0;
		for(int i=0; i<S.length; i++) {
			sum = 0;
			for(int j=i; j<S.length; j++) {
				sum+=S[j];
				if(sum>max)
					max = sum;
			}
		}
		return max;
	}
	
	// 1.3 Solution3 : Divide and Conquer Based Solution
	public int SUM3 (int S[], int low, int high) {
		int mid;
		if(low==high)
			return S[low];
		
		mid = (low+high)/2;
		return Math.max(Math.max(SUM3(S,low,mid),SUM3(S,mid+1,high)),
				MaxCrossingSum(S,low,mid,high));
	}
	
	public int MaxCrossingSum (int S[], int low, int mid, int high) {
		int sum = 0;
		int left_sum = 0;
		int right_sum = 0;
		
		for(int i=mid; i>=low; i--) {
			sum+=S[i];
			if(sum > left_sum)
				left_sum = sum;
		}
		
		sum = 0;
		
		for(int i=mid+1; i<=high; i++) {
			sum+=S[i];
			if(sum > right_sum)
				right_sum = sum;
		}
		
		return left_sum + right_sum;
	}
	
	// 1.4 Solution4 : Dynamic Programming Based Solution
	public int SUM4 (int S[]) {
		int smax = S[0];
		int cmax = S[0];
		
		for(int i=1; i<S.length; i++) {
			cmax = Math.max(S[i], cmax+S[i]);
			smax = Math.max(smax, cmax);
		}
		return smax;
		}
	
	// Print Array
	public void PrintArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
}
