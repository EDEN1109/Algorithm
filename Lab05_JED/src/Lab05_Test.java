import java.util.Random;

public class Lab05_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab05 lab = new Lab05();
		Ranks rank = new Ranks();
		Sort sort = new Sort();
		Random rand = new Random();
		int[] S = new int[5];
		int a = rand.nextInt(10) + 1;
		int n = rand.nextInt(5) + 1;
		
		
		for(int i=0; i<S.length; i++) {
			S[i] = rand.nextInt(10);
		}
		
		System.out.println(lab.isDistinct(S, S.length));
		lab.printArray(S);
		
		System.out.println("Median : "+rank.RankSelection(0, S.length, S.length/2, S));
//		sort.mergeSort(S.length, S);
		sort.quickSort(0, S.length, S);
		sort.printArray(S);
		
		System.out.println(a+"^"+n+" = "+lab.Exponentiation(a, n));
	}

}
