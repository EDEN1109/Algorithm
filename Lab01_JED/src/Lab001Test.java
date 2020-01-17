import java.util.Random;

public class Lab001Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab01 lab1 = new Lab01();
		int arr[] = {12, 32, 54, 10, 53 , 13, 57};
		
		System.out.println(lab1.SumArray(arr));
		lab1.PrintArray(arr);
		
		// TEST for Matrix Multiplication
		Random rm = new Random();
		int Msize = 10;
		int[][] A = new int[Msize][Msize];
		int[][] B = new int[Msize][Msize];
		
		for(int i=0; i<Msize; i++) {
			for(int j=0; j<Msize; j++) {
				A[i][j] = rm.nextInt(10)+1;
				B[i][j] = rm.nextInt(10)+1;
			}
		}
		int[][] C = lab1.MultiplyMatrices(A, B);
		lab1.PrintMatrix(A);
		lab1.PrintMatrix(B);
		lab1.PrintMatrix(C);
		
		//TEST FIB Problem
		System.out.println(lab1.FIB(5));
		System.out.println(lab1.FIB2(5));
		
		//TEST Power Problem
		System.out.println(lab1.Power(3));
		System.out.println(lab1.Power2(3));
		
		//TEST ExchangeSort
		lab1.ExchangeSort(arr.length, arr);
		lab1.PrintArray(arr);
		
		//TEST Location1
		System.out.println(lab1.Location1(arr.length, arr, 10, 0, arr.length-1));
		
		//TEST SEQSearch
		System.out.println(lab1.SEQSearch(arr.length, arr, 13));
		
		System.out.println("All System is done...");
	}

}
