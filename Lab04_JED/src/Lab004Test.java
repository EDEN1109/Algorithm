import java.util.Random;

public class Lab004Test {

	public static void main(String[] args) {
		Random rand = new Random();
		int size = 100;
		int[] S = new int[size];
		Lab04 lab = new Lab04();
		
		for(int i=0; i<S.length; i++) {
			S[i] = -9 + rand.nextInt(20);
		}
		
		lab.PrintArray(S);
		System.out.println("Maximum of Array from SUM1 : " + lab.SUM1(S));
		System.out.println("Maximum of Array from SUM2 : " + lab.SUM2(S));
		System.out.println("Maximum of Array from SUM3 : " + lab.SUM3(S, 0, S.length-1));
		System.out.println("Maximum of Array from SUM4 : " + lab.SUM4(S));

	}

}
