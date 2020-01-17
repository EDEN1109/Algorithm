import java.util.Arrays;

public class SumSubset {
	private int[] weights;
	private int[] included;
	private int W;

	public SumSubset(int[] w, int W) {
		weights = w;
		included = new int[weights.length];
		Arrays.sort(weights);
		this.W = W;
		int totalSum=0;
		for(int item : weights) totalSum += item;
		sumOfsubsets(0,0,totalSum);
	}
	
	public void sumOfsubsets(int index, int weight, int remainSum) { // index = item num
		included[index] = 1;
		if((weights[index] + weight) == W) {
			int sum = 0;
			for(int i=0;i<=index;i++) { // 1인 것만 출력
				if(included[i] == 1) {
					System.out.print(weights[i] + " ");
					sum += weights[i];
				}
			}
			System.out.println(", sum = " + sum);
		}
		else if(index+1 < weights.length && weight + weights[index]+weights[index+1] <= W) { 
			sumOfsubsets(index+1, weight+weights[index], remainSum-weights[index]);
		}
		if(index+1<weights.length && weight+weights[index+1]<=W && weight+remainSum-weights[index] >= W) {
			included[index] = 0;
			sumOfsubsets(index+1, weight, remainSum-weights[index]);
		}
	}
}
