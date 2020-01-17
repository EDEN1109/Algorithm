
import java.util.Random;

public class Lab06Test {
	public static void main(String[] args) {

		// 1. Exponentiation problem
		Exponentiation ep = new Exponentiation();
		System.out.println(ep.Power(2, 4));

		// 2. Multiplication of Large Integers
		Multiplication mp = new Multiplication();
		System.out.println(mp.Prod(2, 4));

		// 3. Strassen’s Algorithm
		Random rm = new Random(); //랜덤 클래스 호출
		MatrixMulti mm = new MatrixMulti(); 
		int Msize = 4;
		int[][] A = new int[Msize][Msize];
		int[][] B = new int[Msize][Msize];

		for (int i = 0; i < Msize; i++) {
			for (int j = 0; j < Msize; j++) {
				A[i][j] = rm.nextInt(5) + 1;
				B[i][j] = rm.nextInt(5) + 1;
			}
		}
		int[][] C = mm.MultiplyMatrices(A, B);
		int[][] D = mm.strassan(A, B);
		mm.PrintMatrix(A);
		mm.PrintMatrix(B);
		mm.PrintMatrix(C);
		mm.PrintMatrix(D);

		// 4. Tromino Puzzle(Tiling problem)
		TrominaPuzzle tp = new TrominaPuzzle(0, 0, 2);

	}

}
