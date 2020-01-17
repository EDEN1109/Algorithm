
public class TrominaPuzzle {
	private int[][] board; // 2���� �迭 ����
	private int TrominoNum;
	
	public TrominaPuzzle(int x_missing, int y_missing, int b_size) { // ������, x_missing, y_missing, b_size�� �Է¹޾� ����
		
		board = new int[b_size][b_size]; // b_sizeũ���� ��� ���� ���� 2���� �迭�� ����
		TrominoNum=1; // 1�� ����
		
		//���� �ʱ�ȭ
		for(int i=0 ; i < b_size ; i++) {
			for(int j=0 ; j<b_size ; j++) {
				board[i][j] = 0; // ��� ���� 0���� ����
			}
		}
		
		//mark the input squre
		board[x_missing][y_missing] = -1; // �Է¹��� ��ǥ�� ���� -1�� ����
		
		tileTromino(0,0,b_size); // tileTromono�� 0,0,b_size�� �־� ����
		
		printBoard(); // ������ش�.
		System.out.println();
	}
	
	public void tileTromino(int x_board, int y_board, int size) {
		//base
		if(size==2) // �迭�� ����� 2x2���
		{
			
			for(int i=0 ; i < size ; i++) {
				for(int j=0 ; j < size ; j++) {
					
					if(board[x_board+i][y_board+j] == 0) { // �Է¹��� ��ǥ���� ���� i��ŭ ���� j��ŭ ū ��ǥ�� ���� 0���� �ʱ�ȭ�� ���� �״�� ���
						board[x_board+i][y_board+j] = TrominoNum; // TrominoNum���� ����
					}
				}
			}
			
			System.out.println();
			printBoard(); // �迭�� ���
			TrominoNum++; // TrominoNum�� ���� 1����
			
		}
		//recursive cases
		else // size�� 2���� ũ�ٸ�
		{
			int half_size, x_center, y_center;
			
			half_size = size/2; // size�� ������ ����
			
			x_center = x_board + half_size; // x ��ǥ�� �߰����� �־��ش�.
			y_center = y_board + half_size; // y ��ǥ�� �߰����� �־��ش�.
			
			int x_m=0;
			int y_m=0;
			
			for(int i=x_board; i < x_board+size ; i++) // ������ x��ǥ ó������ ������
			{
				for(int j=y_board; j < y_board+size ; j++) { // ������ y��ǥ ó������ ������
					
					if(board[i][j] != 0) { // �ش� ��ǥ�� ���� 0�� �ƴϸ�, �� ó�� �ʱ�ȭ �� ���� �ƴϸ�
						x_m = i; // x_m�� �ش� �迭�� �� ��ǥ i�� �ִ´�.
						y_m = j; // y_m�� �ش� �迭�� �� ��ǥ j�� �ִ´�.
					}
				}
			}
			
			// ��� �и鿡 tromino ������ ���� �� �����
			if(x_m < x_center && y_m < y_center) { //1��и�
				board[x_center][y_center-1] = TrominoNum; // �迭�� x_center��� y_center-1���� TrominoNum���� �ִ´�.
				board[x_center][y_center] = TrominoNum; // �迭�� x_center��� y_center���� TrominoNum���� �ִ´�.
				board[x_center-1][y_center] = TrominoNum; // �迭�� x_center-1��� y_center���� TrominoNum���� �ִ´�.
				printBoard(); // 1��и� ���
				TrominoNum++; // TrominoNum�� ���� 1 ����
			}
			else if(x_m >= x_center && y_m < y_center){ //2��и�
				board[x_center-1][y_center] = TrominoNum; // �迭�� x_center-1��� y_center���� TrominoNum���� �ִ´�.
				board[x_center][y_center] = TrominoNum; // �迭�� x_center��� y_center���� TrominoNum���� �ִ´�.
				board[x_center-1][y_center-1] = TrominoNum; // �迭�� x_center-1��� y_center-1���� TrominoNum���� �ִ´�.
				printBoard(); // 2��и� ���
				TrominoNum++; // TrominoNum�� ���� 1 ����
			}
			else if(x_m < x_center && y_m >= y_center){ //3��и�
				board[x_center][y_center-1] = TrominoNum; // �迭�� x_center��� y_center-1���� TrominoNum���� �ִ´�.
				board[x_center][y_center] = TrominoNum; // �迭�� x_center��� y_center���� TrominoNum���� �ִ´�.
				board[x_center-1][y_center-1] = TrominoNum; // �迭�� x_center-1��� y_center-1���� TrominoNum���� �ִ´�.
				printBoard(); // 3��и� ���
				TrominoNum++; // TrominoNum�� ���� 1 ����
			}
			else { //4��и�
				board[x_center-1][y_center] = TrominoNum; // �迭�� x_center-1��� y_center���� TrominoNum���� �ִ´�.
				board[x_center][y_center-1] = TrominoNum; // �迭�� x_center��� y_center-1���� TrominoNum���� �ִ´�.
				board[x_center-1][y_center-1] = TrominoNum; // �迭�� x_center-1��� y_center-1���� TrominoNum���� �ִ´�.
				printBoard(); // 4��и� ���
				TrominoNum++; // TrominoNum�� ���� 1 ����
			}
			
			
			tileTromino(x_board,y_board,half_size); //�� 1��и�
			tileTromino(x_board,y_center,half_size); //�� 2��и�
			System.out.println();
			tileTromino(x_center,y_board,half_size); //�� 3��и�
			tileTromino(x_center,y_center,half_size); //�� 4��и�
			System.out.println();
		}
	}
	

	public void printBoard() { // 2���� �迭�� ����Ѵ�.
		for(int i=0 ; i<board.length ; i++) {
			for(int j=0 ; j<board.length ; j++) {
				System.out.print(board[i][j] + "\t"); // 2���� �迭 ���� i�� j�� ���� ����ϰ� Tab�� �ش�.
			}
			System.out.println(); // �ٹٲ�
		}
	}
	

}