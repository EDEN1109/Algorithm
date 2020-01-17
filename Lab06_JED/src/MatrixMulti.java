
public class MatrixMulti {
	public int[][] strassan(int a[][], int b[][]) { // a,b �迭�� �μ��� �޴´�.
		int[][] c = new int[a.length][a.length]; // a�� ũ�Ⱑ ���� �����Ҵ� �� �迭 c�� �����Ѵ�.

		int n = a.length; // n�� ũ��� a�� ������ �������̴�.

		if ((n % 2 != 0) && (n != 1)) { // n�� 1�� �ƴϰ�, n�� 2�� ���� �������� 0�� �ƴҰ��
			int[][] a1, b1, c1; // �迭 a1,b1,c1�� ����.
			int n1 = n + 1; // n1�� n+1�� �� ���� ����.

			a1 = new int[n1][n1]; // a1 �迭�� n1������� �����Ҵ�.
			b1 = new int[n1][n1]; // b1 �迭�� n1������� �����Ҵ�.
			c1 = new int[n1][n1]; // c1 �迭�� n1������� �����Ҵ�.

			for (int i = 0; i < n; i++) // n�� a�迭�� ������. 
				for (int j = 0; j < n; j++) {
					a1[i][j] = a[i][j]; // a1�� a�� ���� ����.
					b1[i][j] = b[i][j]; // b1�� b�� ���� ����.
				}

			c1 = strassan(a1, b1);
			// ����Լ��� ����� ��� n�� ����� Ȧ�� ���� ��� +1�� �Ǿ Ȧ���� �ƴϰ� ������ c1�� ���� ä������.

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					c[i][j] = c1[i][j]; // c�� c1�� ���� ����.
				}
			}

			return c; // c�� return �Ѵ�.

		}

		//base case
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0]; // a�� ����� 1�� ��� �迭�� ���� c���ٰ� �ִ´�.
		} 

		//recursive case
		else {
			// a/2�������� �迭�� �����Ҵ� �Ѵ�.
			int[][] A11 = new int[n / 2][n / 2]; 
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];

			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			// �迭 a�� 4�и����� �����ٰ� ������
			devide(a, A11, 0, 0); // a�� 2��и� ���� a11���� �ִ´�.
			devide(a, A12, 0, n / 2); // a�� 3��и� ���� a12���� �ִ´�.
			devide(a, A21, n / 2, 0); // a�� 1��и� ���� a13���� �ִ´�.
			devide(a, A22, n / 2, n / 2); // a�� 4�и� ���� a14���� �ִ´�.

			// �迭 b�� 4�и����� �����ٰ� ������
			devide(b, B11, 0, 0); // b�� 2��и� ���� b11���� �ִ´�.
			devide(b, B12, 0, n / 2); // b�� 3��и� ���� b12���� �ִ´�.
			devide(b, B21, n / 2, 0); // b�� 1��и� ���� b13���� �ִ´�.
			devide(b, B22, n / 2, n / 2); // b�� 4�и� ���� b14���� �ִ´�.

			// ��� ����� �Ѵ�. ������ ���ڿ� �°� ���� Ȥ�� ������ �Ͽ� �־��ش�.
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

			// C�� ���� 4��и��� C���� �����ش�.
			copy(C11, c, 0, 0);
			copy(C12, c, 0, n / 2);
			copy(C21, c, n / 2, 0);
			copy(C22, c, n / 2, n / 2);
		}

		return c; // c�� ��ȯ�Ѵ�.
	}

	public void copy(int[][] c1, int[][] p1, int iB, int jB) {
		for (int i1 = 0, i2 = iB; i1 < c1.length; i1++, i2++)
			for (int j1 = 0, j2 = jB; j1 < c1.length; j1++, j2++) {
				p1[i2][j2] = c1[i1][j1];
			}
	} // �迭 c1�� ���� �Է��� �������� p1���ٰ� �ִ´�.

	public void devide(int[][] p1, int[][] c1, int iB, int jB) { 
		for (int i1 = 0, i2 = iB; i1 < c1.length; i1++, i2++) // c�迭�� ũ�� ��ŭ �ݺ��Ѵ�.
			for (int j1 = 0, j2 = jB; j1 < c1.length; j1++, j2++) {
				c1[i1][j1] = p1[i2][j2];
			}
	} // �迭 p1�� ���� �Է��� �������� c1���ٰ� �ִ´�.

	public int[][] add(int[][] A, int[][] B) {
		int n = A.length; // n�� A�迭�� ������� �����Ѵ�
		int[][] R = new int[n][n]; // �迭 R�� ������ n*n�� �����迭�� �����Ѵ�.
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) {
				R[i][j] = A[i][j] + B[i][j]; // A, B�迭�� ���� R���� �ִ´�.
			}
		return R; // R�� ��ȯ�Ѵ�.
	}

	public int[][] sub(int[][] A, int[][] B) {
		int n = A.length;
		int[][] R = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				R[i][j] = A[i][j] - B[i][j];
			}
		return R;
	} // �迭 ����

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
	} // �迭 ���ϱ�

	// 2���� ��� ���
	public void PrintMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

}