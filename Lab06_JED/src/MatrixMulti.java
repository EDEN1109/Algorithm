
public class MatrixMulti {
	public int[][] strassan(int a[][], int b[][]) { // a,b 배열을 인수로 받는다.
		int[][] c = new int[a.length][a.length]; // a와 크기가 같은 동적할당 된 배열 c를 선언한다.

		int n = a.length; // n의 크기는 a의 길이의 사이즈이다.

		if ((n % 2 != 0) && (n != 1)) { // n이 1이 아니고, n을 2로 나눈 나머지가 0이 아닐경우
			int[][] a1, b1, c1; // 배열 a1,b1,c1을 선언.
			int n1 = n + 1; // n1에 n+1을 한 값을 대입.

			a1 = new int[n1][n1]; // a1 배열에 n1사이즈로 동적할당.
			b1 = new int[n1][n1]; // b1 배열에 n1사이즈로 동적할당.
			c1 = new int[n1][n1]; // c1 배열에 n1사이즈로 동적할당.

			for (int i = 0; i < n; i++) // n은 a배열의 사이즈. 
				for (int j = 0; j < n; j++) {
					a1[i][j] = a[i][j]; // a1에 a의 값을 대입.
					b1[i][j] = b[i][j]; // b1에 b의 값을 대입.
				}

			c1 = strassan(a1, b1);
			// 재귀함수를 사용할 경우 n의 사이즈가 홀수 였을 경우 +1이 되어서 홀수가 아니게 됨으로 c1에 값이 채워진다.

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					c[i][j] = c1[i][j]; // c에 c1의 값을 대입.
				}
			}

			return c; // c를 return 한다.

		}

		//base case
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0]; // a의 사이즈가 1일 경우 배열의 곱을 c에다가 넣는다.
		} 

		//recursive case
		else {
			// a/2사이즈의 배열을 동적할당 한다.
			int[][] A11 = new int[n / 2][n / 2]; 
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];

			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			// 배열 a를 4분면으로 나눴다고 했을때
			devide(a, A11, 0, 0); // a의 2사분면 값을 a11에게 넣는다.
			devide(a, A12, 0, n / 2); // a의 3사분면 값을 a12에게 넣는다.
			devide(a, A21, n / 2, 0); // a의 1사분면 값을 a13에게 넣는다.
			devide(a, A22, n / 2, n / 2); // a의 4분면 값을 a14에게 넣는다.

			// 배열 b를 4분면으로 나눴다고 했을떄
			devide(b, B11, 0, 0); // b의 2사분면 값을 b11에게 넣는다.
			devide(b, B12, 0, n / 2); // b의 3사분면 값을 b12에게 넣는다.
			devide(b, B21, n / 2, 0); // b의 1사분면 값을 b13에게 넣는다.
			devide(b, B22, n / 2, n / 2); // b의 4분면 값을 b14에게 넣는다.

			// 행렬 계산을 한다. 각각의 인자에 맞게 덧셈 혹은 뺄셈을 하여 넣어준다.
			int[][] M1 = strassan(add(A11, A22), add(B11, B22));
			int[][] M2 = strassan(add(A21, A22), B11);
			int[][] M3 = strassan(A11, sub(B12, B22));
			int[][] M4 = strassan(A22, sub(B21, B11));
			int[][] M5 = strassan(add(A11, A12), B22);
			int[][] M6 = strassan(sub(A21, A11), add(B11, B12));
			int[][] M7 = strassan(sub(A12, A22), add(B21, B22));

			int[][] C11 = add(sub(add(M1, M4), M5), M7);
			int[][] C12 = add(M3, M5);
			int[][] C21 = add(M2, M4);
			int[][] C22 = add(sub(add(M1, M3), M2), M6);

			// C를 나눈 4사분면을 C에게 합쳐준다.
			copy(C11, c, 0, 0);
			copy(C12, c, 0, n / 2);
			copy(C21, c, n / 2, 0);
			copy(C22, c, n / 2, n / 2);
		}

		return c; // c를 반환한다.
	}

	public void copy(int[][] c1, int[][] p1, int iB, int jB) {
		for (int i1 = 0, i2 = iB; i1 < c1.length; i1++, i2++)
			for (int j1 = 0, j2 = jB; j1 < c1.length; j1++, j2++) {
				p1[i2][j2] = c1[i1][j1];
			}
	} // 배열 c1의 값을 입력한 구간부터 p1에다가 넣는다.

	public void devide(int[][] p1, int[][] c1, int iB, int jB) { 
		for (int i1 = 0, i2 = iB; i1 < c1.length; i1++, i2++) // c배열의 크기 만큼 반복한다.
			for (int j1 = 0, j2 = jB; j1 < c1.length; j1++, j2++) {
				c1[i1][j1] = p1[i2][j2];
			}
	} // 배열 p1의 값을 입력한 구간부터 c1에다가 넣는다.

	public int[][] add(int[][] A, int[][] B) {
		int n = A.length; // n을 A배열의 사이즈로 선언한다
		int[][] R = new int[n][n]; // 배열 R을 사이즈 n*n의 동적배열로 선언한다.
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) {
				R[i][j] = A[i][j] + B[i][j]; // A, B배열을 더해 R에게 넣는다.
			}
		return R; // R을 반환한다.
	}

	public int[][] sub(int[][] A, int[][] B) {
		int n = A.length;
		int[][] R = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				R[i][j] = A[i][j] - B[i][j];
			}
		return R;
	} // 배열 뺄셈

	public int[][] MultiplyMatrices(int a[][], int b[][]) {
		int[][] c = new int[a.length][a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < a.length; k++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}
		return c;
	} // 배열 곱하기

	// 2차원 행렬 출력
	public void PrintMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

}