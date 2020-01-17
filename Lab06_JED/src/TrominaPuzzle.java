
public class TrominaPuzzle {
	private int[][] board; // 2차원 배열 생성
	private int TrominoNum;
	
	public TrominaPuzzle(int x_missing, int y_missing, int b_size) { // 생성자, x_missing, y_missing, b_size를 입력받아 생성
		
		board = new int[b_size][b_size]; // b_size크기의 행과 열을 가진 2차원 배열로 설정
		TrominoNum=1; // 1로 설정
		
		//보드 초기화
		for(int i=0 ; i < b_size ; i++) {
			for(int j=0 ; j<b_size ; j++) {
				board[i][j] = 0; // 모든 값을 0으로 설정
			}
		}
		
		//mark the input squre
		board[x_missing][y_missing] = -1; // 입력받은 좌표의 값을 -1로 설정
		
		tileTromino(0,0,b_size); // tileTromono에 0,0,b_size를 넣어 실행
		
		printBoard(); // 출력해준다.
		System.out.println();
	}
	
	public void tileTromino(int x_board, int y_board, int size) {
		//base
		if(size==2) // 배열의 사이즈가 2x2라면
		{
			
			for(int i=0 ; i < size ; i++) {
				for(int j=0 ; j < size ; j++) {
					
					if(board[x_board+i][y_board+j] == 0) { // 입력받은 좌표보다 행은 i만큼 열은 j만큼 큰 좌표의 값이 0으로 초기화된 상태 그대로 라면
						board[x_board+i][y_board+j] = TrominoNum; // TrominoNum으로 설정
					}
				}
			}
			
			System.out.println();
			printBoard(); // 배열을 출력
			TrominoNum++; // TrominoNum의 값을 1증가
			
		}
		//recursive cases
		else // size가 2보다 크다면
		{
			int half_size, x_center, y_center;
			
			half_size = size/2; // size의 반절로 설정
			
			x_center = x_board + half_size; // x 좌표의 중간값을 넣어준다.
			y_center = y_board + half_size; // y 좌표의 중간값을 넣어준다.
			
			int x_m=0;
			int y_m=0;
			
			for(int i=x_board; i < x_board+size ; i++) // 설정한 x좌표 처음부터 끝까지
			{
				for(int j=y_board; j < y_board+size ; j++) { // 설정한 y좌표 처음부터 끝까지
					
					if(board[i][j] != 0) { // 해당 좌표의 값이 0이 아니면, 즉 처음 초기화 된 값이 아니면
						x_m = i; // x_m에 해당 배열의 행 좌표 i를 넣는다.
						y_m = j; // y_m에 해당 배열의 열 좌표 j를 넣는다.
					}
				}
			}
			
			// 어느 분면에 tromino 만들지 결정 후 만들기
			if(x_m < x_center && y_m < y_center) { //1사분면
				board[x_center][y_center-1] = TrominoNum; // 배열의 x_center행과 y_center-1열에 TrominoNum값을 넣는다.
				board[x_center][y_center] = TrominoNum; // 배열의 x_center행과 y_center열에 TrominoNum값을 넣는다.
				board[x_center-1][y_center] = TrominoNum; // 배열의 x_center-1행과 y_center열에 TrominoNum값을 넣는다.
				printBoard(); // 1사분면 출력
				TrominoNum++; // TrominoNum의 값을 1 증가
			}
			else if(x_m >= x_center && y_m < y_center){ //2사분면
				board[x_center-1][y_center] = TrominoNum; // 배열의 x_center-1행과 y_center열에 TrominoNum값을 넣는다.
				board[x_center][y_center] = TrominoNum; // 배열의 x_center행과 y_center열에 TrominoNum값을 넣는다.
				board[x_center-1][y_center-1] = TrominoNum; // 배열의 x_center-1행과 y_center-1열에 TrominoNum값을 넣는다.
				printBoard(); // 2사분면 출력
				TrominoNum++; // TrominoNum의 값을 1 증가
			}
			else if(x_m < x_center && y_m >= y_center){ //3사분면
				board[x_center][y_center-1] = TrominoNum; // 배열의 x_center행과 y_center-1열에 TrominoNum값을 넣는다.
				board[x_center][y_center] = TrominoNum; // 배열의 x_center행과 y_center열에 TrominoNum값을 넣는다.
				board[x_center-1][y_center-1] = TrominoNum; // 배열의 x_center-1행과 y_center-1열에 TrominoNum값을 넣는다.
				printBoard(); // 3사분면 출력
				TrominoNum++; // TrominoNum의 값을 1 증가
			}
			else { //4사분면
				board[x_center-1][y_center] = TrominoNum; // 배열의 x_center-1행과 y_center열에 TrominoNum값을 넣는다.
				board[x_center][y_center-1] = TrominoNum; // 배열의 x_center행과 y_center-1열에 TrominoNum값을 넣는다.
				board[x_center-1][y_center-1] = TrominoNum; // 배열의 x_center-1행과 y_center-1열에 TrominoNum값을 넣는다.
				printBoard(); // 4사분면 출력
				TrominoNum++; // TrominoNum의 값을 1 증가
			}
			
			
			tileTromino(x_board,y_board,half_size); //제 1사분면
			tileTromino(x_board,y_center,half_size); //제 2사분면
			System.out.println();
			tileTromino(x_center,y_board,half_size); //제 3사분면
			tileTromino(x_center,y_center,half_size); //제 4사분면
			System.out.println();
		}
	}
	

	public void printBoard() { // 2차원 배열을 출력한다.
		for(int i=0 ; i<board.length ; i++) {
			for(int j=0 ; j<board.length ; j++) {
				System.out.print(board[i][j] + "\t"); // 2차원 배열 안의 i행 j열 값을 출력하고 Tab해 준다.
			}
			System.out.println(); // 줄바꿈
		}
	}
	

}